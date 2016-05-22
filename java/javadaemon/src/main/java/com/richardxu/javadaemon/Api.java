package com.richardxu.javadaemon;

import java.util.Iterator;

public class Api {
	public static String findSlowMethodsBySession(String sessionId, int delay, int slowerThan) {
		long startTime = System.currentTimeMillis();
		Thread[] threads = getAllThreads();
		
		boolean found = false;
		StringBuffer results = new StringBuffer();
		while (System.currentTimeMillis() < startTime + delay) {
			for (Thread thread : threads) {
				if (thread != null) {
					// if (threadS)
				}
			}
		}
		
		
		return "No Thread activity registered for session: " + sessionId + " within the specified time: " + delay + " ms";
	}
	
	private static Thread[] getAllThreads() {
		ThreadGroup g = Thread.currentThread().getThreadGroup();
		for (;;) {
			ThreadGroup g2 = g.getParent();
			if (g2 == null)
				break;
			g = g2;
		}
		int size = 256;
		Thread[] threads;
		for (;;) {
			threads = new Thread[size];
			if (g.enumerate(threads) < size) {
				break;
			}
			size *= 2;
		}
		return threads;
	}
}