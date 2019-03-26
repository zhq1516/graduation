package com.platform.service.impl;

import com.platform.dao.CommentInfoDao;
import com.platform.model.Comment;
import com.platform.model.vm.ApiResult;
import com.platform.service.ICommentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-22 13:33
 */
@Service
public class CommentInfoServiceImpl implements ICommentInfoService {

    @Autowired
    private CommentInfoDao commentInfoDao;

    @Override
    public ApiResult list(HashMap<String, Object> search) {
        ApiResult result = new ApiResult();
        List<Comment> list = commentInfoDao.list(search);
        Integer count = commentInfoDao.count(search);
        // 判断是否dataTable
        if(!search.containsKey("sEcho"))
            search.put("sEcho",1);
        result.dataTable(Integer.parseInt(search.get("sEcho").toString()),count,list);
        if(count == 0){
            result.setMsg("没有更多数据了！");
        }
        result.success();
        return result;
    }

}
