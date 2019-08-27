package cha08;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionDemo {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();

        list.add(new Person("张三", 12, "北京"));
        list.add(new Person("李四", 14, "青岛"));

        for (Person e : list){
            System.out.print(e + "\n");
        }

        System.out.print("\n--------------------------------\n");

        Collections.sort(list);
        System.out.print("排序后\n");
        for (Person e : list){
            System.out.print(e + "\n");
        }

        System.out.print("\n---------------------------------\n");

        System.out.print("年龄最小:" + Collections.min(list) + "\n");
        System.out.print("年龄最大:" + Collections.max(list));
    }
}
