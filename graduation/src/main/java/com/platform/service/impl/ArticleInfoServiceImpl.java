package com.platform.service.impl;

import com.platform.dao.ArticleInfoDao;
import com.platform.model.ArticleInfo;
import com.platform.model.vm.ApiResult;
import com.platform.service.IArticleInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: Air
 * @date: 2019-02-28 22:58
 */
@Service
public class ArticleInfoServiceImpl implements IArticleInfoService {

    @Resource
    private ArticleInfoDao articleInfoDao;

    @Override
    public ApiResult list(HashMap<String, Object> search) {
        ApiResult result = new ApiResult();
        List<ArticleInfo> list = articleInfoDao.list(search);
        Integer count = articleInfoDao.count(search);
        // 判断是否dataTable
        if(!search.containsKey("sEcho"))
            search.put("sEcho",1);
        result.dataTable(Integer.parseInt(search.get("sEcho").toString()),count,list);
        result.success();
        return result;
    }
}
