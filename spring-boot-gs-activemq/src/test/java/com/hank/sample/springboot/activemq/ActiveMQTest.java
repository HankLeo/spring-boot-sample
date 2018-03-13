package com.hank.sample.springboot.activemq;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveMQTest {

    public final String testMsg = "Test Message";

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Autowired
    public Producer producer;

    @Test
    public void sendSimpleMessage() throws InterruptedException {
        this.producer.send(testMsg);
        Thread.sleep(1000L);
        assertThat(this.outputCapture.toString().contains(testMsg)).isTrue();
    }

}
