package com.aaron.mq_topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Producer {
    public static void main(String[] args) throws Exception{
        //创建mq的连接工厂
        ConnectionFactory factory=new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        //获取一个连接
        Connection connection=factory.createConnection();
        //开启连接
        connection.start();;
        //创建一个seseeion
        Session session= connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建一个主题对象
        Topic topic= session.createTopic("aaron_topic");
        //创建消息的生产者
        MessageProducer producer= session.createProducer(topic);
        //创建一个消息
        TextMessage message=session.createTextMessage("hello world topic");
        //发送消息
        producer.send(message);
        //关闭资源
        producer.close();
        session.close();
        connection.close();

    }
}
