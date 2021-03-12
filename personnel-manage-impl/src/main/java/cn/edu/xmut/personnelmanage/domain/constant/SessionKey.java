package cn.edu.xmut.personnelmanage.domain.constant;

/**
 * @Author wangjian
 * @Date 2019-10-08 9:00
 * 常量
 */
public class SessionKey {

    /**
     * 角色数据权限
     */
    public static final String ROLE_DATA_PERMISSION = "role_data_permission";
    /**
     * 角色公众号数据权限wechat
     */
    public static final String AREA_ROLE_DATA_PERMISSION = "area_role_data_permission";

    /**
     * 角色机构数据权限organ
     */
    public static final String PLACE_ROLE_DATA_PERMISSION = "place_role_data_permission";


    /**
     * 默认初始化密码
     */
    public static final String DEFAULT_INIT_PASSWORD = "123456";//NOSONAR

    /**
     * session:用户
     */
    public static final String SESSION_USER = "user";


    /**
     * 用户角色
     */
    public static final String SESSION_USER_ROLES = "role_user";

    /**
     * session:验证码
     */
    public static final String SESSION_VERIFICATION_CODE = "verification_code";

    /**
     * token前缀
     */
    public static final String TOKEN_PRE = "token_pre_";

    /**
     * app的验证码过期时间（30分钟）
     */
    public static final Integer APP_CODE_TIME_OUT = 30 * 60 * 1000;

    /**
     * app的登录超时时间（7天）
     */
    public static final Integer APP_LOGIN_TIME_OUT = 7 * 24 * 60 * 60 * 1000;


    /**
     * 对称加密规则
     */
    public final static String ASE_ENCODE_RULES = "herocheer";

    /**
     * 用户:admin
     */
    public static final String USER_ADMIN = "admin";


    /**
     * app端传递的token的参
     */
    public static final String TOKEN = "token";

}
