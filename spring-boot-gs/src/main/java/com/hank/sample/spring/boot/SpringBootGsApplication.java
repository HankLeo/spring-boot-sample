package com.hank.sample.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootGsApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootGsApplication.class, args);
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootGsApplication.class, args);

		System.out.println("Let's inspect the beans provided by Spring Boot:");
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
}
