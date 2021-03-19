package cn.edu.xmut.personnelmanage.domain.vo;

import lombok.Data;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/3/12 15:24
 */
@Data
public class SysRoleVO {

    private Long id;

    private String roleCode;

    private String roleName;

    private String parentRoleCode;

}
