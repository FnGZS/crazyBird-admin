package com.admin.controller.secondary.model;

import java.math.BigDecimal;
import java.util.List;

import com.admin.controller.base.AbstractFlagModel;
import com.admin.controller.base.AbstractPageFlagModel;

public class SecondaryOrderModel extends AbstractPageFlagModel{
	private List<SecondaryOrderItem> list;

	public List<SecondaryOrderItem> getList() {
		return list;
	}

	public void setList(List<SecondaryOrderItem> list) {
		this.list = list;
	}
	
}
