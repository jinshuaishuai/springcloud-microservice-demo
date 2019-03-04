package com.jin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@PropertySource(encoding = "utf-8",value = "classpath:property.properties")
@Data
public class AppConfig {
	//Mysql配置
	@Value("${mysql.driver.name}")
	private String driverName;
	@Value("${mysql.host.name}")
	private String jdbcUrl;
	@Value("${mysql.username}")
	private String username;
	@Value("${mysql.pwd}")
	private String pwd;
	
	//Redis配置,此处没有配置redis的缓存等属性
	@Value("${redis.host}")
	private String host;
	@Value("${redis.port}")
	private int port;
	
	
	
}
