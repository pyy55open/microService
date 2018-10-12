package com.csy.product.service;

import com.csy.product.ProductApplicationTests;
import com.csy.product.dataobject.Product;
import com.csy.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 廖师兄
 * 2017-12-09 22:03
 */
@Component
public class ProductServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() throws Exception {
        List<Product> list = productService.findUpAll();
        Assert.assertTrue(list.size() > 0);
    }


}