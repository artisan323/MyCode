package Work2;

import java.util.Date;
import java.util.Scanner;

public class ParticulateMatterService {
    public ParticulateMatter inputParticulateMatter(){

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入ID标识：");
        int id = sc.nextInt();
        Date nowdate = new Date();

        System.out.println("请输入城市：");
        String city = sc.next();

        System.out.println("请输入该城市的细颗粒物（pm2.5）信息：");
        int pm2_5 = sc.nextInt();

        System.out.println("请输入该城市可吸入颗粒物（pm10）信息：");
        int pm10 = sc.nextInt();

        System.out.println("请输入该城市的臭氧(O3)信息：");
        int o3 = sc.nextInt();

        System.out.println("请输入该城市的二氧化硫（So2）信息：");
        int So2 = sc.nextInt();

        System.out.println("请输入该城市二氧化氮（No2）信息：");
        int no2 = sc.nextInt();

        System.out.println("请输入该城市一氧化碳（co）信息：");
        int co = sc.nextInt();

        System.out.println("==============================");
        System.out.println("请选择城市污染状况：");
        System.out.println("优（1）		良（2）			轻度污染（3）");
        System.out.println("中度污染（4）	    重度污染（5）			严重污染（6）");
        System.out.println("============================");
        String[] l = new String[7];
        l[1] = "优";
        l[2] = "良";
        l[3] = "轻度污染";
        l[4] = "重度污染";
        l[5] = "重度污染";
        l[6] = "严重污染";
        int i = sc.nextInt();
        String level;
        level = l[i];

        ParticulateMatter p = new ParticulateMatter(id, nowdate, city, pm2_5, pm10, o3, So2, no2, co, level);
        return  p;
    }
    public void showParticulateMatter(ParticulateMatter...pm){
        for (ParticulateMatter e : pm){
            if (e != null){
                System.out.println(e.toString());
            }
        }
    }

    public static void main(String[] args) {
        ParticulateMatterService par = new ParticulateMatterService();
        ParticulateMatter[] pm = new ParticulateMatter[3];
        for (int i = 0; i < pm.length; i++){
            System.out.println("第" + (i + 1) + "个城市的PM信息采集");
            pm[i] = par.inputParticulateMatter();
        }
        par.showParticulateMatter(pm);
    }
}
