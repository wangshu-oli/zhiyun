package oliver.manage.zhiyun.app.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import oliver.manage.zhiyun.commom.BaseEntity;

/**
 * @author zhangxiaojian
 * @date 2022年07月14日 15:29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("employee")
public class Employee extends BaseEntity {

    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String cellphone;

}
