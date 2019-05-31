package com.aaron.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class TaskThread extends Thread {
    private CyclicBarrier barrier;
    public TaskThread(CyclicBarrier barrier){
        this.barrier=barrier;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            System.out.println(getName()+"到达栅栏A");
            barrier.await();
            System.out.println(getName()+"冲破栅栏A");
            Thread.sleep(2000);
            System.out.println(getName()+"到达栅栏B");
            barrier.await();
            System.out.println(getName()+"冲破栅栏B");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
