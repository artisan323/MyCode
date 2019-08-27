package com.artisan.test;

/**
 * @author wannengqingnian
 */
public class LambdaDemo {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("一般方式");
            }
        };
        r1.run();

        System.out.println("---------------------------");

        Runnable r2 = () ->
                System.out.println("lambda方式");
        r2.run();

    }
}
