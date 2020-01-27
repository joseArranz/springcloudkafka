package com.jarranz.springcloudkafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    private static final Logger LOG = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.topic.foo}")
    private String topic;

    public void send(String message){
        LOG.info("sending message='{}' to topic='{}'", message, topic);
        System.out.println("sending : "  + topic + ", mensaje : " + message);
        kafkaTemplate.send(topic, message);
        for (int i = 0; i < 10; i++) {						
			kafkaTemplate.send(topic, "Comunication Open -------- ");
		}
        kafkaTemplate.send(topic, "Comunication Finish ");
        kafkaTemplate.send(topic, message);
    }
}
