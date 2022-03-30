package top.dj.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @Author: DengJia
 * @Date: 2022/3/30 11:32
 * @Description:
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.mail")
public class EmailConfig {
    private String host;
    private String protocol;
    private String defaultEncoding;
    private String username;
    private String password;

    @Autowired
    private JavaMailSender javaMailSender;

    @Bean
    public SimpleMailMessage simpleMailMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        //主题
        message.setSubject("账号激活");
        //发送者
        message.setFrom(username);
        //抄送
        message.setCc(username);

        return message;
    }

    @Bean
    public MimeMessageHelper mimeMessageHelper() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        // 主题
        mimeMessageHelper.setSubject("消息推送");
        // 发送者
        mimeMessageHelper.setFrom(username);
        // 抄送
        mimeMessageHelper.setCc(username);

        return mimeMessageHelper;
    }

}
