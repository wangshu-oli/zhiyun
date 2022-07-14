package oliver.manage.zhiyun.app.domain.service;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.DES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import java.nio.charset.StandardCharsets;
import javax.annotation.Resource;
import oliver.manage.zhiyun.app.domain.entity.Employee;
import oliver.manage.zhiyun.app.domain.repository.EmployeeRepository;
import oliver.manage.zhiyun.commom.Result;
import org.springframework.stereotype.Service;

/**
 * @author zhangxiaojian
 * @date 2022年07月14日 15:40
 */
@Service
public class EmployeeService {

    @Resource
    private EmployeeRepository repository;

    public Result<Boolean> login(String account, String password) {
        Employee employee = repository.getEmployee(account);
        DES des = SecureUtil.des(employee.getPassword().getBytes(StandardCharsets.UTF_8));
        return Result.success();
    }

    public static void main(String[] args) {

        String password = "314159";
        byte[] key = Base64.decode("43dBvnie8LfRiFDxJfBT+w==".getBytes(StandardCharsets.UTF_8));
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);

        String str = aes.encryptHex(password);
        System.out.println("str = " + str);

        String aaa = aes.decryptStr(str, CharsetUtil.CHARSET_UTF_8);
        System.out.println("aaa = " + aaa);
    }
}
