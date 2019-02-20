package com.hxd.consumerb.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
/**
 *  containerFactory：通过传入不同的factory,来实现发送不同类型的信息
 * */
@Component
public class TopicListener {
    @JmsListener(destination = "publish.topic",containerFactory = "jmsListenerContainerTopic")
    public void receive(String text){
        System.out.println("TopicListener：consumer-b 收到一条信息："+text);
    }
}
