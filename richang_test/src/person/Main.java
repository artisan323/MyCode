package person;

import person.Person;

public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAddress("ewe");
        p.setAge(12);
        p.setName("真棒");

        System.out.println(p.getName());
    }
}
