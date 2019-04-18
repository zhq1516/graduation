package com.platform.controller;

import com.platform.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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

	public ModelAndView buildMAV(String page, String layout){
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

	private Subject getCurrentSubject() {
		return SecurityUtils.getSubject();
	}

	protected void currentSubjectLogout() {
		try {
			getCurrentSubject().logout();
		}catch (Exception e){
			System.out.print("登出失败");
		}
	}

	protected Session getCurrentSession() {
		return getCurrentSubject().getSession();
	}

	protected User getCurrentUser() {
		return (User) getCurrentSubject().getPrincipal();
	}

}
