package com.hxd.consumerb.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {

    @JmsListener(destination = "publish.queue",containerFactory ="jmsListenerContainerQueue" )
    @SendTo("out.queue")    //SendTo会将此方法返回的数据，写入到queue:out.queue中去
    public String receive(String text){
        System.out.println("QueueListener：consumer-b 收到一条信息："+text);
        return "consumer-b received："+text;
    }
}
