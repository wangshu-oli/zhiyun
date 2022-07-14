package oliver.manage.zhiyun.errorcode;

import lombok.AllArgsConstructor;
import oliver.manage.zhiyun.enums.BusinessLine;

/**
 * @author zhangxiaojian
 * @date 2022年07月14日 13:32
 */
@AllArgsConstructor
public enum DetailErrorCode implements BizErrorCode {

    REQUEST_PARAMS_NOT_VALID("001", "请求参数不合法");

    private String code;
    private String errorMsg;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public BusinessLine getBusinessLine() {
        return BusinessLine.ZHIYUN;
    }

}
