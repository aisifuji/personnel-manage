package cn.edu.xmut.personnelmanage.common;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/3/9 17:14
 */
public class ResponseResult {

    private int code = 0;
    private Object data;
    private String msg;

    public ResponseResult() {
    }

    public ResponseResult(Object data) {
        this.data = data;
    }

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(Object data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    public ResponseResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
