package oliver.manage.zhiyun.utils;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import oliver.manage.zhiyun.errorcode.DetailErrorCode;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangxiaojian
 * @date 2022年04月25日 15:36
 */
public final class ValidationUtils {

    private static final String COMMA = ",";

    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory()
        .getValidator();

    private ValidationUtils() {
    }

    public static <T> void validateEntity(T obj) {
        Set<ConstraintViolation<T>> set = VALIDATOR.validate(obj, Default.class);
        if (CollectionUtils.isNotEmpty(set)) {
            StringBuilder builder = new StringBuilder();
            for (ConstraintViolation<T> cv : set) {
                builder.append(cv.getMessage()).append(COMMA);
            }
            DetailErrorCode requestParamsNotValid = DetailErrorCode.REQUEST_PARAMS_NOT_VALID;
            requestParamsNotValid.setErrorMsg(StringUtils.removeEnd(builder.toString(), COMMA));
            throw ExceptionUtils.getException(requestParamsNotValid);
        }
    }

}
