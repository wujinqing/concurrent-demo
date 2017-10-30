## Fork Join框架

fork/join框架是ExecutorService的一个实现，其目的是为了充分利用多核处理器的优势。

设计目标是将一个大任务拆分成多个小任务递归处理。以便使用所有处理器以提高应用的性能。


和所有ExecutorService的实现一样，fork/join框架将任务线程维护再一个线程池当中。
采用了工作窃取算法，先工作完的线程会窃取其他未工作完的线程的任务。

fork/join框架的核心是ForkJoinPool，扩展于AbstractExecutorService，ForkJoinPool实现了工作窃取算法。


### 基本用法

if(任务足够小)

{

    直接执行任务

}

else

{

    将任务拆分成两个小任务;

    执行两个任务并等待结果;

}


### 两种类型的任务：RecursiveTask & RecursiveAction
* RecursiveTask 有返回结果的任务

* RecursiveAction 没有返回结果的任务


### Fork Join执行流程

1. Create a task that represents all of the work to be done.

    // source image pixels are in src
    // destination image pixels are in dst

    ForkBlur fb = new ForkBlur(src, 0, src.length, dst);

2. Create the ForkJoinPool that will run the task.

    ForkJoinPool pool = new ForkJoinPool();

3. Run the task.

    pool.invoke(fb);




### ForkJoinTask 任务的父类、

#### fork 将任务提交到线程池中

#### join 获取计算结果

#### invoke 开始执行任务并等待获取结果。

#### invokeAll 开始执行多个任务并等待获取结果。








