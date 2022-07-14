package oliver.manage.zhiyun.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import java.time.LocalDateTime;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/*
 * 自动填充公共字段
 * @author zhangxiaojian
 * @date 2022年04月25日 15:36
 */
@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {

    private static final String CREATE_BY = "createdBy";
    private static final String CREATE_TIME = "createdTime";
    private static final String UPDATE_BY = "updatedBy";
    private static final String UPDATE_TIME = "updatedTime";
    private static final String DEFAULT_INSERT_UPDATE_PERSON = "系统管理员";

    @Override
    public void insertFill(MetaObject metaObject) {
        //这里创建人ID暂时写死，等之后有登录规则后修改
        this.strictInsertFill(metaObject, CREATE_BY, String.class, DEFAULT_INSERT_UPDATE_PERSON);
        this.strictInsertFill(metaObject, CREATE_TIME, LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, UPDATE_BY, String.class, DEFAULT_INSERT_UPDATE_PERSON);
        this.strictInsertFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //这里创建人ID暂时写死，等之后有登录规则后修改
        this.strictUpdateFill(metaObject, UPDATE_BY, String.class, DEFAULT_INSERT_UPDATE_PERSON);
        this.strictUpdateFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
    }
}
