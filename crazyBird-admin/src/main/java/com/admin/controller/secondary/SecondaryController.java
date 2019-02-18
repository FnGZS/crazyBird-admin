package com.admin.controller.secondary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.admin.controller.base.SimpleFlagModel;
import com.admin.controller.secondary.model.SecondaryGoodsDetailModel;
import com.admin.controller.secondary.model.SecondaryGoodsModel;
import com.admin.controller.secondary.model.SecondaryOrderDetailModel;
import com.admin.controller.secondary.model.SecondaryOrderModel;
import com.admin.controller.secondary.model.SecondaryRefundModel;
import com.admin.controller.secondary.param.SecondaryGoodsListParam;
import com.admin.controller.secondary.param.SecondaryGoodsParam;
import com.admin.controller.secondary.param.SecondaryGoodsSearchParam;
import com.admin.controller.secondary.param.SecondaryOrderListParam;
import com.admin.controller.secondary.param.SecondaryOrderParam;
import com.admin.controller.secondary.model.SecondaryTypeModel;

@Controller
@RequestMapping("/secondary")
public class SecondaryController {
	@Autowired
	SecondaryProcess secondaryProcess;
	/**
	 * 得到商品列表
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/goods/list",method = RequestMethod.GET)
	@ResponseBody
	public SecondaryGoodsModel getSecondaryGoodsList(SecondaryGoodsListParam param) {
		return secondaryProcess.getSecondaryGoodsList(param);	
	}
	/**
	 * 搜索商品
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/goods/name",method = RequestMethod.GET)
	@ResponseBody
	public SecondaryGoodsModel getSecondaryGoodsListByName(SecondaryGoodsSearchParam param) {
		return secondaryProcess.getSecondaryGoodsListByName(param);
		
	}
	/**
	 * 得到商品详情
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/goods/get",method = RequestMethod.GET)
	@ResponseBody
	public SecondaryGoodsDetailModel getSecondaryGoods(SecondaryGoodsSearchParam param) {
		return secondaryProcess.getSecondaryGoods(param);
	}
	/**
	 * 修改商品
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/goods/update",method = RequestMethod.PUT)
	@ResponseBody
	public SimpleFlagModel updateSecondaryGoods(@RequestBody SecondaryGoodsParam param) {
		return secondaryProcess.updateSecondaryGoods(param);	
	}
	/**
	 * 添加官方商品
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/goods/add",method = RequestMethod.POST)
	@ResponseBody
	public SimpleFlagModel addSecondaryGoods(@RequestBody SecondaryGoodsParam param) {
		return secondaryProcess.addSecondaryGoods(param);	
	}
	/**
	 * 删除二手商品
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/goods/delete",method = RequestMethod.DELETE)
	@ResponseBody
	public SimpleFlagModel deleteSecondaryGoods(Long id) {
		return secondaryProcess.deleteSecondaryGoods(id);
	}
	/**
	 * 得到订单列表
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/order/list",method = RequestMethod.GET)
	@ResponseBody
	public SecondaryOrderModel getSecondaryOrdeList(SecondaryOrderListParam param) {
		
		return secondaryProcess.getSecondaryOrdeList(param);	
	}
	/**
	 * 得到订单详情
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "/order/get",method = RequestMethod.GET)
	@ResponseBody
	public SecondaryOrderDetailModel getSecondaryOrder(String orderId) {
		return secondaryProcess.getSecondaryOrder(orderId);
		
	}
	/**
	 * 修改订单
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/order/update",method = RequestMethod.PUT)
	@ResponseBody
	public SimpleFlagModel updateSecondaryOrder(@RequestBody SecondaryOrderParam param) {
		return secondaryProcess.updateSecondaryOrder(param);
		
	}
	/**
	 * 删除订单
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "/order/delete",method = RequestMethod.DELETE)
	@ResponseBody
	public SimpleFlagModel deletearyOrder(String orderId) {
		return secondaryProcess.deletearyOrder(orderId);
	}
	/**
	 * 得到商品分类
	 */
	@ResponseBody
	@RequestMapping(value="/type",method=RequestMethod.GET)
	public SecondaryTypeModel getSecondaryType(){
		return secondaryProcess.getSecondaryType();
	}
	/**
	 * 得到交易方式
	 */
	@ResponseBody
	@RequestMapping(value="/traydingWay",method=RequestMethod.GET)
	public SecondaryTypeModel getSecondaryTradingWay(){
		return secondaryProcess.getSecondaryTradingWay();
	}
	/**
	 * 得到售卖形式
	 */
	@ResponseBody
	@RequestMapping(value="/way",method=RequestMethod.GET)
	public SecondaryTypeModel getSecondaryWay(){
		return secondaryProcess.getSecondaryWay();
	}
	/**
	 * 得到退款详情
	 */
	@ResponseBody
	@RequestMapping(value="/refund",method=RequestMethod.GET)
	public SecondaryRefundModel getSecondaryRefund(String orderId){
		return secondaryProcess.getSecondaryRefund(orderId);
	}
}
