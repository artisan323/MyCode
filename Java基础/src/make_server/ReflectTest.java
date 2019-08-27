package make_server;

import java.lang.reflect.InvocationTargetException;

//反射
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Iphone iphone = new Iphone();
        //1、对象.getClass()
        Class clz = iphone.getClass();
        //2、类.class()
        clz = Iphone.class;
        //3、Class.forName()
        clz = Class.forName("make_server.Iphone");


        //创建对象
        Iphone iphone_se = (Iphone) clz.getConstructor().newInstance();
        System.out.println(iphone_se);
    }
}

class Iphone{
    public Iphone(){

    }
}
