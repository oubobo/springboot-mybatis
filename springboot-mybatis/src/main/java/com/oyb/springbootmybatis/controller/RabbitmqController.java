package com.oyb.springbootmybatis.controller;

import com.oyb.springbootmybatis.rabbitmq.CallbackSender;
import com.oyb.springbootmybatis.rabbitmq.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RabbitmqController {

    @Autowired
    private Sender sender;

    @Autowired
    private CallbackSender callbackSender;




    @GetMapping("/send")
    public String send(HttpServletRequest request, @RequestParam("msg") String msg) {
        sender.send(msg);
        return "Send OK.";
    }

    @GetMapping("/callbackSender")
    public String callbackSender(HttpServletRequest request, @RequestParam("msg") String msg) {
        sender.send(msg);
        return "Send OK.";
    }


}
