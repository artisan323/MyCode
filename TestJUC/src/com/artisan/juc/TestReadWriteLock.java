package com.artisan.juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 *
 * 创建一个写线程
 * 20个读线程
 * @author wannengqingnian
 */
public class TestReadWriteLock {
    public static void main(String[] args) {
        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();



        new Thread(new Runnable() {

            @Override
            public void run() {
                readWriteLockDemo.set((int) (Math.random() * 101));
            }
        }, "写线程").start();

        for (int i = 1; i <= 20; i++){
            new Thread(new Runnable() {

                @Override
                public void run() {
                    readWriteLockDemo.get();
                }
            }, "读线程 " + i).start();
        }

    }
}

class ReadWriteLockDemo {

    private int number = 0;

    /**
     * 创建读写锁
     */
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void get(){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " : " + number);
        }finally {
            lock.readLock().unlock();
        }
    }


    public void set(int number){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName());
            this.number = number;
        }finally {
            lock.writeLock().unlock();
        }
    }
}
