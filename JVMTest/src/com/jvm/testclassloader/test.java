package com.jvm.testclassloader;

public class test {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());


        Class<?> clazz2 = Class.forName("com.jvm.testclassloader.c");
        System.out.println(clazz2.getClassLoader());
    }
}

class c {

}
