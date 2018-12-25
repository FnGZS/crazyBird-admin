package com.admin.service.lost;

import java.util.List;

import com.admin.controller.lost.param.LostExamineParam;
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

	ResponseDO<Long> lostUpdate(LostArticleDO update);

	ResponseDO<LostDTO> lostTypeInput(LostTypeDO dO);

	ResponseDO<LostDTO> lostTypeDelete(Long id);

	ResponseDO<Long> lostTypeUpdate(LostTypeDO update);

	ResponseDO<LostDTO> lostExamineUpdate(LostDTO update);



	


}
