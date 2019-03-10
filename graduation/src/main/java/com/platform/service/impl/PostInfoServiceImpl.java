package com.platform.service.impl;

import com.platform.dao.PostInfoDao;
import com.platform.model.PostInfo;
import com.platform.model.vm.ApiResult;
import com.platform.service.IPostInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-09 13:36
 */
@Service
public class PostInfoServiceImpl implements IPostInfoService {

    @Resource
    private PostInfoDao postInfoDao;

    @Override
    public ApiResult detail(Integer id) {
        ApiResult result = new ApiResult();
        PostInfo postInfo = postInfoDao.detail(id);
        if(postInfo != null){
            result.success(postInfo);
        }else{
            result.fail("该帖子信息不存在！");
        }
        return result;
    }

    @Override
    public ApiResult list() {
        ApiResult result = new ApiResult();
        List<PostInfo> list = postInfoDao.list();
        if(list != null){
            result.success(list);
        }else{
            result.fail("没有更多的内容了！");
        }
        return result;
    }
}
