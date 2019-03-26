package com.platform.service;

import com.platform.model.vm.ApiResult;

import java.util.HashMap;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-11 15:35
 */
public interface ICommentInfoService {

    // 评论列表
    ApiResult list(HashMap<String, Object> search);

}
