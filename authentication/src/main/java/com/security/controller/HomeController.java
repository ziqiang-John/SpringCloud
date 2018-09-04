package com.security.controller;

import com.security.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @Autowired
    CustomUserDetailsService customUserDetailsService;
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }
    @GetMapping("/getUser")
    @ResponseBody
    public String getUser(@RequestParam("userName")String userName){
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(userName);
        return userDetails.getUsername();
    }
}