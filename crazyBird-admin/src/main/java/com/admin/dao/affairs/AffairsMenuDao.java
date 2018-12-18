package com.admin.dao.affairs;

import java.util.List;

import com.admin.dao.affairs.dataobject.AffairsTypeDO;
import com.admin.dao.affairs.dataobject.addAffairsTypeDO;

public interface AffairsMenuDao {

	List<AffairsTypeDO> getAffairsType();
	
	void addAffairsType(addAffairsTypeDO dO);

	void deleteAffairsType(long id);

}
