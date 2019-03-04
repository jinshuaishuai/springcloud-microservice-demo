package com.jin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * 
 * @author shuai.jin
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationStartUp {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationStartUp.class, args);
	}
}
