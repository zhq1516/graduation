package com.platform.dao;

import com.platform.model.PostInfo;

import java.util.List;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-09 13:30
 */
public interface PostInfoDao {

    // 根据ID获取帖子信息
    PostInfo detail(Integer id);

    // 获取所有帖子内容
    List<PostInfo> list();

}
