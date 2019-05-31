package com.aaron.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Producer {
    public static void main(String[] args) throws Exception{
       //创建mq的连接工厂
        ConnectionFactory factory=new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        //获取一个连接
        Connection connection=factory.createConnection("publisher","publisher");
        //开启连接
        connection.start();;
        //创建一个seseeion
       Session session= connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建一个队列对象
       Queue queue= session.createQueue("aaron-queue");
       //创建消息的生产者
       MessageProducer producer= session.createProducer(queue);
       //创建一个消息
        TextMessage message=session.createTextMessage("hello world");
       //发送消息
        producer.send(message);
        //关闭资源
        producer.close();
        session.close();
        connection.close();

    }
}
