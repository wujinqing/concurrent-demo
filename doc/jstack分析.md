## jstack 分析

### 基本介绍

> jstack用于生成java虚拟机当前时刻的线程快照。

> 线程快照是当前java虚拟机内每一条线程正在执行的方法堆栈的集合，

> 生成线程快照的主要目的是定位线程出现长时间停顿的原因，

> 如线程间死锁、死循环、请求外部资源导致的长时间等待等。

>  线程出现停顿的时候通过jstack来查看各个线程的调用堆栈，

> 就可以知道没有响应的线程到底在后台做什么事情，或者等待什么资源。


### 命令格式
> jstack \[ option ] pid

> 基本参数：

> -F 当’jstack [-l] pid’没有相应的时候强制打印栈信息

> -l 长列表. 打印关于锁的附加信息,例如属于java.util.concurrent的ownable synchronizers列表.

> -m 打印java和native c/c++框架的所有栈信息. -h | -help打印帮助信息

> pid 需要被打印配置信息的java进程id,可以用jps工具查询


示例1：
> jstack 6678 // 将线程堆栈信息打印到控制台

示例2：
> jstack 10698 > /app/tomcat/tmp/dump01.txt // 将线程堆栈信息存储到文件



通过top -Hp 23344可以查看该进程下各个线程的cpu使用情况；



















































