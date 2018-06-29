package com.accenture.serivce;

import com.accenture.hystrix.SchedualServiceHelloHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-client",fallback = SchedualServiceHelloHystrix.class)
public interface SchedualServiceHello {
    @GetMapping(value = "/hello")
    String sayHelloFromClientOne(@RequestParam(value = "name")String name);
}
