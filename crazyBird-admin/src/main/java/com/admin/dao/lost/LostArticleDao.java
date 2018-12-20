package com.admin.dao.lost;

import java.util.List;

import com.admin.dao.lost.dataobject.LostArticleDO;
import com.admin.dao.lost.dataobject.LostDTO;
import com.admin.dao.lost.dataobject.LostPO;

public abstract interface LostArticleDao {

	Integer getLostCount(LostPO po);

	List<LostDTO> getLost(LostPO po);

	LostDTO getLostDetails(Long id);

	void updateBrow(LostDTO lost);

	int insert(LostArticleDO dO);

	int delete(Long id);
	
}
