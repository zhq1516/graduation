package com.platform.service.impl;

import com.platform.dao.ConsultInfoDao;
import com.platform.model.ConsultInfo;
import com.platform.model.Message;
import com.platform.model.User;
import com.platform.model.vm.ApiResult;
import com.platform.service.IConsultInfoService;
import com.platform.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: Air
 * @date: 2019-04-04 16:53
 */
@Service
public class ConsultInfoServiceImpl implements IConsultInfoService {

    @Autowired
    private ConsultInfoDao consultInfoDao;

    @Override
    public ApiResult list(HashMap<String, Object> search) {
        ApiResult result = new ApiResult();
        List<ConsultInfo> list = consultInfoDao.list(search);
        Integer count = consultInfoDao.count(search);
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

    @Override
    public ApiResult consult(ConsultInfo model) {
        ApiResult result = new ApiResult();
        Integer ins = consultInfoDao.createConsult(model);
        if(ins > 0){
            result.setData(model.getId());
            result.success();
        }else{
            result.fail("发起咨询失败！");
        }
        return result;
    }

    @Override
    public ApiResult doctor(HashMap<String, Object> search) {
        ApiResult result = new ApiResult();
        List<User> list = consultInfoDao.doctor(search);
        if(list != null){
            result.setData(list);
            result.success();
        }else{
            result.fail("获取医生列表失败！");
        }
        return result;
    }

    @Override
    public ApiResult detail(HashMap<String, Object> search) {
        ApiResult result = new ApiResult();
        ConsultInfo model = consultInfoDao.detail(search);
        if(model != null){
            result.setData(model);
            result.success();
        }else{
            result.fail("获取咨询内容失败！");
        }
        return result;
    }

    @Override
    public ApiResult msgList(HashMap<String, Object> map) {
        ApiResult result = new ApiResult();
        List<Message> list = consultInfoDao.msgList(map);
        if(list != null){
            result.setData(list);
            result.success();
        }else{
            result.fail("获取消息列表失败！");
        }
        return result;
    }

    @Override
    public ApiResult sendMsg(Message model) {
        ApiResult result = new ApiResult();
        if(model.getImageArray() != null && model.getImageArray().size() > 0){
            String image = FileUploadUtil.uploadFile(model.getImageArray(),"consult");
            model.setImage(image);
        }
        Integer ins = consultInfoDao.sendMsg(model);
        if(ins > 0){
            result.setData(model.getId());
            result.success();
        }else{
            result.fail("发送消息失败！");
        }
        return result;
    }

    @Override
    public ApiResult delete(List<Integer> ids) {
        ApiResult result = new ApiResult();
        Integer ins = consultInfoDao.delete(ids);
        if(ins > 0){
            result.success();
        }else{
            result.fail("批量删除失败！");
        }
        return result;
    }

    @Override
    public ApiResult finish(List<Integer> ids) {
        ApiResult result = new ApiResult();
        Integer ins = consultInfoDao.finish(ids);
        if(ins > 0){
            result.success();
        }else{
            result.fail("批量结束失败！");
        }
        return result;
    }
}
