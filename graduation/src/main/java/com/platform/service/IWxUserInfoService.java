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
    ApiResult list(HashMap<String,Object> search);

    // 用户注册
    ApiResult register(WxUserInfo model);

}
