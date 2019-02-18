package com.admin.service.secondary;

import java.util.List;

import com.admin.dao.secondary.dataobject.RefundApplyDO;
import com.admin.dao.secondary.dataobject.SecondaryGoodsDO;
import com.admin.dao.secondary.dataobject.SecondaryGoodsPO;
import com.admin.dao.secondary.dataobject.SecondaryGoodsSearchDO;
import com.admin.dao.secondary.dataobject.SecondaryOrderDO;
import com.admin.dao.secondary.dataobject.SecondaryOrderPO;

import com.admin.service.base.ResponsePageQueryDO;
import com.admin.dao.secondary.dataobject.SecondaryTypeDO;

public interface SecondaryService {
	ResponsePageQueryDO<List<SecondaryGoodsDO>> getSecondaryGoodsList(SecondaryGoodsPO po);
	SecondaryGoodsDO getSecondaryGoods(SecondaryGoodsSearchDO searchDO);
	boolean updateSecondaryGoods(SecondaryGoodsDO goodsDO);
	void deleteSecondaryGoods(Long id);
	int addSecondaryGoods(SecondaryGoodsDO goodsDO);
	List<SecondaryGoodsDO> getSecondaryGoodsByName(SecondaryGoodsSearchDO searchDO);
	
	ResponsePageQueryDO<List<SecondaryOrderDO>> getSecondaryOrderList(SecondaryOrderPO po);
	SecondaryOrderDO getSecondaryOrder(String orderId);
	void deleteSecondaryOrder(String orderId);
	int updateSecondaryOrder(SecondaryOrderDO orderDO);
	
	List<SecondaryTypeDO>  getSecondaryType();
	List<SecondaryTypeDO>  getSecondaryWay();
	List<SecondaryTypeDO>  getSecondaryTradingWay();
	
	List<RefundApplyDO> getRefundApply(String orderId);
}
