package oliver.manage.zhiyun.errorcode;

import oliver.manage.zhiyun.enums.BusinessLine;

/**
 * @author zhangxiaojian
 * @date 2022年07月14日 13:23
 */
public enum BaseErrorCode implements BizErrorCode {

    SUCCESS("000", "成功"),

    INTERNAL_SERVER_ERROR("001", "服务内部错误"),

    BAD_REQUEST("002", "请求不合法"),

    UNKNOWN_ERROR("003", "未知错误");

    private final String code;
    private final String errorMsg;

    public String getCode() {
        return this.code;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public BusinessLine getBusinessLine() {
        return BusinessLine.ZHIYUN;
    }

    BaseErrorCode(final String code, final String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }
}
