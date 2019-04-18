package com.platform.controller.manage;

import com.platform.controller.ApplicationController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description:
 * @author: Air
 * @date: 2019-04-12 15:10
 */
@Controller
@RequestMapping(value = "home")
@ResponseBody
public class HomeManageController extends ApplicationController {

    @RequestMapping(value = "")
    public ModelAndView index(){
        return buildMAV("home/index.jsp");
    }

}
