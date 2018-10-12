package com.csy.order.client;

import com.csy.order.dataobject.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/msg")
    String getProductMsg();

    @PostMapping("/product/list4list")
    List<Product> getProductList(@RequestBody List<Long> productidList);
}
