package com.platform.service;

import com.platform.model.vm.ApiResult;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-25 13:56
 */
public interface IDiseaseInfoService {

    ApiResult spiderMenu(List<LinkedHashMap<String,Object>> list);

    ApiResult spiderList(List<LinkedHashMap<String,Object>> list);

    ApiResult spiderDetail(List<Map> list);

    ApiResult getList(HashMap<String,Object> search);

}
