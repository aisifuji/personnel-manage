package cn.edu.xmut.personnelmanage.domain.entity;

import cn.edu.xmut.personnelmanage.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (FileInfo)实体类
 *
 * @author luols
 * @since 2021-04-08 11:01:54
 */
@Data
public class FileInfo extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -68222737938193174L;

    private Long id;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 路径
     */
    private String url;
    /**
     * 文件内容
     */
    private String fileContent;
    /**
     * 备注
     */
    private String remark;
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