package com.artisan.juc;
import java.util.ArrayList;
import	java.util.List;
import java.util.concurrent.*;

/**
 * @author wannengqingnian
 */
public class TestThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestRunnableDemo demo = new TestRunnableDemo();
        TestCallableDemo cdemo = new TestCallableDemo();

        List < Future < Integer > > futures = new ArrayList<>();

        //1.创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);

//        //2.为线程池中的线程分配任务 Runnable方式
//        for (int i = 0; i < 10; i++){
//            pool.submit(demo);
//        }

        //2.为线程池中的线程分配任务 Callable方式
        for (int i = 0 ; i < 10; i++){
            Future<Integer> future = pool.submit(cdemo);
            futures.add(future);
        }


        for (Future future : futures){
            System.out.println(future.get());
        }


        //3.关闭线程
        pool.shutdown();
    }
}

class TestRunnableDemo implements Runnable{

    private int i = 0;

    @Override
    public void run() {
        while (i <= 100){
            System.out.println(Thread.currentThread().getName() + " : " + i++);
        }
    }
}

class TestCallableDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++){
            sum += i;
        }
        return sum;
    }
}
