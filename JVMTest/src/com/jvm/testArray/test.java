package com.jvm.testArray;

public class test {
    public static void main(String[] args) {
        Person[] people = new Person[2];
        System.out.println(people);
    }
}

class Person{
    static {
        System.out.println("啦啦啦");
    }
}
