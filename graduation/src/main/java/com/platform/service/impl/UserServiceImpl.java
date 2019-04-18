package com.platform.service.impl;

import com.platform.dao.UserDao;
import com.platform.model.User;
import com.platform.model.vm.ApiResult;
import com.platform.service.IUserService;
import com.platform.utils.FileUploadUtil;
import com.platform.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: Air
 * @date: 2019-02-28 19:27
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ApiResult list(HashMap<String, Object> search) {
        ApiResult result = new ApiResult();
        List<User> list = userDao.list(search);
        Integer count = userDao.count(search);
        // 判断是否dataTable
        if(!search.containsKey("sEcho"))
            search.put("sEcho",1);
        result.dataTable(Integer.parseInt(search.get("sEcho").toString()),count,list);
        result.success();
        return result;
    }

    @Override
    public ApiResult addUser(User model) {
        ApiResult result = new ApiResult();
        if(model.getAvatorFile() != null && model.getAvatorFile().size() > 0){
            String avator = FileUploadUtil.uploadFile(model.getAvatorFile(),"avator");
            model.setAvator(avator);
        }else{
            model.setAvator("/avator/public_avator.jpg");
        }
        if(model.getPassword() != null && !model.getPassword().equals("")){
            String newPassword = MD5Util.md5Encrypt(model.getPassword());
            model.setPassword(newPassword);
        }
        Integer ins = userDao.addUser(model);
        if(ins > 0){
            result.setData(model.getId());
            result.success();
        }else {
            result.fail("用户创建失败！");
        }
        return result;
    }

    @Override
    public ApiResult modifyUser(User model) {
        ApiResult result = new ApiResult();
        if(model.getAvatorFile() != null && model.getAvatorFile().size() > 0){
            String avator = FileUploadUtil.uploadFile(model.getAvatorFile(),"avator");
            model.setAvator(avator);
        }else{
            model.setAvator("/avator/public_avator.jpg");
        }
        if(model.getPassword() != null && !model.getPassword().equals("")){
            String newPassword = MD5Util.md5Encrypt(model.getPassword());
            model.setPassword(newPassword);
        }
        Integer ins = userDao.modifyUser(model);
        if(ins > 0){
            result.success();
        }else{
            result.fail("用户信息修改失败！");
        }
        return result;
    }

    @Override
    public ApiResult deleteUser(List<Integer> ids) {
        ApiResult result = new ApiResult();
        Integer ins = userDao.deleteUser(ids);
        if(ins > 0){
            result.success();
        }else {
            result.fail("删除用户失败！");
        }
        return result;
    }

    @Override
    public ApiResult forbidUser(List<Integer> ids) {
        ApiResult result = new ApiResult();
        Integer ins = userDao.forbidUser(ids);
        if(ins > 0){
            result.success();
        }else{
            result.fail("禁用用户失败！");
        }
        return result;
    }

    @Override
    public ApiResult unForbidUser(List<Integer> ids) {
        ApiResult result = new ApiResult();
        Integer ins = userDao.unForbidUser(ids);
        if(ins > 0){
            result.success();
        }else{
            result.fail("启用用户失败！");
        }
        return result;
    }

    @Override
    public ApiResult detail(HashMap<String, Object> map) {
        ApiResult result = new ApiResult();
        User user = userDao.detail(map);
        if(user != null){
            result.setData(user);
            result.success();
        }else{
            result.fail("没有相关用户信息！");
        }
        return result;
    }
}
