package com.admin.controller.lost;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSOutput;

import com.admin.controller.base.BaseProcess;
import com.admin.controller.lost.model.LostDetailsModel;
import com.admin.controller.lost.model.LostInputModel;
import com.admin.controller.lost.model.LostItem;
import com.admin.controller.lost.model.LostMessageItem;
import com.admin.controller.lost.model.LostMessageModel;
import com.admin.controller.lost.model.LostPageModel;
import com.admin.controller.lost.model.LostTypeInputModel;
import com.admin.controller.lost.model.LostTypeItem;
import com.admin.controller.lost.model.LostTypeModel;
import com.admin.controller.lost.model.LostTypeUpdateModel;
import com.admin.controller.lost.model.LostUpdateModel;
import com.admin.controller.lost.param.LostInputParam;
import com.admin.controller.lost.param.LostPageParam;
import com.admin.controller.lost.param.LostTypeInputParam;
import com.admin.controller.lost.param.LostTypeUpdateParam;
import com.admin.controller.lost.param.LostUpdateParam;
import com.admin.dao.lost.dataobject.LostArticleDO;
import com.admin.dao.lost.dataobject.LostDTO;
import com.admin.dao.lost.dataobject.LostPO;
import com.admin.dao.lost.dataobject.LostTypeDO;
import com.admin.model.enums.HttpCodeEnum;
import com.admin.service.base.ResponseDO;
import com.admin.service.base.ResponsePageQueryDO;
import com.admin.service.lost.LostService;
import com.admin.utils.CollectionUtil;
import com.admin.utils.PageUtils;
import com.admin.utils.TokenUtils;

@Component
public class LostProcess extends BaseProcess{
	
	@Autowired
	private LostService lostService;
	
	public LostMessageModel getLostMessage() {
		LostMessageModel model = new LostMessageModel();
		List<LostTypeDO> tags = lostService.getLostMessage();
		if(CollectionUtil.isNotEmpty(tags)) {
			List<LostMessageItem> items = new ArrayList<LostMessageItem>();
			for(LostTypeDO tag : tags) {
				LostMessageItem item = new LostMessageItem();
				item.setTypeId(tag.getTypeId());
				item.setMessage(tag.getMessage());
				items.add(item);
			}
			model.setLostTypeList(items);
		}
		return model;
		
	}

	public LostTypeModel getLostType() {
		LostTypeModel model = new LostTypeModel();
		List<LostTypeDO> tags = lostService.getLostType();
		if(CollectionUtil.isNotEmpty(tags)) {
			List<LostTypeItem> items = new ArrayList<LostTypeItem>();
			for(LostTypeDO tag : tags) {
				LostTypeItem item = new LostTypeItem();
				item.setTypeId(tag.getTypeId());
				item.setTypeName(tag.getTypeName());
				items.add(item);
			}
			model.setLostTypeList(items);
		}
		return model;
	}

	public LostPageModel getLostList(LostPageParam param) {
		LostPageModel model = new LostPageModel();
		PageUtils.resetPageParam(param);
		LostPO po = new LostPO();
		po.setPageIndex(param.getPageNo().intValue() - 1);
		po.setPageSize(param.getPageSize().intValue());
		po.setTypeId(param.getTypeId());
		po.setKey(param.getKey());
		po.setMessageId(param.getMessageId());
		if(param.getPublisher() != null) {
			po.setPublisher(param.getPublisher());
			if(po.getPublisher() == (long)0) {
				model.setCode(HttpCodeEnum.ERROR.getCode());
				model.setMessage("登录状态无效");
				return model;
			}	
		}
		ResponsePageQueryDO<List<LostDTO>>  response = lostService.getLostList(po);
		if(response.isSuccess()) {
			PageUtils.setPageModel(model, param, response.getTotal());
			model.setItems(convertDemands(response.getDataResult()));
		}
		else {
			model.setCode(HttpCodeEnum.ERROR.getCode());
		}
		model.setMessage(response.getMessage());
		return model;
	}

	private List<LostItem> convertDemands(List<LostDTO> dataResult) {
		List<LostItem> items = new ArrayList<>();
		if(CollectionUtil.isNotEmpty(dataResult)) {
			for(LostDTO dataResults : dataResult) {
				if(dataResults != null) {
					LostItem item = new LostItem();
					item.setId(dataResults.getId());
					item.setPersonal(dataResults.getPersonal());
					item.setBrow(dataResults.getBrow());
					item.setContent(dataResults.getContent());
					item.setFoundPic(dataResults.getFoundPic());
					item.setTypeId(dataResults.getTypeId());
					item.setTypeName(dataResults.getTypeName());
					item.setYear(dataResults.getGmtCreated().substring(0, 4));
					item.setDay(dataResults.getGmtCreated().substring(5,11));
					item.setMinute(dataResults.getGmtCreated().substring(11, 16));
					item.setIsExamine(dataResults.getIsExamine());
					item.setIsSolve(dataResults.getIsSolve());
					item.setPublisher(dataResults.getPublisher());
					item.setAddress(dataResults.getAddress());
					item.setTitle(dataResults.getTitle());
					item.setTitlePic(dataResults.getTitlePic());
					item.setMessageId(dataResults.getMessageId());
					item.setContact(dataResults.getContact());
					items.add(item);
				}
			}
		}
		return items;
	}

	public LostDetailsModel getLostDetails(Long id) {
		LostDetailsModel model = new LostDetailsModel();
		LostDTO detail = lostService.getLostDetails(id);
		if(detail != null) {
			LostItem item = new LostItem();
			item.setBrow(detail.getBrow());
			item.setContent(detail.getContent());
			item.setFoundPic(detail.getFoundPic());
			item.setYear(detail.getGmtCreated().substring(0, 4));
			item.setDay(detail.getGmtCreated().substring(5, 11));
			item.setMinute(detail.getGmtCreated().substring(11, 16));
			item.setId(detail.getId());
			item.setIsExamine(detail.getIsExamine());
			item.setIsSolve(detail.getIsSolve());
			item.setAddress(detail.getAddress());
			item.setMessageId(detail.getMessageId());
			item.setPublisher(detail.getPublisher());
			item.setTitle(detail.getTitle());
			item.setPersonal(detail.getPersonal());
			item.setTypeId(detail.getTypeId());
			item.setTypeName(detail.getTypeName());
			item.setContact(detail.getContact());
			item.setTitlePic(detail.getTitlePic());
			model.setDetails(item);
			return model;
		}
		model.setCode(HttpCodeEnum.ERROR.getCode());
		model.setMessage("无此项");
		return model;
	}

	public LostInputModel lostInput(LostInputParam param) {
		LostInputModel model = new LostInputModel();
		LostArticleDO DO = new LostArticleDO();
		DO.setAddress(param.getAddress());
		DO.setTitle(param.getTitle());
		DO.setPersonal(param.getPersonal());
		DO.setTitlePic(param.getTitlePic());
		DO.setTypeId(param.getTypeId());
		DO.setMessageId(param.getMessageId());
		DO.setContact(param.getContact());
		DO.setContent(param.getContent());
		DO.setFoundPic(param.getFoundPic());
		ResponseDO<LostDTO> response = lostService.lostInput(DO);
		if(!response.isSuccess()) {
			model.setCode(HttpCodeEnum.ERROR.getCode());
			model.setMessage(response.getMessage());
		}
		else {
			model.setCode(HttpCodeEnum.SUCCESS.getCode());
			model.setMessage(response.getMessage());
		}
		return model;
	}

	public LostInputModel getLostDelete(Long id) {
		LostInputModel model = new LostInputModel();
		ResponseDO<LostDTO> response = lostService.lostDelete(id);
		if(!response.isSuccess()) {
			model.setCode(HttpCodeEnum.ERROR.getCode());
			model.setMessage(response.getMessage());
		}
		else {
			model.setCode(HttpCodeEnum.SUCCESS.getCode());
			model.setMessage(response.getMessage());
		}
		return model;
	}

	public LostUpdateModel lostUpdate(LostUpdateParam param) {
		LostUpdateModel model = new LostUpdateModel();
		LostArticleDO update = new LostArticleDO();
		update.setId(param.getId());
		update.setAddress(param.getAddress());
		update.setContact(param.getContact());
		update.setContent(param.getContent());
		update.setFoundPic(param.getFoundPic());
		update.setMessageId(param.getMessageId());
		update.setPersonal(param.getPersonal());
		update.setTitle(param.getTitle());
		update.setTitlePic(param.getTitlePic());
		update.setTypeId(param.getTypeId());
		ResponseDO<Long> response = lostService.lostUpdate(update);
		if(!response.isSuccess()) {
			model.setCode(HttpCodeEnum.ERROR.getCode());
			model.setMessage(response.getMessage());
		}
		else {
			model.setCode(HttpCodeEnum.SUCCESS.getCode());
			model.setMessage(response.getMessage());
		}
		return model;
	}

	public LostTypeInputModel lostTypeInput(LostTypeInputParam param) {
		LostTypeInputModel model = new LostTypeInputModel();
		LostTypeDO DO = new LostTypeDO();
		DO.setTypeName(param.getTypeName());
		ResponseDO<LostDTO> response = lostService.lostTypeInput(DO);
		if(!response.isSuccess()) {
			model.setCode(HttpCodeEnum.ERROR.getCode());
			model.setMessage(response.getMessage());
		}
		else {
			model.setCode(HttpCodeEnum.SUCCESS.getCode());
			model.setMessage(response.getMessage());
		}
		return model;
	}

	public LostTypeInputModel lostTypeDelete(Long id) {
		LostTypeInputModel model = new LostTypeInputModel();
		ResponseDO<LostDTO> response = lostService.lostTypeDelete(id);
		if(!response.isSuccess()) {
			model.setCode(HttpCodeEnum.ERROR.getCode());
			model.setMessage(response.getMessage());
		}
		else {
			model.setCode(HttpCodeEnum.SUCCESS.getCode());
			model.setMessage(response.getMessage());
		}
		return model;
	}

	public LostTypeUpdateModel lostTypeUpdate(LostTypeUpdateParam param) {
		LostTypeUpdateModel model = new LostTypeUpdateModel();
		LostTypeDO update = new LostTypeDO();
		update.setTypeId(param.getId());
		update.setTypeName(param.getTypeName());
		ResponseDO<Long> response = lostService.lostTypeUpdate(update);
		if(!response.isSuccess()) {
			model.setCode(HttpCodeEnum.ERROR.getCode());
			model.setMessage(response.getMessage());
		}
		else {
			model.setCode(HttpCodeEnum.SUCCESS.getCode());
			model.setMessage(response.getMessage());
		}
		return model;
	}
	
	
	
}
