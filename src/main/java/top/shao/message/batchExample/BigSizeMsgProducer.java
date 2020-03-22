/**
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package top.shao.message.batchExample;

/**
 * @author shaoneng
 * @version version
 * @title BigSizeMsgProducer
 * @desc description
 * @date 2020/3/22
 */

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 发送大于1Mb，继承Iterator接口
 */
public class BigSizeMsgProducer{


    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("batchSmallProducer");
        producer.setNamesrvAddr("localhost:9876");


        String topic = "BatchTest";
        List<Message> messages = new ArrayList<>();

        ListSplitter listSplitter = new ListSplitter(messages);
        while (listSplitter.hasNext()) {
            List<Message> listItem = listSplitter.next();
            producer.send(listItem);
        }
    }

}
