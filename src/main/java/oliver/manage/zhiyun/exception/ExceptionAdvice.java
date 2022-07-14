package oliver.manage.zhiyun.exception;

import java.util.Iterator;
import javax.validation.ConstraintViolationException;
import oliver.manage.zhiyun.commom.Result;
import oliver.manage.zhiyun.errorcode.BaseErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

/**
 * @author zhangxiaojian
 * @date 2022年07月14日 13:00
 */
@ControllerAdvice
public class ExceptionAdvice {

    protected Logger log = LoggerFactory.getLogger(this.getClass());
    private static final String ERROR_LOG_TEMPLATE = "Handle thrown exception to failed result";

    public ExceptionAdvice() {
    }

    @ExceptionHandler({BizException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result<Object> ftbExceptionHandler(BizException exception) {
        return Result.fail(exception.getErrorCode(), exception.getErrorMessage());
    }

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Result<Object> runtimeExceptionHandler(RuntimeException exception) {
        this.log.error(ERROR_LOG_TEMPLATE, exception);
        return Result.fail(BaseErrorCode.INTERNAL_SERVER_ERROR.get6Code(), exception.getMessage());
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result<Object> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException exception) {
        this.log.error(ERROR_LOG_TEMPLATE, exception);
        return Result.fail(BaseErrorCode.BAD_REQUEST.get6Code(), exception.getMessage());
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Object> constraintViolationExceptionHandler(ConstraintViolationException exception) {
        this.log.error(ERROR_LOG_TEMPLATE, exception);
        return Result.fail(BaseErrorCode.BAD_REQUEST.get6Code(), exception.getMessage());
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result<Object> methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException exception) {
        this.log.error(ERROR_LOG_TEMPLATE, exception);
        return Result.fail(BaseErrorCode.BAD_REQUEST.get6Code(), exception.getMessage());
    }

    @ExceptionHandler({DuplicateKeyException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Result<Object> duplicateKeyExceptionHandler(DuplicateKeyException exception) {
        this.log.error(ERROR_LOG_TEMPLATE, exception);
        return Result.fail(BaseErrorCode.INTERNAL_SERVER_ERROR.get6Code(), exception.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result<Object> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        this.log.error(ERROR_LOG_TEMPLATE, exception);
        String message = "传入参数异常";
        BindingResult result = exception.getBindingResult();
        if (result.hasErrors()) {
            Iterator<ObjectError> var4 = result.getAllErrors().iterator();
            if (var4.hasNext()) {
                ObjectError error = var4.next();
                message = error.getDefaultMessage();
            }
        }

        return Result.fail(BaseErrorCode.BAD_REQUEST.get6Code(), message);
    }

}
