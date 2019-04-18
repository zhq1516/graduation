package com.platform.controller.wx;

import com.platform.controller.ApplicationController;
import com.platform.model.ConsultInfo;
import com.platform.model.Message;
import com.platform.service.IConsultInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @description:
 * @author: Air
 * @date: 2019-04-04 16:56
 */
@Controller
@RequestMapping(value = "wx/consult")
@ResponseBody
public class ConsultInfoController extends ApplicationController {

    @Resource
    private IConsultInfoService consultInfoService;

    @RequestMapping(value = "list")
    public Object list(@RequestBody HashMap<String,Object> search){
        return consultInfoService.list(search);
    }

    @RequestMapping(value = "add")
    public Object add(@RequestBody ConsultInfo model){
        return consultInfoService.consult(model);
    }

    @RequestMapping(value = "doctor")
    public Object doctor(@RequestBody HashMap<String,Object> search){
        return consultInfoService.doctor(search);
    }

    @RequestMapping(value = "detail")
    public Object detail(@RequestBody HashMap<String,Object> search){
        return consultInfoService.detail(search);
    }

    @RequestMapping(value = "msgList")
    public Object msgList(@RequestBody HashMap<String,Object> map){
        return consultInfoService.msgList(map);
    }

    @RequestMapping(value = "sendMsg")
    public Object sendMsg(Message model){
        return consultInfoService.sendMsg(model);
    }

}
