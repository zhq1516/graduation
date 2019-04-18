package com.platform.dao;

import com.platform.model.Comment;
import com.platform.model.PostHistory;
import com.platform.model.PostInfo;
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

    // 获取收藏、点赞、看过的文章
    List<PostHistory> postHistory(HashMap<String,Object> search);

    // 删除文章的历史操作
    Integer deletePostHistory(HashMap<String,Object> search);

    // 历史评论
    List<Comment> commentHistory(HashMap<String,Object> search);

    // 删除历史评论
    Integer deleteCommentHistory(HashMap<String,Object> search);

}
