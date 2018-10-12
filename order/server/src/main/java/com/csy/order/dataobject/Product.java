package com.csy.order.dataobject;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_product")
public class Product {
	@Id
    @Column(name = "product_id")
	private Long productid;
    @Column(name = "product_name")
	private String productname;
    @Column(name = "product_desc")
	private String productdesc;
    @Column(name = "img_addr")
    private String imgaddr;
    @Column(name = "normal_price")
	private String normalprice;
    @Column(name = "promotion_price")
	private String promotionprice;
    @Column(name = "level")
	private Integer level;
    @Column(name = "create_time")
	private Date createTime;
    @Column(name = "update_time")
	private Date updateTime;
    @Column(name = "enable_status")
	private Integer enableStatus;
    @Column(name = "product_category_id")
    private String productCategoryid;
    @Column(name = "shop_id")
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
}
