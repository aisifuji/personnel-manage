package cn.edu.xmut.personnelmanage.domain.vo;

import cn.edu.xmut.personnelmanage.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (cn.edu.xmut.personnelmanage.domain.entity.EmployeeWorkAttendance)实体类
 *
 * @author luols
 * @since 2021-04-09 15:46:11
 */
@Data
public class EmployeeWorkAttendanceVO extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 989087240112919184L;

    private Long id;
    /**
     * 员工id
     */
    private Long employeeId;
    /**
     * 日期
     */
    private Date workDate;
    /**
     * 周几
     */
    private String weekday;
    /**
     * 上班时间
     */
    private Date startWork;
    /**
     * 下班时间
     */
    private Date endWork;
    /**
     * 员工姓名
     */
    private String employeeNm;


}