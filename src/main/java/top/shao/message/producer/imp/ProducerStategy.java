/**
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package top.shao.message.producer.imp;

import org.apache.rocketmq.client.producer.MQProducer;
import top.shao.message.producer.MsgProducer;

/**
 * @author shaoneng
 * @version version
 * @title ProduceStategy
 * @desc description
 * @date 2020/3/20
 */
public class ProducerStategy {

    private MsgProducer msgProducer;

    public ProducerStategy(MsgProducer msgProducer) {
        this.msgProducer = msgProducer;
    }

    public void sendMsg(MQProducer mqProducer) throws Exception {
        msgProducer.sendMsg(mqProducer);
    }
}
