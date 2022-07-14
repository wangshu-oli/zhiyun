package oliver.manage.zhiyun.app.domain.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * @author zhangxiaojian
 * @date 2022年07月14日 13:56
 */
@Data
public class EmployeeRequest {

    /**
     * 账号
     */
    @NotBlank(message = "账户不能为空")
    @Size(message = "账户不能超过32个字符")
    private String account;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Size(message = "密码不能超过255个字符")
    private String password;
    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    @Size(message = "姓名不能超过255个字符")
    private String name;
    /**
     * 手机号
     */
    @Pattern(regexp = "/^1(3\\d|4[5-9]|5[0-35-9]|6[567]|7[0-8]|8\\d|9[0-35-9])\\d{8}$/", message = "手机号码格式错误")
    private String cellphone;

}
