package com.artisan.lock;
import	java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wannengqingnian
 */
public class ReentranLockDemo {
    public static void main(String[] args) {
        Person person = new Person();
        Thread thread1 = new Thread(person);
        Thread thread2 = new Thread(person);



        thread1.start();
        thread2.start();
    }
}

class Person implements Runnable{

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        call();
    }

    public void call(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "call");
            send();
        }finally {
            lock.unlock();
        }
    }

    public void send() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "send");
        }finally {
            lock.unlock();
        }
    }

}
