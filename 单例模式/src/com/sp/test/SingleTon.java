package com.sp.test;

public class SingleTon {

    private static SingleTon singleTon;

    private SingleTon(){}

    public static SingleTon SingleTonGetInstance(){
        if (singleTon == null){
            synchronized(SingleTon.class){
                if (singleTon == null){

                    singleTon = new SingleTon();
                }

            }
        }
        return singleTon;
    }
}
