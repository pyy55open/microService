package com.csy.product.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 廖师兄
 * 2017-12-09 21:37
 */
@Data
@Entity
@Table(name = "tb_product_category")
public class ProductCategory {

    @Id
    @GeneratedValue
    @Column(name = "product_category_id")
    private Long categoryId;

    /** 类目名字. */
    @Column(name = "product_category_name")
    private String categoryName;

    @Column(name = "shop_id")
    private Long shopid;

    @Column(name = "level")
    private Integer level;

    @Column(name = "create_time")
    private Date createTime;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getShopid() {
        return shopid;
    }

    public void setShopid(Long shopid) {
        this.shopid = shopid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
