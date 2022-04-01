package top.dj.job;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: DengJia
 * @Date: 2022/3/29 22:09
 * @Description: 定时任务
 */

@Slf4j
@Component
public class TaskJob {

    /**
     * 按照标准时间进行计算，每隔 10s 执行一次。
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void job1() {
        log.info("【job1】开始执行：{}", DateUtil.formatDateTime(new Date()));
    }

    /**
     * 从项目启动时间开始，每间隔 2s（固定的时间间隔） 执行一次。
     */
    @Scheduled(fixedDelay = 2000)
    public void job2() {
        log.info("【job2】开始执行：{}", DateUtil.formatDateTime(new Date()));
    }

    /**
     * 从项目启动时间开始，延迟 5s 后每间隔 4s 执行一次。
     */
    @Scheduled(initialDelay = 5000, fixedDelay = 4000)
    public void job3() {
        log.info("【job3】开始执行：{}", DateUtil.formatDateTime(new Date()));
    }
}
