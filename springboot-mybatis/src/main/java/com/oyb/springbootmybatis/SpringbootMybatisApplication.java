package com.oyb.springbootmybatis;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;


@SpringBootApplication

@MapperScan("com.oyb.springbootmybatis.mapper")
@EnableScheduling
@EnableAsync
public class SpringbootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisApplication.class, args);

	/*	//注册异步定时器
		AnnotationConfigApplicationContext rootContext =
				new AnnotationConfigApplicationContext();

		rootContext.register(RootContextConfiguration.class);
		rootContext.refresh();*/

	}


}
