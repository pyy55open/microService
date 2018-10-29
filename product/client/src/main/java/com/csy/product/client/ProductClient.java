package com.csy.product.client;


import com.csy.product.common.DecreaseStockInput;
import com.csy.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by 廖师兄
 * 2017-12-10 21:04
 */
@FeignClient(name = "product",fallback = ProductClient.ProductClientFallback.class)
public interface ProductClient {

    @PostMapping("/product/list4Order")
    List<ProductInfoOutput> list4Order(@RequestBody List<String> productIDList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);

    @Component
    static class ProductClientFallback implements ProductClient{

        @Override
        public List<ProductInfoOutput> list4Order(List<String> productIDList) {
            return null;
        }

        @Override
        public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {

        }
    }
}
