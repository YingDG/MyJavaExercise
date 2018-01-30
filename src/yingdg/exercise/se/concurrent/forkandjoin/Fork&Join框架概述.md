Fork/Join实现了“工作窃取算法”，
当一个工作线程的队列里暂时没有任务时，它会随机从其他工作线程的队列的尾部获取一个任务，
本质上是分治算法的一种实现。

基于以下两种操作：

    fork操作：当你把任务分成更小的任务和使用这个框架执行它们。
    join操作：当一个任务等待它创建的任务的结束。

Fork/Join框架执行的任务有以下局限性：

    任务只能使用fork()和join()操作，作为同步机制。
    任务不应该执行I/O操作，如读或写数据文件。
    任务不能抛出检查异常，它必须包括必要的代码来处理它们。

核心是由以下两个类：

    ForkJoinPool：它实现ExecutorService接口和work-stealing算法。它管理工作线程和提供关于任务的状态和它们执行的信息。
    ForkJoinTask： 它是将在ForkJoinPool中执行的任务的基类。它提供在任务中执行fork()和join()操作的机制，并且这两个方法控制任务的状态。
                                通常， 为了实现你的Fork/Join任务，你将实现两个子类的子类的类：RecursiveAction对于没有返回结果的任务和RecursiveTask 对于返回结果的任务。

&&&引用：http://ifeve.com/fork-join-1/