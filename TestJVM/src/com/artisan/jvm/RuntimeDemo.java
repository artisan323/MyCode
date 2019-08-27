package com.artisan.jvm;

import java.lang.ref.SoftReference;
import java.sql.Time;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author wannengqingnian
 */
public class RuntimeDemo {
    public static void main(String[] args) throws InterruptedException {
        //java虚拟机的试图获得的最大内存
        long maxMemory = Runtime.getRuntime().maxMemory();
        //获取java虚拟机中的内存总量
        long totalMemory = Runtime.getRuntime().totalMemory();

        HashMap<String, Integer> hashMap = new HashMap();

        StringBuilder sb = new StringBuilder();
        String s1 = "java";
        String s2 = "ja";
        String s3 = "va";
        System.out.println(s1 == "java");
        System.out.println(s1 == (s2+s3));
        System.out.println(s1 == "ja"+s3);

    }
}
