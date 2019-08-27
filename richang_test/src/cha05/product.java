package cha05;

public class product {
    private String type;
    private String manufacture;
    private double price;

    public product(String type, String manufacture, double price) {
        this.type = type;
        this.manufacture = manufacture;
        this.price = price;
    }

    public product(){

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void disPlay() {
        System.out.println("product{" +
                "type='" + type + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", price=" + price +
                '}');
    }
}
