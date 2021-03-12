package cn.edu.xmut.personnelmanage.domain.entity;

import cn.edu.xmut.personnelmanage.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * (cn.edu.xmut.personnelmanage.domain.entity.SysDict)实体类
 *
 * @author luols
 * @since 2021-03-11 11:15:41
 */
@Data
public class SysDict extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 199872678561744267L;


    private Long parentId;
    /**
     * 字典值
     */
    private String value;
    /**
     * 字典编码
     */
    private String code;
    /**
     * 字典名称
     */
    private String name;
    /**
     * 状态1：启用，2：禁用
     */
    private Integer statusCd;



}