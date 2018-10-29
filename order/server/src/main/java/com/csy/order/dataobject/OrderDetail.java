package com.csy.order.dataobject;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by 廖师兄
 * 2017-12-10 16:07
 */
@Data
@Entity
@Table(name="tb_order_detail")
public class OrderDetail {

    @Id
    @Column(name = "detail_id")
    private String detailId;

    /** 订单id. */
    @Column(name = "order_id")
    private String orderId;

    /** 商品id. */
    @Column(name = "product_id")
    private String productId;

    /** 商品名称. */
    @Column(name = "product_name")
    private String productName;

    /** 商品单价. */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /** 商品数量. */
    @Column(name = "product_quantity")
    private Integer productQuantity;

    /** 商品小图. */
    @Column(name = "product_icon")
    private String productIcon;

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }
}
