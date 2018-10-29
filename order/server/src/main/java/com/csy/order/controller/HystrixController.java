package com.csy.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.hibernate.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {
    //设置超时时间
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty( name ="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
    //加到配置文件
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
//    })
    @GetMapping("getProductListInfo")
    @HystrixCommand
    public String getProductList(@RequestParam("index")Integer i){
       if(i % 2 == 0){
           return "success";
       }
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://127.0.0.1:8081/product/list4list", Arrays.asList(1L),String.class);
//        throw new RuntimeException("异常了");
    }

    public String fallback(){
        return "服务器太拥挤。";
    }
    public String defaultFallback(){
        return "默认fallback：服务器太拥挤。";
    }
}
