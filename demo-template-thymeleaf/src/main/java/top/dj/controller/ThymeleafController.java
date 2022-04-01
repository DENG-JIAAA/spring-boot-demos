package top.dj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @Author: DengJia
 * @Date: 2022/3/28 22:07
 * @Description:
 */

@Slf4j
@RestController
@RequestMapping("/")
public class ThymeleafController {
    @Autowired
    private TemplateEngine templateEngine;

    @GetMapping("/{name}")
    public String thymeleaf(@PathVariable("name") String name) {
        Context context = new Context();
        context.setVariable("NAME", name);
        return templateEngine.process("emailTemplate", context);
    }
}
