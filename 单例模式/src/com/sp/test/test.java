package com.sp.test;

public class test {

    public static void main(String[] args) {
        SingleTon singleTon1 = SingleTon.SingleTonGetInstance();
        SingleTon singleTon2 = SingleTon.SingleTonGetInstance();
        System.out.println(singleTon1 == singleTon2);
    }




}
