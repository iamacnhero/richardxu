package com.richardxu.concurrentpattern;

public class CubeWorker extends Worker {
	public Object handle(Object input) {
		int i = (Integer) input;
		// return i * i * i;
		return (int) Math.pow(i, 3);
	}
}