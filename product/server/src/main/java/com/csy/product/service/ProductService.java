package com.csy.product.service;

import com.csy.product.common.DecreaseStockInput;
import com.csy.product.dataobject.Product;

import java.util.List;

/**
 * Created by 廖师兄
 * 2017-12-09 21:57
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<Product> findUpAll();

    /**
     * 查询所有商品列表
     * @param productIdList
     * @return
     */
    List<Product> findList(List<Long> productIdList);

    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
