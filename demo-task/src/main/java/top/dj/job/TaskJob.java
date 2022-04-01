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
    public void task() {

    }

    @Scheduled(cron = "0/10 * * * * ?")
    public void job1() {
        log.info("【job1】开始执行：{}", DateUtil.formatDateTime(new Date()));
    }
}
