package com.platform.controller.manage;

import com.google.gson.Gson;
import com.platform.controller.ApplicationController;
import com.platform.model.User;
import com.platform.model.vm.ApiResult;
import com.platform.model.vm.DataTablesParameters;
import com.platform.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "user")
@ResponseBody
public class UserManageController extends ApplicationController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "")
    public ModelAndView index(){
        return buildMAV("user/list.jsp");
    }

    // 用户列表
    @RequestMapping(value = "list")
    public ApiResult list(String aoData,String formData){
        DataTablesParameters parameters = DataTablesParameters.fromJson(aoData);
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap = new Gson().fromJson(formData,searchMap.getClass());
        searchMap.put("limit", parameters.getRows());
        searchMap.put("offset", parameters.getStart());
        searchMap.put("search", parameters.getSearch());
        searchMap.put("sEcho",parameters.getsEcho());
        return userService.list(searchMap);
    }

    // 保存用户信息
    @RequestMapping(value = "save")
    public ApiResult save(User model){
        if(model.getId() == null){
            return userService.addUser(model);
        }else{
            return userService.modifyUser(model);
        }
    }

    // 批量操作
    @RequestMapping(value = "operation")
    public ApiResult operation(@RequestParam(value = "ids[]") List<Integer> ids,Integer type){
        ApiResult result = new ApiResult();
        switch (type){
            case 1:
                result = userService.deleteUser(ids);
                break;
            case 2:
                result = userService.forbidUser(ids);
                break;
            default:
                break;
        }
        return result;
    }

    // 用户信息
    @RequestMapping(value = "detail")
    public ApiResult detail(@RequestBody HashMap<String,Object> map){
        return userService.detail(map);
    }

}
