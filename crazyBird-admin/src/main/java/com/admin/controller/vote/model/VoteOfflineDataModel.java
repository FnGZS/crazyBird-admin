package com.admin.controller.vote.model;

import java.util.List;

import com.admin.controller.base.AbstractFlagModel;
import com.admin.controller.vote.param.VoteListOffLineItem;

public class VoteOfflineDataModel extends AbstractFlagModel{
	private Integer sum;
	private List<VoteListOffLineItem> list;
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	public List<VoteListOffLineItem> getList() {
		return list;
	}
	public void setList(List<VoteListOffLineItem> list) {
		this.list = list;
	}
	
}
