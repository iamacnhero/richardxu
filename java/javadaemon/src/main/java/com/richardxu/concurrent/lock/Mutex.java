package com.richardxu.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 独占锁Mutex是一个自定义同步组件, 它在同一时刻只允许一个线程占有锁
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2015年11月1日
 */
public class Mutex implements Lock {
	// 定义静态内部类，自定义同步器，继承了同步器并实现了独占式获取和释放同步状态
	private static class Sync extends AbstractQueuedSynchronizer {
		private static final long serialVersionUID = 1L;
		// 是否处于占用状态
		protected boolean isHeldExclusively() {
			return getState() == 1;
		}
		
		// 当状态为0的时候获取锁
		public boolean tryAcquire(int acquires) {
			if (compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}
		
		// 释放锁, 将状态设置为0
		protected boolean tryRelease(int releases) {
			if (getState() == 0) throw new IllegalMonitorStateException();
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}
		
		// 返回一个Condition, 每个Condition都包含了一个condition队列
		Condition newCondition() {
			return new ConditionObject();
		}
	}

	// 仅需要将操作代理到Sync上即可
	private final Sync sync = new Sync();
	
	public void lock() { 
		sync.acquire(1); 
	}
	
	@Override
	public boolean tryLock() {
		return sync.tryAcquire(1);
	}
	
	@Override
	public void unlock() {
		sync.release(1);
	}
	
	@Override
	public Condition newCondition() {
		return sync.newCondition();
	}
	
	public boolean isLocked() {
		return sync.isHeldExclusively();
	}
	
	public boolean hasQueuedThreads() {
		return sync.hasQueuedThreads();
	}
	
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}
	
	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, unit.toNanos(time));
	}
	
}