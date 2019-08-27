package cha04;

public class Book_test {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book("Java程序设计", 99);

        /*book1.setName("Java程序设计");
        book1.setPrice(69);

        System.out.println("输出book1 == book2");
        System.out.println(book1 == book2);
        System.out.println(book1.equals(book2));

        System.out.println(book1);*/


        Book book3 = book1;
        book1.setName("真棒");
        System.out.println(book3.toString());
    }
}
