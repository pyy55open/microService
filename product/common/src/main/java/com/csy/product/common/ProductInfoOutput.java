package com.csy.product.common;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 廖师兄
 * 2017-12-09 21:23
 */
@Data
public class ProductInfoOutput {

    private Long productid;

    private String productname;

    private String productdesc;

    private String imgaddr;

    private String normalprice;

    private String promotionprice;

    private Integer level;

    private Integer stock;

    private Date createTime;

    private Date updateTime;

    private Integer enableStatus;

    private String productCategoryid;

    private String shopid;

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdesc() {
        return productdesc;
    }

    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc;
    }

    public String getImgaddr() {
        return imgaddr;
    }

    public void setImgaddr(String imgaddr) {
        this.imgaddr = imgaddr;
    }

    public String getNormalprice() {
        return normalprice;
    }

    public void setNormalprice(String normalprice) {
        this.normalprice = normalprice;
    }

    public String getPromotionprice() {
        return promotionprice;
    }

    public void setPromotionprice(String promotionprice) {
        this.promotionprice = promotionprice;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public String getProductCategoryid() {
        return productCategoryid;
    }

    public void setProductCategoryid(String productCategoryid) {
        this.productCategoryid = productCategoryid;
    }

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid;
    }
}
