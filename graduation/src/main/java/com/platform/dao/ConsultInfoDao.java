package com.platform.dao;

import com.platform.model.ConsultInfo;
import com.platform.model.Message;
import com.platform.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: Air
 * @date: 2019-04-04 16:26
 */
@Repository
public interface ConsultInfoDao {

    // 咨询记录
    List<ConsultInfo> list(HashMap<String,Object> search);

    // 咨询数量
    Integer count(HashMap<String,Object> search);

    // 发起咨询
    Integer createConsult(ConsultInfo model);

    // 医生列表
    List<User> doctor(HashMap<String,Object> search);

    // 获取某次咨询详情
    ConsultInfo detail(HashMap<String,Object> search);

    // 消息列表
    List<Message> msgList(HashMap<String,Object> map);

    // 发送消息
    Integer sendMsg(Message model);

    // 批量删除
    Integer delete(List<Integer> ids);

    // 批量结束
    Integer finish(List<Integer> ids);

}
