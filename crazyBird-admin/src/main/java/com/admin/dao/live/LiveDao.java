package com.admin.dao.live;

import java.util.List;

import com.admin.dao.live.dataobject.LiveDO;

public interface LiveDao {
	int addPushUrl(LiveDO liveDO);
	List<LiveDO> getPushUrlList();
}
