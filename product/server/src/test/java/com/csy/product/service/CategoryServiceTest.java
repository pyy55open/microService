package com.csy.product.service;

import com.csy.product.ProductApplicationTests;
import com.csy.product.ProductApplicationTests;
import com.csy.product.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 廖师兄
 * 2017-12-09 22:07
 */
@Component
public class CategoryServiceTest extends ProductApplicationTests {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> list = categoryService.findByCategoryIdIn(Arrays.asList(1L, 2L));
        Assert.assertTrue(list.size() > 0);
    }

}