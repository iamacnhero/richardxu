package com.richardxu.annotation;

public class PerformanceLogProcess {
	public static void main(String[] args) {
		HeavyTask task = new HeavyTask();
		if (task.getClass().isAnnotationPresent(PerformanceLog.class)) {
			long start = System.currentTimeMillis();
			task.run();
			long end = System.currentTimeMillis() - start;
			System.out.println(end);
		}
	}
}
