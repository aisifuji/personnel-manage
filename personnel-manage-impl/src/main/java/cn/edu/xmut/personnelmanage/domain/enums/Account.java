package cn.edu.xmut.personnelmanage.domain.enums;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/3/12 10:15
 */
public enum  Account {
    NORMAL(0,"启用"),
    FORBIDDEN(1,"禁用");

    private int code;
    private String msg;

    Account(int code, String msg) {
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
