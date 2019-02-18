package com.admin.dao.secondary.dataobject;

import com.admin.service.base.PageQueryDO;

public class SecondaryOrderPO extends PageQueryDO{
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
