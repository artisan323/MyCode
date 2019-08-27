package com.artisan.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA问题解决
 * @author wannengqingnian
 */
public class TestAtomicStampedReference {

    /**
     * 创建带时间戳的原子引用
     */
    static AtomicStampedReference<Integer> atomicStampedReference
            = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {

        //启动一个T1线程模拟ABA问题出现
        new Thread(() -> {
            //获取时间戳
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t第一次时间戳" + stamp);

            //暂停1秒钟T1线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //模拟ABA
            atomicStampedReference.compareAndSet(100, 101,
                    atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t第一次修改版本号 : "+atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101, 100,
                    atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t第二次修改版本号 : "+atomicStampedReference.getStamp());

        }, "T1").start();

        //启动T2线程验证是否解决ABA问题
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t线程获得的版本号 ："+stamp);

            //暂停3秒，确保T1完成ABA问题
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //开始修改
            Boolean flag = atomicStampedReference.compareAndSet(100, 2019, stamp, stamp + 1);

            System.out.println(Thread.currentThread().getName() + "\t修改是否成功"+flag + "\t此时的版本号" + atomicStampedReference.getStamp());

        }, "T2").start();
    }

}
