package cha05;

public interface MyInterface {
    int MAX_SIAZE = 50;

    void delmsg();
    void addmsg(String msg);

    default void print(String...msg){
        for (String e : msg) {
            System.out.println(e);
        }
    }

    static String staticTest(){
        return "接口里的类方法";
    }
}
