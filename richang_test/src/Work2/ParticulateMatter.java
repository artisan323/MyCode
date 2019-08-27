package Work2;

import java.util.Date;

public class ParticulateMatter {

    private int id;
    private Date time;
    private String city;
    private int pm2_5;
    private int pm10;
    private int o3;
    private int So2;
    private int no2;
    private int co;
    private String level;

    public ParticulateMatter(){

    }

    public ParticulateMatter(int id, Date time, String city, int pm2_5, int pm10, int o3, int so2, int no2, int co, String level) {
        this.id = id;
        this.time = time;
        this.city = city;
        this.pm2_5 = pm2_5;
        this.pm10 = pm10;
        this.o3 = o3;
        So2 = so2;
        this.no2 = no2;
        this.co = co;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(int pm2_5) {
        this.pm2_5 = pm2_5;
    }

    public int getPm10() {
        return pm10;
    }

    public void setPm10(int pm10) {
        this.pm10 = pm10;
    }

    public int getO3() {
        return o3;
    }

    public void setO3(int o3) {
        this.o3 = o3;
    }

    public int getSo2() {
        return So2;
    }

    public void setSo2(int so2) {
        So2 = so2;
    }

    public int getNo2() {
        return no2;
    }

    public void setNo2(int no2) {
        this.no2 = no2;
    }

    public int getCo() {
        return co;
    }

    public void setCo(int co) {
        this.co = co;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "ParticulateMatter{" +
                "id=" + id +
                ", time=" + time +
                ", city='" + city + '\'' +
                ", pm2_5=" + pm2_5 +
                ", pm10=" + pm10 +
                ", o3=" + o3 +
                ", So2=" + So2 +
                ", no2=" + no2 +
                ", co=" + co +
                ", level='" + level + '\'' +
                '}';
    }
}
