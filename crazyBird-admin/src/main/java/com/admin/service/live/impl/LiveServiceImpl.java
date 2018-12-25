package com.admin.service.live.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.admin.dao.live.LiveDao;
import com.admin.dao.live.dataobject.LiveDO;
import com.admin.service.live.LiveService;
@Component("LiveService")
public class LiveServiceImpl implements LiveService{
	@Autowired
	private LiveDao liveDao;

	@Override
	public int addPushUrl(LiveDO liveDO) {
		
		return liveDao.addPushUrl(liveDO);
	}

	@Override
	public List<LiveDO> getPushUrlList() {
		// TODO Auto-generated method stub
		return liveDao.getPushUrlList();
	}
}
