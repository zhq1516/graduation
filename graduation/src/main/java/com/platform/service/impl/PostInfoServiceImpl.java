package com.platform.service.impl;

import com.platform.dao.PostInfoDao;
import com.platform.model.Comment;
import com.platform.model.PostInfo;
import com.platform.model.vm.ApiResult;
import com.platform.service.IPostInfoService;
import com.platform.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-09 13:36
 */
@Service
public class PostInfoServiceImpl implements IPostInfoService {

    @Autowired
    private PostInfoDao postInfoDao;

    @Override
    public ApiResult detail(HashMap<String,Object> map) {
        ApiResult result = new ApiResult();
        PostInfo postInfo = postInfoDao.detail(map);
        if(postInfo != null){
            result.success(postInfo);
        }else{
            result.fail("该帖子信息不存在！");
        }
        return result;
    }

    @Override
    public ApiResult list(HashMap<String,Object> map) {
        ApiResult result = new ApiResult();
        List<PostInfo> list = postInfoDao.list(map);
        Integer count = postInfoDao.count(map);
        // 判断是否dataTable
        if(!map.containsKey("sEcho")) {
            map.put("sEcho", 1);
        }
        result.dataTable(Integer.parseInt(map.get("sEcho").toString()),count,list);
        if(list != null){
            result.success(list);
        }else{
            result.fail("没有更多的内容了！");
        }
        return result;
    }

    @Override
    public ApiResult read(HashMap<String,Object> map) {
        ApiResult result = new ApiResult();
        Integer ins = postInfoDao.read(map);
        if(ins > 0){
            result.success();
        }else{
            result.fail("阅读量增加失败！");
        }
        return result;
    }

    @Override
    public ApiResult collect(HashMap<String,Object> map) {
        ApiResult result = new ApiResult();
        Integer ins = 0;
        if((Integer)(map.get("status")) == 1){
            ins = postInfoDao.cancelCollect(map);
        }else{
            ins = postInfoDao.collect(map);
        }
        if(ins > 0){
            result.success();
        }else{
            result.fail("收藏操作失败！");
        }
        return result;
    }

    @Override
    public ApiResult up(HashMap<String, Object> map) {
        ApiResult result = new ApiResult();
        Integer ins = 0;
        if((Integer)(map.get("status")) == 0){
            ins = postInfoDao.up(map);
        }else{
            ins = postInfoDao.cancelUp(map);
        }
        if(ins > 0){
            result.success();
        }else{
            result.fail("点赞操作失败！");
        }
        return result;
    }

    @Override
    public ApiResult comment(Comment model) {
        ApiResult result = new ApiResult();
        Integer ins = 0;
        if(model.getId() == null) {
            if(model.getImageArray() != null){
                String image = FileUploadUtil.uploadFile(model.getImageArray(),"comment");
                model.setImage(image);
            }
            ins = postInfoDao.comment(model);
        }else{
            ins = postInfoDao.deleteComment(model);
        }
        if(ins > 0){
            result.setData(model.getId());
            result.success();
        }else{
            result.fail("评论操作失败！");
        }
        return result;
    }

    @Override
    public ApiResult publish(List<Integer> ids) {
        ApiResult result = new ApiResult();
        Integer ins = postInfoDao.publish(ids);
        if(ins > 0){
            result.success();
        }else{
            result.fail("批量推送失败！");
        }
        return result;
    }

    @Override
    public ApiResult cancelPublish(List<Integer> ids) {
        ApiResult result = new ApiResult();
        Integer ins = postInfoDao.cancelPublish(ids);
        if(ins > 0){
            result.success();
        }else{
            result.fail("批量取消推送失败！");
        }
        return result;
    }

    @Override
    public ApiResult delete(List<Integer> ids) {
        ApiResult result = new ApiResult();
        Integer ins = postInfoDao.delete(ids);
        if(ins > 0){
            result.success();
        }else{
            result.fail("批量删除失败！");
        }
        return result;
    }

    @Override
    public ApiResult save(PostInfo model) {
        ApiResult result = new ApiResult();
        Integer ins = 0;
        if(model.getImageFiles() != null && model.getImageFiles().size() > 0){
            String image = FileUploadUtil.uploadFile(model.getImageFiles(),"post");
            model.setPostImage(image);
        }
        if(model.getId() == null){
            ins = postInfoDao.create(model);
        }else{
            ins = postInfoDao.update(model);
        }
        if(ins > 0){
            result.setData(model.getId());
            result.success();
        }else{
            result.fail("文章保存失败！");
        }
        return result;
    }
}
