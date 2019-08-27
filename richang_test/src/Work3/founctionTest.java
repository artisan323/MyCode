package Work3;

import java.util.Scanner;

public class founctionTest {
    public static void main(String[] args) {

        User[] u = new User[2];

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < u.length; i++){

            System.out.println("请输入第" + (i + 1) + "个用户");
            User u1 = new User();
            System.out.println("请输入用户名：");
            String name = sc.next();
            u1.setUserName(name);

            System.out.println("请输入密码：");
            try{
                String pw = sc.next();
                if (pw.length() < 4 || pw.length() > 8){
                    throw new chackException("用户密码长度不能少于4,大于8");
                }else{
                    u1.setPassWorld(pw);
                }

            }catch (chackException e){
                e.printStackTrace();
            }

            System.out.println("请输入用户年龄：");
            try{
                int age = sc.nextInt();
                if (age > 100 || age < 0){
                    throw new chackException("用户年龄大于100或小于0");
                }else {
                    u1.setUserAge(age);
                }
            }catch (chackException e){
                e.printStackTrace();
            }

            System.out.println("请输入性别：");
            u1.setUserSex(sc.next());

            System.out.println("请输入邮箱地址：");
            String add = sc.next();
            try{
                if (isEmail(add) == false){
                    throw new chackException("输入邮箱格式不合法");
                }else{
                    u1.setE_mail(add);
                }
            }catch (chackException e){
                e.printStackTrace();
            }

            u[i] = u1;
            System.out.println("\n---------------------------");
        }

        System.out.println(u[0].toString());
        System.out.println(u[1].toString());
    }
    public static boolean isEmail(String str) {
        int a1= str.indexOf(".com");
        int a2= str.lastIndexOf(".com");
        int b1= str.indexOf("@");
        int b2= str.lastIndexOf("@");
        if (a1>0 && a1==a2 && b1==b2)
            return true;
        else
            return false;
    }
}
