package cn.edu.xmut.personnelmanage.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author luols
 * @version v1.0
 * @since 2021/4/2 16:17
 */
@Data
public class EmployeeLeaveApplyVO {


    private Long id;
    /**
     * 员工编号
     */
    private Long userId;
    /**
     * 请假开始时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date leaveStartTime;
    /**
     * 请假结束时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date leaveEndTime;
    /**
     * 请假理由
     */
    private String leaveReason;
    /**
     * 申请时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date applyTime;
    /**
     * 请假类型(1病假2年假3调休4婚假5事假
     */
    private Integer leaveTp;
    /**
     * 审批状态（1待审批2审批通过3审批不通过
     */
    private Integer statusCd;

    private String userName;
}
