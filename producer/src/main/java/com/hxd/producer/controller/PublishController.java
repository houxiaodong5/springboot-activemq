package com.hxd.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

@RestController
@RequestMapping("/publish")
public class PublishController {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;

    @RequestMapping("/queue")
    public String queue(){
        for(int i=0;i<10;i++){
            jmsMessagingTemplate.convertAndSend(queue,"queue    "+i);
        }
        return "queue 发送成功";
    }

    /**
     * @JmsListener(destination = "out.queue") :监听topic或queue的值
     * @JmsListener(subscription="") :持久化订阅者名称， 设置这个属性，服务器每次重启后，都不会生成新的，一直只有这一个
     * */
    @JmsListener(destination = "out.queue")
    public void consumerMsg(String msg){
        System.out.println(msg);
    }

    @RequestMapping("/topic")
    public String topic(){
        for(int i=0;i<10;i++){
            jmsMessagingTemplate.convertAndSend(topic,"topic    "+i);
        }
        return "topic 发送成功";
    }

}
