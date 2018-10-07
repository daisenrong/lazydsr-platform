package com.lazydsr.platform.kafka;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * FileName: KafkaProperties
 * Project_Name: lazydsr-platform
 * Package_Name: com.lazydsr.platform.kafka
 *
 * @author: lazydsr
 * @Date: 2018/10/08 00:07
 * Version: 1.0
 * Info: @TODO:...
 */
@Deprecated
@Data
@Component
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaProperties {

    private Template template;

    @Data
    public class Template {
        private String defaultTopic = "";
    }
}
