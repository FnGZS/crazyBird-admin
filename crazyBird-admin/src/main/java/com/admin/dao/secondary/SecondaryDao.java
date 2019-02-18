package com.admin.dao.secondary;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.admin.dao.secondary.dataobject.RefundApplyDO;
import com.admin.dao.secondary.dataobject.SecondaryGoodsDO;
import com.admin.dao.secondary.dataobject.SecondaryGoodsPO;
import com.admin.dao.secondary.dataobject.SecondaryGoodsSearchDO;
import com.admin.dao.secondary.dataobject.SecondaryGoodsViolationDO;
import com.admin.dao.secondary.dataobject.SecondaryOrderDO;
import com.admin.dao.secondary.dataobject.SecondaryOrderPO;
import com.admin.dao.secondary.dataobject.SecondaryTypeDO;

public interface SecondaryDao {
	Integer getSecondaryGoodsCount(@Param ("status") Integer status);
	List<SecondaryGoodsDO> getSecondaryGoodsList(SecondaryGoodsPO po);
	SecondaryGoodsDO getSecondaryGoodsById(SecondaryGoodsSearchDO searchDO);
	List<SecondaryGoodsDO> getSecondaryGoodsByName(SecondaryGoodsSearchDO searchDO);
	int updateSecondaryGoods(SecondaryGoodsDO goodsDO);
	void deleteSecondaryGoods(Long id);
	int addSecondaryGoods(SecondaryGoodsDO goodsDO);
	void insertSecondaryGoodsViolation(SecondaryGoodsViolationDO violationDO);
	
	int getSecondaryOrderCount(@Param ("status") Integer status);
	List<SecondaryOrderDO> getSecondaryOrderList(SecondaryOrderPO po);
	SecondaryOrderDO getSecondaryOrder(String orderId);
	void deleteSecondaryOrder(String orderId);
	int updateSecondaryOrder(SecondaryOrderDO orderDO);
	
	List<SecondaryTypeDO>  getSecondaryType();
	List<SecondaryTypeDO>  getSecondaryWay();
	List<SecondaryTypeDO>  getSecondaryTradingWay();
	
	List<RefundApplyDO> getRefundApply(String orderId);
	
	
}
