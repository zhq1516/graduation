package com.platform.dao;

import com.platform.model.ArticleInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @description:推送管理
 * @author: Air
 * @date: 2019-02-28 22:48
 */
@Repository
public interface ArticleInfoDao {

    // 查询记录
    List<ArticleInfo> list(HashMap<String,Object> search);

    // 查询记录数
    Integer count(HashMap<String,Object> search);

}
