package cha07;

import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[3];
        try{
            System.out.println("请输入第一个数");
            String str = sc.next();
            int i = Integer.parseInt(str);
            System.out.println("请输入第二个数");
            int i2 = sc.nextInt();
            arr[1] = i / i2;
            arr[3] = i * i2;
            System.out.println("两数的和为" + (i + i2));

        }catch (NumberFormatException ex){
            System.out.println("数字格式化异常");
        }catch (ArithmeticException ex){
            System.out.println("算数异常");
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("数组越界异常");
        }catch (Exception ex){
            System.out.println("其他未知异常");
        }
        System.out.println("程序结束");
    }
}
