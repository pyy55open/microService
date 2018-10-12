package com.csy.product.common;

import lombok.Data;
import lombok.Getter;

/**
 * 减库存入参
 * Created by 廖师兄
 * 2018-01-20 22:50
 */
@Data
@Getter
public class DecreaseStockInput {

    private Long productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(Long productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}