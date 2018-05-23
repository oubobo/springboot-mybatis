package com.oyb.springbootmybatis.controller;

import com.oyb.springbootmybatis.syn.IAsynService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsynController {
    private Logger logger = LoggerFactory.getLogger(AsynController.class);
    @Autowired
    private IAsynService asynService;
    @GetMapping(value = "/asyn" )
    public  void asyn(){
        System.out.println("=========================");
        asynService.asyncInvokeSimplest();
        System.out.println("111111111111111");
    }
}
