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

    private String role_code;

    private String role_name;

    private String parent_role_code;

}
