package cn.edu.xmut.personnelmanage.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/3/11 11:16
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * id
     */
    private Long id;
    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
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
