package cha08;

import java.util.ArrayList;
import java.util.Iterator;

public class Arr {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();

        list.add("北京");
        list.add("青岛");
        list.add("天津");

        System.out.println("使用for循环");
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        System.out.println("使用for each循环");
        for (String e : list){
            System.out.println(e);
        }

        System.out.println("使用迭代器遍历");
        Iterator<String> iterable = list.iterator();
        while (iterable.hasNext()){
            System.out.println(iterable.next());
        }

        list.remove(1);
        System.out.println("删除后剩下的数据");
        for (String e : list){
            System.out.println(e);
        }

    }
}
