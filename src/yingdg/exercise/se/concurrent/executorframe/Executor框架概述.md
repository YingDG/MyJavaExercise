主要类：

Executors
1)接口：
Executor：
    用来执行提交的Runnable任务的对象。是一个简单的标准化接口，用来定义包括线程池、异步IO、轻量级任务框架等等。
    任务可以由一个新创建的线程、一个已有任务执行线程、或是线程直接调用execute()来执行，可以串行也可并行执行，取决于使用的是哪个Executor具体类。
ExecutorService：
    Executor的子接口，提供了一个更加具体的异步任务执行框架：
    提供了管理结束的方法，以及能够产生Future以跟踪异步任务进程的方法。一个ExcutorService管理着任务队列和任务调度。
ScheduledExecutorService：
    ExecutorService的子接口，增加了对延迟和定期任务执行的支持。
Callable：
    一个返回结果或抛出异常的任务，实现类需要实现其中一个没有参数的叫做call的方法。
    Callabe类似于Runnable，但是Runnable不返回结果且不能抛出checked exception。
    ExecutorService提供了安排Callable异步执行的方法。
Future：
    代表一个异步计算的结果（由于是并发执行，结果可以在一段时间后才计算完成），
    提供了可判断执行是否完成以及取消执行的方法。

2)实现：
ThreadPoolExecutor和ScheduledThreadPoolExecutor：
    可配置线程池（后者具备延迟或定期调度功能）。
Executors：
    提供Executor、ExecutorService、ScheduledExecutorService、ThreadFactory以及Callable的工厂方法及工具方法。
FutureTask：
    对Future的实现
ExecutorCompletionService：
    帮助协调若干（成组）异步任务的处理。


Queues
1)非阻塞队列：
    ConcurrentLinkedQueue类提供了一个高效可伸缩线程安全非阻塞FIFO队列。
2)阻塞队列：
    BlockingQueue接口，有五个实现类：
    LinkedBlockingQueue、ArrayBlockingQueue、SynchronousQueue、PriorityBlockingQueue和DelayQueue。
    他们对应了不同的应用环境：生产者/消费者、消息发送、并发任务、以及相关并发设计。


Timing
    TimeUnit类：提供了多种时间粒度（包括纳秒）用以表述和控制基于超时的操作。


Synchronizers 提供特定用途同步语境
    Semaphore：计数信号量，这是一种经典的并发工具。
    CountDownLatch：简单的倒计数同步工具，可以让一个或多个线程等待直到另外一些线程中的一组操作处理完成。
    CyclicBarrier：可重置的多路同步工具，可重复使用（CountDownLatch是不能重复使用的）。
    Exchanger：允许两个线程在汇合点交换对象，在一些pipeline设计中非常有用。


Concurrent Collections
除队列外，该包还提供了一些为多线程上下文设计的集合实现：
    ConcurrentHashMap、CopyOnWriteArrayList、CopyOnWriteArraySet。（不需要synchronized关键字配合使用）


java.util.conrurrent下还有两个子包：
1)java.util.concurrent.atomic包下是一组工具类，支持在单个变量上无锁线程安全编程。
2)java.util.concurrent.locks包提供了一个用于锁定和等待条件的框架、不同于内建同步和监视器（synchronization and monitors）。
    Lock接口，实现类ReentrantLock
    ReadWriteLock接口，实现类ReentrantReadWriteLock
    
Exceptions
    InterruptedException


&&&引用：http://blog.csdn.net/wang_shuyu/article/details/53319098