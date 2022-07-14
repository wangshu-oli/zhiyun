package oliver.manage.zhiyun.app.controller;

import javax.annotation.Resource;
import oliver.manage.zhiyun.app.domain.entity.GlobalConfigEntity;
import oliver.manage.zhiyun.app.domain.request.GlobalConfigRequest;
import oliver.manage.zhiyun.app.domain.service.GlobalConfigService;
import oliver.manage.zhiyun.commom.Result;
import oliver.manage.zhiyun.constants.Constants;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxiaojian
 * @date 2022年07月14日 16:51
 */
@RestController
@RequestMapping(Constants.VERSION + "/" + Constants.API)
public class GlobalConfigController {

    @Resource
    private GlobalConfigService service;

    @GetMapping("global-config/{configKey}")
    public Result<GlobalConfigEntity> globalConfig(@PathVariable String configKey) {
        return service.getConfig(configKey);
    }

    @PutMapping("global-config")
    public Result<GlobalConfigEntity> globalConfig(@RequestBody GlobalConfigRequest request) {
        return service.saveConfig(request);
    }

    @DeleteMapping("global-config/{id}")
    public Result<GlobalConfigEntity> globalConfig(@PathVariable Long id) {
        return service.delConfig(id);
    }

}
