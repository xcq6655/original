package com.xcq.original.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SystemController {

    @RequestMapping(value = "/")
    public String loginPage(){
        return "/login.html";
    }

    @RequestMapping(value = "/xcqError")
    public String errorPage(){
        return "/error.html";
    }
}
