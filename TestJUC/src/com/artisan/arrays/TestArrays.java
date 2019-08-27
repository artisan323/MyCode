package com.artisan.arrays;

import java.util.*;

/**
 * @author wannengqingnian
 */
public class TestArrays {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i <= 30; i++){
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }).start();
        }
    }
}
