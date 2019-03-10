package com.platform.controller;

import com.platform.model.vm.ApiResult;
import com.platform.model.vm.DataTablesParameters;
import com.platform.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;

@Controller
@RequestMapping(value = "user")
@ResponseBody
public class UserManageController extends ApplicationController{

    @Resource
    private IUserService userService;

    @RequestMapping(value = "")
    public ModelAndView index(){
        return buildMAV("user/list.jsp");
    }

    // 用户列表
    @RequestMapping(value = "list")
    public ApiResult list(String aoData){
        DataTablesParameters parameters = DataTablesParameters.fromJson(aoData);
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("limit", parameters.getRows());
        searchMap.put("offset", parameters.getStart());
        searchMap.put("search", parameters.getSearch());
        searchMap.put("sEcho",parameters.getsEcho());
        return userService.list(searchMap);
    }

    // 上传头像
    @RequestMapping(value = "upload/avator")
    public ApiResult upLoadAvator(){
        ApiResult result = new ApiResult();
        return result;
    }

}
