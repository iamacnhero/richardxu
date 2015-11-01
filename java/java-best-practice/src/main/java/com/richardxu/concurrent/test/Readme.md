### Java并发容器和框架

#### ConcurrentHashMap的实现原理与使用
在并发编程中使用HashMap可能导致程序死循环(HashMap在并发执行put操作时会引起死循环，是因为多线程会导致HashMap的Entry链表形成环形数据结构，一旦形成环形数据结构，
Entry的next节点永远不为空，就会产生死循环获取Entry)；而使用线程安全的HashTable效率又非常低下（使用synchronized来保证线程安全）。

ConcurrentHashMap的 *锁分段技术* 可有效提升并发访问率。

#### ConcurrentLinkedQueue(并发列队)
在并发编程中，有时需要使用线程安全的队列。如果要实现一个线程安全的队列有两种方式：一是使用阻塞算法（使用锁），另一种是使用非阻塞算法（如循环CAS）。
ConcurrentLinkedQueue是一个基于链接节点的无界线程安全队列，它采用先进先出的规则对节点进行排序，当添加一个元素的时候，它会添加到队列的尾部；当获取一个元素的，它会返回队列头部的元素。

#### Java中的阻塞队列(BlockingQueue)
阻塞队列(BlockingQueue)是一个支持两个附加操作的队列。这两个附加的操作支持阻塞的插入和移除方法。
 * 支持阻塞的插入方法：当队列满时，队列会阻塞插入元素的线程，直到队列不满。
 * 支持阻塞的移除方法：在队列为空时，获取元素的线程会等待队列变为非空。

阻塞队列常用于生产者和消费者的场景。

** 插入和移除操作的4种处理方式 ** 
| 方法/处理方式   | 抛出异常   |  返回特殊值 |  一直阻塞  |  超时退出  |
| -----------   | -----:    | :----:     | :----:    | :----:    |  
| 插入方法       | add(e)    | offer(e)   |  put(e)   |  offer(e, time, unit) |
| 移除方法       | remove()  | poll()     |  take()   |  poll(time, unit)     |
| 检查方法       | element() | peek()     |  不可用    |  不可用    |

** JDK 7 提供了7个阻塞队列： **
 - ArrayBlockingQueue: 一个由数组结构组成的有界阻塞队列。队列按先进先出（FIFO）的原则对元素进行排序。
 - LinkedBlockingQueue: 一个由链表结构组成的有界阻塞队列。队列的默认和最大长度为Integer.MAX_VALUE。队列按先进先出（FIFO）的原则对元素进行排序。
 - PriorityBlockingQueue: 一个支持优先级排序的无界阻塞队列。默认情况下元素采取自然顺序升序排列。 
 - DelayQueue: 一个使用优先级队列实现的无界阻塞队列，支持延时获取元素。
 - SynchronousQueue: 一个不存储元素的阻塞队列。每一个put操作必须等待一个take操作，否则不能继续添加元素。
 - LinkedTranferQueue: 一个由链表结构组成的无界阻塞队列。相对于其他阻塞队列，LinkedTranferQueue多了tryTransfer和transfer方法。
 - LinkedBlockingDeque: 一个由链接结构组成的双向阻塞队列。双向列队因为多了一个操作队列的入口，在多线程同时入队时，也就减少了一半的竞争。
 

 