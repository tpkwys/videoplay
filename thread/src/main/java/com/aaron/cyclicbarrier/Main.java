package com.aaron.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        int num=5;
        CyclicBarrier barrier=new CyclicBarrier(num, new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName()+"完成最后的任务");
            }
        });
        for(int i=0;i<num;i++){
            new TaskThread(barrier).start();
        }
    }
}
