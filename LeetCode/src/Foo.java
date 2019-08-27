import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import	java.util.concurrent.locks.Condition;
/**
 * @author wannengqingnian
 */

public class Foo {

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int state = 1;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            if (state != 1){
                condition1.wait();
            }
            state = 2;
            printFirst.run();
            condition2.signal();
        }finally {
            lock.unlock();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            if (state != 2){
                condition2.wait();
            }
            state = 3;
            printSecond.run();
            condition3.signal();
        }finally {
            lock.unlock();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            if (state != 3){
                condition3.wait();
            }
            state = 1;
            printThird.run();
            condition1.signal();
        }finally {
            lock.unlock();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}