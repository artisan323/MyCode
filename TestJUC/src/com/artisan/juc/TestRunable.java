package com.artisan.juc;

import java.util.Stack;

@SuppressWarnings({"ALL", "AlibabaClassMustHaveAuthor"})
public class TestRunable {
    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo();
        new Thread(runnableDemo).start();
    }
}
class RunnableDemo implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println(i);
        }
    }
}