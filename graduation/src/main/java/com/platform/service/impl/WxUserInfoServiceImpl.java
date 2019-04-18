package com.platform.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.platform.dao.WxUserInfoDao;
import com.platform.model.Comment;
import com.platform.model.PostHistory;
import com.platform.model.PostInfo;
import com.platform.model.WxUserInfo;
import com.platform.model.vm.ApiResult;
import com.platform.service.IWxUserInfoService;
import com.platform.utils.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-11 15:38
 */
@Service
public class WxUserInfoServiceImpl implements IWxUserInfoService {

    @Autowired
    private WxUserInfoDao wxUserInfoDao;

    @Override
    public ApiResult list(HashMap<String, Object> search) {
        ApiResult result = new ApiResult();
        List<WxUserInfo> list = wxUserInfoDao.list(search);
        Integer count = wxUserInfoDao.count(search);
        if(!search.containsKey("sEcho"))
            search.put("sEcho",1);
        result.dataTable(Integer.parseInt(search.get("sEcho").toString()),count,list);
        result.success();
        return result;
    }

    @Override
    public ApiResult register(WxUserInfo model) {
        ApiResult result = new ApiResult();
        Integer ins = 0;
        if(model.getCode() == null || model.getCode().length() == 0){
            result.fail("code不能为空！");
        }else{
            String appid = "wx29a0eb0b0cb2b83d";
            String secret = "d438097a8a3d66864c3a87af5b5874f0";
            String grant_type = "authorization_code";
            // 拼接请求参数
            String params = "appid=" + appid + "&secret=" + secret + "&js_code=" + model.getCode() + "&grant_type=" + grant_type;
            // 发送请求
            String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session",params);
            // 解析结果为JSON
            JSONObject json = JSON.parseObject(sr);
            // 获取会话密钥
            String session_key = json.get("session_key").toString();
            // 用户唯一ID
            String openid = json.get("openid").toString();
            // 判断用户是否已注册
            WxUserInfo user = wxUserInfoDao.login(openid);
            // 没有注册
            if(user == null){
                // 设置openid
                model.setOpenId(openid);
                // 注册用户
                ins = wxUserInfoDao.register(model);
                // 注册成功
                if(ins > 0){
                    // 返回用户信息
                    result.setData(model);
                    result.success();
                }else{
                    // 注册失败
                    result.fail("微信账号注册失败！");
                }
            }else{
                // 已注册，返回用户信息
                result.setData(user);
                result.success();
            }
        }
        return result;
    }

    @Override
    public ApiResult postHistory(HashMap<String, Object> search) {
        ApiResult result = new ApiResult();
        List<PostHistory> list = wxUserInfoDao.postHistory(search);
        if(list != null){
            result.setData(list);
            result.success();
        }else{
            result.fail("历史数据获取失败！");
        }
        return result;
    }

    @Override
    public ApiResult deletePostHistory(HashMap<String, Object> search) {
        ApiResult result = new ApiResult();
        Integer ins = wxUserInfoDao.deletePostHistory(search);
        if(ins > 0){
            result.success();
        }else{
            result.fail("历史记录删除失败！");
        }
        return result;
    }

    @Override
    public ApiResult commentHistory(HashMap<String, Object> search) {
        ApiResult result = new ApiResult();
        List<Comment> list = wxUserInfoDao.commentHistory(search);
        if(list != null){
            result.setData(list);
            result.success();
        }else{
            result.fail("历史评论数据获取失败！");
        }
        return result;
    }

    @Override
    public ApiResult deleteCommentHistory(HashMap<String, Object> search) {
        ApiResult result = new ApiResult();
        Integer ins = wxUserInfoDao.deleteCommentHistory(search);
        if(ins > 0){
            result.success();
        }else{
            result.fail("删除历史评论失败！");
        }
        return result;
    }

}
