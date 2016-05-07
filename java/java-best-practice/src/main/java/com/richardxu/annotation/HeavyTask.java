package com.richardxu.annotation;

import java.util.concurrent.TimeUnit;

@PerformanceLog
public class HeavyTask {

	public void run() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
