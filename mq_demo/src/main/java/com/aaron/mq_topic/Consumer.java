package com.aaron.mq_topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {
    public static void main(String[] args)  throws Exception{
        //创建mq的连接工厂
        ConnectionFactory factory=new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        //获取一个连接
        Connection connection=factory.createConnection();
        //在持久化订阅的时候需要一个Id来标识
        connection.setClientID("aaron_00");
        //开启连接
        connection.start();;
        //创建一个seseeion
        Session session= connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建一个topic对象
        Topic topic= session.createTopic("aaron_topic");
        //创建消息的消费者
        MessageConsumer consumer=session.createDurableSubscriber(topic,"aaron_topic_00");
        //接受消息
        TextMessage message=(TextMessage) consumer.receive();
        String text=message.getText();
        System.out.println("消费者0收到消息："+text);
        consumer.close();
        session.close();
        connection.close();

    }
}
