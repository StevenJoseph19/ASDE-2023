package com.mycompany.tollrateui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class TollrateUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollrateUiApplication.class, args);
	}
}
