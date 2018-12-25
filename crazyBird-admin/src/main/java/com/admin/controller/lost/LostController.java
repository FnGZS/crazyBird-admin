package com.admin.controller.lost;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.ls.LSOutput;

import com.admin.controller.lost.model.LostDetailsModel;
import com.admin.controller.lost.model.LostExamineModel;
import com.admin.controller.lost.model.LostInputModel;
import com.admin.controller.lost.model.LostMessageModel;
import com.admin.controller.lost.model.LostPageModel;
import com.admin.controller.lost.model.LostTypeInputModel;
import com.admin.controller.lost.model.LostTypeModel;
import com.admin.controller.lost.model.LostTypeUpdateModel;
import com.admin.controller.lost.model.LostUpdateModel;
import com.admin.controller.lost.param.LostExamineParam;
import com.admin.controller.lost.param.LostInputParam;
import com.admin.controller.lost.param.LostPageParam;
import com.admin.controller.lost.param.LostTypeInputParam;
import com.admin.controller.lost.param.LostTypeUpdateParam;
import com.admin.controller.lost.param.LostUpdateParam;


@Controller
@RequestMapping("/lost")
public class LostController {
	
	@Autowired
	private LostProcess lostProcess;
	
	/**
	 * 获取失物招领类型
	 * @param param
	 * @return
	 */
	
	@RequestMapping(value = "/lostMessage",method = RequestMethod.GET)
	@ResponseBody
	public LostMessageModel getLostMessage() {
		return lostProcess.getLostMessage();
	}
	
	/**
	 * 获取物品分类
	 * @param param
	 * @return
	 */
	
	@RequestMapping(value = "/lostType",method = RequestMethod.GET)
	@ResponseBody
	public LostTypeModel getLostType() {
		return lostProcess.getLostType();
	}
	
	/**
	 * 获得失物列表
	 * @param param
	 * @return
	 */
	
	@RequestMapping(value = "/getLostList",method = RequestMethod.GET)
	@ResponseBody
	public LostPageModel getLostList(LostPageParam param) throws UnsupportedEncodingException{
		if(StringUtils.isNotBlank(param.getKey())) {
			String key = new String(param.getKey().getBytes("iso-8859-1"),"utf-8");
			param.setKey(key);
		}
		return lostProcess.getLostList(param);
	}
	/**
	 *失物详情
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/lostDetails/{id}",method = RequestMethod.GET)
	@ResponseBody
	public LostDetailsModel getLostDetails(@PathVariable Long id) {
		return lostProcess.getLostDetails(id);
	}
	
	/** 
	 * 失物信息录入
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/lostInput",method = RequestMethod.POST)
	@ResponseBody
	public LostInputModel setLostInput(@RequestBody LostInputParam param) {
		return lostProcess.lostInput(param);
	}
	
	
	/** 
	 * 失物类型录入
	 * @param param
	 * @return
	 */
	
	@RequestMapping(value = "/lostTypeInput",method = RequestMethod.POST)
	@ResponseBody
	public LostTypeInputModel setLostTypeInput(@RequestBody LostTypeInputParam param){
		return lostProcess.lostTypeInput(param);
	}
	
	
	/** 
	 * 失物类型删除
	 * @param param
	 * @return
	 */
	
	@RequestMapping(value = "/LostTypeDelete/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public LostTypeInputModel LostTypeDelete(@PathVariable Long id) {
		return lostProcess.lostTypeDelete(id);
	}
	
	/** 
	 * 失物类型修改
	 * @param param
	 * @return
	 */
	
	
	@RequestMapping(value = "/lostTypeUpdate",method = RequestMethod.POST)
	@ResponseBody
	public LostTypeUpdateModel LostTypeDelete(@RequestBody LostTypeUpdateParam param) {
		return lostProcess.lostTypeUpdate(param);
	}
	
	
	/**
	 *删除发布的记录
	 * @param param
	 * @return
	 */
	
	@RequestMapping(value = "/lostDelete/{id}",method = RequestMethod.GET)
	@ResponseBody
	public LostInputModel getLostDelete(@PathVariable Long id) {
		return lostProcess.getLostDelete(id);
	}
	
	/** 
	 * 失物信息更新
	 * @param param
	 * @return
	 */
	
	@RequestMapping(value = "/lostUpdate",method = RequestMethod.POST)
	@ResponseBody
	public LostUpdateModel setLostUpdate(@RequestBody LostUpdateParam param) {
		return lostProcess.lostUpdate(param);
	}
	
	/** 
	 * 审核
	 * @param param
	 * @return
	 */
	
	@RequestMapping(value = "lostExamineUpdate",method = RequestMethod.POST)
	@ResponseBody
	public LostExamineModel setExamine(@RequestBody LostExamineParam param){
		return lostProcess.lostExamineUpdate(param);
	}
}
