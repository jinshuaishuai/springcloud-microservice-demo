package com.jin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(encoding = "utf-8",value = "classpath:property.properties")

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
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	
}
