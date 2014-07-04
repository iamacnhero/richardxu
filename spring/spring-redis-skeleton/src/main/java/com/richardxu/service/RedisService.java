package com.richardxu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisService<V> {
	@Autowired
	private RedisTemplate<String, V> redisTemplate;

	@Autowired
	private ValueOperations<String, V> valueOpeartions;

	@Autowired
	private SetOperations<String, V> setOperations;

	@Autowired
	private ZSetOperations<String, V> zSetOperations;

	@Autowired
	private ListOperations<String, V> listOperations;

	@Autowired
	private HashOperations<String, String, V> hashOperations;

	public RedisTemplate<String, V> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, V> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public ValueOperations<String, V> getValueOpeartions() {
		return valueOpeartions;
	}

	public void setValueOpeartions(ValueOperations<String, V> valueOpeartions) {
		this.valueOpeartions = valueOpeartions;
	}

	public SetOperations<String, V> getSetOperations() {
		return setOperations;
	}

	public void setSetOperations(SetOperations<String, V> setOperations) {
		this.setOperations = setOperations;
	}

	public ZSetOperations<String, V> getzSetOperations() {
		return zSetOperations;
	}

	public void setzSetOperations(ZSetOperations<String, V> zSetOperations) {
		this.zSetOperations = zSetOperations;
	}

	public ListOperations<String, V> getListOperations() {
		return listOperations;
	}

	public void setListOperations(ListOperations<String, V> listOperations) {
		this.listOperations = listOperations;
	}

	public HashOperations<String, String, V> getHashOperations() {
		return hashOperations;
	}

	public void setHashOperations(
			HashOperations<String, String, V> hashOperations) {
		this.hashOperations = hashOperations;
	}

}
