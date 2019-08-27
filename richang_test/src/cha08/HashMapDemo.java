package cha08;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();

        hm.put(1, "zhangsan");

        System.out.print(hm.get(1));
    }

}
