package com.admin.controller.secondary.param;

import java.math.BigDecimal;
import java.util.Date;

public class SecondaryGoodsParam {
	private Long id;
	private Long userId;
	private String goodsTitle;
	private String goodsContent;
	private String goodsImag;
	private String postion;
	private Integer goodsType;
	private Integer status;
	private Integer views;
	private Integer goodsWay;
	private Integer tradingWay;
	private String telephone;
	private BigDecimal price;
	private BigDecimal oldPrice;
	private Date gmtCreated;
	private Date gmtModified;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getGoodsTitle() {
		return goodsTitle;
	}
	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}
	public String getGoodsContent() {
		return goodsContent;
	}
	public void setGoodsContent(String goodsContent) {
		this.goodsContent = goodsContent;
	}
	public String getGoodsImag() {
		return goodsImag;
	}
	public void setGoodsImag(String goodsImag) {
		this.goodsImag = goodsImag;
	}
	public String getPostion() {
		return postion;
	}
	public void setPostion(String postion) {
		this.postion = postion;
	}
	public Integer getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}
	public Integer getGoodsWay() {
		return goodsWay;
	}
	public void setGoodsWay(Integer goodsWay) {
		this.goodsWay = goodsWay;
	}
	public Integer getTradingWay() {
		return tradingWay;
	}
	public void setTradingWay(Integer tradingWay) {
		this.tradingWay = tradingWay;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(BigDecimal oldPrice) {
		this.oldPrice = oldPrice;
	}
	public Date getGmtCreated() {
		return gmtCreated;
	}
	public void setGmtCreated(Date gmtCreated) {
		this.gmtCreated = gmtCreated;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	
	
	
	
}
