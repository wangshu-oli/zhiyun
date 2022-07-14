package oliver.manage.zhiyun.exception;

import oliver.manage.zhiyun.errorcode.BizErrorCode;

/**
 * @author zhangxiaojian
 * @date 2022年07月14日 13:19
 */
public class BizException extends RuntimeException {

    private final String errorCode;
    private final String errorMessage;

    public BizException(BizErrorCode errorCode) {
        super(errorCode.getErrorMsg());
        this.errorCode = errorCode.get6Code();
        this.errorMessage = errorCode.getErrorMsg();
    }

    public BizException(BizErrorCode errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode.get6Code();
        this.errorMessage = errorMessage;
    }

    public BizException(BizErrorCode errorCode, String errorMessage, Throwable throwable) {
        super(throwable);
        this.errorCode = errorCode.get6Code();
        this.errorMessage = errorMessage;
    }

    public BizException(BizErrorCode errorCode, Throwable throwable) {
        super(throwable);
        this.errorCode = errorCode.get6Code();
        this.errorMessage = errorCode.getErrorMsg();
    }

    public BizException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BizException(String errorCode, String errorMessage, Throwable throwable) {
        super(throwable);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
