/**
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package top.shao.message.batchExample;

/**
 * @author shaoneng
 * @version version
 * @title SmallSizeMsgProducer
 * @desc description
 * @date 2020/3/22
 */

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;
import java.util.List;

/**
 * 发送小于1MB的消息
 */
public class SmallSizeMsgProducer {

    public static void main(String[] args) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {

        DefaultMQProducer producer = new DefaultMQProducer("batchSmallProducer");
        producer.setNamesrvAddr("localhost:9876");


        String topic = "BatchTest";
        List<Message> messages = new ArrayList<>();

        messages.add(new Message(topic, "TagA", "OrderID001", "Hello world 0".getBytes()));
        messages.add(new Message(topic, "TagA", "OrderID002", "Hello world 1".getBytes()));
        messages.add(new Message(topic, "TagA", "OrderID003", "Hello world 2".getBytes()));

        producer.send(messages);
    }

}
