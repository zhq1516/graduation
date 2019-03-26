package com.platform.dao;

import com.platform.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface UserDao {

    // 用户列表
    List<User> list(HashMap<String,Object> search);

    // 用户数量
    Integer count(HashMap<String,Object> search);

    // 新增用户
    Integer addUser(User model);

    // 修改用户信息
    Integer modifyUser(User model);

    // 批量删除用户
    Integer deleteUser(List<Integer> ids);

    // 批量禁用用户
    Integer forbidUser(List<Integer> ids);

    // 获取用户信息
    User detail(HashMap<String,Object> map);

    // 登录
    User login(String userName);

}
