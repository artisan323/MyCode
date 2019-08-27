package com.jvm.test01;

public class MyTest01 {
    public static void main(String[] args) {

        System.out.println(child.str2);
    }
}


class parent{

    public static String str = "parent";

    static {
        System.out.println("parent static block");
    }
}

class child extends parent{
    public static String str2 = "child";
    static {
        System.out.println("child static clock");
    }
}