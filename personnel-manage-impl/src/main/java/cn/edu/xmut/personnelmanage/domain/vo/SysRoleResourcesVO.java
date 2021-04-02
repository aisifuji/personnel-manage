package cn.edu.xmut.personnelmanage.domain.vo;


import lombok.Data;

@Data
public class SysRoleResourcesVO  {

    private Long roleId;

    private Long[] resourcesIds;

    public Long[] getResourcesIds() {
        return resourcesIds;//NOSONAR
    }

    public void setResourcesIds(Long[] resourcesIds) {
        this.resourcesIds = resourcesIds;//NOSONAR
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
