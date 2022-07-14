package oliver.manage.zhiyun.utils;

import oliver.manage.zhiyun.errorcode.BizErrorCode;
import oliver.manage.zhiyun.exception.BizException;

/**
 * @author zhangxiaojian
 * @date 2022年07月14日 13:29
 */
public final class ExceptionUtils {

    private ExceptionUtils() {
    }

    public static BizException getException(BizErrorCode bizErrorCode) {
        return new BizException(bizErrorCode);
    }

    public static BizException getException(BizErrorCode bizErrorCode, String errorMessage) {
        return new BizException(bizErrorCode, errorMessage);
    }

    public static BizException getException(BizErrorCode bizErrorCode, Throwable cause) {
        return new BizException(bizErrorCode, cause);
    }

    public static BizException getException(BizErrorCode bizErrorCode, String errorMessage, Throwable cause) {
        return new BizException(bizErrorCode, errorMessage, cause);
    }

}
