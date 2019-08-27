package com.sp.pojo;

public class Person {
    private String name;
    private int pass;


    public Person(String name, int pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", pass=" + pass +
                '}';
    }
}
