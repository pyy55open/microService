package com.csy.product.service.impl;

import com.csy.product.dataobject.ProductCategory;
import com.csy.product.repository.ProductCategoryRepository;
import com.csy.product.service.CategoryService;
import com.csy.product.dataobject.ProductCategory;
import com.csy.product.repository.ProductCategoryRepository;
import com.csy.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 廖师兄
 * 2017-12-09 22:06
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;


    @Override
    public List<ProductCategory> findByCategoryIdIn(List<Long> categoryidList) {
        return productCategoryRepository.findByCategoryIdIn(categoryidList);
    }
}
