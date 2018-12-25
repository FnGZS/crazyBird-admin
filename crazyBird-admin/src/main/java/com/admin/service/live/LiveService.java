package com.admin.service.live;

import java.util.List;

import com.admin.dao.live.dataobject.LiveDO;

public interface LiveService {
	int addPushUrl(LiveDO liveDO);
	List<LiveDO> getPushUrlList();
}
