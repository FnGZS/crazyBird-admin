package com.admin.controller.secondary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.admin.controller.base.SimpleFlagModel;
import com.admin.controller.secondary.model.SecondaryGoodsDetailModel;
import com.admin.controller.secondary.model.SecondaryGoodsItem;
import com.admin.controller.secondary.model.SecondaryGoodsModel;
import com.admin.controller.secondary.model.SecondaryOrderDetailModel;
import com.admin.controller.secondary.model.SecondaryOrderItem;
import com.admin.controller.secondary.model.SecondaryOrderModel;
import com.admin.controller.secondary.model.SecondaryRefundItem;
import com.admin.controller.secondary.model.SecondaryRefundModel;
import com.admin.controller.secondary.param.SecondaryGoodsListParam;
import com.admin.controller.secondary.param.SecondaryGoodsParam;
import com.admin.controller.secondary.param.SecondaryGoodsSearchParam;
import com.admin.controller.secondary.param.SecondaryOrderListParam;
import com.admin.controller.secondary.param.SecondaryOrderParam;
import com.admin.dao.secondary.dataobject.RefundApplyDO;
import com.admin.dao.secondary.dataobject.SecondaryGoodsDO;
import com.admin.dao.secondary.dataobject.SecondaryGoodsPO;
import com.admin.dao.secondary.dataobject.SecondaryGoodsSearchDO;
import com.admin.dao.secondary.dataobject.SecondaryOrderDO;
import com.admin.dao.secondary.dataobject.SecondaryOrderPO;
import com.admin.model.enums.HttpCodeEnum;
import com.admin.service.base.ResponsePageQueryDO;
import com.admin.service.secondary.SecondaryService;
import com.admin.utils.CollectionUtil;
import com.admin.utils.DateUtil;
import com.admin.utils.PageUtils;
import com.admin.controller.secondary.model.SecondaryTypeItem;
import com.admin.controller.secondary.model.SecondaryTypeModel;
import com.admin.dao.secondary.dataobject.SecondaryTypeDO;

@Component
public class SecondaryProcess {
	@Autowired
	SecondaryService secondaryService;

	public SecondaryGoodsModel getSecondaryGoodsList(SecondaryGoodsListParam param) {
		SecondaryGoodsModel model = new SecondaryGoodsModel();

		PageUtils.resetPageParam(param);
		SecondaryGoodsPO po = new SecondaryGoodsPO();
		po.setStatus(param.getStatus());
		po.setPageIndex(param.getPageNo() - 1);
		po.setPageSize(param.getPageSize());
		ResponsePageQueryDO<List<SecondaryGoodsDO>> response = secondaryService.getSecondaryGoodsList(po);
		if (response.isSuccess()) {
			PageUtils.setPageModel(model, param, response.getTotal());
			model.setList(convertGoods(response.getDataResult()));
		} else {
			model.setCode(HttpCodeEnum.ERROR.getCode());
			model.setMessage(response.getMessage());
		}
		return model;
	}
	
	public SecondaryGoodsModel getSecondaryGoodsListByName(SecondaryGoodsSearchParam param) {
		SecondaryGoodsModel model = new SecondaryGoodsModel();
		if(param.getGoodsName()==null) {
			
			return model;
		}
		
		SecondaryGoodsSearchDO searchDO = new SecondaryGoodsSearchDO();
		searchDO.setGoodsName(param.getGoodsName());
		List<SecondaryGoodsDO> tags = secondaryService.getSecondaryGoodsByName(searchDO);
		model.setList(convertGoods(tags));		
		return model;
	}
	public SecondaryGoodsDetailModel getSecondaryGoods(SecondaryGoodsSearchParam param) {
		SecondaryGoodsDetailModel model = new SecondaryGoodsDetailModel();
		SecondaryGoodsSearchDO searchDO = new SecondaryGoodsSearchDO();
			searchDO.setId(param.getId());
		SecondaryGoodsDO goodsDO = secondaryService.getSecondaryGoods(searchDO);
		if(goodsDO==null) {
			model.setMessage("商品不存在");
			return model;	
		}
		model.setGoodsContent(goodsDO.getGoodsContent());
		model.setGoodsImag(goodsDO.getGoodsImag());
		model.setGoodsTitle(goodsDO.getGoodsTitle());
		model.setGoodsType(goodsDO.getGoodsType());
		model.setGoodsWay(goodsDO.getGoodsWay());
		model.setId(goodsDO.getId());
		model.setViews(goodsDO.getViews());
		model.setStatus(goodsDO.getStatus());
		model.setOldPrice(goodsDO.getOldPrice());
		model.setPostion(goodsDO.getPostion());
		model.setPrice(goodsDO.getPrice());
		model.setTelephone(goodsDO.getTelephone());
		model.setTradingWay(goodsDO.getTradingWay());
		model.setUserId(goodsDO.getUserId());
		model.setGmtCreated(DateUtil.formatDate(goodsDO.getGmtCreated(), DateUtil.DATE_FORMAT_YMDHMS));
		model.setGmtModified(DateUtil.formatDate(goodsDO.getGmtModified(), DateUtil.DATE_FORMAT_YMDHMS));
		return model;
	}

	public SimpleFlagModel updateSecondaryGoods(SecondaryGoodsParam param) {
		SimpleFlagModel model = new SimpleFlagModel();
		SecondaryGoodsDO goodsDO = new SecondaryGoodsDO();
		goodsDO.setGoodsContent(param.getGoodsContent());
		goodsDO.setGoodsImag(param.getGoodsImag());
		goodsDO.setGoodsTitle(param.getGoodsTitle());
		goodsDO.setGoodsType(param.getGoodsType());
		goodsDO.setGoodsWay(param.getGoodsWay());
		goodsDO.setId(param.getId());
		goodsDO.setViews(param.getViews());
		goodsDO.setOldPrice(param.getOldPrice());
		goodsDO.setPostion(param.getPostion());
		goodsDO.setStatus(param.getStatus());
		goodsDO.setPrice(param.getPrice());
		goodsDO.setTelephone(param.getTelephone());
		goodsDO.setTradingWay(param.getTradingWay());
		goodsDO.setUserId(param.getUserId());
		if (!secondaryService.updateSecondaryGoods(goodsDO)) {
			model.setCode(HttpCodeEnum.ERROR.getCode());
			model.setMessage("修改失败");
			return model;
		}
		return model;
	}

	public SimpleFlagModel addSecondaryGoods(SecondaryGoodsParam param) {
		SimpleFlagModel model = new SimpleFlagModel();
		SecondaryGoodsDO goodsDO = new SecondaryGoodsDO();
		goodsDO.setGoodsContent(param.getGoodsContent());
		goodsDO.setGoodsImag(param.getGoodsImag());
		goodsDO.setGoodsTitle(param.getGoodsTitle());
		goodsDO.setGoodsType(param.getGoodsType());
		goodsDO.setGoodsWay(param.getGoodsWay());
		goodsDO.setOldPrice(param.getOldPrice());
		goodsDO.setPostion(param.getPostion());
		goodsDO.setViews(param.getViews());
		goodsDO.setStatus(param.getStatus());
		goodsDO.setPrice(param.getPrice());
		goodsDO.setTelephone(param.getTelephone());
		goodsDO.setTradingWay(param.getTradingWay());
		goodsDO.setUserId(param.getUserId());
		if (secondaryService.addSecondaryGoods(goodsDO) <= 0) {
			model.setCode(HttpCodeEnum.ERROR.getCode());
			model.setMessage("修改失败");
			return model;
		}
		return model;
	}

	public SimpleFlagModel deleteSecondaryGoods(Long id) {
		SimpleFlagModel model = new SimpleFlagModel();
		secondaryService.deleteSecondaryGoods(id);
		return model;
	}

	public SecondaryOrderModel getSecondaryOrdeList(SecondaryOrderListParam param) {
		SecondaryOrderModel model = new SecondaryOrderModel();

		PageUtils.resetPageParam(param);
		SecondaryOrderPO po = new SecondaryOrderPO();
		po.setStatus(param.getStatus());
		po.setPageIndex(param.getPageNo() - 1);
		po.setPageSize(param.getPageSize());
		ResponsePageQueryDO<List<SecondaryOrderDO>> response = secondaryService.getSecondaryOrderList(po);
		if (response.isSuccess()) {
			PageUtils.setPageModel(model, param, response.getTotal());
			model.setList(convertOrder(response.getDataResult()));
		} else {
			model.setCode(HttpCodeEnum.ERROR.getCode());
			model.setMessage(response.getMessage());
		}
		return model;
	}

	public SecondaryOrderDetailModel getSecondaryOrder(String orderId) {
		SecondaryOrderDetailModel model = new SecondaryOrderDetailModel();
		SecondaryOrderDO orderDO = secondaryService.getSecondaryOrder(orderId);
		if (orderDO == null) {
			model.setMessage("订单不存在");
			return model;
		}
		model.setConsignee(orderDO.getConsignee());
		model.setGoodsId(orderDO.getGoodsId());
		model.setId(orderDO.getId());
		model.setOrderId(orderDO.getOrderId());
		model.setPrice(orderDO.getPrice());
		model.setOrderState(orderDO.getOrderState());
		model.setLogistics(orderDO.getLogistics());
		model.setReceiveAddress(orderDO.getReceiveAddress());
		model.setReceivePhone(orderDO.getReceivePhone());
		model.setSeller(orderDO.getSeller());
		model.setSellerId(orderDO.getSellerId());
		model.setUserId(orderDO.getUserId());
		model.setGmtCreated(DateUtil.formatDate(orderDO.getGmtCreated(), DateUtil.DATE_FORMAT_YMDHMS));
		model.setGmtModified(DateUtil.formatDate(orderDO.getGmtModified(), DateUtil.DATE_FORMAT_YMDHMS));
		return model;

	}

	public SimpleFlagModel updateSecondaryOrder(SecondaryOrderParam param) {
		SimpleFlagModel model = new SimpleFlagModel();
		SecondaryOrderDO orderDO = new SecondaryOrderDO();
		orderDO.setConsignee(param.getConsignee());
		orderDO.setGoodsId(param.getGoodsId());
		orderDO.setId(param.getId());
		orderDO.setOrderId(param.getOrderId());
		orderDO.setPrice(param.getPrice());
		orderDO.setLogistics(param.getLogistics());
		orderDO.setOrderState(param.getOrderState());
		orderDO.setReceiveAddress(param.getReceiveAddress());
		orderDO.setReceivePhone(param.getReceivePhone());
		orderDO.setSeller(param.getSeller());
		orderDO.setSellerId(param.getSellerId());
		orderDO.setUserId(param.getUserId());
		if (secondaryService.updateSecondaryOrder(orderDO) <= 0) {
			model.setCode(HttpCodeEnum.ERROR.getCode());
			model.setMessage("修改失败");
			return model;
		}
		return model;

	}

	public SimpleFlagModel deletearyOrder(String orderId) {
		SimpleFlagModel model = new SimpleFlagModel();
		secondaryService.deleteSecondaryOrder(orderId);
		return model;

	}
	public SecondaryTypeModel getSecondaryType() {
		SecondaryTypeModel model = new SecondaryTypeModel();
		List<SecondaryTypeDO> tags = secondaryService.getSecondaryType();
		model.setList(convertSecondaryType(tags));
		return model;
	}

	public SecondaryTypeModel getSecondaryTradingWay() {
		SecondaryTypeModel model = new SecondaryTypeModel();
		List<SecondaryTypeDO> tags = secondaryService.getSecondaryTradingWay();
		model.setList(convertSecondaryType(tags));
		return model;
	}

	public SecondaryTypeModel getSecondaryWay() {
		SecondaryTypeModel model = new SecondaryTypeModel();
		List<SecondaryTypeDO> tags = secondaryService.getSecondaryWay();
		model.setList(convertSecondaryType(tags));
		return model;
	}
	
	public SecondaryRefundModel getSecondaryRefund(String orderId) {
		SecondaryRefundModel model = new SecondaryRefundModel();
		List<RefundApplyDO> tags = secondaryService.getRefundApply(orderId);
		List<SecondaryRefundItem> items = new ArrayList<>();
		if(CollectionUtil.isNotEmpty(tags)) {
		for (RefundApplyDO tag : tags) {
			SecondaryRefundItem item = new SecondaryRefundItem();
			item.setContent(tag.getContent());
			item.setId(tag.getId());
			item.setOrderId(tag.getOrderId());
			item.setState(tag.getState());
			item.setType(tag.getType());
			item.setGmtCreated(DateUtil.formatDate(tag.getGmtCreated(), DateUtil.DATE_FORMAT_YMDHMS));
			item.setGmtModified(DateUtil.formatDate(tag.getGmtModified(), DateUtil.DATE_FORMAT_YMDHMS));
			items.add(item);
		}
		model.setList(items);
		}
		return model;	
	}
	private List<SecondaryOrderItem> convertOrder(List<SecondaryOrderDO> tags) {
		List<SecondaryOrderItem> items = new ArrayList<>();
		if (CollectionUtil.isNotEmpty(tags)) {
			for (SecondaryOrderDO tag : tags) {
				if (tag != null) {
					SecondaryOrderItem item = new SecondaryOrderItem();
					item.setConsignee(tag.getConsignee());
					item.setGoodsId(tag.getGoodsId());
					item.setId(tag.getId());
					item.setOrderId(tag.getOrderId());
					item.setPrice(tag.getPrice());
					item.setLogistics(tag.getLogistics());
					item.setOrderState(tag.getOrderState());
					item.setReceiveAddress(tag.getReceiveAddress());
					item.setReceivePhone(tag.getReceivePhone());
					item.setSeller(tag.getSeller());
					item.setSellerId(tag.getSellerId());
					item.setUserId(tag.getUserId());
					item.setGmtCreated(DateUtil.formatDate(tag.getGmtCreated(), DateUtil.DATE_FORMAT_YMDHMS));
					item.setGmtModified(DateUtil.formatDate(tag.getGmtModified(), DateUtil.DATE_FORMAT_YMDHMS));
					items.add(item);
				}
			}
		}
		return items;

	}
	private List<SecondaryGoodsItem> convertGoods(List<SecondaryGoodsDO> tags) {
		List<SecondaryGoodsItem> items = new ArrayList<>();
		if (CollectionUtil.isNotEmpty(tags)) {
			for (SecondaryGoodsDO tag : tags) {
				if (tag != null) {
					SecondaryGoodsItem item = new SecondaryGoodsItem();
					item.setGoodsContent(tag.getGoodsContent());
					item.setGoodsImag(tag.getGoodsImag());
					item.setGoodsTitle(tag.getGoodsTitle());
					item.setGoodsType(tag.getGoodsType());
					item.setGoodsWay(tag.getGoodsWay());
					item.setId(tag.getId());
					item.setOldPrice(tag.getOldPrice());
					item.setPostion(tag.getPostion());
					item.setStatus(tag.getStatus());
					item.setViews(tag.getViews());
					item.setPrice(tag.getPrice());
					item.setTelephone(tag.getTelephone());
					item.setTradingWay(tag.getTradingWay());
					item.setUserId(tag.getUserId());
					item.setGmtCreated(DateUtil.formatDate(tag.getGmtCreated(), DateUtil.DATE_FORMAT_YMDHMS));
					item.setGmtModified(DateUtil.formatDate(tag.getGmtModified(), DateUtil.DATE_FORMAT_YMDHMS));
					items.add(item);
				}
			}
		}
		return items;

	}
	private List<SecondaryTypeItem> convertSecondaryType(List<SecondaryTypeDO> tags) {
		List<SecondaryTypeItem> items = new ArrayList<>();
		for (SecondaryTypeDO tag : tags) {
			SecondaryTypeItem item = new SecondaryTypeItem();
			item.setId(tag.getId());
			item.setField(tag.getField());
			items.add(item);
		}
		return items;
	}
}
