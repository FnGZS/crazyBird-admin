package com.admin.dao.lost;

import java.util.List;

import com.admin.dao.lost.dataobject.LostTypeDO;

public abstract interface LostMessageDao {
	List<LostTypeDO> getLostMessage();
}
