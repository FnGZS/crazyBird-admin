package com.admin.controller.upload.model;

import java.util.List;

import com.admin.controller.base.AbstractFlagModel;

public class MultiPicUploadModel extends AbstractFlagModel{
	private List<String> urlList;

	public List<String> getUrlList() {
		return urlList;
	}

	public void setUrlList(List<String> urlList) {
		this.urlList = urlList;
	}
	
}
