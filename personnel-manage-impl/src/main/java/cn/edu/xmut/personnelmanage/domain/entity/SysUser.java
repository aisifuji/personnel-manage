package cn.edu.xmut.personnelmanage.domain.entity;

import cn.edu.xmut.personnelmanage.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户表(SysUser)实体类
 *
 * @author luols
 * @since 2021-03-12 15:54:27
 */
@Data
public class SysUser extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -32897450292860830L;
    /**
     * 0
     */
    private Long id;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String userName;
    /**
     * 英文名称
     */
    private String engName;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 籍贯
     */
    private String nativePlace;
    /**
     * 民族
     */
    private String nation;
    /**
     * 性别(0：女，1：男)
     */
    private Integer sex;
    /**
     * 出生日期
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date birthday;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 地址
     */
    private String address;
    /**
     * 加密盐
     */
    private String salt;
    /**
     * 账户状态（0：启用，1：停用）
     */
    private Integer statusCd;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String photo;
    /**
     * 职务
     */
    private String job;
    /**
     * 职位
     */
    private String position;
    /**
     * 入职时间
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date entryDate;
    /**
     * 个人简介
     */
    private String personalProfile;
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