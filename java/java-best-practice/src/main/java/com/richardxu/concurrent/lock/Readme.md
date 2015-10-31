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