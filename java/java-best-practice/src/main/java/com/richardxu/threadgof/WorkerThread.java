package com.richardxu.threadgof;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 工作者线程示例代码
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年6月7日
 */
public class WorkerThread {
	public static void main(String[] args) {
		Helper helper = new Helper();
		helper.init();

		// 此处，helper的客户端线程为main线程
		helper.submit("Something...");
	}

	static class Helper {
		private final BlockingQueue<String> workQueue = new ArrayBlockingQueue<String>(1000);

		// 用于处理队列workQueue中的任务的工作者线程
		private final Thread workerThread = new Thread() {
			@Override
			public void run() {
				String task = null;
				while (true) {
					try {
						task = workQueue.take();
					} catch (Exception e) {
						break;
					}
					System.out.println(doProcess(task));
				}
			}
		};

		public void init() {
			workerThread.start();
		}

		protected String doProcess(String task) {
			return task + "->processed.";
		}

		public void submit(String task) {
			workQueue.add(task);
		}
	}
}
