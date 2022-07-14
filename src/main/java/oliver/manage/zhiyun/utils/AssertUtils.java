package oliver.manage.zhiyun.utils;

import oliver.manage.zhiyun.errorcode.DetailErrorCode;

/**
 * @author zhangxiaojian
 * @date 2022年07月14日 13:29
 */
public final class AssertUtils {

    private AssertUtils() {
    }

    public static void isTrue(boolean condition, DetailErrorCode errorCode) {
        if (!condition) {
            throw ExceptionUtils.getException(errorCode);
        }
    }

}
