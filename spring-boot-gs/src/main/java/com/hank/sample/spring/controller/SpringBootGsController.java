package com.hank.sample.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hank on 11/28/2017.
 */
@RestController
public class SpringBootGsController {

    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot!";
    }

}
