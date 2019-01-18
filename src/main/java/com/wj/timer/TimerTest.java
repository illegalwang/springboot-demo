package com.wj.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务测试，在启动类中加上@EnableScheduling启用定时任务
 * 在定时方法上加上@Scheduled 完成。如下。
 * Created by wj on 2019/1/17.
 */
@Component
public class TimerTest {

//    @Scheduled(cron = "*/6 * * * * ?")
//    public void test() {
//        System.out.println("****timer测试成功，六秒一次*****************************************************************");
//    }

//    @Scheduled(fixedRate = 3000)
//    public void test2() {
//        System.out.println("****这个3秒一次*************************************************************************");
//    }
}
