package com.platform.service;

import com.platform.model.vm.ApiResult;

import javax.servlet.http.Part;
import java.util.HashMap;

/**
 * @description:
 * @author: Air
 * @date: 2019-02-28 19:21
 */
public interface IUserService {

    ApiResult list(HashMap<String,Object> search);



}
