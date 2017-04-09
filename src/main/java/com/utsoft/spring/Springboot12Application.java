package com.utsoft.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot12Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Springboot12Application.class, args);
		//System.out.println("===：" + context.getBean(Runnable.class));
		context.getBean(Runnable.class);
		context.close();

	}

}
