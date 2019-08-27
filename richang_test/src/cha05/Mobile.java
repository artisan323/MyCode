package cha05;

public class Mobile extends product{

    private String screenSize;
    private String cpu;

    public Mobile(){

    }

    public Mobile(String type, String manufacture, double price, String screenSize, String cpu) {
        super(type, manufacture, price);
        this.screenSize = screenSize;
        this.cpu = cpu;
    }


    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    @Override
    public void disPlay() {
        super.disPlay();

        System.out.println("Mobile{" +
                "screenSize='" + screenSize + '\'' +
                ", cpu='" + cpu + '\'' +
                '}');
    }


}
