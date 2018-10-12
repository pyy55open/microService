package com.csy.product.repository;

import com.csy.product.dataobject.Product;
import com.csy.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 廖师兄
 * 2017-12-09 21:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() throws Exception {
        List<Product> list = productInfoRepository.findByEnableStatus(0);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void findByProductIdIn() throws Exception {
        List<Product> list = productInfoRepository.findByProductidIn(Arrays.asList(1L, 2L));
        System.out.println(list.get(0).getProductname());
        Assert.assertTrue(list.size() > 0);
    }

}