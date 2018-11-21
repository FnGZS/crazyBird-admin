package com.admin.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.admin.controller.user.model.AdminModel;
import com.admin.controller.user.model.BindingModel;
import com.admin.controller.user.model.LoginModel;
import com.admin.controller.user.param.AdminParam;
import com.admin.controller.user.param.BindingParam;
import com.admin.controller.user.param.LoginParam;



@Controller
@RequestMapping("/user")
public class UserLoginController {
	
	@Autowired
	private UserLoginProcess userLoginProcess;
	
		@RequestMapping(value = "/login", method = RequestMethod.POST)
	    @ResponseBody
	    public LoginModel userLogin(@RequestBody LoginParam param) {
	    	return userLoginProcess.doLogin(param);
	    }
		
		@RequestMapping(value = "/binding", method = RequestMethod.POST)
	    @ResponseBody
	    public BindingModel binding(@RequestBody BindingParam param) {
			return userLoginProcess.binding(param);
		}
		
		@RequestMapping(value = "/admin", method = RequestMethod.POST)
	    @ResponseBody
	    public AdminModel adminLogin(@RequestBody AdminParam param) {
			return userLoginProcess.adminLogin(param);
		}
}
