package com.platform.controller.wx;

import com.google.gson.Gson;
import com.platform.controller.ApplicationController;
import com.platform.model.Comment;
import com.platform.model.vm.DataTablesParameters;
import com.platform.service.IPostInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @description:用户发布内容
 * @author: Air
 * @date: 2019-03-09 13:39
 */
@Controller
@RequestMapping(value = "wx/post")
@ResponseBody
public class PostInfoController extends ApplicationController {

    @Resource
    private IPostInfoService postInfoService;

    @RequestMapping(value = "")
    public ModelAndView index(){
        return buildMAV("post/list.jsp");
    }

    @RequestMapping(value = "manage/list")
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

    @RequestMapping(value = "detail")
    public Object detail(@RequestBody HashMap<String,Object> map){
        return postInfoService.detail(map);
    }

    @RequestMapping(value = "list")
    public Object list(@RequestBody HashMap<String,Object> map){
        return postInfoService.list(map);
    }

    @RequestMapping(value = "read")
    public Object read(@RequestBody HashMap<String,Object> map){
        return  postInfoService.read(map);
    }

    @RequestMapping(value = "collect")
    public Object collect(@RequestBody HashMap<String,Object> map){
        return postInfoService.collect(map);
    }

    @RequestMapping(value = "up")
    public Object up(@RequestBody HashMap<String,Object> map){
        return postInfoService.up(map);
    }

    @RequestMapping(value = "comment")
    public Object comment(Comment model){
        return postInfoService.comment(model);
    }

}
