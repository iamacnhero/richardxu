### Fork/Join框架

Fork/Join框架是Java 7提供的一个用于并行执行任务的框架，是一个把大任务分割成若干个小任务，最终汇总每个小任务结果得到大任务结果的框架。

#### 工作窃取算法(work-stealing)
工作窃取算法(work-stealing)是指某个线程从其他队列里窃取任务来执行。
为了减少窃取任务线程和被窃取任务线程之间的竞争，通常会使用双端队列，被窃取任务线程永远从双端队列的头部拿任务执行，而窃取任务的线程永远从双端队列的尾部拿任务执行。

** Fork/Join使用两个类 **
 - ForkJoinTask: 要使用Fork/Join框架，首先需要创建一个ForkJoin任务，它提供在任务中执行fork()和join()操作的机制。该类有两个子类：
  - RecursiveAction: 用于没有返回结果的任务
  - RecursiveTask: 用于有返回结果的任务
 - ForkJoinPool: ForkJoinTask需要通过ForkJoinPool来执行。
任务分割出的子任务会添加到当前工作线程所维护的双端队列中，进入队列的头部。当一个工作线程的队列里暂时没有任务时，它会随机从其他工作线程的队列的尾部获取一个任务。 

ForkJoinTask与一般任务的主要区别在于它需要实现compute方法。在这个方法里，首先需要判断任务是否足够小，如果足够小就直接执行任务；否则就分割成两个子任务。
每个子任务在调用fork方法时，又会进入compute方法。

#### Fork/Join框架的异常处理
Fork/Join在执行的时候可能会抛出异常，但是我们没办法在主线程里直接捕获异常，所以ForkJoinTask提供了isCompletedAbnormally()方法来检查方法是否已经抛出异常或已被取消了，
并且可以通过ForkJoinTask的getException()方法获取异常。使用如下代码：
```java
if (task.isCompletedAbnormally()) {
    System.out.println(task.getException());
}
```
