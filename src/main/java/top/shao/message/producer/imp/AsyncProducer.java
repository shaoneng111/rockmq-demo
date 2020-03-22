/**
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package top.shao.message.producer.imp;

import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import top.shao.message.producer.MsgProducer;

/**
 * @author shaoneng
 * @version version
 * @title AsyncProducer
 * @desc 异步生产者
 * @date 2020/3/20
 */
public class AsyncProducer implements MsgProducer {

    @Override
    public void sendMsg(MQProducer mqProducer) throws Exception {
        for (int i = 0; i < 5; i++) {
            final int index = i;
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("TopicTest",
                    "TagA",
                    "OrderID1188",
                    "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
            mqProducer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%-10d OK %s %n", index,
                            sendResult.getMsgId());
                }
                @Override
                public void onException(Throwable e) {
                    System.out.printf("%-10d Exception %s %n", index, e);
                    e.printStackTrace();
                }
            });
        }
        mqProducer.shutdown();
    }

    public void asynSendMethod(MQProducer mqProducer) {

    }
}
