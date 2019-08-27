package com.artisan.lock;

/**
 * @author wannengqingnian
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(new Runnable() {
            @Override
            public void run() {
                phone.call();
            }
        }, "t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                phone.call();
            }
        }, "t2").start();
    }
}

class Phone extends Thread{
    public synchronized void call() {
        System.out.println(Thread.currentThread().getName() + "call");
        send();
    }

    public synchronized void send(){
        System.out.println(Thread.currentThread().getName() + "send");
    }
}
