package com.example.demo;

import com.rabbitmq.client.*;

public class Consumer {
    public static final String QUEUE_NAME="hello";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("192.168.109.100");
        factory.setUsername("admin");
        factory.setPassword("123");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
//        声明接受消息
        DeliverCallback deliverCallback=(consumerTag,message)->{
            System.out.println(new String(message.getBody()));

        };
        CancelCallback cancelCallback=consumerTag->{
            System.out.println("消息被中断");
        };
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback);
        System.out.println("over2");
    }
}
