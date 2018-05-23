package com.oyb.springbootmybatis.controller;

import com.oyb.springbootmybatis.redis.RedisClient;
import com.oyb.springbootmybatis.vo.MybatisInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class RedisController {

    private static final Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedisClient redisClient;

    /**
     * 缓存测试
     *
     * @return
     * @author SHANHY
     * @create 2016年9月12日
     */
    @GetMapping("/redisTest")
    public String redisTest() {
        try {
            redisTemplate.opsForValue().set("test-key", "111111", 100000, TimeUnit.SECONDS);// 缓存有效期2秒
            logger.info("从Redis中读取数据：" + redisTemplate.opsForValue().get("test-key").toString());

            TimeUnit.SECONDS.sleep(3);

            logger.info("等待3秒后尝试读取过期的数据：" + redisTemplate.opsForValue().get("test-key"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "OK";
    }

    @GetMapping(value = "/redisSet")
    public String  redisSet(){
        redisClient.set("test-keys", "111111", 100000);
        return redisClient.get("test-keys");
    }
    @GetMapping(value = "/delSet")
    public Long delKey(){
       return  redisClient.del("test-keys");
    }
    @GetMapping(value = "/putObj")
    public Object putObject(){
        MybatisInfoVO vo = new MybatisInfoVO();
        vo.setId(1L);
        vo.setCupSize("FFFFF");
        vo.setAge("F");

        redisClient.putObject("oyb",vo,10000);
        return redisClient.getObject("oyb");
    }



}
