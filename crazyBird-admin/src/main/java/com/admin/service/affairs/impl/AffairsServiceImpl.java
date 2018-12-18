package com.admin.service.affairs.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.admin.dao.affairs.AffairsDao;
import com.admin.dao.affairs.AffairsMenuDao;
import com.admin.dao.affairs.dataobject.AddAffairDO;
import com.admin.dao.affairs.dataobject.AffairsDO;
import com.admin.dao.affairs.dataobject.AffairsPO;
import com.admin.dao.affairs.dataobject.AffairsTypeDO;
import com.admin.dao.affairs.dataobject.addAffairsTypeDO;
import com.admin.service.affairs.AffairsService;
import com.admin.service.base.ResponseDO;
import com.admin.service.base.ResponsePageQueryDO;
import com.admin.service.base.ResponseCode;


@Component("AffairsService")
public class AffairsServiceImpl implements AffairsService{

	@Autowired
	private AffairsDao affairsDao;
	@Autowired
	private AffairsMenuDao affairsMenuDao;
	
	@Override
	public ResponsePageQueryDO<List<AffairsDO>> getAffairsList(AffairsPO po) {
		ResponsePageQueryDO<List<AffairsDO>> response = new ResponsePageQueryDO<>();
		response.setPageSize(po.getPageSize());
		response.setTotal(affairsDao.getAffairsCount(po));
		if(response.getTotal() > 0 && response.getTotalPage() > po.getPageIndex()){
			List<AffairsDO> dataResult = affairsDao.getAffairs(po);
			response.setDataResult(dataResult);
		}
		return response;
	}

	@Override
	public ResponseDO<Long> addAffair(AddAffairDO affair) {
		ResponseDO<Long> result = new ResponseDO<>();
		if(affair!=null) {
			affairsDao.addAffairs(affair);
			result.setMessage("添加成功");
			result.setDataResult((long) 1);
			return result;
		}
		result.setCode(ResponseCode.ERROR);
		result.setDataResult((long) 0);
		return result;
	}

	@Override
	public ResponseDO<Long> deleteAffair(Long id) {
		ResponseDO<Long> result = new ResponseDO<>();
		AffairsDO affair = affairsDao.getAffairsDetails(id);
		if(affair != null) {
			affairsDao.deleteAffair(id);
			result.setMessage("删除成功");
			result.setDataResult((long) 1);
			return result;
		}
		result.setCode(ResponseCode.ERROR);
		result.setDataResult((long) 0);
		return result;
	}

	@Override
	public AffairsDO getAffairsDetails(Long id) {
		AffairsDO affairs = affairsDao.getAffairsDetails(id);
		affairsDao.update(affairs);
		return affairs;
	}

	@Override
	public ResponseDO<Long> update(AffairsDO update) {
		ResponseDO<Long> result = new ResponseDO<>();
		AffairsDO affair = affairsDao.getAffairsDetails(update.getId());
		if(affair != null) {
			affairsDao.update(update);
			result.setMessage("修改成功");
			result.setDataResult((long) 1);
			return result;
		}
		result.setCode(ResponseCode.ERROR);
		result.setDataResult((long) 0);
		return result;
	}

	@Override
	public List<AffairsTypeDO> getAffairsType() {
		return affairsMenuDao.getAffairsType();
	}

	@Override
	public ResponseDO<Long> addAffairsType(addAffairsTypeDO DO) {
		ResponseDO<Long> result = new ResponseDO<>();
		if(DO!=null) {
			affairsMenuDao.addAffairsType(DO);
			result.setMessage("添加成功");
			result.setDataResult((long) 1);
			return result;
		}
		result.setCode(ResponseCode.ERROR);
		result.setDataResult((long) 0);
		return result;
	}

	@Override
	public ResponseDO<Long> deleteAffairsType(Long id) {
		ResponseDO<Long> result = new ResponseDO<>();
		if(id!=null) {
			affairsMenuDao.deleteAffairsType(id);
			result.setMessage("删除成功");
			result.setDataResult((long) 1);
			return result;
		}
		result.setCode(ResponseCode.ERROR);
		result.setDataResult((long) 0);
		return result;
	}



}
