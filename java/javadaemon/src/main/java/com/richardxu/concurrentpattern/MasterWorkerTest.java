package com.richardxu.concurrentpattern;

import java.util.*;

/**
 * 应用Master-Worker框架，实现一个计算立方和的应用, 并计算1~100的立方和 
 */
public class MasterWorkerTest {
	public static void main(String[] args) {
		// 使用5个Worker，并指定Worker类型
		Master master = new Master(new CubeWorker(), 5);
		
		// 提交100个Job
		for (int i = 0; i < 100; i++) {
			master.submit(i);
		}
		master.execute();		// 开始计算
		
		int result = 0;			// 最终计算结果保存在这
		Map<String, Object> resultMap = master.getResultMap();
		while (resultMap.size() > 0 || !master.isComplete()) {
			// 不需要等待所有Worker都执行完，即可开始计算最终结果
			Set<String> keys = resultMap.keySet();
			String key = null;
			for (String k : keys) {
				key = k;
				break;
			}
			Integer i = null;
			if (key != null)
				i = (Integer) resultMap.get(key);
			if (i != null)
				result += i;				// 最终结果
			if (key != null)
				resultMap.remove(key);		// 移除已被计算过的项
			
		}
		System.out.println(result);
	}
}