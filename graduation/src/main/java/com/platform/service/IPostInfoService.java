package com.platform.service;

import com.platform.model.Comment;
import com.platform.model.PostInfo;
import com.platform.model.vm.ApiResult;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-09 13:34
 */
public interface IPostInfoService {

    // 根据ID查询帖子信息
    ApiResult detail(HashMap<String,Object> map);

    // 帖子列表
    ApiResult list(HashMap<String,Object> map);

    // 阅读量+1
    ApiResult read(HashMap<String,Object> map);

    // 收藏/取消收藏内容
    ApiResult collect(HashMap<String,Object> map);

    // 点赞/取消点赞
    ApiResult up(HashMap<String,Object> map);

    // 发送评论
    ApiResult comment(Comment model);

    // 推送
    ApiResult publish(List<Integer> ids);

    // 取消推送
    ApiResult cancelPublish(List<Integer> ids);

    // 删除
    ApiResult delete(List<Integer> ids);

    // 保存
    ApiResult save(PostInfo model);

}
