package cn.edu.xmut.personnelmanage.domain.entity;

import cn.edu.xmut.personnelmanage.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (AgencyInfo)实体类
 *
 * @author luols
 * @since 2021-04-08 11:01:56
 */
@Data
public class AgencyInfo extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 173877143858538765L;

    private Long id;
    /**
     * 项目名称
     */
    private String itemName;
    /**
     * 计划时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date planTime;
    /**
     * 项目内容
     */
    private String itemContent;
    /**
     * 是否完成0否1是
     */
    private Integer isFinish;
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