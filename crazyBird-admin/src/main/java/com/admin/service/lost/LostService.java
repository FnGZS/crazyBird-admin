package com.admin.service.lost;

import java.util.List;

import com.admin.dao.lost.dataobject.LostArticleDO;
import com.admin.dao.lost.dataobject.LostDTO;
import com.admin.dao.lost.dataobject.LostPO;
import com.admin.dao.lost.dataobject.LostTypeDO;
import com.admin.service.base.ResponseDO;
import com.admin.service.base.ResponsePageQueryDO;

public abstract interface LostService {
	List<LostTypeDO> getLostMessage();

	List<LostTypeDO> getLostType();

	ResponsePageQueryDO<List<LostDTO>> getLostList(LostPO po);

	LostDTO getLostDetails(Long id);

	ResponseDO<LostDTO> lostInput(LostArticleDO dO);

	ResponseDO<LostDTO> lostDelete(Long id);


}
