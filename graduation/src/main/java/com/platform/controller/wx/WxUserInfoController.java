package com.platform.controller.wx;

import com.google.gson.Gson;
import com.platform.controller.ApplicationController;
import com.platform.model.WxUserInfo;
import com.platform.model.vm.ApiResult;
import com.platform.model.vm.DataTablesParameters;
import com.platform.service.IUserService;
import com.platform.service.IWxUserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;

@Controller
@RequestMapping(value = "wx/user")
@ResponseBody
public class WxUserInfoController extends ApplicationController {

    @Resource
    private IWxUserInfoService wxUserInfoService;

    @RequestMapping(value = "")
    public ModelAndView index(){
        return buildMAV("wxUser/list.jsp");
    }

    @RequestMapping(value = "list")
    public Object list(String aoData,String formData){
        DataTablesParameters parameters = DataTablesParameters.fromJson(aoData);
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap = new Gson().fromJson(formData,searchMap.getClass());
        searchMap.put("limit", parameters.getRows());
        searchMap.put("offset", parameters.getStart());
        searchMap.put("search", parameters.getSearch());
        searchMap.put("sEcho",parameters.getsEcho());
        return wxUserInfoService.list(searchMap);
    }

    @RequestMapping(value = "register")
    public Object register(WxUserInfo model){
        return wxUserInfoService.register(model);
    }

    @RequestMapping(value = "history/post")
    public Object postHistory(@RequestBody HashMap<String,Object> search){
        return wxUserInfoService.postHistory(search);
    }

    @RequestMapping(value = "history/post/delete")
    public Object deletePostHistory(@RequestBody HashMap<String,Object> search){
        return wxUserInfoService.deletePostHistory(search);
    }

    @RequestMapping(value = "history/comment")
    public Object commentHistory(@RequestBody HashMap<String,Object> search){
        return wxUserInfoService.commentHistory(search);
    }

    @RequestMapping(value = "history/comment/delete")
    public Object deleteCommentHistory(@RequestBody HashMap<String,Object> search){
        return wxUserInfoService.deleteCommentHistory(search);
    }

}
