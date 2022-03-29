package top.dj.template.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @Author: DengJia
 * @Date: 2022/3/28 22:07
 * @Description:
 */

@RestController
@RequestMapping("/")
public class ThymeleafController {
    @Autowired
    private TemplateEngine templateEngine;

    @GetMapping("/")
    public String thymeleaf() {
        Context context = new Context();
        context.setVariable("NAME", " DENG-JIAAA ");
        return templateEngine.process("emailTemplate", context);
    }
}
