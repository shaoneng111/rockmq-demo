package top.shao.message.producer;

import org.apache.rocketmq.client.producer.MQProducer;

import java.io.UnsupportedEncodingException;

/**
 * @author shaoneng
 * @version version
 * @title MsgProducer
 * @desc 抽象生产者
 * @date 2020/3/20
 */
public interface MsgProducer {
    void sendMsg(MQProducer mqProducer) throws Exception;
}
