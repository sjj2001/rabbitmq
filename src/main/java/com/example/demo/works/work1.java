package com.example.demo.works;

import com.example.demo.FactoryUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

public class work1 {
    public static final String QUEUE_NAME="hello";

    public static void main(String[] args) throws Exception {
        Channel channel = FactoryUtils.getChannel();
        DeliverCallback deliverCallback=(consumerTag, message)->{
            System.out.println(new String(message.getBody()));

        };
        CancelCallback cancelCallback= consumerTag->{
            System.out.println("消息被中断");
        };
        System.out.println("c2在等待");
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback);

    }



}
