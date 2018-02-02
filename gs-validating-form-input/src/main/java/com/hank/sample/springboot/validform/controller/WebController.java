package com.hank.sample.springboot.validform.controller;

import com.hank.sample.springboot.validform.model.PersonForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by Hank on 2/2/2018.
 */
@Controller
public class WebController extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // used to be redirect view
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(PersonForm personForm) {
        return "form";
    }

    /**
     *
     * @param personForm - A personForm object marked up with @Valid to gather the attributes filled out in the form you’re about to build
     * @param bindingResult - A bindingResult object so you can test for and retrieve validation errors
     * @return
     */
    @PostMapping("/")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Test for errors, and if so, send the user back to the original form template.
            return "form";
        }

        // If all of the person’s attribute are valid, then it redirects the browser to the final results template.
        return "redirect:/results";
    }
}
