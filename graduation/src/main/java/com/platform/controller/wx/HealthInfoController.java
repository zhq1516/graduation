package com.platform.controller.wx;

import com.platform.controller.ApplicationController;
import com.platform.service.IDiseaseInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @description:
 * @author: Air
 * @date: 2019-04-04 13:35
 */
@Controller
@RequestMapping(value = "wx/health")
@ResponseBody
public class HealthInfoController extends ApplicationController {

    @Resource
    private IDiseaseInfoService diseaseInfoService;

    @RequestMapping(value = "type")
    public Object type(){
        return diseaseInfoService.typeList();
    }

    @RequestMapping(value = "list")
    public Object list(@RequestBody HashMap<String,Object> search){
        return diseaseInfoService.getList(search);
    }

}
