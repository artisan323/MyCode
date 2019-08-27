package cha04;

import java.util.Scanner;

public class sumDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int sum = 0;
        System.out.println("请连续输入十个数字");
        for (int i = 0; i < 10; i++){
            sum += sc.nextInt();
        }
        System.out.println("连续十个数字的和为" + sum);
        
    }
}
