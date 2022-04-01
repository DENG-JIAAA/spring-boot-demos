package top.dj.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: DengJia
 * @Date: 2022/4/1 22:30
 * @Description: 开发者人员自定义配置信息
 */

@Data
@Component
@ConfigurationProperties(prefix = "developer")
public class DeveloperProperty {
    private String name;
    private String website;
    private String qq;
    private String phoneNumber;
}
