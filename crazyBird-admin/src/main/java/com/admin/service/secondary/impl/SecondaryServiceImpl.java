package com.admin.service.secondary.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.admin.dao.lost.dataobject.LostDTO;
import com.admin.dao.secondary.SecondaryDao;
import com.admin.dao.secondary.dataobject.RefundApplyDO;
import com.admin.dao.secondary.dataobject.SecondaryGoodsDO;
import com.admin.dao.secondary.dataobject.SecondaryGoodsPO;
import com.admin.dao.secondary.dataobject.SecondaryGoodsSearchDO;
import com.admin.dao.secondary.dataobject.SecondaryGoodsViolationDO;
import com.admin.dao.secondary.dataobject.SecondaryOrderDO;
import com.admin.dao.secondary.dataobject.SecondaryOrderPO;
import com.admin.service.base.ResponsePageQueryDO;
import com.admin.service.secondary.SecondaryService;
import com.admin.dao.secondary.dataobject.SecondaryTypeDO;

@Component("SecondaryService")
public class SecondaryServiceImpl implements SecondaryService{
	@Autowired 
	SecondaryDao secondaryDao;

	@Override
	public ResponsePageQueryDO<List<SecondaryGoodsDO>> getSecondaryGoodsList(SecondaryGoodsPO po) {
		ResponsePageQueryDO<List<SecondaryGoodsDO>> response = new ResponsePageQueryDO<>();
		response.setPageSize(po.getPageSize());

		response.setTotal(secondaryDao.getSecondaryGoodsCount(po.getStatus()));
		if((response.getTotal() > 0) && (response.getTotalPage() > po.getPageIndex())) {
			List<SecondaryGoodsDO> dataResult = secondaryDao.getSecondaryGoodsList(po);
			response.setDataResult(dataResult);
		}
		else {
			response.setMessage("到底了");
		}
		return response;
	}

	@Override
	public SecondaryGoodsDO getSecondaryGoods(SecondaryGoodsSearchDO searchDO) {

		return secondaryDao.getSecondaryGoodsById(searchDO);
	}

	@Override
	public boolean updateSecondaryGoods(SecondaryGoodsDO goodsDO) {
		if(secondaryDao.updateSecondaryGoods(goodsDO) > 0) {
			if(goodsDO.getStatus()==2) {
				SecondaryGoodsViolationDO violationDO = new SecondaryGoodsViolationDO();
				violationDO.setGoodsId(goodsDO.getId());
				violationDO.setIsView(0);
				violationDO.setNotice(1);
				violationDO.setUserId(goodsDO.getUserId());
				secondaryDao.insertSecondaryGoodsViolation(violationDO);
			}
			return true;
		}
		
		return false;
	}

	@Override
	public void deleteSecondaryGoods(Long id) {
		secondaryDao.deleteSecondaryGoods(id);
		
	}

	@Override
	public int addSecondaryGoods(SecondaryGoodsDO goodsDO) {

		return secondaryDao.addSecondaryGoods(goodsDO);
	}
	
	@Override
	public List<SecondaryTypeDO> getSecondaryType() {

		return secondaryDao.getSecondaryType();
	}

	@Override
	public List<SecondaryTypeDO> getSecondaryWay() {

		return secondaryDao.getSecondaryWay();
	}

	@Override
	public List<SecondaryTypeDO> getSecondaryTradingWay() {

		return secondaryDao.getSecondaryTradingWay();
	}


	@Override
	public ResponsePageQueryDO<List<SecondaryOrderDO>> getSecondaryOrderList(SecondaryOrderPO po) {
		ResponsePageQueryDO<List<SecondaryOrderDO>> response = new ResponsePageQueryDO<>();
		response.setPageSize(po.getPageSize());
		response.setTotal(secondaryDao.getSecondaryOrderCount(po.getStatus()));
		if((response.getTotal() > 0) && (response.getTotalPage() > po.getPageIndex())) {
			List<SecondaryOrderDO> dataResult = secondaryDao.getSecondaryOrderList(po);
			response.setDataResult(dataResult);
		}
		else {
			response.setMessage("到底了");
		}
		return response;
	}
	
	@Override
	public SecondaryOrderDO getSecondaryOrder(String orderId) {

		return secondaryDao.getSecondaryOrder(orderId);
	}

	@Override
	public void deleteSecondaryOrder(String orderId) {
		secondaryDao.deleteSecondaryOrder(orderId);
		
	}

	@Override
	public int updateSecondaryOrder(SecondaryOrderDO orderDO) {

		return secondaryDao.updateSecondaryOrder(orderDO);
	}

	@Override
	public List<SecondaryGoodsDO> getSecondaryGoodsByName(SecondaryGoodsSearchDO searchDO) {
		
		return secondaryDao.getSecondaryGoodsByName(searchDO);
	}

	@Override
	public List<RefundApplyDO> getRefundApply(String orderId) {
		
		return secondaryDao.getRefundApply(orderId);
	}
	
}
