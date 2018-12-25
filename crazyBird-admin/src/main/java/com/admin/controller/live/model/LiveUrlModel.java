package com.admin.controller.live.model;

import java.util.List;

import com.admin.controller.base.AbstractFlagModel;

public class LiveUrlModel extends AbstractFlagModel{
	private List<LiveUrlItem> list ;

	public List<LiveUrlItem> getList() {
		return list;
	}

	public void setList(List<LiveUrlItem> list) {
		this.list = list;
	}
	
}
