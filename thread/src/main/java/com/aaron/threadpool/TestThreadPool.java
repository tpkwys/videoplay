package com.aaron.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//任务拒绝策略：AbortPolicy丢弃任务并抛出 RejectedExecutionException
//              DiscardPolicy 也是丢去任务，但是不抛出异常
//              DiscardOldestPolicy 丢弃队列最前面的任务，然后重新尝试执行任务
//              CallerRunsPolicy 由调用线程处理
//阻塞队列：ArrayBlockQueue 基于数组的队列，创建时必须指定大小
//          SynchronousQueue 不会保存任务，而是直接创建新的线程
//          LinkedBlockingQueue 基于链表 创建时没指定大小 默认Integer.MAX_VAlUE
public class TestThreadPool {
    public static void main(String[] args) {
       // ThreadPoolExecutor executor=new ThreadPoolExecutor(5,10,200,TimeUnit.MICROSECONDS,new ArrayBlockingQueue<Runnable>(5));
       ThreadPoolExecutor executor=(ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        for(int i=0;i<20;i++){
            MyTask myTask=new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize());
            System.out.println("队列中等待的线程数目："+executor.getQueue().size());
            System.out.println("已执行完成的任务数目："+executor.getCompletedTaskCount());
        }

    }
}
