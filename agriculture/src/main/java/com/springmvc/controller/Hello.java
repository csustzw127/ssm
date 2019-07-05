package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
public class Hello {
	@RequestMapping(value="/user")
    public String handle(Model model) {
        model.addAttribute("message", "Hello World!");
        return "zw/user/login.jsp";
    }
	
//	@RequestMapping(value="/user/verify/AjaxValidateVerifyCode.action",consumes={"application/json"},
//            produces={"application/json"})
//	@ResponseBody
//	public String ajaxValidateUsername(@RequestBody JSONObject  json) {
//		System.out.println(json);
//		JSONObject responseObj = (JSONObject)JSONObject.parseObject("{\"msg\":\"right\"}", JSONObject.class);
//		return "{\"msg\":\"正确\"}";
//	} 
}
