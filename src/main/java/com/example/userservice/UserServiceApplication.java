package com.example.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
//https://spring.io/blog/2020/03/25/spring-tips-spring-cloud-loadbalancer/   thing to complete today 23/01
//https://www.youtube.com/watch?v=tG2dA6zyEgM


@SpringBootApplication
@ComponentScan("com.example.userservice")
@EnableDiscoveryClient 
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
}
