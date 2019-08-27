package com.artisan.block;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import	java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wannengqingnian
 */
public class ProdConsumBlockQuequDemo {
    public static void main(String[] args) throws InterruptedException {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<String>(3));

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("生产者线程启动");
                    myResource.myProd();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Prod").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("消费者线程启动");
                    myResource.myConsumer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer").start();

        System.out.println("");
        System.out.println("");
        TimeUnit.SECONDS.sleep(5);
        myResource.stop();
        System.out.println("退出");
    }

}

class MyResource {
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    /**
     * 生产者
     */
    public void myProd() throws Exception {
        String data = null;
        boolean resValue;
        while (FLAG){
            data = atomicInteger.incrementAndGet()+"";
            resValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (resValue){
                System.out.println(Thread.currentThread().getName() + "\t插入队列成功："+data);
            }else {
                System.out.println(Thread.currentThread().getName() + "\t插入队列失败："+data);
            }
            TimeUnit.SECONDS.sleep(1);
        }
        //当FLAG为false时，线程立即感知，停止生产
        System.out.println(Thread.currentThread().getName() +"生产停止");
    }

    public void myConsumer() throws InterruptedException {
        String result = null;
        while (FLAG){
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == result || result.equalsIgnoreCase("")){
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "超过两秒没有取到，消费退出");
                System.out.println("");
                System.out.println("");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "消费者取到数据" + result);
        }
    }

    public void stop(){
        FLAG = false;
    }
}