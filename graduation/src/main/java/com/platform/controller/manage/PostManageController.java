package com.platform.controller.manage;

import com.google.gson.Gson;
import com.platform.controller.ApplicationController;
import com.platform.model.PostInfo;
import com.platform.model.vm.ApiResult;
import com.platform.model.vm.DataTablesParameters;
import com.platform.service.IPostInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: Air
 * @date: 2019-04-06 12:00
 */
@Controller
@RequestMapping(value = "post")
@ResponseBody
public class PostManageController extends ApplicationController {

    @Resource
    private IPostInfoService postInfoService;

    @RequestMapping(value = "")
    public ModelAndView index(){
        return buildMAV("post/list.jsp");
    }

    @RequestMapping(value = "list")
    public Object manageList(String aoData,String formData){
        DataTablesParameters parameters = DataTablesParameters.fromJson(aoData);
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap = new Gson().fromJson(formData,searchMap.getClass());
        searchMap.put("limit", parameters.getRows());
        searchMap.put("offset", parameters.getStart());
        searchMap.put("search", parameters.getSearch());
        searchMap.put("sEcho",parameters.getsEcho());
        return postInfoService.list(searchMap);
    }

    @RequestMapping(value = "operation")
    public Object operation(@RequestParam(value = "ids[]") List<Integer> ids, Integer type){
        ApiResult result = new ApiResult();
        switch (type){
            case 1:
                result = postInfoService.publish(ids);
                break;
            case 2:
                result = postInfoService.cancelPublish(ids);
                break;
            case 3:
                result = postInfoService.delete(ids);
                break;
            default:
                break;
        }
        return result;
    }

    @RequestMapping(value = "save")
    public Object save(PostInfo model){
        return postInfoService.save(model);
    }

}
