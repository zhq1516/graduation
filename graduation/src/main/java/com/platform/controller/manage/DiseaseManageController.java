package com.platform.controller.manage;

import com.platform.controller.ApplicationController;
import com.platform.model.DiseaseInfo;
import com.platform.model.DiseaseItem;
import com.platform.service.IDiseaseInfoService;
import com.platform.utils.SpiderUtil;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-25 14:11
 */

@Controller
@RequestMapping(value = "disease")
@ResponseBody
public class DiseaseManageController extends ApplicationController {

    @Resource
    private IDiseaseInfoService diseaseInfoService;

    @RequestMapping(value = "spider/menu")
    public Object spiderMenu(){
        List<LinkedHashMap<String,Object>> list = SpiderUtil.spiderMenu();
        return diseaseInfoService.spiderMenu(list);
    }

    @RequestMapping(value = "spider/list")
    public Object spiderList(String url,Integer type,Integer start,Integer end){
        List<LinkedHashMap<String,Object>> list = SpiderUtil.spiderDiseaseList(url,start,end);
        for(LinkedHashMap<String,Object> o : list){
            o.put("type",type);
        }
        return diseaseInfoService.spiderList(list);
    }

    @RequestMapping(value = "spider/detail")
    public Object save(@RequestBody HashMap<String,Object> search){
        List<DiseaseInfo> searchList = new ArrayList<>();
        List<Map> list = new ArrayList<>();
        if(diseaseInfoService.getList(search).getData() != null && diseaseInfoService.getList(search).getData() != ""){
            searchList = (List<DiseaseInfo>) diseaseInfoService.getList(search).getData();
        }
        if( searchList != null && searchList.size() > 0){
            list = SpiderUtil.spiderDiseaseDetail(searchList);
        }
        return diseaseInfoService.spiderDetail(list);
    }

    @RequestMapping(value = "list")
    public Object getList(@RequestBody HashMap<String,Object> search){
        return diseaseInfoService.getList(search);
    }

}
