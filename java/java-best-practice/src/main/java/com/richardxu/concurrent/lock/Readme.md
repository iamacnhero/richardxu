### Java中的锁

#### Lock 接口
Lock接口及其相关实现类提供了与synchronized关键字类似的同步功能，只是在使用时需要显式地获取和释放锁。
使用synchronized关键字将会隐式地获取锁，但是它将锁的获取和释放固化了，也就是先获取再释放。
`java
Lock lock = new ReentrantLock();
lock.lock();
try {
    
} finally {
    lock.unlock();
}
`
不要将获取锁的过程写在try块中，因为如果在获取锁（自定义锁的实现）时发生了异常，异常抛出的同时，也会导致锁释放。

Lock 接口提供的synchronized关键字不具备的特性
* 尝试非阻塞地获取锁 ( tryLock() )
* 能被中断地获取锁 ( lockInterruptibly() )
* 超时获取锁 ( tryLock(long time, TimeUnit unit) )

同步器AbstractQueuedSynchronizer。
Lock接口的实现基本都是通过聚合了一个同步器的子类来完成线程访问控制的。

#### 队列同步器(AbstractQueuedSynchronizer)
队列同步器是用来构建锁或者其他同步组件的基础框架，它使用了一个int成员变量(state)表示同步状态，通过内置的FIFO队列来完成资源获取线程的排队工作。
同步器是实现锁的关键，在锁的实现中聚合同步器，利用同步器实现锁的语义。

同步器的设计是基于模板方法模式的。
