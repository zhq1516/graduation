package com.platform.controller;

import com.platform.model.vm.ApiResult;
import com.platform.model.vm.DataTablesParameters;
import com.platform.service.IArticleInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;


@Controller
@RequestMapping(value = "article")
@ResponseBody
public class ArticleManageController extends ApplicationController{

    @Resource
    private IArticleInfoService articleInfoService;

    @RequestMapping(value = "")
    public ModelAndView index(){
        return buildMAV("article/list.jsp");
    }

    @RequestMapping(value = "list")
    public ApiResult list(String aoData){
        DataTablesParameters parameters = DataTablesParameters.fromJson(aoData);
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap.put("limit", parameters.getRows());
        searchMap.put("offset", parameters.getStart());
        searchMap.put("search", parameters.getSearch());
        searchMap.put("sEcho",parameters.getsEcho());
        return articleInfoService.list(searchMap);
    }

}
