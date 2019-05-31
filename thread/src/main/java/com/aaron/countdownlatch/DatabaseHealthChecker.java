package com.aaron.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class DatabaseHealthChecker extends  BaseHealthChecker {
    public DatabaseHealthChecker(CountDownLatch latch){
        super("Database service",latch);
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
