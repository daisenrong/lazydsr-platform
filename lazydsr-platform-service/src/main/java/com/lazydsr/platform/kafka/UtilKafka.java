package com.lazydsr.platform.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;


/**
 * FileName: KafkaListener
 * Project_Name: lazydsr-platform
 * Package_Name: com.lazydsr.platform.kafka
 *
 * @Author: lazydsr
 * @Date: 2018/10/05 19:15
 * Version: 1.0
 * Info: @TODO:...
 */
@Service
@Slf4j
//@ConfigurationProperties(prefix = "spring.kafka.template.default_topic")
public class UtilKafka {

    //@Autowired
    //private  KafkaProperties kafkaProperties;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    //private final String defaultTopic = "";


    //@KafkaListener(topics = "lazydsr-platform")
    //public void receive(ConsumerRecord<?, ?> consumer) {
    //    log.info("xiaofeikafkaxiaoxi:{} - {}:{}", consumer.topic(), consumer.key(), consumer.value());
    //}

    @KafkaListener(topics = "lazydsr-platform")
    private void receive(List<ConsumerRecord<?, ?>> consumers, Acknowledgment ack) {
        log.info("批量接收消息：{}", consumers.size());
        consumers.forEach(consumer -> {
            log.info("消费kafka消息:{} - {}:{}", consumer.topic(), consumer.key(), consumer.value());
            ack.acknowledge();

        });
    }

    public void send(String key, String data) {


        log.info("发送kafka消息：{}-->{}", key, data);
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send("lazydsr-platform", key, data);
        send.addCallback(
                result -> log.info("消息发送成功{}-->{}:{}", result.getRecordMetadata().topic(), key, data)
                , ex -> log.error("消息发送失败{}-->{}:{}-----{}", "lazydsr-platform", key, data, ex.getStackTrace())
        );

    }

    //class myListener implements MessageListener<String, String> {
    //
    //    @Override
    //    public void onMessage(ConsumerRecord<String, String> data) {
    //
    //    }
    //}


}
