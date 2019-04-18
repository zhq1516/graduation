package com.platform.controller.manage;

import com.google.gson.Gson;
import com.platform.controller.ApplicationController;
import com.platform.model.Message;
import com.platform.model.vm.ApiResult;
import com.platform.model.vm.DataTablesParameters;
import com.platform.service.IConsultInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
 * @date: 2019-04-06 15:27
 */
@Controller
@RequestMapping(value = "consult")
@ResponseBody
public class ConsultManageController extends ApplicationController {

    @Resource
    private IConsultInfoService consultInfoService;

    @RequestMapping(value = "")
    public ModelAndView index(){
        return buildMAV("consult/list.jsp");
    }

    @RequestMapping(value = "doctor")
    public ModelAndView doctor(){
        return buildMAV("consult/consult.jsp");
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
        return consultInfoService.list(searchMap);
    }

    @RequestMapping(value = "operation")
    public Object operation(@RequestParam(value = "ids[]") List<Integer> ids, Integer type){
        ApiResult result = new ApiResult();
        switch (type){
            case 1 :
                result = consultInfoService.delete(ids);
                break;
            case 2 :
                result = consultInfoService.finish(ids);
                break;
            default:
                break;
        }
        return result;
    }

    @RequestMapping(value = "doctor/list")
    public Object doctorList(@RequestBody HashMap<String,Object> search){
        return consultInfoService.list(search);
    }

    @RequestMapping(value = "message/list")
    public Object messageList(@RequestBody HashMap<String,Object> search){
        return consultInfoService.msgList(search);
    }

    @RequestMapping(value = "message/send")
    public Object messageSend(Message message){
        return consultInfoService.sendMsg(message);
    }

}
