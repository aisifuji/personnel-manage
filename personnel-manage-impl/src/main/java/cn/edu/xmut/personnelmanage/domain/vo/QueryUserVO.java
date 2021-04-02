package cn.edu.xmut.personnelmanage.domain.vo;

import cn.edu.xmut.personnelmanage.base.QueryPageParam;
import lombok.Data;

import java.util.Date;

/**
 * @author jinagjx
 * @version v1.0
 * @since 2021/3/22 9:12
 */
@Data
public class QueryUserVO extends QueryPageParam {


    private Long id;
    /**
     * 姓名
     */
    private String userName;

    /**
     * 籍贯
     */
    private String nativePlace;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 职务
     */
    private String job;
    /**
     * 入职时间
     */
    private Date entryDate;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 状态
     */
    private Integer statusCd;


}
