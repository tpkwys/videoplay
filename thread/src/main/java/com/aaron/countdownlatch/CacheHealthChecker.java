package com.aaron.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CacheHealthChecker extends  BaseHealthChecker {
    public CacheHealthChecker(CountDownLatch latch){
        super("Cache service",latch);
    }
    @Override
    public void vertifyService() {
        System.out.println(this.get_serviceName()+"checking....");
        try {
            Thread.sleep(7000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(this.get_serviceName()+"is UP");
    }
}
