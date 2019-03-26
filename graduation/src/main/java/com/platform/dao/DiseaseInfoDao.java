package com.platform.dao;

import com.platform.model.DiseaseInfo;
import com.platform.model.DiseaseItem;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-25 13:39
 */
@Repository
public interface DiseaseInfoDao {

    // 爬取疾病菜单
    Integer spiderMenu(List<LinkedHashMap<String,Object>> list);

    // 爬取疾病列表
    Integer spiderList(List<LinkedHashMap<String,Object>> list);

    // 爬取疾病详情
    Integer spiderDetail(List<Map> list);

    // 获取疾病列表
    List<DiseaseItem> list(HashMap<String,Object> search);

    // 疾病列表
    Integer count(HashMap<String,Object> search);

    // 获取

}
