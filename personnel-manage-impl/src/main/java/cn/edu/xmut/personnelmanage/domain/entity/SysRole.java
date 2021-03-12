package cn.edu.xmut.personnelmanage.domain.entity;

import cn.edu.xmut.personnelmanage.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * 系统角色表(cn.edu.xmut.personnelmanage.domain.entity.SysRole)实体类
 *
 * @author luols
 * @since 2021-03-11 11:15:42
 */
@Data
public class SysRole extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 423076342642544772L;

    /**
     * 角色编码
     */
    private String roleCode;
    /**
     * 名称
     */
    private String roleName;
    /**
     * 父角色编码
     */
    private String parentRoleCode;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否为默认(0：否，1：是)
     */
    private Integer isDefault;
    /**
     * 状态（0：启用，1：未启用）
     */
    private Integer statusCd;



}