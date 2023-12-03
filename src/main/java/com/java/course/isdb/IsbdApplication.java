package com.java.course.isdb;

import com.java.course.isdb.configuration.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class IsbdApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(IsbdApplication.class, args);
		ApplicationConfig config = ctx.getBean(ApplicationConfig.class);
		System.out.println(config);
	}

}
