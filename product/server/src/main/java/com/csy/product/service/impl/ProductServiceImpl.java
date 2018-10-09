package com.csy.product.service.impl;

import com.csy.product.dataobject.ProductInfo;
import com.csy.product.repository.ProductInfoRepository;
import com.csy.product.service.ProductService;
import com.csy.product.enums.ProductStatusEnum;
import com.csy.product.enums.ResultEnum;
import com.csy.product.exception.ProductException;
import com.csy.product.utils.JsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by 廖师兄
 * 2017-12-09 21:59
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private AmqpTemplate amqpTemplate;


    @Override
    public List<ProductInfo> findUpAll() {
        return null;
    }
}
