package cn.edu.xmut.personnelmanage.domain.entity;

import cn.edu.xmut.personnelmanage.base.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

/**
 * (cn.edu.xmut.personnelmanage.domain.entity.EmployeeWorkAttendance)实体类
 *
 * @author jiangjx
 * @since 2021-04-09 15:46:11
 */
@Data
public class EmployeeWorkAttendance extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 989087240112919184L;

    private Long id;
    /**
     * 员工id
     */
    private Long employeeId;
    /**
     * 日期
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date workDate;
    /**
     * 周几
     */
    private String weekday;
    /**
     * 上班时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date startWork;
    /**
     * 下班时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date endWork;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 修改人
     */
    private String modifyUser;
    /**
     * 删除状态(0：否，1：是)
     */
    private Integer isDelete;

    private LocalTime starWorkTime;

    private LocalTime endWorkTime;

    private String employeeNm;




}