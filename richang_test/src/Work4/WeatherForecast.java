package Work4;

import java.util.Date;

public class WeatherForecast {

    private int id;
    private Date time;
    private String city;
    private int status;
    private String wind;
    private int lowTemperature;
    private int highTemperature;
    private String weather;

    public WeatherForecast(int id, Date time, String city, String wind, int lowTemperature, int highTemperature, String weather) {
        this.id = id;
        this.time = time;
        this.city = city;
        this.status = status;
        this.wind = wind;
        this.lowTemperature = lowTemperature;
        this.highTemperature = highTemperature;
        this.weather = weather;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public int getLowTemperature() {
        return lowTemperature;
    }

    public void setLowTemperature(int lowTemperature) {
        this.lowTemperature = lowTemperature;
    }

    public int getHighTemperature() {
        return highTemperature;
    }

    public void setHighTemperature(int highTemperature) {
        this.highTemperature = highTemperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "WeatherForecast{" +
                "id=" + id +
                ", time=" + time +
                ", city='" + city + '\'' +
                ", status=" + status +
                ", wind='" + wind + '\'' +
                ", lowTemperature=" + lowTemperature +
                ", highTemperature=" + highTemperature +
                ", weather='" + weather + '\'' +
                '}';
    }
}
