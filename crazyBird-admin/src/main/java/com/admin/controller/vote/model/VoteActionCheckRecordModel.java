package com.admin.controller.vote.model;

import com.admin.controller.base.AbstractFlagModel;

public class VoteActionCheckRecordModel extends AbstractFlagModel{
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	private Integer status;
	private String detail;
}
