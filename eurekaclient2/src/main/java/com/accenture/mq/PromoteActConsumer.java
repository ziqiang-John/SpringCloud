package com.accenture.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class PromoteActConsumer {
    @JmsListener(destination = "promoteAct")
    public void receiveQueue(String consumer){
        System.out.println(consumer+"消费者消费");
    }

}
