package com.platform.service.impl;

import com.platform.dao.DiseaseInfoDao;
import com.platform.model.DiseaseInfo;
import com.platform.model.DiseaseType;
import com.platform.model.vm.ApiResult;
import com.platform.service.IDiseaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-25 13:58
 */
@Service
public class DiseaseInfoServiceImpl implements IDiseaseInfoService {

    @Autowired
    private DiseaseInfoDao diseaseInfoDao;

    @Override
    public ApiResult spiderMenu(List<LinkedHashMap<String, Object>> list) {
        ApiResult result = new ApiResult();
        Integer ins = diseaseInfoDao.spiderMenu(list);
        if(ins > 0){
            result.success();
        }else{
            result.fail("保存出错！");
        }
        return result;
    }

    @Override
    public ApiResult spiderList(List<LinkedHashMap<String, Object>> list) {
        ApiResult result = new ApiResult();
        Integer ins = diseaseInfoDao.spiderList(list);
        if(ins > 0){
            result.success();
        }else{
            result.fail("保存出错！");
        }
        return result;
    }

    @Override
    public ApiResult spiderDetail(List<Map> list) {
        ApiResult result = new ApiResult();
        Integer ins = diseaseInfoDao.spiderDetail(list);
        if(ins > 0){
            result.success();
        }else{
            result.fail("保存出错！");
        }
        return result;
    }

    @Override
    public ApiResult typeList() {
        ApiResult result = new ApiResult();
        List<DiseaseType> list = diseaseInfoDao.typeList();
        if(list != null){
            result.setData(list);
            result.success();
        }else{
            result.fail("获取类型列表失败！");
        }
        return result;
    }

    @Override
    public ApiResult getList(HashMap<String,Object> search) {
        ApiResult result = new ApiResult();
        List<DiseaseInfo> list = diseaseInfoDao.list(search);
        Integer count = diseaseInfoDao.count(search);
        // 判断是否dataTable
        if(!search.containsKey("sEcho"))
            search.put("sEcho",1);
        result.dataTable(Integer.parseInt(search.get("sEcho").toString()),count,list);
        if(list != null){
            result.success();
        }else{
            result.fail("获取列表失败！");
        }
        return result;
    }

    @Override
    public ApiResult setInvisible(List<Integer> ids) {
        ApiResult result = new ApiResult();
        Integer ins = diseaseInfoDao.setInvisible(ids);
        if(ins > 0){
            result.success();
        }else{
            result.fail("批量操作失败！");
        }
        return result;
    }

    @Override
    public ApiResult setVisible(List<Integer> ids) {
        ApiResult result = new ApiResult();
        Integer ins = diseaseInfoDao.setVisible(ids);
        if(ins > 0){
            result.success();
        }else{
            result.fail("批量操作失败！");
        }
        return result;
    }

}
