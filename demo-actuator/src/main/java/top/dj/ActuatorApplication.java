package top.dj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: DengJia
 * @Date: 2022/4/2 21:38
 * @Description: 集成spring-boot-starter-actuator用于监控spring-boot的启动和运行状态
 */

@SpringBootApplication
public class ActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplication.class, args);
    }

}
