package com.example.springcloudapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@SpringBootApplication
//增加注解用来将微服务注册到Eureka中管理
@EnableEurekaClient
//增加注解用于接入第三方系统
//@EnableSidecar
public class SpringcloudApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudApiApplication.class, args);
	}
}
