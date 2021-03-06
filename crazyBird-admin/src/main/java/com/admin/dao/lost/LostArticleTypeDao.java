package com.admin.dao.lost;

import java.util.List;

import com.admin.dao.lost.dataobject.LostTypeDO;

public abstract interface LostArticleTypeDao {
	List<LostTypeDO> getLostType();

	boolean insert(LostTypeDO dO);

	boolean delete(Long id);

	boolean update(LostTypeDO update);
}
