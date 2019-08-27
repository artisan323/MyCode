package com.smartisan.test;

import com.smartisan.bean.Person;

/**
 * @author wannengqingnian
 */
public class TestRefilection {
    public static void main(String[] args) throws Exception{

        //传统方式创建对象
        Person person = new Person();

        //反射创建对象第一种--->主要用于创建类对象
        Class clazz = Class.forName("com.smartisan.bean.Person");
        Object obj = clazz.newInstance();

        //第二种--->调用底层使用反射封装的方法
        Class clazz1 = Person.class;

        //第三种--->调用底层使用反射封装的方法
        Class clazz2 = person.getClass();

    }
}
