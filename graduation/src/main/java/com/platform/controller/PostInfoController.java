package com.platform.controller;

import com.platform.service.IPostInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-09 13:39
 */
@Controller
@RequestMapping(value = "post")
@ResponseBody
public class PostInfoController extends ApplicationController{

    @Resource
    private IPostInfoService postInfoService;

    @RequestMapping(value = "detail")
    public Object detail(Integer id){
        return postInfoService.detail(id);
    }

    @RequestMapping(value = "list")
    public Object list(){
        return postInfoService.list();
    }

}
