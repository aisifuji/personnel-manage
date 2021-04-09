package cn.edu.xmut.personnelmanage.domain.vo;

import cn.edu.xmut.personnelmanage.base.QueryPageParam;
import lombok.Data;

/**
 * @author luols
 * @version v1.0
 * @since 2021/4/7 14:50
 */
@Data
public class QueryNoticeInfoVO extends QueryPageParam {

    private String title;

    private Integer type;

}
