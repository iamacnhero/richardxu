package com.richardxu.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义同步组件，在同一时刻，只允许至多两个线程同时访问，超过两个线程的访问将被阻塞。
 * 1. 确定访问模式：TwinsLock能够同一时刻支持多个线程的访问，显然是共享式访问，因此需要重写tryAcquireShared(int args)方法和tryReleaseShared(int args)方法，
 * 这样才能保证同步器的共享式同步状态的获取与释放方法得以执行
 * 2. 定义资源数：TwinsLock能够同一时刻允许至多两个线程的同时访问，表明同步资源数为2，这样可以设置初始状态为2，当一个线程获取，status减1，该线程释放，则status加1，
 * 状态的合法范围为0、1和2。其中0表示当前已有两个线程获取了同步资源，此时再有其他线程对同步状态进行获取，该线程只能被阻塞。在同步状态变更时，需使用compareAndSet方法做原子性保障。
 * 3. 最后，组合自定义同步器：一般情况下，自定义同步器会被定义为自定义同步组件的内部类。
 *  
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2015年11月1日
 */
public class TwinsLock implements Lock {
	private final Sync sync = new Sync(2);
	
	@SuppressWarnings("serial")
	private static final class Sync extends AbstractQueuedSynchronizer {
		Sync(int count) {
			if (count <= 0) {
				throw new IllegalArgumentException("count must large than zero.");
			}
			setState(count);
		}
		
		public int tryAcquireShared(int reduceCount) {
			for (;;) {
				int current = getState();
				int newCount = current - reduceCount;
				if (newCount < 0 || compareAndSetState(current, newCount)) {
					return newCount;
				}
			}
		}
		
		public boolean tryReleaseShared(int returnCount) {
			for (;;) {
				int current = getState();
				int newCount = current + returnCount;
				if (compareAndSetState(current, newCount)) {
					return true;
				}
			}
		}
	}
	
	@Override
	public void lock() {
		sync.tryAcquireShared(1);
	}

	@Override
	public boolean tryLock() {
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return false;
	}

	@Override
	public void unlock() {
		sync.releaseShared(1);
	}

	@Override
	public Condition newCondition() {
		return null;
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		
	}
	
}