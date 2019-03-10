package com.platform.dao;

import com.platform.model.User;

import java.util.HashMap;
import java.util.List;

public interface UserDao {

    // 用户列表
    List<User> list(HashMap<String,Object> search);

    // 用户数量
    Integer count(HashMap<String,Object> search);

    // 新增用户
    Integer addUser(User model);

}
