package com.aaron.countdownlatch;

public class Main {


    public static void main(String[] args) {
        boolean result=false;
        try{
            result=ApplicationStartUpUtil.checkExternalService();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("External services validation complete! result was::"+result);
    }
}
