package com.jarranz.springcloudkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jarranz.springcloudkafka.producer.Sender;

@SpringBootApplication
public class SpringcloudkafkaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudkafkaApplication.class, args);
	}
    @Autowired
    private Sender sender;

    @Override
    public void run(String... strings) throws Exception {
        String data = "Spring Kafka Producer and Consumer Example";
        sender.send(data);
    }
}
