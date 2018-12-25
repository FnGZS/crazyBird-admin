package com.admin.controller.live;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.admin.controller.base.SimpleFlagModel;
import com.admin.controller.live.model.LiveUrlModel;
import com.admin.controller.live.param.LivePushParam;
@Controller
@RequestMapping("/live")
public class LiveController {
	@Autowired
	private LiveProcess liveProcess;
	@RequestMapping(value = "/addPush", method = RequestMethod.POST)
    @ResponseBody
	public SimpleFlagModel addPushUrl(@RequestBody LivePushParam param) {
		return liveProcess.addPushUrl(param);	
	}
	@RequestMapping(value = "/getUrlList", method = RequestMethod.GET)
    @ResponseBody
    public LiveUrlModel getUrlList() {
		return liveProcess.getUrlList();
	}
    
}
