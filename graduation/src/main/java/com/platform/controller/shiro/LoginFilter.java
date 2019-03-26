package com.platform.controller.shiro;

import com.platform.model.User;
import com.platform.model.vm.ApiResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request,ServletResponse response, Object mappedValue) throws Exception {

        User token = (User) SecurityUtils.getSubject().getPrincipal();

        if(null != token || isLoginRequest(request, response)){// && isEnabled()
            return Boolean.TRUE;
        }
        if (ShiroFilterUtils.isAjax(request)) {// ajax请求
            ApiResult result = new ApiResult();
            result.setStatus(300);
            result.setMsg("登录超时，请重新登录！");//当前用户没有登录！
            ShiroFilterUtils.out(response, result);
        }
        return Boolean.FALSE ;

    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //保存Request和Response 到登录后的链接
        saveRequestAndRedirectToLogin(request, response);
        return Boolean.FALSE ;
    }
}