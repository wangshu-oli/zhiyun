package oliver.manage.zhiyun.app.domain.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import oliver.manage.zhiyun.app.domain.entity.GlobalConfigEntity;
import oliver.manage.zhiyun.app.domain.mapper.GlobalConfigMapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhangxiaojian
 * @date 2022年07月14日 15:44
 */
@Repository
public class GlobalConfigRepository extends ServiceImpl<GlobalConfigMapper, GlobalConfigEntity> {
}
