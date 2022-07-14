package oliver.manage.zhiyun.app.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import javax.annotation.Resource;
import oliver.manage.zhiyun.app.domain.entity.Employee;
import oliver.manage.zhiyun.app.domain.mapper.EmployeeMapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhangxiaojian
 * @date 2022年07月14日 15:44
 */
@Repository
public class EmployeeRepository extends ServiceImpl<EmployeeMapper, Employee> {

    @Resource
    private EmployeeMapper mapper;

    private static final String ACCOUNT = "account";

    public Employee getEmployee(String account) {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq(ACCOUNT, account);
        return mapper.selectOne(wrapper);
    }

}
