package cha08;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String address;

    public Person(){

    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public int compareTo(Person p){
        if(this.age < p.age){
            return -1;
        }else if (this.age == p.age){
            return 0;
        }else {
            return 1;
        }
    }
}
