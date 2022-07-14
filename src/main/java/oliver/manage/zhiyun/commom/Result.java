package oliver.manage.zhiyun.commom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.UUID;

/**
 * API统一返回数据封装类
 *
 * @author zhangxiaojian
 * @date 2022年07月14日 13:01
 */
@JsonIgnoreProperties(
    ignoreUnknown = true
)
public class Result<T> implements Serializable {

    public static final String SUCCEED = "SUCCEED";
    public static final String FAILED = "FAILED";
    /**
     * 返回状态:SUCCEED和FAILED
     */
    private String returnStatus;
    /**
     * 时间戳
     */
    @JsonInclude(Include.NON_NULL)
    private Long serverTime;
    /**
     * 请求ID
     */
    @JsonInclude(Include.NON_NULL)
    private String requestId;
    /**
     * 错误码
     */
    @JsonInclude(Include.NON_NULL)
    private String errorCode;
    /**
     * 错误信息
     */
    @JsonInclude(Include.NON_NULL)
    private String errorMessage;
    /**
     * 错误扩展信息
     */
    @JsonInclude(Include.NON_NULL)
    private Object extMessage;
    /**
     * 封装数据
     */
    @JsonInclude(Include.NON_NULL)
    private T data;

    public static <T> Result<T> fail(String errCode, String errMsg) {
        Result<T> result = buildBasic(FAILED);
        result.setErrorCode(errCode);
        result.setErrorMessage(errMsg);
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = success();
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success() {
        return buildBasic(SUCCEED);
    }

    private static <T> Result<T> buildBasic(String status) {
        Result<T> result = new Result<>();
        result.setReturnStatus(status);
        result.setServerTime(System.currentTimeMillis());
        result.setRequestId(createRequestId());
        return result;
    }

    protected static String createRequestId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public String getReturnStatus() {
        return this.returnStatus;
    }

    public Long getServerTime() {
        return this.serverTime;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public Object getExtMessage() {
        return this.extMessage;
    }

    public T getData() {
        return this.data;
    }

    public void setReturnStatus(final String returnStatus) {
        this.returnStatus = returnStatus;
    }

    public void setServerTime(final Long serverTime) {
        this.serverTime = serverTime;
    }

    public void setRequestId(final String requestId) {
        this.requestId = requestId;
    }

    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setExtMessage(final Object extMessage) {
        this.extMessage = extMessage;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Result)) {
            return false;
        } else {
            Result<?> other = (Result) obj;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label95:
                {
                    Object thisServerTime = this.getServerTime();
                    Object otherServerTime = other.getServerTime();
                    if (thisServerTime == null && otherServerTime == null) {
                        break label95;
                    } else if (thisServerTime != null && thisServerTime.equals(otherServerTime)) {
                        break label95;
                    }

                    return false;
                }

                Object thisReturnStatus = this.getReturnStatus();
                Object otherReturnStatus = other.getReturnStatus();
                if (thisReturnStatus == null && otherReturnStatus != null) {
                    return false;
                } else if (thisReturnStatus != null && !thisReturnStatus.equals(otherReturnStatus)) {
                    return false;
                }

                Object thisRequestId = this.getRequestId();
                Object otherRequestId = other.getRequestId();
                if (thisRequestId == null && otherRequestId != null) {
                    return false;
                } else if (thisRequestId != null && !thisRequestId.equals(otherRequestId)) {
                    return false;
                }

                label74:
                {
                    Object thisErrorCode = this.getErrorCode();
                    Object otherErrorCode = other.getErrorCode();
                    if (thisErrorCode == null && otherErrorCode == null) {
                        break label74;
                    } else if (thisErrorCode != null && thisErrorCode.equals(otherErrorCode)) {
                        break label74;
                    }

                    return false;
                }

                label67:
                {
                    Object thisErrorMessage = this.getErrorMessage();
                    Object otherErrorMessage = other.getErrorMessage();
                    if (thisErrorMessage == null && otherErrorMessage == null) {
                        break label67;
                    } else if (thisErrorMessage != null && thisErrorMessage.equals(otherErrorMessage)) {
                        break label67;
                    }

                    return false;
                }

                Object thisExtMessage = this.getExtMessage();
                Object otherExtMessage = other.getExtMessage();
                if (thisExtMessage == null && otherExtMessage != null) {
                    return false;
                } else if (thisExtMessage != null && !thisExtMessage.equals(otherExtMessage)) {
                    return false;
                }

                Object thisData = this.getData();
                Object otherData = other.getData();
                if (thisData == null && otherData != null) {
                    return false;
                } else {
                    return thisData == null || thisData.equals(otherData);
                }
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Result;
    }

    public int hashCode() {
        int result = 1;
        result = result * 59 + (this.getServerTime() == null ? 43 : this.getServerTime().hashCode());
        result = result * 59 + (this.getReturnStatus() == null ? 43 : this.getReturnStatus().hashCode());
        result = result * 59 + (this.getRequestId() == null ? 43 : this.getRequestId().hashCode());
        result = result * 59 + (this.getErrorCode() == null ? 43 : this.getErrorCode().hashCode());
        result = result * 59 + (this.getErrorMessage() == null ? 43 : this.getErrorMessage().hashCode());
        result = result * 59 + (this.getExtMessage() == null ? 43 : this.getExtMessage().hashCode());
        result = result * 59 + (this.getData() == null ? 43 : this.getData().hashCode());
        return result;
    }

    public String toString() {
        return "Result(returnStatus=" + this.getReturnStatus() + ", serverTime=" + this.getServerTime() + ", requestId="
            + this.getRequestId() + ", errorCode=" + this.getErrorCode() + ", errorMessage=" + this.getErrorMessage()
            + ", extMessage=" + this.getExtMessage() + ", data=" + this.getData() + ")";
    }

    public Result() {
    }

}
