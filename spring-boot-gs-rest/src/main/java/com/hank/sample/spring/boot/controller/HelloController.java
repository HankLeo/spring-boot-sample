package com.hank.sample.spring.boot.controller;

import com.hank.sample.spring.boot.model.Hello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Hank on 12/4/2017.
 */
@RestController
public class HelloController {

    private final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public Hello hello(@RequestParam(value = "username", defaultValue = "World") String name) {
        return new Hello(counter.incrementAndGet(), String.format(template, name));
        // class Hello will be formatted to JSON in response body
    }
}
