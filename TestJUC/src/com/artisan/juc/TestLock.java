package com.artisan.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wannengqingnian
 */
public class TestLock {
    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();

        new Thread(lockDemo, "1号").start();
        new Thread(lockDemo, "2号").start();
        new Thread(lockDemo, "3号").start();
    }
}

class LockDemo implements Runnable{
    private  int ticket = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            //上锁
            lock.lock();
            try {
                if (ticket > 0){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "完成售票，余票为" + --ticket);
                }
            }finally {
                //释放锁
                lock.unlock();
            }

        }
    }
}