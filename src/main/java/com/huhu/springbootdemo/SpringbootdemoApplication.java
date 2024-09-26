package com.huhu.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.huhu.springbootdemo.mapper")
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext  context=  SpringApplication.run(SpringbootdemoApplication.class, args);
		Object redisTemplate = context.getBean("redisTemplate");
		System.out.println(redisTemplate);

	}

}
