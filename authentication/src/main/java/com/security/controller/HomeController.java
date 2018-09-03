package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }
}