package cn.edu.xmut.personnelmanage.domain.vo;

import cn.edu.xmut.personnelmanage.base.QueryPageParam;
import lombok.Data;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/4/2 16:03
 */
@Data
public class QueryEmployeeLeaveApplyVO extends QueryPageParam {


    private Long id;

    private String userName;

    private Integer statusCd;

    private Long userId;

}
