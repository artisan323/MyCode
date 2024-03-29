package com.mybatis.pojo;

public class Airport {
    private int id;
    private String portName;
    private String cityName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", portName='" + portName + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
