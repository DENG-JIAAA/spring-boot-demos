package top.dj.config;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/**
 * @Author: DengJia
 * @Date: 2022/4/1 21:21
 * @Description: 定时任务配置类 等同于YML文件配置
 */

@Configuration
@EnableScheduling
@ComponentScan(basePackages = {"top.dj.job"})
public class TaskConfig implements SchedulingConfigurer {

    @Bean
    public Executor executor() {
        BasicThreadFactory.Builder builder = new BasicThreadFactory.Builder();
        ThreadFactory factory = builder.namingPattern("Job-Thread-%d").build();
        return new ScheduledThreadPoolExecutor(20, factory);
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(executor());
    }
}
