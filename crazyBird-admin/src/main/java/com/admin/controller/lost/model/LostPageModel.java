package com.admin.controller.lost.model;

import java.util.List;

import com.admin.controller.base.AbstractPageFlagModel;

public class LostPageModel extends AbstractPageFlagModel{
	private List<LostItem> items;

	public List<LostItem> getItems() {
		return items;
	}

	public void setItems(List<LostItem> items) {
		this.items = items;
	}
	
}
