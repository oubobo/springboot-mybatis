package com.oyb.springbootmybatis.controller;

import com.oyb.springbootmybatis.mapper.MybatisInfoMapper;
import com.oyb.springbootmybatis.service.MailService;
import com.oyb.springbootmybatis.vo.MybatisInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import  java.util.List;
import org.springframework.ui.Model;

@RestController
public class MyBatisController {

    private static final Logger logger = LoggerFactory.getLogger(MyBatisController.class);

    @Autowired
    MybatisInfoMapper mybatisInfoMapper;

    @Autowired
    private MailService mailService;

    @GetMapping(value = "/getAll")
    public List<MybatisInfoVO> getAll(){
        return mybatisInfoMapper.getAll();
    }

    @PostMapping(value = "/add")
    public  void insert(@RequestBody MybatisInfoVO vo){
        System.out.println("11111111111111");

        mybatisInfoMapper.insert(vo);
    }

    @GetMapping(value = "/getOne/{id}")
    public MybatisInfoVO getOne(@PathVariable("id") Long id){
      return   mybatisInfoMapper.getOne(id);

    }

    @PostMapping(value = "/update" )
    public  void update(@RequestBody  MybatisInfoVO vo){

        logger.info("id={}",vo.getId());
        logger.info("age={}",vo.getAge());
        logger.info("cupSize={}",vo.getCupSize());
        mybatisInfoMapper.update(vo);

    }
    @GetMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id){
            logger.info("id={}",id);
            mybatisInfoMapper.delete(id);
    }

    @GetMapping(value = "/senndMail")
    public void senndMail(){

        mailService.sendSimpleMail("ouyangbo@jrzhuxue.com","邮件测试","hahaha");

    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(Model model) {
        String name = "haha";
        model.addAttribute("name", name);
        return "hellon";
    }






}
