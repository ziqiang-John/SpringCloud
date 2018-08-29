package com.accenture;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class EurekaClientApplication {
    @Bean
    public ActiveMQQueue queue(){
        return new ActiveMQQueue("promoteAct");
    }
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

}
