package cn.edu.xmut.personnelmanage.domain.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/3/12 15:17
 */
@Data
public class SysUserVO {

    private Long id;
    /**
     * 登录名
     */
    private String loginName;
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
    private Date entryDate;
    /**
     * 个人简介
     */
    private String personalProfile;
    /**
     * 角色信息
     */
    private List<SysRoleVO> roleList;
    /**
     * 部门信息
     */
    private List<SysDeptVO> deptList;

    private String salt;


    private String password;

    private List<Long> roleIds;

    private List<Long> deptIds;

    private Integer statusCd;



}
