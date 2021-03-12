package cn.edu.xmut.personnelmanage.domain.enums;

import java.io.Serializable;

/**
 * @author jiangjx
 * @version V1.0
 * @Date 2021-03-12 17:21:59
 * 返回码及提示信息
 */
@SuppressWarnings("all")
public enum ResponseInfo implements Serializable {
    SUCCESS(200, "操作成功！"),
    ERROT(1050,"操作失败！"),
    OTHER_ERROR(1000,"验证码错误！"),
    VERIFICATION_CODE(1025,"验证码失效！"),
    PARAMETER_ERROR(-1, "参数有误！"),
    LOGIN_FAIL(1001, "账号或密码有误！"),
    LOGIN_MAX_LIMIT(1002,"登陆错误次数过多，账户锁定30分钟！"),
    LOGIN_FREEZE(1003, "账号不可用或已被冻结!"),
    USER_NOT_EXIST(1004, "账号不存在!"),
    SYSTEM_ERROR(1005,"系统错误！"),
    UNAUTHORIZED(1006,"账户未授权或未登录！"),
    PARAMETER_VALIDATION_ERROR(1007,"参数校验异常"),
    BUSINESS_ERROR(1008,"业务异常"),
    LOGIN_USER_EXIST(1009,"登录名已存在！"),
    DATASOURCE_ERROR(999, "获取学校数据失败！"),
    SMS_ERROR(1000, "获取短信验证码失败！请稍后重试"),
    SMS_VERIFY_ERROR(1001, "无效的短信验证码！"),
    IDCARD_VERIFY_ERROR(1002, "人证比对失败！"),
    GET_USER_ERROR(1003, "获取微信账户失败！"),
    REGISTER_ERROR(1004, "用户注册失败！"),
    SUBSCRIBE_ERROR(1014, "请先关注公众号！"),
    RESERVATION_SUCCESS(0, "申请预约成功！"),
    RESERVATION_ERROR(1005, "申请预约失败！"),
    VERIFY_ERROR(1006, "审核失败，请联系管理员！"),
    SEARCH_LIST_EMPTY(0, "暂无数据！"),
    GET_EMPTY(0, "暂无数据！"),
    INSERT_ERROR(1, "新增失败！"),
    UPDATE_ERROR(1, "修改失败！"),
    REMOVE_ERROR(1, "删除失败！"),
    ILLEGAL_DATA_ERROR(-1, "非法数据！"),
    UNREGISTERED_MSG(1007, "您的信息还未录入系统，请联系管理员！"),
    ACTIVATION_ERROR(1008, "账户激活失败，请联系管理员！"),
    USER_NOEXISTS(1009, "查询账户不存在！"),
    IMAGE_TRANS_CODE_ERROR(1010, "图片转码失败！"),
    IMAGE_DECODE_ERROR(1011, "图片解码失败！"),
    SIGNING_ERROR(1, "签收失败，可能已被签收或已被删除！"),
    FEEDBACK_ERROR(1, "反馈失败，可能已被删除！"),
    NOT_NEED_SIGNING(1, "该信息无需签收"),
    NOT_NEED_FEEDBACK(1, "该信息无需反馈"),
    CANNOT_ACCESS(-2, "无权访问"),
    IMAGE_CONVERT_ERROR(1, "照片转换失败！"),
    IMAGE_COMPRESSION_ERROR(1, "照片压缩失败！"),
    USER_EXISTS(1, "用户已经注册！"),
    SEMESTER_ALREADY_SET(1,"已设置学期，请勿重复添加！"),
    INITIALIZED(1,"已初始化，请勿重复操作！"),
    NO_INITIALIZED(1,"该学校年級沒有初始化，请先初始化！"),
    USER_UNREGISTERED(1010,"该用户尚未注册微信！"),
    STUDENT_NOEXISTS(1012,"未查询到学生信息！"),
    UNDEFINED_DATASOURCE(1013,"未定义数据源"),
    NO_NEW_SEMESTER(1,"该学校年级没有新增学期，请先新增学期"),
    NO_NITIALIZED(1,"该学校年级没有新增学期，请先新增学期"),
    STUDENT_NUM_EXISTS(1, "该学号已存在！"),
    ERROR_OLD_PASSWORD(1015,"原密码输入不正确！"),
    SYSTEM_UNAUTHORIZATION(1016,"未分配系统权限！"),
    DATA_UNAUTHORIZATION(1017,"未分配数据权限！"),
    SYSTEN_DATA_UNAUTHORIZATION(1018,"未分配系统和数据权限！"),
    STUDENT_IS(1019,"该学生已经绑定过卡号"),
    CLASS_EXISTS(1,"存在班级，不可直接删除！"),
    GRADE_EXISTS(1,"存在年级，不可直接删除！"),
    SCHOOL_EXISTS(1,"存在学校，不可直接删除！"),
    ORGAN_EXISTS(1,"机构存在，不可直接删除！"),
    ORGAN_EXISTS_STATE(1,"机构存在，不可直接禁用！"),
    AREA_EXISTS(1,"存在区域，不可直接删除！"),
    CITY_EXISTS(1,"存在城市，不可直接删除！"),
    ADD_CLASS_EXISTS(1,"该班级已存在！"),
    ADD_GRADE_EXISTS(1,"该年级已存在！"),
    ADD_SCHOOL_EXISTS(1,"该学校已存在！"),
    ADD_SORT_EXISTS(1,"该类别序号已存在！"),
    ADD_ORGAN_EXISTS(1,"该英文简称已存在！"),
    ADD_CATEGORY_EXISTS(1,"该机构类别不存在！"),
    FILE_ERROR_UPLOAD(1020,"文件上传错误！"),
    EXCEL_DATA_NULL(1022,"解析数据为空！"),
    STUDENT_NO_REPEAT(1023,"存在重复学号！"),
    CARD_IS_BOUND_OR_DAMAGED(1024,"该卡已经绑定或者损坏！"),
    CHECK_ROLE(1026,"该角色下存在用户，不可直接删除！"),
    CHECK_ORG(1027,"该组织下存在用户，不可直接删除！"),
    APPID_EXISTENCE(1028,"该公众号已关联学校，不能删除！"),
    MENU_EMPTY(1030,"菜单数据为空！"),
    MENU_HAS_DATA(1030,"该菜单下已有子菜单"),
    MENU_IS_FULL(1030,"该级别菜单已满"),
    SCHOOL_HAS_DATA(1030,"该学校在此公众号下已有数据！"),
    VISITED_STAFF_EXIST(1,"该用户在当前学校已有数据！"),
    ONEKEYUP_SCHOOL_EMPTY(1,"请选择升学学校！"),
    ONEKEYUP_ERROR(1,"一键升学失败！"),
    APPID_ERROR(1523,"微信APPID/APPSECRET不正确！"),
    DECRYPT_ERROR(1100,"解密失败！"),
    GET_WECHAT_CONFIG_ERROR(1196,"获取公众号配置信息有误！"),
    DATA_EMPTY(1100,"没有需要同步的访客预约数据！"),
    GATE_MANAG_NUMBER_REPEAT(1197,"闸机唯一编码重复"),
    REPAT_PHONE_NUMBER(1198,"该手机号已预约"),
    MENU_NAME_IS_EMPTY(1199,"菜单名不能为空"),
    MENU_URL_IS_EMPTY(1200,"没有二级菜单,菜单路径不能为空"),
    MENU_IS_EMPTY(1201,"二级菜单名和路径都不能为空"),
    EXIST_CHILD_AREA(1202,"存在子区域，不可直接操作！"),
    REGISTERED_PHONE_NUMBER(1202,"改手机号已注册"),
    VALID_ERROR(1203,"参数异常");


    private int code;
    private String msg;

    public static String getMsgByKey(Integer key) {
        for (ResponseInfo em : ResponseInfo.values()) {
            if (em.getCode() == key) {
                return em.getMsg();
            }
        }
        return null;
    }

    private ResponseInfo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
