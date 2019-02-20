package com.hxd.consumera.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 *  containerFactory：通过传入不同的factory,来实现发送不同类型的信息
 *
 *  topic默认情况下, 是不会保存数据的, 也就是说, consumer是接收不到之前未接收到的信息.
 *
 * */
@Component
public class TopicListener {
    @JmsListener(destination = "publish.topic",containerFactory = "jmsListenerContainerTopic")

    public void  receive(String text){
        System.out.println("TopicListener：consumer-a 收到一条信息："+text);
    }
}
