package com.platform.dao;

import com.platform.model.WxUserInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-11 15:30
 */
@Repository
public interface WxUserInfoDao {

    // 列表
    List<WxUserInfo> list(HashMap<String,Object> search);

    // 数量
    Integer count(HashMap<String,Object> search);

    // 注册
    Integer register(WxUserInfo model);

    // 获取用户信息
    WxUserInfo login(String openId);

}
