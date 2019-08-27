package com.smartisan.test;

import com.smartisan.bean.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestDemo3 {
    public static void main(String[] args) {
        String path = "com.smartisan.bean.Person";

        try {
            Class<Person> clazz = (Class<Person>) Class.forName(path);


            //通过调用构造方法创建对象
            Person p = clazz.newInstance();//调用无参构造器生成对象
            System.out.println(p);

            Constructor<Person> constructor = clazz.getConstructor(int.class, int.class, String.class);
            Person p2 = constructor.newInstance(1, 18, "李志");

            System.out.println(p2);
            System.out.println(p2.getName());

            //调用普通方法
            Person p3 = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("setName", String.class);
            method.invoke(p3, "罗永浩");// 相当于 p3.setName("罗永浩");
            System.out.println(p3.getName());

            //操作属性
            Person p4 = clazz.newInstance();
            Field f = clazz.getDeclaredField("name");
            f.setAccessible(true); //可以操作私有属性
            f.set(p4, "张玮玮"); //通过反射直接写属性
            System.out.println(p4.getName());
            System.out.println(f.get(p4));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
