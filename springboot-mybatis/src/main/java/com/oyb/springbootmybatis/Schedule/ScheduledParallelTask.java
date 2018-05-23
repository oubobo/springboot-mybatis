//package com.oyb.springbootmybatis.Schedule;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
///**
// * 并行定时器
// * ScheduleConfig 继承SchedulingConfigurer类并重写其方法即可，这样既可达到并行
// * 其中 @EnableScheduling 注解的作用是发现注解@Scheduled的任务并后台执行。
// *Springboot本身默认的执行方式是串行执行，也就是说无论有多少task，都是一个线程串行执行，并行需手动配置
// */
//@Component
//public class ScheduledParallelTask {
//
//    private static final Logger logger = LoggerFactory.getLogger(ScheduledParallelTask.class);
//
//    @Scheduled(cron="* 0/10 * * * ?")
//    public void executeFileDownLoadTask() {
//
//        // 间隔1秒钟,执行任务
//        Thread current = Thread.currentThread();
//        System.out.println("定时任务1:"+current.getId());
//        logger.info("ScheduledTest.executeFileDownLoadTask 定时任务1:"+current.getId()+ ",name:"+current.getName());
//    }
//}
