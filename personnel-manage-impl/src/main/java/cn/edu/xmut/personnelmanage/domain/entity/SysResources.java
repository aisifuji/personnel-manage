package cn.edu.xmut.personnelmanage.domain.entity;

import cn.edu.xmut.personnelmanage.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * 系统资源表(cn.edu.xmut.personnelmanage.domain.entity.SysResources)实体类
 *
 * @author luols
 * @since 2021-03-11 11:15:41
 */
@Data
public class SysResources extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -59956378650424104L;

    /**
     * 父id
     */
    private Long parentId;
    /**
     * 资源名称
     */
    private String name;
    /**
     * 资源类型（0：菜单，1：按钮）
     */
    private Integer type;
    /**
     * 访问url地址
     */
    private String url;
    /**
     * 权限代码
     */
    private String percode;
    /**
     * 排序号
     */
    private Integer sort;
    /**
     * 是否可用（0：可用，1：不可用）
     */
    private Integer statusCd;
    /**
     * 图标样式
     */
    private String icon;
    /**
     * 资源编码
     */
    private String resCode;



}