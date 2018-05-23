package com.oyb.springbootmybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TymeleafController {

    @RequestMapping(value = "/thymeleaf" ,method = RequestMethod.GET)
    public String thymeleaf(Model model) {
        String name = "haha";
        System.out.println("hello===============");
        model.addAttribute("name", name);
        return "hellon";
    }

}
