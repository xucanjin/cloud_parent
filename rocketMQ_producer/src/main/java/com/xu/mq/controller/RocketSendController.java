package com.xu.mq.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.xu.mq.PayLog;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author: canjin
 * @Date: 2021/8/12
 * 说明: 发送rocketMq的事务消息
 */
@RestController
@RequestMapping(value = "/wx")
@CrossOrigin
public class RocketSendController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /****
     * 支付结果回调
     */
    @RequestMapping(value = "/result")
    public String result(HttpServletRequest request){
        //创建日志对象
        PayLog payLog = new PayLog(IdWorker.getIdStr(),1,"hello","AA",new Date());

        //构建消息
        Message<String> message = MessageBuilder.withPayload(JSON.toJSONString(payLog)).build();

        //sendMessageInTransaction 发送事务消息
        //log是topic的名字
        rocketMQTemplate.sendMessageInTransaction("log",message,null);

        return null;
    }
}
