package oliver.manage.zhiyun.app.domain.service;

import cn.dev33.satoken.stp.StpUtil;
import javax.annotation.Resource;
import oliver.manage.zhiyun.app.domain.entity.Employee;
import oliver.manage.zhiyun.app.domain.repository.EmployeeRepository;
import oliver.manage.zhiyun.app.domain.repository.GlobalConfigRepository;
import oliver.manage.zhiyun.commom.Result;
import oliver.manage.zhiyun.errorcode.DetailErrorCode;
import oliver.manage.zhiyun.utils.ExceptionUtils;
import oliver.manage.zhiyun.utils.SecureUtils;
import org.springframework.stereotype.Service;

/**
 * @author zhangxiaojian
 * @date 2022年07月14日 15:40
 */
@Service
public class EmployeeService {

    @Resource
    private EmployeeRepository repository;
    @Resource
    private GlobalConfigRepository globalConfigRepository;

    private static final String AES_BASE64_KEY = "AES_BASE64_KEY";

    public Result<Boolean> login(String account, String password) {
        Employee employee = repository.getEmployee(account);
        if (employee == null) {
            throw ExceptionUtils.getException(DetailErrorCode.NONEXISTENT_EMPLOYEE);
        }
        String config = globalConfigRepository.getConfig(AES_BASE64_KEY);
        String decryptedPassword = SecureUtils.decryptHexPassword(config, employee.getPassword());
        if (password.equals(decryptedPassword)) {
            StpUtil.login(employee.getId());
            return Result.success();
        } else {
            throw ExceptionUtils.getException(DetailErrorCode.PASSWORD_WRONG_ERROR);
        }
    }

}
