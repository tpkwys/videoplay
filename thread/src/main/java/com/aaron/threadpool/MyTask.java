package com.aaron.threadpool;

public class MyTask implements  Runnable {
    private int taskNum;

    public MyTask(int num){
        taskNum=num;
    }
    public void run() {
        System.out.println("正在执行task:"+taskNum);
        try{
            Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("task:"+taskNum+"执行完毕");

    }
}
