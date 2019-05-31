package com.aaron.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 负责所有的特定的外部服务健康的检测
 */
public  abstract  class BaseHealthChecker implements Runnable{
    private CountDownLatch _latch;
    private String _serviceName;
    private boolean _serviceUp;
    public BaseHealthChecker(String serviceName,CountDownLatch latch){
        super();
        this._latch=latch;
        this._serviceName=serviceName;
        this._serviceUp=false;
    }
    public void run() {
        try{
            vertifyService();
            _serviceUp=true;
        }catch (Throwable t){
            t.printStackTrace(System.err);
            _serviceUp=false;
        }finally {
            if(_latch!=null)
                //通知CountDownLatch 的count-1
                _latch.countDown();
        }
    }

    public String get_serviceName() {
        return _serviceName;
    }

    public boolean is_serviceUp() {
        return _serviceUp;
    }
    public abstract void vertifyService();
}
