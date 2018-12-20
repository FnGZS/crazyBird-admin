package com.admin.controller.lost.param;

import com.admin.controller.base.AbstractOrderPageParam;

public class LostPageParam extends AbstractOrderPageParam{
	private Integer typeId;
	private String key;
	private Integer messageId;
	private Long publisher;
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public Long getPublisher() {
		return publisher;
	}
	public void setPublisher(Long publisher) {
		this.publisher = publisher;
	}
	
}
