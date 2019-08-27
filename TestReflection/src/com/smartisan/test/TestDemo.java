package com.smartisan.test;

public class TestDemo {
    public static void main(String[] args) {

        try {

            String path = "com.smartisan.bean.Person";

            Class clazz1 = Class.forName(path);
            System.out.println(clazz1.hashCode());
            //只能生成一个对象
            Class clazz2 = Class.forName(path);
            System.out.println(clazz2.hashCode());

            Class strClazz1 = String.class;
            Class strClazz2 = path.getClass();
            System.out.println(strClazz1.equals(strClazz2));

            Class intClazz = int.class;

            //只要数据类型相同则返回同一个

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
