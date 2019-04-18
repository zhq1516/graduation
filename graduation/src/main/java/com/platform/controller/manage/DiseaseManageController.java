package com.platform.controller.manage;

import com.google.gson.Gson;
import com.platform.controller.ApplicationController;
import com.platform.model.DiseaseInfo;
import com.platform.model.vm.ApiResult;
import com.platform.model.vm.DataTablesParameters;
import com.platform.service.IDiseaseInfoService;
import com.platform.utils.SpiderUtil;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-25 14:11
 */

@Controller
@RequestMapping(value = "health")
@ResponseBody
public class DiseaseManageController extends ApplicationController {

    @Resource
    private IDiseaseInfoService diseaseInfoService;

    @RequestMapping(value = "")
    public ModelAndView index(){
        return buildMAV("health/list.jsp");
    }

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
    public Object getList(String aoData,String formData){
        DataTablesParameters parameters = DataTablesParameters.fromJson(aoData);
        HashMap<String, Object> searchMap = new HashMap<>();
        searchMap = new Gson().fromJson(formData,searchMap.getClass());
        searchMap.put("limit", parameters.getRows());
        searchMap.put("offset", parameters.getStart());
        searchMap.put("search", parameters.getSearch());
        searchMap.put("sEcho",parameters.getsEcho());
        return diseaseInfoService.getList(searchMap);
    }

    @RequestMapping(value = "operation")
    public Object operation(@RequestParam(value = "ids[]") List<Integer> ids,Integer type){
        ApiResult result = new ApiResult();
        switch (type){
            case 1:
                result = diseaseInfoService.setInvisible(ids);
                break;
            case 2:
                result = diseaseInfoService.setVisible(ids);
                break;
            default:
                break;
        }
        return result;
    }

}
