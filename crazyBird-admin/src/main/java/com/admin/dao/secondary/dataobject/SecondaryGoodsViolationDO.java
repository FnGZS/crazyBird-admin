package com.admin.dao.secondary.dataobject;

public class SecondaryGoodsViolationDO {
	private Integer id;
	private Long goodsId;
	private Long userId;
	private Integer notice;
	private Integer isView;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getNotice() {
		return notice;
	}
	public void setNotice(Integer notice) {
		this.notice = notice;
	}
	public Integer getIsView() {
		return isView;
	}
	public void setIsView(Integer isView) {
		this.isView = isView;
	}
	
	
	
}
