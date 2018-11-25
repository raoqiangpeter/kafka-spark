package com.raoqiang.kafkaspark;

import com.raoqiang.kafkaspark.kafkaDemo.beans.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaSparkApplicationTests {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    public void contextLoads() throws InterruptedException, ExecutionException {

        for (int i=0; i<10; i++){
            kafkaTemplate.send("wordcount", "key : test", new Message("kafka-header", 1, "kafka-body", "kafka 描述")).get();
//            Thread.sleep(500);
        }
    }

}
