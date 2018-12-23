package com.admin.controller.lost.model;

import com.admin.controller.base.AbstractFlagModel;

public class LostDetailsModel extends AbstractFlagModel{
	private LostItem details;

	public LostItem getDetails() {
		return details;
	}

	public void setDetails(LostItem details) {
		this.details = details;
	}
	
}
