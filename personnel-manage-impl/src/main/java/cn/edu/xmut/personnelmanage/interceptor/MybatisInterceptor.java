package cn.edu.xmut.personnelmanage.interceptor;

import cn.edu.xmut.personnelmanage.auth.util.SessionUtil;
import cn.edu.xmut.personnelmanage.base.BaseEntity;
import cn.edu.xmut.personnelmanage.base.Page;
import cn.edu.xmut.personnelmanage.domain.entity.SysUser;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/3/11 15:50
 */
@Component
@Intercepts({@Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
), @Signature(
        type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class}
)})
public class MybatisInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (invocation.getArgs().length > 2) {
            this.query(invocation);
        } else {
            this.update(invocation);
        }

        return invocation.proceed();
    }



    private Object query(Invocation invocation) throws SQLException {
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement)args[0];
        Object parameterObject = args[1];
        BoundSql boundSql = ms.getBoundSql(parameterObject);
        SqlCommandType sqlCommandType = ms.getSqlCommandType();
        if (SqlCommandType.SELECT.equals(sqlCommandType)) {
            Page page = Page.getLocalPage();
            if (page != null) {
                Page.clearPage();
                String sql = boundSql.getSql();
                String countSQL = this.getMysqlCountSql(new StringBuffer(sql));
                int totalCount = this.getCounts(ms, countSQL, boundSql, invocation, parameterObject);
                String pageSql = this.getMysqlPageSql(page, new StringBuffer(sql));
                page.setTotalCount(totalCount);
                BoundSql newBoundSql = this.copyFromBoundSql(ms, boundSql, pageSql);
                MappedStatement newMs = this.copyFromMappedStatement(ms, new MybatisInterceptor.BoundSqlSqlSource(newBoundSql));
                invocation.getArgs()[0] = newMs;
            }
        }

        return null;
    }



    private void update(Invocation invocation) {
        MappedStatement mappedStatement = (MappedStatement)invocation.getArgs()[0];
        Object parameter = invocation.getArgs()[1];
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        if ((SqlCommandType.UPDATE.equals(sqlCommandType) || SqlCommandType.INSERT.equals(sqlCommandType)) && parameter != null) {
            SysUser sysUser = this.getUserBaseInfo();
            if (parameter instanceof BaseEntity) {
                BaseEntity entity = (BaseEntity)parameter;
                this.buildBaseEntity(sysUser, entity, sqlCommandType);
            } else if (parameter instanceof Map) {
                Map map = (Map)parameter;
                if (map.containsKey("list") && map.get("list") != null && map.get("list") instanceof List) {
                    ArrayList list = (ArrayList)map.get("list");
                    if (!list.isEmpty() && list.get(0) instanceof BaseEntity) {
                        Iterator var16 = list.iterator();
                        while(var16.hasNext()) {
                            BaseEntity baseEntity = (BaseEntity)var16.next();
                            this.buildBaseEntity(sysUser, baseEntity, sqlCommandType);
                        }
                    }
                } else if (SqlCommandType.UPDATE.equals(sqlCommandType)) {
                    BoundSql boundSql = mappedStatement.getBoundSql(parameter);
                    String sql = boundSql.getSql();
                    String[] s = sql.split("where");
                    StringBuffer sb = new StringBuffer();
                    sb.append(s[0]);
                    sb.append(",modify_user = '" + sysUser.getUserName() + "' ");
                    sb.append(",modify_time = " + new Date() + " ");
                    sb.append(" where ");
                    sb.append(s[1] + " ");
                    BoundSql newBoundSql = this.copyFromBoundSql(mappedStatement, boundSql, sb.toString());
                    MappedStatement newMs = this.copyFromMappedStatement(mappedStatement, new MybatisInterceptor.BoundSqlSqlSource(newBoundSql));
                    invocation.getArgs()[0] = newMs;
                }
            }
        }

    }


    private SysUser getUserBaseInfo() {
        SysUser user = SessionUtil.getUser();
        if(null != user){
            return user;
        }else {
            SysUser tempUser = new SysUser();
            tempUser.setId(0L);
            tempUser.setUserName("system");
            return tempUser;
        }
    }


    private void buildBaseEntity(SysUser sysUser, BaseEntity entity, SqlCommandType sqlCommandType) {
        if (SqlCommandType.UPDATE.equals(sqlCommandType)) {
            entity.setModifyTime(new Date());
            entity.setModifyUser(sysUser.getUserName());
        } else if (SqlCommandType.INSERT.equals(sqlCommandType)) {
            entity.setIsDelete(0);
            entity.setCreateTime(new Date());
            entity.setCreateUser(sysUser.getUserName());
        }

    }

    private String getMysqlCountSql(StringBuffer sqlBuffer) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("select count(1) from (");
        buffer.append(sqlBuffer);
        buffer.append(") as total");
        return buffer.toString();
    }


    private int getCounts(MappedStatement mappedStatement, String countSQL, BoundSql boundSql, Invocation invocation, Object parameter) {
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameter, boundSql);
        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement countStmt = null;
        int totpage = 0;

        try {
            connection = mappedStatement.getConfiguration().getEnvironment().getDataSource().getConnection();
            countStmt = connection.prepareStatement(countSQL);
            parameterHandler.setParameters(countStmt);
            rs = countStmt.executeQuery();
            if (rs.next()) {
                totpage = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (countStmt != null) {
                    countStmt.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException var19) {
                var19.printStackTrace();
            }

        }

        return totpage;
    }

    private String getMysqlPageSql(Page page, StringBuffer sqlBuffer) {
        sqlBuffer.append(" limit ").append((page.getPageNo() - 1) * page.getPageSize()).append(",").append(page.getPageSize());
        return sqlBuffer.toString();
    }

    private BoundSql copyFromBoundSql(MappedStatement ms, BoundSql boundSql, String pageSql) {
        BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), pageSql, boundSql.getParameterMappings(), boundSql.getParameterObject());
        Iterator<ParameterMapping> iterator = boundSql.getParameterMappings().iterator();

        while(iterator.hasNext()) {
            ParameterMapping mapping = iterator.next();
            String prop = mapping.getProperty();
            if (boundSql.hasAdditionalParameter(prop)) {
                newBoundSql.setAdditionalParameter(prop, boundSql.getAdditionalParameter(prop));
            }
        }

        return newBoundSql;
    }



    private MappedStatement copyFromMappedStatement(MappedStatement ms, MybatisInterceptor.BoundSqlSqlSource boundSqlSqlSource) {
        MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId(), boundSqlSqlSource, ms.getSqlCommandType());
        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        if (ms.getKeyProperties() != null && ms.getKeyProperties().length != 0) {
            StringBuffer keyProperties = new StringBuffer();
            String[] var5 = ms.getKeyProperties();
            int var6 = var5.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                String keyProperty = var5[var7];
                keyProperties.append(keyProperty).append(",");
            }

            keyProperties.delete(keyProperties.length() - 1, keyProperties.length());
            builder.keyProperty(keyProperties.toString());
        }

        builder.timeout(ms.getTimeout());
        builder.parameterMap(ms.getParameterMap());
        builder.resultMaps(ms.getResultMaps());
        builder.resultSetType(ms.getResultSetType());
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());
        return builder.build();
    }


    public class BoundSqlSqlSource implements SqlSource {
        BoundSql boundSql;

        public BoundSqlSqlSource(BoundSql boundSql) {
            this.boundSql = boundSql;
        }

        public BoundSql getBoundSql(Object parameterObject) {
            return this.boundSql;
        }
    }

}
