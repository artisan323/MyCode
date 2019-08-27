package com.artisan.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wannengqingnian
 */
public class TestAotmic {
    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        testThread.start();
    }
}

class TestThread extends Thread {
    @Override
    public void run() {
        System.out.println("线程启动");
    }
}
