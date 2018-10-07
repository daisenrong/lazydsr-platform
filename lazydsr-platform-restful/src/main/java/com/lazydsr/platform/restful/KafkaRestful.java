package com.lazydsr.platform.restful;

import com.lazydsr.platform.kafka.UtilKafka;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName: restful
 * Project_Name: lazydsr-platform
 * Package_Name: com.lazydsr.platform
 * Author: lazydsr
 * Date: 2018/10/05 18:57
 * Version: 1.0
 * Info: @TODO:...
 */
@RestController
@Slf4j
public class KafkaRestful {

    @Autowired
    private UtilKafka utilKafka;

    @Value("${spring.kafka.template.default-topic}")
    private static final String DEFAULT_TOPICS = "";

    @GetMapping("kafka")
    public String sendKafka() {

        int iMax = 6;
        for (int i = 1; i < iMax; i++) {
            utilKafka.send("key" + i, "data" + i);
        }
        log.info("========="+DEFAULT_TOPICS);
        return "success";
    }
    //@GetMapping("kafka1")
    //public String getKafka(){
    //
    //}



}
