package oliver.manage.zhiyun.app.controller;

import cn.dev33.satoken.stp.StpUtil;
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
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
       /* if ("zhang".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            return "登录成功";
        }
        return "登录失败";*/
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

}
