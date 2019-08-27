package cha04;

public class Book {
    String name;
    int price;

    public Book(){

    }

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean equals(Book n){
        if (this.name == n.name){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name = '" + name +
                ", price = " + price +
                '}';
    }
}
