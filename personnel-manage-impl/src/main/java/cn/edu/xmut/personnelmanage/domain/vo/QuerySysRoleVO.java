package cn.edu.xmut.personnelmanage.domain.vo;

import cn.edu.xmut.personnelmanage.base.QueryPageParam;
import lombok.Data;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/4/1 15:04
 */
@Data
public class QuerySysRoleVO extends QueryPageParam {

    private String roleName;

}
