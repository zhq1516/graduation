package com.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ApplicationController {

	@Autowired
	protected  HttpServletRequest request;
	@Autowired
	protected HttpServletResponse response;

	protected ModelAndView buildMAV(String page) {
		return buildMAV(page,"platform/layout");
	}

	private ModelAndView buildMAV(String page, String layout){
		ModelAndView mav  = new ModelAndView(layout);
		mav.addObject("view", page);
		Map<String,String> requestContext = new HashMap<>();
		requestContext.put("contextPath", request.getContextPath());
		mav.addObject("rc", requestContext);
		mav.addObject("contextPath", request.getContextPath());
		return mav;
	}

	protected String getRealPath(){
		return request.getSession().getServletContext().getRealPath("/");
	}

}
