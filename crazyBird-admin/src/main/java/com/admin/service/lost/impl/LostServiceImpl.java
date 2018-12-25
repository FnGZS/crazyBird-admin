package com.admin.service.lost.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.admin.controller.lost.param.LostExamineParam;
import com.admin.dao.lost.LostArticleDao;
import com.admin.dao.lost.LostArticleTypeDao;
import com.admin.dao.lost.LostMessageDao;
import com.admin.dao.lost.dataobject.LostArticleDO;
import com.admin.dao.lost.dataobject.LostDTO;
import com.admin.dao.lost.dataobject.LostPO;
import com.admin.dao.lost.dataobject.LostTypeDO;
import com.admin.service.base.ResponseCode;
import com.admin.service.base.ResponseDO;
import com.admin.service.base.ResponsePageQueryDO;
import com.admin.service.lost.LostService;

@Component("LostService")
public class LostServiceImpl implements LostService{
	
	@Autowired
	private LostMessageDao lostMessageDao;
	@Autowired
	private LostArticleTypeDao lostArticleTypeDao;
	@Autowired
	private LostArticleDao lostArticleDao;

	@Override
	public List<LostTypeDO> getLostMessage() {
		return lostMessageDao.getLostMessage();
	}

	@Override
	public List<LostTypeDO> getLostType() {
		return lostArticleTypeDao.getLostType();
	}

	@Override
	public ResponsePageQueryDO<List<LostDTO>> getLostList(LostPO po) {
		ResponsePageQueryDO<List<LostDTO>> response = new ResponsePageQueryDO<>();
		response.setPageSize(po.getPageSize());
		response.setTotal((Integer)lostArticleDao.getLostCount(po));
		if((response.getTotal() > 0) && (response.getTotalPage() > po.getPageIndex())) {
			List<LostDTO> dataResult = lostArticleDao.getLost(po);
			response.setDataResult(dataResult);
		}
		else {
			response.setMessage("到底了");
		}
		return response;
	}

	@Override
	public LostDTO getLostDetails(Long id) {
		LostDTO lost = lostArticleDao.getLostDetails(id);
		lostArticleDao.updateBrow(lost);
		return lost;
	}

	@Override
	public ResponseDO<LostDTO> lostInput(LostArticleDO dO) {
		ResponseDO<LostDTO> response = new ResponseDO<>();
		int status = lostArticleDao.insert(dO);
		if(status == 1) {
			response.setCode(ResponseCode.SUCCESS);
			response.setMessage("录入成功");
		}
		else {
			response.setCode(ResponseCode.ERROR);
			response.setMessage("录入失败");
		}
		return response;
	}

	@Override
	public ResponseDO<LostDTO> lostDelete(Long id) {
		ResponseDO<LostDTO> response = new ResponseDO<>();
		int status = lostArticleDao.delete(id);
		if(status == 1) {
			response.setCode(ResponseCode.SUCCESS);
			response.setMessage("删除成功");
		}
		else {
			response.setCode(ResponseCode.ERROR);
			response.setMessage("删除失败");
		}
		return response;
	}

	@Override
	public ResponseDO<Long> lostUpdate(LostArticleDO update) {
		ResponseDO<Long> response = new ResponseDO<>();
		int status = lostArticleDao.update(update);
		if(status == 1) {
			response.setCode(ResponseCode.SUCCESS);
			response.setMessage("修改成功");
		}else {
			response.setCode(ResponseCode.ERROR);
			response.setMessage("修改失败");
		}
		return response;
	}

	@Override
	public ResponseDO<LostDTO> lostTypeInput(LostTypeDO dO) {
		ResponseDO<LostDTO> response = new ResponseDO<>();
		if(lostArticleTypeDao.insert(dO)) {
			response.setCode(ResponseCode.SUCCESS);
			response.setMessage("录入成功");
		}
		else {
			response.setCode(ResponseCode.ERROR);
			response.setMessage("录入失败");
		}
		return response;
	}

	@Override
	public ResponseDO<LostDTO> lostTypeDelete(Long id) {
		ResponseDO<LostDTO> response = new ResponseDO<>();
		if(lostArticleTypeDao.delete(id)) {
			response.setCode(ResponseCode.SUCCESS);
			response.setMessage("删除成功");
		}
		else {
			response.setCode(ResponseCode.ERROR);
			response.setMessage("删除失败");
		}
		return response;
	}

	@Override
	public ResponseDO<Long> lostTypeUpdate(LostTypeDO update) {
		ResponseDO<Long> response = new ResponseDO<>();
		if(lostArticleTypeDao.update(update)) {
			response.setCode(ResponseCode.SUCCESS);
			response.setMessage("修改成功");
		}
		else {
			response.setCode(ResponseCode.ERROR);
			response.setMessage("修改失败");
		}
		return response;
	}

	@Override
	public ResponseDO<LostDTO> lostExamineUpdate(LostDTO update) {
		ResponseDO<LostDTO> response = new ResponseDO<>();
		if(lostArticleDao.examine(update)) {
			response.setCode(ResponseCode.SUCCESS);
			response.setMessage("成功");
		}
		else {
			response.setCode(ResponseCode.ERROR);
			response.setMessage("失败");
		}
		return response;
	}


	

	
}
