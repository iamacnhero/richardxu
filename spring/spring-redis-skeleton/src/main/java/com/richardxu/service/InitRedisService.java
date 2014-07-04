package com.richardxu.service;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 初始化 Redis 数据
 */
@Service
public class InitRedisService {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
//	@Autowired
//	private RedisService<String> redisService;
	
	@PostConstruct
	public void init() {
		// Delete existing ones

		String key = "user"+"john";
		redisTemplate.opsForHash().delete(key, "id");	// or redisService.getHashOperations().delete(key, "id");
		redisTemplate.opsForHash().delete(key, "firstName");
		redisTemplate.opsForHash().delete(key, "lastName");
		redisTemplate.opsForHash().delete(key, "username");
		redisTemplate.opsForHash().delete(key, "password");
		redisTemplate.opsForHash().delete(key, "role");
		
		key = "user"+"jane";
		redisTemplate.opsForHash().delete(key, "id");
		redisTemplate.opsForHash().delete(key, "firstName");
		redisTemplate.opsForHash().delete(key, "lastName");
		redisTemplate.opsForHash().delete(key, "username");
		redisTemplate.opsForHash().delete(key, "password");
		redisTemplate.opsForHash().delete(key, "role");
		
		// Create new records
		key = "user"+"john";
		redisTemplate.opsForHash().put(key, "id", UUID.randomUUID().toString());
		redisTemplate.opsForHash().put(key, "firstName", "John");
		redisTemplate.opsForHash().put(key, "lastName", "Smith");
		redisTemplate.opsForHash().put(key, "username", "john");
		redisTemplate.opsForHash().put(key, "password", "21232f297a57a5a743894a0e4a801fc3");
		redisTemplate.opsForHash().put(key, "role", "1");
		redisTemplate.opsForSet().add("user", key);		// redisService.getSetOperations().add("user", key);
		
		key = "user"+"jane";
		redisTemplate.opsForHash().put(key, "id", UUID.randomUUID().toString());
		redisTemplate.opsForHash().put(key, "firstName", "Jane");
		redisTemplate.opsForHash().put(key, "lastName", "Adams");
		redisTemplate.opsForHash().put(key, "username", "jane");
		redisTemplate.opsForHash().put(key, "password", "ee11cbb19052e40b07aac0ca060c23ee");
		redisTemplate.opsForHash().put(key, "role", "2");
		redisTemplate.opsForSet().add("user", key);
	}
}
