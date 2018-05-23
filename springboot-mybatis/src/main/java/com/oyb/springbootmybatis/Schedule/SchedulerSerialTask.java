//package com.oyb.springbootmybatis.Schedule;
//
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
///**
// * 串行定时器
// */
//@Component
//public class SchedulerSerialTask {
//
//    private int count = 0;
//    @Scheduled(cron = "* */10 * * * ?")
//    private void process(){
//
//        System.out.println("this is scheduler task runing  "+(count++));
//
//    }
//}
