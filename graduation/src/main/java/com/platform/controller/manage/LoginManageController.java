package com.platform.controller.manage;

import com.platform.controller.ApplicationController;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-26 22:00
 */
@Controller
public class LoginManageController extends ApplicationController {

    @RequestMapping(value = "login")
    public ModelAndView login(){
        currentSubjectLogout();
        String errorClassName = (String) request.getAttribute("shiroLoginFailure");
        String authticationError = null;
        if (UnknownAccountException.class.getName().equals(errorClassName)) {
            authticationError = "用户名/密码错误";
        } else if (IncorrectCredentialsException.class.getName().equals(errorClassName)) {
            authticationError = "用户名/密码错误";
        } else if (errorClassName != null) {
            authticationError = "未知错误：" + errorClassName;
        }
        request.setAttribute("errorMessage", authticationError);
        return buildMAV("login.jsp",null);
    }

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout() {
        currentSubjectLogout();
        return "redirect:/login";
    }

}
