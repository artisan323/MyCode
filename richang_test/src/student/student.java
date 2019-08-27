package student;

public class student {

    private String name;
    private String clas;
    private int age;

    public student() {

    }

    public student(String name, String clas, int age) {
        this.name = name;
        this.clas = clas;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", clas='" + clas + '\'' +
                ", age=" + age +
                '}';
    }
}
