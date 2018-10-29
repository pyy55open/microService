package com.csy.order.dataobject;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 廖师兄
 * 2017-12-10 16:06
 */
@Data
@Entity
@Table(name = "tb_order")
public class OrderMaster {

    /** 订单id. */
    @Id
    @Column(name = "order_id")
    private String orderId;

    /** 买家名字. */
    @Column(name = "buyer_name")
    private String buyerName;

    /** 买家手机号. */
    @Column(name = "buyer_phone")
    private String buyerPhone;

    /** 买家地址. */
    @Column(name = "buyer_address")
    private String buyerAddress;

    /** 买家微信Openid. */
    @Column(name = "buyer_openid")
    private String buyerOpenid;

    /** 订单总金额. */
    @Column(name = "order_amount")
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    @Column(name = "order_status")
    private Integer orderStatus;

    /** 支付状态, 默认为0未支付. */
    @Column(name = "pay_status")
    private Integer payStatus;

    /** 创建时间. */
    @Column(name = "create_time")
    private Date createTime;

    /** 更新时间. */
    @Column(name = "update_time")
    private Date updateTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getBuyerOpenid() {
        return buyerOpenid;
    }

    public void setBuyerOpenid(String buyerOpenid) {
        this.buyerOpenid = buyerOpenid;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
