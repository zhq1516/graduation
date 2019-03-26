package com.platform.dao;

import com.platform.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-22 13:04
 */
@Repository
public interface CommentInfoDao {

    // 评论列表
    List<Comment> list(HashMap<String,Object> search);

    // 评论数量
    Integer count(HashMap<String,Object> search);

}
