package Work4;

import java.util.ArrayList;

public class WeatherArr {
    private ArrayList<? extends WeatherForecast> w;

    public ArrayList<? extends WeatherForecast> getW() {
        return w;
    }

    public void setW(ArrayList<? extends WeatherForecast> w) {
        this.w = w;
    }
}
