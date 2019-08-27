package com.artisan.lock;
import	java.util.HashMap;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wannengqingnian
 */
public class ReentranReadWriteLockDemo {
    public static void main(String[] args) throws InterruptedException {
        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++){
            final int temp = i;
            new Thread(() -> {
                myCache.put(temp + "", temp + "");
            }, String.valueOf(i)).start();
        }

        TimeUnit.SECONDS.sleep(1);

        for (int i = 0; i < 5; i++){
            final int temp = i;
            new Thread(() -> {
                myCache.get(temp + "");
            }, String.valueOf(i)).start();
        }
    }
}

class MyCache{

    private volatile Map<String, Object> map = new HashMap<String, Object> ();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在写" + key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写完成");
        }finally {
            rwLock.writeLock().unlock();
        }

    }

    public void get(String key){
        rwLock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "正在读" + key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "读完成" + map.get(key));
        }finally {
            rwLock.readLock().unlock();
        }

    }
}
