package oliver.manage.zhiyun.app.domain.service;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import javax.annotation.Resource;
import oliver.manage.zhiyun.app.domain.entity.GlobalConfigEntity;
import oliver.manage.zhiyun.app.domain.repository.GlobalConfigRepository;
import oliver.manage.zhiyun.app.domain.request.GlobalConfigRequest;
import oliver.manage.zhiyun.commom.Result;
import org.springframework.stereotype.Service;

/**
 * @author zhangxiaojian
 * @date 2022年07月14日 15:40
 */
@Service
public class GlobalConfigService {

    @Resource
    private GlobalConfigRepository repository;

    private static final String CONFIG_KEY = "config_key";

    public Result<GlobalConfigEntity> getConfig(String configKey) {
        QueryWrapper<GlobalConfigEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(CONFIG_KEY, configKey);
        GlobalConfigEntity config = repository.getOne(wrapper);
        return Result.success(config);
    }

    public Result<GlobalConfigEntity> saveConfig(GlobalConfigRequest request) {
        GlobalConfigEntity config = Convert.convert(GlobalConfigEntity.class, request);
        QueryWrapper<GlobalConfigEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(CONFIG_KEY, config.getConfigKey());
        repository.saveOrUpdate(config, wrapper);
        return Result.success();
    }

    public Result<GlobalConfigEntity> delConfig(Long id) {
        repository.removeById(id);
        return Result.success();
    }

}
