package cha08;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> books = new LinkedList<>();
        books.offer("Java 8程序设计");
        books.push("java ee企业应用开发");
        books.offerFirst("c++程序设计");
        books.offerLast("c#应用开发");

        System.out.print(books);

        System.out.print("\nfor each遍历：");
        for (String str : books){
            System.out.print(str);
        }

        System.out.print("-------------------------");

        System.out.print("按索引访问");
        for (int i = 0; i < books.size(); i++){
            System.out.print(books.get(i));
        }
        System.out.print("-------------------------");

        books.peek();
    }
}
