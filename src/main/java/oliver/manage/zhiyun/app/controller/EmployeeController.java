package oliver.manage.zhiyun.app.controller;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import oliver.manage.zhiyun.app.domain.service.EmployeeService;
import oliver.manage.zhiyun.commom.Result;
import oliver.manage.zhiyun.constants.Constants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxiaojian
 * @date 2022年07月14日 13:36
 */
@RestController
@RequestMapping(Constants.VERSION + "/" + Constants.API)
@Slf4j
public class EmployeeController {

    @Resource
    private EmployeeService service;

    @GetMapping("login/{account}/{password}")
    public Result<Boolean> login(@PathVariable String account, @PathVariable String password) {
        return service.login(account, password);
    }

}
