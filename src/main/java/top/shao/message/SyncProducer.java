/**
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package top.shao.message;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import top.shao.message.producer.MsgProducer;
import top.shao.message.producer.imp.AsyncProducer;
import top.shao.message.producer.imp.OneWayProducer;
import top.shao.message.producer.imp.ProducerStategy;
import top.shao.message.producer.imp.SyncMsgProducer;

/**
 * @author shaoneng
 * @version version
 * @title SyncProducer
 * @desc description
 * @date 2020/3/20
 */
public class SyncProducer {

    private static final String PRODUCER_GROUP = "producer_simple";

    public static void main(String[] args) throws Exception {

        // 策略模式发送消息
        MsgProducer msgProducer = new AsyncProducer();
        ProducerStategy producerStategy = new ProducerStategy(msgProducer);

        DefaultMQProducer producer = new DefaultMQProducer(PRODUCER_GROUP);
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        producerStategy.sendMsg(producer);

    }


}
