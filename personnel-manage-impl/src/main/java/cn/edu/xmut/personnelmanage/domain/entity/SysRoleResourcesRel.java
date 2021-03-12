package cn.edu.xmut.personnelmanage.domain.entity;

import cn.edu.xmut.personnelmanage.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * 系统角色资源表(cn.edu.xmut.personnelmanage.domain.entity.SysRoleResourcesRel)实体类
 *
 * @author luols
 * @since 2021-03-11 11:15:42
 */
@Data
public class SysRoleResourcesRel extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 776474409202219164L;

    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 资源id
     */
    private Long resourcesId;



}