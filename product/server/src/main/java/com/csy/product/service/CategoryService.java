package com.csy.product.service;

import com.csy.product.dataobject.ProductCategory;
import com.csy.product.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * Created by 廖师兄
 * 2017-12-09 22:06
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryIdIn(List<Long> categoryidList);
}
