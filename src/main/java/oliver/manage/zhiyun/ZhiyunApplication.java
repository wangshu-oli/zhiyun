package oliver.manage.zhiyun;

import cn.dev33.satoken.SaManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ZhiyunApplication {

    public static void main(String[] args) {
        log.info("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
        SpringApplication.run(ZhiyunApplication.class, args);
    }

}
