package com.kubedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class KubeTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(KubeTestApplication.class, args);
	}

}
