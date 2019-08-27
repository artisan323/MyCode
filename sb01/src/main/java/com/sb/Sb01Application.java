package com.sb;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sb01Application {

    public static void main(String[] args) {
        SpringApplication.run(Sb01Application.class, args);
    }


    @Test
    public void test(){
        System.out.println("123");
    }
}
