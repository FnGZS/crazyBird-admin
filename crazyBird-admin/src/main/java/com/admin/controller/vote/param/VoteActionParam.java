package com.admin.controller.vote.param;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class VoteActionParam {
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private String actionName;
	private String actionImage;
	private String actionIntro;
	private String voteRuler;
	private String host;
	private String telephone;
	private Integer status;
	private Long visitNum;
	private Long voteSum;
	public Integer getVoteMin() {
		return voteMin;
	}
	public void setVoteMin(Integer voteMin) {
		this.voteMin = voteMin;
	}
	public Integer getVoteMax() {
		return voteMax;
	}
	public void setVoteMax(Integer voteMax) {
		this.voteMax = voteMax;
	}
	private Integer voteMin;
	private Integer voteMax;
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;
	public String getActionImage() {
		return actionImage;
	}
	public void setActionImage(String actionImage) {
		this.actionImage = actionImage;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public String getActionIntro() {
		return actionIntro;
	}
	public void setActionIntro(String actionIntro) {
		this.actionIntro = actionIntro;
	}
	public String getVoteRuler() {
		return voteRuler;
	}
	public void setVoteRuler(String voteRuler) {
		this.voteRuler = voteRuler;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Long getVisitNum() {
		return visitNum;
	}
	public void setVisitNum(Long visitNum) {
		this.visitNum = visitNum;
	}
	public Long getVoteSum() {
		return voteSum;
	}
	public void setVoteSum(Long voteSum) {
		this.voteSum = voteSum;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

}
