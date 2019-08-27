package student;

public class Instance {
    public static  int count = 0;

    public Instance() {
        count++;
        System.out.println(count);
    }

    public void print(){
        System.out.println("创建了" + count +"对象");
    }
}
