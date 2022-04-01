package top.dj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.dj.job.TaskJob;

@SpringBootTest
class TaskTest {

    @Autowired
    private TaskJob taskJob;

    @Test
    void contextLoads() {
        taskJob.job1();
    }

}
