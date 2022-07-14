package oliver.manage.zhiyun.errorcode;

import oliver.manage.zhiyun.enums.BusinessLine;

/**
 * @author zhangxiaojian
 * @date 2022年07月14日 13:19
 */
public interface BizErrorCode {
    String getCode();

    String getErrorMsg();

    BusinessLine getBusinessLine();

    default String get6Code() {
        return String.format("%s%s", this.getBusinessLine().getCode(), this.getCode());
    }

}
