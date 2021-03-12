package cn.edu.xmut.personnelmanage.domain.entity;

import cn.edu.xmut.personnelmanage.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * 系统角色用户(cn.edu.xmut.personnelmanage.domain.entity.SysUserRoleRel)实体类
 *
 * @author luols
 * @since 2021-03-11 11:15:44
 */
@Data
public class SysUserRoleRel extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -45824075169059876L;

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 角色id
     */
    private Long roleId;



}