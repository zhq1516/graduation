package com.platform.dao;

import com.platform.model.Comment;
import com.platform.model.PostInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-09 13:30
 */
@Repository
public interface PostInfoDao {

    // 根据ID获取帖子信息
    PostInfo detail(HashMap<String,Object> map);

    // 获取所有帖子内容
    List<PostInfo> list(HashMap<String,Object> map);

    // 数量
    Integer count(HashMap<String,Object> map);

    // 阅读量+1
    Integer read(HashMap<String,Object> map);

    // 收藏内容
    Integer collect(HashMap<String,Object> map);

    // 取消收藏
    Integer cancelCollect(HashMap<String,Object> map);

    // 点赞
    Integer up(HashMap<String,Object> map);

    // 取消点赞
    Integer cancelUp(HashMap<String,Object> map);

    // 发送评论
    Integer comment(Comment model);

    // 删除评论
    Integer deleteComment(Comment model);

    // 批量推送
    Integer publish(List<Integer> ids);

    // 批量取消推送
    Integer cancelPublish(List<Integer> ids);

    // 批量删除
    Integer delete(List<Integer> ids);

    // 新建文章
    Integer create(PostInfo model);

    // 修改文章
    Integer update(PostInfo model);

}
