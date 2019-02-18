package com.admin.controller.secondary.model;

import java.util.List;

import com.admin.controller.base.AbstractFlagModel;

public class SecondaryTypeModel extends AbstractFlagModel{
	private List<SecondaryTypeItem> list;

	public List<SecondaryTypeItem> getList() {
		return list;
	}

	public void setList(List<SecondaryTypeItem> list) {
		this.list = list;
	}
	
}
