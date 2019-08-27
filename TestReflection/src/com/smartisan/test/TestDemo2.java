package com.smartisan.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestDemo2 {
    public static void main(String[] args) {

        String path = "com.smartisan.bean.Person";

        try {
            Class clazz = Class.forName(path);

            //获取类的名字
            System.out.println(clazz.getName());
            System.out.println(clazz.getSimpleName());

            //获取属性

                //Field[] fields = clazz.getFields();//只能获取公有属性
                Field[] fields = clazz.getDeclaredFields();//获取所有属性

                Field f = clazz.getDeclaredField("name");

                System.out.println(fields.length);

                for (Field temp : fields) {
                    System.out.println("属性 : " + temp);
                }
            //获取方法
            Method[] methods = clazz.getDeclaredMethods();
            Method m = clazz.getMethod("getName");
            Method m2 = clazz.getMethod("setName", String.class);
            System.out.println(m2);
            for (Method m3 : methods){
                System.out.println("方法 ：" + m3);
            }

            //获取构造方法
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor con : constructors){
                System.out.println("构造方法 ： " + con);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
