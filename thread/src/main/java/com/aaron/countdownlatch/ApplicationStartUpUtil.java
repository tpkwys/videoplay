package com.aaron.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ApplicationStartUpUtil {
    //健康检测服务列表
    private static List<BaseHealthChecker> _services;

    private static CountDownLatch _latch;

    private ApplicationStartUpUtil(){}

    private static ApplicationStartUpUtil INSTANCE=new ApplicationStartUpUtil();

    public static ApplicationStartUpUtil getINSTANCE(){
        return  INSTANCE;
    }
    public static boolean checkExternalService() throws  Exception{
        _latch=new CountDownLatch(3);
        _services=new ArrayList<BaseHealthChecker>(3);
        _services.add(new NetWorkHealthChecker(_latch));
        _services.add(new CacheHealthChecker(_latch));
        _services.add(new DatabaseHealthChecker(_latch));
        Executor executor=Executors.newFixedThreadPool(_services.size());
        for(final BaseHealthChecker v:_services){
            executor.execute(v);
        }
        _latch.await();
        for(final BaseHealthChecker v:_services){
            if(!v.is_serviceUp()){
                return false;
            }
        }
        return  true;
    }


}
