package cha05;

public class Printer extends product{
    private String color;
    private String paperSize;

    public Printer(String type, String manufacture, double price, String color, String paperSize) {
        super(type, manufacture, price);
        this.color = color;
        this.paperSize = paperSize;
    }

    public Printer(String color, String paperSize) {
        this.color = color;
        this.paperSize = paperSize;
    }

    public Printer(){

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPaperSize() {
        return paperSize;
    }

    public void setPaperSize(String paperSize) {
        this.paperSize = paperSize;
    }


    public void disPlay() {

        super.disPlay();

        System.out.println("Printer{" +
                "color='" + color + '\'' +
                ", paperSize='" + paperSize + '\'' +
                '}');
    }
}
