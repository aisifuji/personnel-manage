package cn.edu.xmut.personnelmanage.domain.vo;

import cn.edu.xmut.personnelmanage.base.QueryPageParam;
import lombok.Data;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/4/2 14:20
 */
@Data
public class QuerySysResourceVO extends QueryPageParam {

    private Long id;

    private String name;
}
