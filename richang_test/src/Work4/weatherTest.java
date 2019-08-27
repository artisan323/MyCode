package Work4;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class weatherTest {
    public static void main(String[] args) {

        WeatherArr ww = new WeatherArr();
        ww.setW(new ArrayList<WeatherForecast>());
        ArrayList<WeatherForecast> list = (ArrayList<WeatherForecast>) ww.getW();

        for (int i = 0; i < 2; i++){
            WeatherForecast Wea = input();
            list.add(Wea);
        }

        for (WeatherForecast e : list){
            System.out.println(e);
        }

    }


    public static void wind_sta() {
        System.out.println("============================");
        System.out.println("请选择城市天气状况：");
        System.out.println("晴（1）		多云（2）			阴天（3）");
        System.out.println("小雨（4）		中雨（5）			大雨（6）");
        System.out.println("雨夹雪（7）");
        System.out.println("============================");

    }

    public static WeatherForecast input(){

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入ID标识：");
        int id = sc.nextInt();
        Date nowdate = new Date();
        System.out.println("请输入城市：");
        String city = sc.next();
        System.out.println("请输入风速风向（例如：北风三级）：");
        String status = sc.next();
        System.out.println("请输入最低气温：");
        int lowT = sc.nextInt();
        System.out.println("请输入最高气温：");
        int highT = sc.nextInt();
        wind_sta();
        String[] w = new String[8];
        w[1] = "晴";
        w[2] = "多云";
        w[3] = "阴天";
        w[4] = "小雨";
        w[5] = "中雨";
        w[6] = "大雨";
        w[7] = "雨夹雪";
        int i = sc.nextInt();
        String weather;
        weather = w[i];
        WeatherForecast Wea = new WeatherForecast(id, nowdate, city, status, lowT, highT, weather);

        return Wea;
    }
}
