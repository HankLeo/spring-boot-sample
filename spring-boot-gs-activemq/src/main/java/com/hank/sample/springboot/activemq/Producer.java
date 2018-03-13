package com.hank.sample.springboot.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

// This class will be implemented by SpringApplication by using @Component
@Component
public class Producer implements CommandLineRunner {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    // The instance marked by @Autowired must be implemented from a Bean
    @Autowired
    private Queue queue;

    @Override
    public void run(String... args) throws Exception {
        send("Sample message");
        System.out.println("Message sent");
    }

    public void send(String msg) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }
}
