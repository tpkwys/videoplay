package com.aaron.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class NetWorkHealthChecker extends  BaseHealthChecker {
    public NetWorkHealthChecker(CountDownLatch latch){
        super("NetWork service",latch);
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
