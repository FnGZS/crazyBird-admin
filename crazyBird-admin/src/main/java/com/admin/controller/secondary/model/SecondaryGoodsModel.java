package com.admin.controller.secondary.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.admin.controller.base.AbstractFlagModel;
import com.admin.controller.base.AbstractPageFlagModel;

public class SecondaryGoodsModel extends AbstractPageFlagModel{
	private List<SecondaryGoodsItem> list;

	public List<SecondaryGoodsItem> getList() {
		return list;
	}

	public void setList(List<SecondaryGoodsItem> list) {
		this.list = list;
	}
	
	
}
