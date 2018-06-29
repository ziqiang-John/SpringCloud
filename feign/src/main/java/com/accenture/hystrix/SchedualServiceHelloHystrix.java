package com.accenture.hystrix;

import com.accenture.serivce.SchedualServiceHello;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHelloHystrix implements SchedualServiceHello{
    @Override
    public String sayHelloFromClientOne(String name){
        return "sorry "+name+",some error happend";
    }
}
