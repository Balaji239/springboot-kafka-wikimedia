package com.kafkawikimediaconsumer.kafka;

import com.kafkawikimediaconsumer.entity.WikimediaData;
import com.kafkawikimediaconsumer.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private WikimediaRepository dataRepository;

    public KafkaConsumer(WikimediaRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message){
        LOGGER.info(String.format("Message received -> %s", message));

        WikimediaData eventMessage = new WikimediaData();
        eventMessage.setMessage(message);
        dataRepository.save(eventMessage);

    }
}
