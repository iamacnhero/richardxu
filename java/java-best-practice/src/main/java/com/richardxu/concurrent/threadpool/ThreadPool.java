package com.richardxu.concurrent.threadpool;

/**
 * 线程池接口定义
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2015年10月31日
 */
public interface ThreadPool<Job extends Runnable> {
	// 执行Job，Job需实现Runnable
	void execute(Job job);
	
	// 关闭线程池
	void shutdown();
	
	// 增加worker线程
	void addWorkers(int num);
	
	// 减少worker线程
	void removeWorker(int num);
	
	// 得到正在等待执行的任务数据
	int getJobSize();
}