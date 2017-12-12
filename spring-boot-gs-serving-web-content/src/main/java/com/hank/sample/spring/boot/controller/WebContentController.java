package com.hank.sample.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Hank on 12/12/2017.
 */
@Controller
public class WebContentController {

    @RequestMapping("/greeting")
    /**
     * The above example does not specify GET vs. PUT, POST, and so forth,
     * because @RequestMapping maps all HTTP operations by default.
     * Use @RequestMapping(method=GET) to narrow this mapping.
     */
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
