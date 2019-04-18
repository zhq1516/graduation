package com.platform.service;

import com.platform.model.ConsultInfo;
import com.platform.model.Message;
import com.platform.model.vm.ApiResult;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: Air
 * @date: 2019-04-04 16:52
 */
public interface IConsultInfoService {

    // 咨询列表
    ApiResult list(HashMap<String,Object> search);

    // 发起咨询
    ApiResult consult(ConsultInfo model);

    // 医生列表
    ApiResult doctor(HashMap<String,Object> search);

    // 获取某次咨询信息
    ApiResult detail(HashMap<String,Object> search);

    // 消息列表
    ApiResult msgList(HashMap<String,Object> map);

    // 发送消息
    ApiResult sendMsg(Message model);

    // 批量删除
    ApiResult delete(List<Integer> ids);

    // 批量结束
    ApiResult finish(List<Integer> ids);

}
