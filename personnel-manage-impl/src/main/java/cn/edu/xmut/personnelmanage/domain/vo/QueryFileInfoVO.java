package cn.edu.xmut.personnelmanage.domain.vo;

import cn.edu.xmut.personnelmanage.base.QueryPageParam;
import lombok.Data;

/**
 * @author luols
 * @version v1.0
 * @since 2021/4/8 11:10
 */
@Data
public class QueryFileInfoVO extends QueryPageParam {

    private String fileName;
}
