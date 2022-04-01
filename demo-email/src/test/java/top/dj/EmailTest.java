package top.dj;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Slf4j
class EmailTest {
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private MimeMessageHelper mimeMessageHelper;
    @Autowired
    private SimpleMailMessage simpleMailMessage;
    @Autowired
    private JavaMailSender javaMailSender;

    // TODO 改为从数据库读取配置进行邮件发送

    @Test
    void simple() {
        simpleMailMessage.setTo("2663239386@qq.com");
        simpleMailMessage.setText("hello6661");
        javaMailSender.send(simpleMailMessage);
    }

    @Test
    void mime() {
        Map<String, Object> paramMap = new HashMap<>(4);
        paramMap.put("NAME", "邓佳");
        paramMap.put("TYPE", "住院登记");
        paramMap.put("DATE", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));

        Map<String, Object> dataMap = new HashMap<>(4);
        dataMap.put("ZYH", "ZY999911");
        dataMap.put("XM", "小王");

        Context context = new Context();
        context.setVariable("paramMap", paramMap);
        context.setVariable("dataMap", dataMap);
        String emailText = templateEngine.process("mail", context);
        try {
            mimeMessageHelper.setTo("18402894534@163.com");
            mimeMessageHelper.setText(emailText, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        // 邮件异步发送
        log.info("邮件发送...");
        javaMailSender.send(mimeMessageHelper.getMimeMessage());
        log.info("发送完成！");
    }

}
