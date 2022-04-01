package top.dj;

import cn.hutool.core.util.StrUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: DengJia
 * @Date: 2022/4/1 22:17
 * @Description: hello world
 */

@SpringBootApplication
@RestController
@RequestMapping("/")
public class HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }

    /**
     * Hello, world.
     *
     * @param name 非必须参数
     * @return Hello, ${name}.
     */
    @GetMapping("/hello")
    public String hello(@RequestParam(required = false, name = "name") String name) {
        if (StrUtil.isBlank(name)) {
            name = "world";
        }
        return StrUtil.format("Hello, {}.", name);
    }

}
