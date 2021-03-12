package cn.edu.xmut.personnelmanage.domain.entity;

import cn.edu.xmut.personnelmanage.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (cn.edu.xmut.personnelmanage.domain.entity.EmployeeLeaveApply)实体类
 *
 * @author luols
 * @since 2021-03-11 11:15:33
 */
@Data
public class EmployeeLeaveApply extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -26971357430924818L;


    /**
     * 员工编号
     */
    private Long userId;
    /**
     * 请假开始时间
     */
    private Date leaveStartTime;
    /**
     * 请假结束时间
     */
    private Date leaveEndTime;
    /**
     * 请假理由
     */
    private String leaveReason;
    /**
     * 申请时间
     */
    private Date applyTime;
    /**
     * 请假类型(1病假2年假3调休4婚假5事假
     */
    private Integer leaveTp;
    /**
     * 审批状态（1待审批2审批通过3审批不通过
     */
    private Integer statusCd;



}