package com.platform.service;

import com.platform.model.vm.ApiResult;

import java.util.HashMap;

/**
 * @description:
 * @author: Air
 * @date: 2019-02-28 22:56
 */
public interface IArticleInfoService {

    // 记录查询
    ApiResult list(HashMap<String,Object> search);

}
