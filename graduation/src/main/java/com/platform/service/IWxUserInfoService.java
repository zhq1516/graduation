package com.platform.service;

import com.platform.model.WxUserInfo;
import com.platform.model.vm.ApiResult;

import java.util.HashMap;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-11 15:35
 */
public interface IWxUserInfoService {

    // 用户列表
    ApiResult list(HashMap<String, Object> search);

    // 用户注册
    ApiResult register(WxUserInfo model);

    // 历史文章数据
    ApiResult postHistory(HashMap<String, Object> search);

    // 删除历史数据
    ApiResult deletePostHistory(HashMap<String,Object> search);

    // 历史评论数据
    ApiResult commentHistory(HashMap<String,Object> search);

    // 删除历史评论
    ApiResult deleteCommentHistory(HashMap<String,Object> search);

}
