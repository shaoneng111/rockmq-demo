/**
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package top.shao.message.filter;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @author shaoneng
 * @version version
 * @title FilterProducer
 * @desc description
 * @date 2020/3/22
 */
public class FilterProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer mqProducer = new DefaultMQProducer("filterProducer");
        mqProducer.start();

        for (int i = 0; i < 10; i++) {
            Message message = new Message("TopicTest", "TAG_A", ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));

            message.putUserProperty("a", String.valueOf(i));
            SendResult sendResult = mqProducer.send(message);
        }

        mqProducer.shutdown();
    }

}
