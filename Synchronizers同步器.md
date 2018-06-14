## Synchronizers同步器
四个针对特定用途的同步工具类。

### Semaphore 一个典型的同步工具类。
### CountDownLatch 一个非常简单但又非常普遍的同步工具类适用于阻塞直到持有了给定数量的信号量、事件或者条件。
### CyclicBarrier 是一个可重置的多路同步点。
### Exchanger 允许两个线程在相会点交换对象。

### Semaphore
> 一个计数信号量，从概念上来将，一个Semaphore维护着一个许可(permit)的集合, 每次执行获取(acquire)操作都可能会阻塞直到有可用的permit，然后获取它。

> 每次执行释放(release)操作都会增加一个permit。

> Semaphore经常用于限制可同时访问某个资源的线程数。

> 一个Semaphore初始化许可数量为1，只有一permit可用， 可以作为一个互斥锁。也称之为binary semaphore，这种互斥锁有一个优势：

> Semaphore的锁可以被别的线程释放(semaphore是没有拥有者的概念的)， 这个特点在死锁恢复中可以得到应用。

> 构造方法接收一个参数fairness(公平策略), 设为false为非公平锁，不能保证先调用acquire方法的线程优先获得锁。

> 当设为true时为公平锁, 能保证先调用acquire方法的线程优先获得锁。（有个排序点，根据到达排序点的时间来确定FIFO， 先调用acquire方法的线程不一定先到达排序点）

> tryAcquire方法不遵循fairness的设置，只要有许可可以它就会获取到。

> 通常，Semaphore用于控制访问资源时应该设置为公平锁，为了确保不会有线程出现饥饿死锁。

> 当Semaphore用于其他情况时，要充分发挥非公平锁的高吞吐量的优势。


> acquire和release方法也可以一次获取多个许可

#### 实现

底层采用AQS(AbstractQueuedSynchronizer)实现， 它维护了一个整数(int state)用来控制许可数量，





































































































