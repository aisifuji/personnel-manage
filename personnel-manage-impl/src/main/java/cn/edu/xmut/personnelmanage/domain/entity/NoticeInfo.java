package cn.edu.xmut.personnelmanage.domain.entity;

import cn.edu.xmut.personnelmanage.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (cn.edu.xmut.personnelmanage.domain.entity.NoticeInfo)实体类
 *
 * @author luols
 * @since 2021-04-07 14:41:43
 */
@Data
public class NoticeInfo extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 380442675856715582L;

    private Long id;
    /**
     * 通知标题
     */
    private String title;
    /**
     * 类型1
     */
    private Integer type;
    /**
     * 通知内容
     */
    private String content;
    /**
     * 备注
     */
    private String remark;
    /**
     * 简介
     */
    private String introduction;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 修改人
     */
    private String modifyUser;
    /**
     * 删除状态(0：否，1：是)
     */
    private Integer isDelete;


}