package com.hank.sample.springboot.demo;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class Demo {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        //SpringApplication.run(Demo.class, args);
        SpringApplication application = new SpringApplication(Demo.class);
        //application.setBannerMode(Banner.Mode.OFF);    // no "Spring" banner in startup console
        application.run(args);
    }
}

// run $ mvn spring-boot:run to start application