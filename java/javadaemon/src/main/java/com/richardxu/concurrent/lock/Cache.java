package com.richardxu.concurrent.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 通过缓存示例说明读写锁的使用方式
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2015年11月1日
 */
public class Cache {
	static Map<String, Object> map = new HashMap<String, Object>();
	static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
	static Lock rLock = rwLock.readLock();
	static Lock wLock = rwLock.writeLock();
	
	// 获取一个key对应的value
	public static final Object get(String key) {
		rLock.lock();
		try {
			return map.get(key);
		} finally {
			rLock.unlock();
		}
	}
	
	// 设置key对应的value，并返回旧的value
	public static final Object put(String key, Object value) {
		wLock.lock();
		try {
			return map.put(key, value);
		} finally {
			wLock.unlock();
		}
	}
	
	// 清空所有的内容
	public static final void clear() {
		wLock.lock();
		try {
			map.clear();
		} finally {
			wLock.unlock();
		}
	}
	
}