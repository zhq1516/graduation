package com.platform.service;

import com.platform.model.PostInfo;
import com.platform.model.vm.ApiResult;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-09 13:34
 */
public interface IPostInfoService {

    // 根据ID查询帖子信息
    ApiResult detail(Integer id);

    // 帖子列表
    ApiResult list();

}
