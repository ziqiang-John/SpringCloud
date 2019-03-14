package com.accenture.controller;

import com.accenture.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueController {
    @Autowired
    private QueueService queueService;
    @RequestMapping("requestQueue")
    public String requeQueue(@RequestParam("request")String request){
        return queueService.requestQueue(request);
    }
}
