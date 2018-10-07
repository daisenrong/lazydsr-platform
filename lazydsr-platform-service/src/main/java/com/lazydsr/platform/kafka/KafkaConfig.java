package com.lazydsr.platform.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;

/**
 * FileName: KafkaConfig
 * Project_Name: lazydsr-platform
 * Package_Name: com.lazydsr.platform.config
 *
 * @Author: lazydsr
 * @Date: 2018/10/07 22:44
 * Version: 1.0
 * Info: @TODO:...
 */
@Deprecated
@Configuration
public class KafkaConfig {

    //@Autowired
    //private ConcurrentKafkaListenerContainerFactory factory;
    //@Bean
    //public KafkaListenerContainerFactory<?> batchFactory() {
    //
    //    //ConcurrentKafkaListenerContainerFactory<Integer, String> factory =
    //    //        new ConcurrentKafkaListenerContainerFactory<>();
    //    //根据分片数量设置
    //    factory.setConcurrency(2);
    //    //设置为批量消费，每个批次数量在Kafka配置参数中设置ConsumerConfig.MAX_POLL_RECORDS_CONFIG
    //    factory.setBatchListener(true);
    //    //设置提交偏移量的方式
    //    factory.getContainerProperties().setAckMode(AbstractMessageListenerContainer.AckMode.MANUAL_IMMEDIATE);
    //    return factory;
    //}
}
