/**
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package top.shao.message.producer.imp;

import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import top.shao.message.producer.MsgProducer;

/**
 * @author shaoneng
 * @version version
 * @title SyncMsgProducer
 * @desc 同步生产者
 * @date 2020/3/20
 */
public class SyncMsgProducer implements MsgProducer {
    @Override
    public void sendMsg(MQProducer mqProducer) throws Exception {
        for (int i = 0; i < 100; i++) {
            Message msg = new Message("TopicTest" /* Topic */,
                    "TagA" /* Tag */,
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );

            SendResult sendResult = mqProducer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        mqProducer.shutdown();
    }
}
