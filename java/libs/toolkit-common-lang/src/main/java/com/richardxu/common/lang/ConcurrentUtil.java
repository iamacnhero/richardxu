/**
 * 
 */
package com.richardxu.common.lang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * 
 * @version create on 2013-4-23 下午2:06:47
 */
public class ConcurrentUtil {

	public static final void shutdownAndAwaitTermination(
			ExecutorService executorService) {
		if (executorService.isShutdown()) {
			return;
		}
		executorService.shutdown();
		try {
			if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
				executorService.shutdownNow();
			}
		} catch (InterruptedException ie) {
			executorService.shutdownNow();
			Thread.currentThread().interrupt();
		}
		executorService.shutdownNow();

	}

	public static final void shutdownAndAwaitTermination(
			ExecutorService executorService, long timeout, TimeUnit timeUnit) {
		if (executorService.isShutdown()) {
			return;
		}
		executorService.shutdown();
		try {
			if (!executorService.awaitTermination(timeout, timeUnit)) {
				executorService.shutdownNow();
			}
		} catch (InterruptedException ie) {
			executorService.shutdownNow();
			Thread.currentThread().interrupt();
		}
		executorService.shutdownNow();

	}

	public static Exception wait(long timeout, TimeUnit timeUnit) {
		try {
			timeUnit.sleep(timeout);
			return null;
		} catch (InterruptedException e) {
			return e;
		}
	}

}
