package oliver.manage.zhiyun.app.domain.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author zhangxiaojian
 * @date 2022年07月14日 17:01
 */
@Data
public class GlobalConfigRequest {

    @NotBlank(message = "配置Key不能为空")
    private String configKey;

    @NotBlank(message = "配置内容不能为空")
    private String configValue;

    @NotBlank(message = "描述内容不能为空")
    private String description;
}
