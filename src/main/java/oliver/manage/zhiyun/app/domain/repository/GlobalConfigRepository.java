package oliver.manage.zhiyun.app.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    private static final String CONFIG_KEY = "config_key";

    public String getConfig(String configKey) {
        QueryWrapper<GlobalConfigEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(CONFIG_KEY, configKey);
        GlobalConfigEntity config = this.getOne(wrapper);
        return config.getConfigValue();
    }
}
