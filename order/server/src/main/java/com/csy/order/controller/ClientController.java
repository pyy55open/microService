package com.csy.order.controller;

import com.csy.order.client.ProductClient;
import com.csy.order.config.RestTemplateConfig;
import com.csy.order.dataobject.Product;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    ProductClient productClient;

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/getProductMsg")
    public String getProductMsg(){
//        1.
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8081/msg",String.class);
//        2.
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort()) + "/msg";
//        String response = restTemplate.getForObject(url,String.class);

//        3
//        String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);
        String response = productClient.getProductMsg();
        return response;
    }

    @GetMapping("/getProductList")
    public List<Product> getProductList(){
        List<Product> list = productClient.getProductList(Arrays.asList(1L,2L));
        return list;
    }
}
