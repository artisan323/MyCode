package com.artisan.pool;
import java.sql.Time;
import java.util.concurrent.*;

/**
 * 自定义线程池
 * @author wannengqingnian
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());


        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        try {
            for (int i = 0; i < 9; i++){
                threadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + "\t办理业务");
                    }
                });
            }
        }finally {
            threadPool.shutdown();
        }
    }
}
