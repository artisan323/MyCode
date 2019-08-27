package com.artisan.juc;
import	java.util.concurrent.locks.Condition;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程，三个线程ID分别是ABC，打印20遍，显示结果按顺序显示
 * 如 ABCABC...
 * @author wannengqingnian
 */
public class PrintingInSequence {

    public static void main(String[] args) {
        PrintDemo printDemo = new PrintDemo();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i <= 20; i++){
                    printDemo.loopA(i);
                }
            }
        }, "A").start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i <= 20; i++){
                    printDemo.loopB(i);
                }
            }
        }, "B").start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i <= 20; i++){
                    printDemo.loopC(i);
                }
            }
        }, "C").start();
    }

}

class PrintDemo{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA(int total){
        lock.lock();
        try {

            //1.判断是不是到该自己执行，不到则等待
            if (number != 1){
                condition1.await();
            }

            //2.打印自己编号
            for (int i = 1 ; i <= 1; i++){
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + total);
            }

            //3.自己结束后，唤醒下一个线程
            number = 2;
            condition2.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void loopB(int total){
        lock.lock();
        try {

            //1.判断是不是到该自己执行，不到则等待
            if (number != 2){
                condition2.await();
            }

            //2.打印自己编号
            for (int i = 1 ; i <= 1; i++){
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + total);
            }

            //3.自己结束后，唤醒下一个线程
            number = 3;
            condition3.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public void loopC(int total){
        lock.lock();
        try {

            //1.判断是不是到该自己执行，不到则等待
            if (number != 3){
                condition3.await();
            }

            //2.打印自己编号
            for (int i = 1 ; i <= 1; i++){
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + total);
                System.out.println("==========================");
            }

            //3.自己结束后，唤醒下一个线程
            number = 1;
            condition1.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
