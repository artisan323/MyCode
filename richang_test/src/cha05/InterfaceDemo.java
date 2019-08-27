package cha05;

public class InterfaceDemo implements MyInterface {

    private String[] msgs = new String[MyInterface.MAX_SIAZE];
    private int num = 0;


    public void delmsg(){
        if(num <= 0) {
            System.out.println("消息队列亿空，删除失败");
        }else{
            msgs[--num] = null;
        }
    }

    public void addmsg(String msg) {
        if (num >= MyInterface.MAX_SIAZE) {
            System.out.println("消息队列已满，添加失败");
        } else {
            msgs[num++] = msg;
        }
    }

    public void showMsg(){
        for (int i = 0; i < num; i++){
            System.out.println(msgs[i]);
        }
    }

    public static void main(String[] args) {
        MyInterface m = new InterfaceDemo();
        m.print("张三", "李四");

        System.out.println(MyInterface.staticTest());

        InterfaceDemo ifd = new InterfaceDemo();
        ifd.addmsg("java 8应用开发");
        ifd.addmsg("欢迎来到青软实训");
        ifd.addmsg("这是一个测试");

        ifd.showMsg();
    }

}
