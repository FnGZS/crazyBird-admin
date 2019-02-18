package com.admin.controller.secondary.model;

import java.util.Date;
import java.util.List;

import com.admin.controller.base.AbstractFlagModel;

public class SecondaryRefundModel extends AbstractFlagModel{
	private List<SecondaryRefundItem> list;

	public List<SecondaryRefundItem> getList() {
		return list;
	}

	public void setList(List<SecondaryRefundItem> list) {
		this.list = list;
	}
	
	
}
