package com.csy.product.repository;

import com.csy.product.dataobject.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 廖师兄
 * 2017-12-09 21:29
 */
public interface ProductInfoRepository extends JpaRepository<Product, Long>{

    List<Product> findByEnableStatus(Integer enableStatus);

    List<Product> findByProductidIn(List<Long> productIdList);

}
