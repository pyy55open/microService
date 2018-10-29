package com.csy.product.service.impl;

import com.csy.product.common.DecreaseStockInput;
import com.csy.product.common.ProductInfoOutput;
import com.csy.product.dataobject.Product;
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
    public List<Product> findUpAll() {
        return null;
    }

    @Override
    public List<Product> findList(List<Long> productIdList) {
        return productInfoRepository.findByProductidIn(productIdList);
    }

    @Override
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfoOutput> productInfoOutputList = decreaseStockMsg(decreaseStockInputList);
        amqpTemplate.convertAndSend("productInfo",JsonUtil.toJson(productInfoOutputList));
    }

    @Transactional
    public List<ProductInfoOutput> decreaseStockMsg(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfoOutput> productInfoOutputList = new ArrayList<ProductInfoOutput>();
        for (DecreaseStockInput decreaseStockInput: decreaseStockInputList) {
            Optional<Product> productInfoOptional = productInfoRepository.findById(decreaseStockInput.getProductId());
            //判断商品是否存在
            if (!productInfoOptional.isPresent()){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Product product = productInfoOptional.get();
            //库存是否足够
            Integer result = product.getStock() - decreaseStockInput.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            product.setStock(result);
            productInfoRepository.save(product);
            ProductInfoOutput productInfoOutput = new ProductInfoOutput();
            BeanUtils.copyProperties(product,productInfoOutput);
            productInfoOutputList.add(productInfoOutput);
        }
        return productInfoOutputList;
    }
}
