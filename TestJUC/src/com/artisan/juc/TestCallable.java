package com.artisan.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadDemo threadDemo = new ThreadDemo();

        //执行callable方式，需要FuturnTask实现类的支持，用于接收运算结果
        FutureTask<Integer> futureTask = new FutureTask<>(threadDemo);

        //启动线程
        new Thread(futureTask).start();

        //接收运算结果
        Integer sum = futureTask.get();
        System.out.println(sum);
    }

}

class ThreadDemo implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++){
            sum += i;
        }
        return sum;
    }
}

/*
class ThreadTest implements Runnable{
    @Override
    public void run() {

    }
}
*/
