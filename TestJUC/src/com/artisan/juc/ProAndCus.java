package com.artisan.juc;
import	java.util.concurrent.locks.Condition;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wannengqingnian
 */
public class ProAndCus {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);

        new Thread(productor, "生产者A1").start();
        new Thread(consumer, "消费者B1").start();
        new Thread(productor, "生产者A2").start();
        new Thread(consumer, "消费者B2").start();
    }

}

/**
 * 店员
 */
class Clerk{

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int product = 0;

    public void get() {
        lock.lock();
        try {
            while (product >= 1){
                System.out.println("产品已满！");

                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //进货
            System.out.println(Thread.currentThread().getName() + " : " + ++product);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void sales(){
        lock.lock();
        try {
            while (product <= 0){
                System.out.println("产品缺货!");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //卖货
            System.out.println(Thread.currentThread().getName() + " : " + --product);
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }
}


/**
 * 生产者
 */
class Productor implements Runnable{

    private Clerk clerk;

    public Productor(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++){
            clerk.get();
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++){
            clerk.sales();
        }
    }
}