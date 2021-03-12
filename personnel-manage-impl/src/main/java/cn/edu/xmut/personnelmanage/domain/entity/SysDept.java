package cn.edu.xmut.personnelmanage.domain.entity;

import cn.edu.xmut.personnelmanage.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * (cn.edu.xmut.personnelmanage.domain.entity.SysDept)实体类
 *
 * @author luols
 * @since 2021-03-11 11:15:40
 */
@Data
public class SysDept extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -84780385677651524L;

    /**
     * 部门编码
     */
    private String deptCode;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 账户状态（0：启用，1：停用）
     */
    private Integer statusCd;
    /**
     * 备注
     */
    private String remark;


}