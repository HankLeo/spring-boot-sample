package com.hank.sample.spring.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hank on 12/4/2017.
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot!";
    }
}
