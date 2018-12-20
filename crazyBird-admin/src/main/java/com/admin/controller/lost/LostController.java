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

import com.admin.controller.lost.model.LostDetailsModel;
import com.admin.controller.lost.model.LostInputModel;
import com.admin.controller.lost.model.LostMessageModel;
import com.admin.controller.lost.model.LostPageModel;
import com.admin.controller.lost.model.LostTypeModel;
import com.admin.controller.lost.param.LostInputParam;
import com.admin.controller.lost.param.LostPageParam;


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
	 *删除发布的记录
	 * @param param
	 * @return
	 */
	
	@RequestMapping(value = "/lostDelete/{id}",method = RequestMethod.GET)
	@ResponseBody
	public LostInputModel getLostDelete(@PathVariable Long id) {
		return lostProcess.getLostDelete(id);
	}
}
