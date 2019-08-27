package com.artisan.juc;

import java.util.concurrent.atomic.AtomicReference;

class User{
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


/**
 * @author wannengqingnian
 */
public class TestAtomicReference {
    public static void main(String[] args) {
        User u1 = new User("lihzi", 45);
        User u2 = new User("zhangweiwei", 45);
        AtomicReference<User> atomicReference = new AtomicReference<User> ();
        atomicReference.set(u1);
        atomicReference.compareAndSet(u1, u2);
        System.out.println(atomicReference.get().toString());
    }
}


