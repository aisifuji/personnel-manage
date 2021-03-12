package cn.edu.xmut.personnelmanage.domain.entity;

import cn.edu.xmut.personnelmanage.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * (cn.edu.xmut.personnelmanage.domain.entity.SysUserDeptRel)实体类
 *
 * @author luols
 * @since 2021-03-11 11:15:44
 */
@Data
public class SysUserDeptRel extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -91120876325044958L;

    private Long userId;

    private Long deptId;



}