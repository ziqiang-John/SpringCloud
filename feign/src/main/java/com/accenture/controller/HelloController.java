package com.accenture.controller;

import com.accenture.serivce.SchedualServiceHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private SchedualServiceHello schedualServiceHello;
    @GetMapping(value = "/hello")
    public String sayHello(@RequestParam(value = "name")String name){
        return schedualServiceHello.sayHelloFromClientOne(name);
    }
}
