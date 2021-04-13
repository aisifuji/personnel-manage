package cn.edu.xmut.personnelmanage.base;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/4/12 15:26
 */
public class CommonException extends RuntimeException {
    private int errorCode;
    private Class<?> errorClass;
    private String errorMsg;
    private String detailErrorMsg;

    public CommonException(Throwable cause, int errorCode, String errorMsg) {
        super(cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public CommonException(int errorCode, String errorMsg, Class<?> errorClass) {
        this.errorClass = errorClass;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public CommonException(Throwable cause, int errorCode, Class<?> errorClass, String errorMsg) {
        super(cause);
        this.errorCode = errorCode;
        this.errorClass = errorClass;
        this.errorMsg = errorMsg;
    }

    public CommonException(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public CommonException(String errorMsg) {
        this.errorCode = 200;
        this.errorMsg = errorMsg;
    }

    public CommonException(int errorCode, Class<?> errorClass, String errorMsg) {
        this.errorCode = errorCode;
        this.errorClass = errorClass;
        this.errorMsg = errorMsg;
    }

    public CommonException(int errorCode, String errorMsg, String detailErrorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.detailErrorMsg = detailErrorMsg;
    }

    public CommonException(int errorCode, Class<?> errorClass, String errorMsg, String detailErrorMsg) {
        this.errorCode = errorCode;
        this.errorClass = errorClass;
        this.errorMsg = errorMsg;
        this.detailErrorMsg = detailErrorMsg;
    }

    public CommonException(Throwable cause, int errorCode, String errorMsg, String detailErrorMsg) {
        super(cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.detailErrorMsg = detailErrorMsg;
    }

    public CommonException(Throwable cause, int errorCode, Class<?> errorClass, String errorMsg, String detailErrorMsg) {
        super(cause);
        this.errorCode = errorCode;
        this.errorClass = errorClass;
        this.errorMsg = errorMsg;
        this.detailErrorMsg = detailErrorMsg;
    }

    public String getMessage() {
        return this.errorMsg;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Class<?> getErrorClass() {
        return this.errorClass;
    }

    public void setErrorClass(Class<?> errorClass) {
        this.errorClass = errorClass;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getDetailErrorMsg() {
        return this.detailErrorMsg;
    }

    public void setDetailErrorMsg(String detailErrorMsg) {
        this.detailErrorMsg = detailErrorMsg;
    }
}
