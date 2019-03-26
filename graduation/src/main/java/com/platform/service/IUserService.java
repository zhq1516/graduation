package com.platform.service;

import com.platform.model.User;
import com.platform.model.vm.ApiResult;

import javax.servlet.http.Part;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: Air
 * @date: 2019-02-28 19:21
 */
public interface IUserService {

    // 用户列表
    ApiResult list(HashMap<String,Object> search);

    // 添加用户
    ApiResult addUser(User model);

    // 修改用户信息
    ApiResult modifyUser(User model);

    // 批量删除用户
    ApiResult deleteUser(List<Integer> ids);

    // 批量禁用用户
    ApiResult forbidUser(List<Integer> ids);

    // 用户信息
    ApiResult detail(HashMap<String,Object> map);

}
