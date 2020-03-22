/**
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package top.shao.message.producer.imp;

import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.common.message.Message;
import top.shao.message.producer.MsgProducer;

/**
 * @author shaoneng
 * @version version
 * @title OneWayProducer
 * @desc description
 * @date 2020/3/20
 */
public class OneWayProducer implements MsgProducer {

    @Override
    public void sendMsg(MQProducer mqProducer) throws Exception {
        //循环发送消息
        for (int i = 0; i < 3; i++){
            Message msg = new Message(
                    // Message 所属的 Topic
                    "TopicTestMQ",
                    // Message Tag,
                    // 可理解为 Gmail 中的标签，对消息进行再归类，方便 Consumer 指定过滤条件在消息队列 RocketMQ 版的服务器过滤
                    "TagA",
                    // Message Body
                    // 任何二进制形式的数据，消息队列 RocketMQ 版不做任何干预，需要 Producer 与 Consumer 协商好一致的序列化和反序列化方式
                    "Hello MQ".getBytes());

            // 设置代表消息的业务关键属性，请尽可能全局唯一
            // 以方便您在无法正常收到消息情况下，可通过阿里云服务器管理控制台查询消息并补发
            // 注意：不设置也不会影响消息正常收发
            msg.setKeys("ORDERID_" + i);

            // 由于在 oneway 方式发送消息时没有请求应答处理，一旦出现消息发送失败，则会因为没有重试而导致数据丢失。若数据不可丢，建议选用可靠同步或可靠异步发送方式
            mqProducer.sendOneway(msg);
        }

        // 在应用退出前，销毁 Producer 对象
        // 注意：如果不销毁也没有问题
        mqProducer.shutdown();
    }
}
