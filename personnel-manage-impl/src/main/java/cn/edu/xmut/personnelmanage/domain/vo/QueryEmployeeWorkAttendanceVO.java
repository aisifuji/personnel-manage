package cn.edu.xmut.personnelmanage.domain.vo;

import cn.edu.xmut.personnelmanage.base.QueryPageParam;
import lombok.Data;

import java.util.Date;

/**
 * @author luols
 * @version v1.0
 * @since 2021/4/9 15:57
 */
@Data
public class QueryEmployeeWorkAttendanceVO extends QueryPageParam {

    private Date workDate;

    private String employeeNm;

    private Long employeeId;

    private Date start_work;
}
