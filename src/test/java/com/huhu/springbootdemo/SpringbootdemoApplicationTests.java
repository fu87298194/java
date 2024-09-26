package com.huhu.springbootdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class SpringbootdemoApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	public void testSet(){
		// 操作redis中的string类型的数据， 先获取ValueOperation对象
		ValueOperations valueOperations = redisTemplate.opsForValue();
		// 添加数据到redis
		valueOperations.set("name", "zhangsan");


	}

	@Test
	public void testGet() {
		Object name = redisTemplate.boundValueOps("name").get();
		System.out.println(name);
	}

}
