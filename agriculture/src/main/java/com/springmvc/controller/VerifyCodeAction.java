package com.springmvc.controller;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.utils.VerifyCode;

@Controller
public class VerifyCodeAction {
	
	@RequestMapping(value="/verify/VerifyCode.action")
	public void VerifyCode(HttpServletRequest request,HttpServletResponse response){
		VerifyCode vc = new VerifyCode();
		BufferedImage image = vc.getImage();//获取一次性验证码图片
		// 该方法必须在getImage()方法之后来调用
//		System.out.println(vc.getText());//获取图片上的文本
    	response.setCharacterEncoding("utf-8");
		try {
			VerifyCode.output(image, response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//把图片写到指定流中
		
		// 把文本保存到session中，为LoginServlet验证做准备
		request.getSession().setAttribute("vCode", vc.getText());
	}
	@RequestMapping(value="/verify/AjaxValidateVerifyCode.action")
	@ResponseBody
	public String ajaxValidateVerifyCode(@RequestBody JSONObject  json,
			HttpServletRequest request,HttpServletResponse response)  {
		String msg;
		String verifycode = json.getString("verifycode");
		boolean b; // 校验
    	response.setCharacterEncoding("utf-8");
        String vCode = (String) request.getSession().getAttribute("vCode");
        if(vCode.equalsIgnoreCase(verifycode)) b = true;
        else b = false;
    	if(b == true) {
    		msg = "{\"msg\":\"验证码正确,200\"}";
    	} else {
    		msg = "{\"msg\":\"验证码不正确,200\"}";
    	}
    	return msg;
	}

}
