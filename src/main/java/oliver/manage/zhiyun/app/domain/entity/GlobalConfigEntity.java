package oliver.manage.zhiyun.app.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import oliver.manage.zhiyun.commom.BaseEntity;

/**
 * @author zhangxiaojian
 * @date 2022年07月14日 16:54
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("global_config")
public class GlobalConfigEntity extends BaseEntity {

    private String configKey;

    private String configValue;

    private String description;

}
