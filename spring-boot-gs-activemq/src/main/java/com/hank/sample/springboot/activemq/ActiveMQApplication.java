package com.hank.sample.springboot.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

@SpringBootApplication
@EnableJms
public class ActiveMQApplication {

    /**
     * This method create the queue instance
     * @return ActiveMQQueue named "sample.queue"
     * @Bean is a method-level annotation and a direct analog of the XML <bean/> element.
     */
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("sample.queue");
    }

    public static void main(String[] args) {
        SpringApplication.run(ActiveMQApplication.class, args);
    }

}
