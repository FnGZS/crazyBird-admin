package com.admin.controller.lost.model;

import java.util.List;

import com.admin.controller.base.AbstractFlagModel;

public class LostMessageModel extends AbstractFlagModel{

	private List<LostMessageItem> LostTypeList;

	public List<LostMessageItem> getLostTypeList() {
		return LostTypeList;
	}

	public void setLostTypeList(List<LostMessageItem> lostTypeList) {
		LostTypeList = lostTypeList;
	}
	

	
}
