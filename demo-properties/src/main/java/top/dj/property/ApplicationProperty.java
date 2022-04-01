package top.dj.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: DengJia
 * @Date: 2022/4/1 22:31
 * @Description: 项目配置信息
 */

@Data
@Component
public class ApplicationProperty {
    @Value("${application.name}")
    private String name;

    @Value("${application.version}")
    private String version;

}
