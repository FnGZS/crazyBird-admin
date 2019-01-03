package com.admin.controller.live;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.poifs.storage.ListManagedBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.admin.controller.base.SimpleFlagModel;
import com.admin.controller.live.model.LiveUrlItem;
import com.admin.controller.live.model.LiveUrlModel;
import com.admin.controller.live.param.LivePushParam;
import com.admin.dao.live.dataobject.LiveDO;
import com.admin.model.enums.HttpCodeEnum;
import com.admin.service.live.LiveService;
import com.admin.utils.DateUtil;
import com.admin.utils.LiveUtils;

@Component
public class LiveProcess {
	@Autowired
	private LiveService liveService;

	public SimpleFlagModel addPushUrl(LivePushParam param) {
		SimpleFlagModel model = new SimpleFlagModel();
		if (StringUtils.isBlank(param.getDomain()) || StringUtils.isBlank(param.getStreamId())
				|| StringUtils.isBlank(param.getTxTime())) {
			model.setCode(HttpCodeEnum.ERROR.getCode());
			model.setMessage("参数为空");
		}
		LiveDO liveDO = new LiveDO();
		liveDO.setEndTime(DateUtil.getStringToDate(param.getTxTime(), DateUtil.DATE_FORMAT_YMDHMS));
		Date time=DateUtil.getStringToDate(param.getTxTime(), DateUtil.DATE_FORMAT_YMDHMS);
		long txTime = time.getTime()/1000;
		String pushUrl=LiveUtils.getPushUrl(param.getDomain(),  param.getStreamId(), txTime);
		List<String> playUrlList = LiveUtils.getLiveUrl(param.getDomain(), param.getStreamId());
		String[] str = playUrlList.toArray(new String[playUrlList.size()]);
		int length = str.length;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("\"");
		sb.append(str[0]);
		sb.append("\"");
		if (length > 1) {
			for (int i = 1; i < length; i++) {
				{
					sb.append(",");
					sb.append("\"");
					sb.append(str[i]);
					sb.append("\"");
				}
			}
		}
		sb.append("]");
		liveDO.setImageUrl(param.getImageUrl());
		liveDO.setPlayUrl(sb.toString());
		liveDO.setPushUrl(pushUrl);
		liveDO.setStreamId(param.getStreamId());
		liveDO.setTitle(param.getTitle());
		if(param.getStatus()==null) {
			liveDO.setStatus(0);
		}
		else {
			liveDO.setStatus(param.getStatus());
		}
		int flag = liveService.addPushUrl(liveDO);
		if(flag<=0) {
			model.setCode(HttpCodeEnum.ERROR.getCode());
			model.setMessage("添加失败");
		}
		return model;
	}
	public LiveUrlModel getUrlList() {
		LiveUrlModel model =new LiveUrlModel();
		List<LiveDO> tags= liveService.getPushUrlList();
		List<LiveUrlItem> items = new ArrayList<>();
		if(CollectionUtils.isNotEmpty(tags)) {
		for (LiveDO tag : tags) {
			LiveUrlItem item= new LiveUrlItem();
			item.setEndTime(DateUtil.formatDate(tag.getEndTime(), DateUtil.DATE_FORMAT_YMDHMS));			
			item.setGmtCreated(DateUtil.formatDate(tag.getGmtCreated(), DateUtil.DATE_FORMAT_YMDHMS));
			item.setGmtModified(DateUtil.formatDate(tag.getGmtModified(), DateUtil.DATE_FORMAT_YMDHMS));
			item.setId(tag.getId());
			item.setPlayUrl(tag.getPlayUrl());
			item.setPushUrl(tag.getPushUrl());
			item.setStatus(tag.getStatus());
			item.setImageUrl(tag.getImageUrl());
			item.setStreamId(tag.getStreamId());
			item.setTitle(tag.getTitle());
			items.add(item);
		}
		}
		model.setList(items);;
		return  model;
		
	}
	
}
