package 线程;

public class deadLock {
    public static void main(String[] args) {
        MakeUp m1 = new MakeUp();
        m1.girl = "张柏芝";
        m1.flag = 0;
        MakeUp m2 = new MakeUp();
        m2.girl = "阿娇";
        m2.flag = 1;
        m1.start();
        m2.start();
    }
}
class MakeUp extends Thread{
    int flag;
    String girl;

    static Lipstick l = new Lipstick();
    static Mirror m = new Mirror();

    public void run(){
        doMakeip();
    }

    void doMakeip(){
        if (flag == 0){
            synchronized (l){
                System.out.println( girl+ "拿着口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            synchronized (m){
                System.out.println(girl + "拿着镜子");
            }
        }else{
            synchronized (m){
                System.out.println(girl + "拿着镜子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            synchronized (l){
                System.out.println(girl + "拿着口红");
            }
        }
    }

}

class Lipstick{
    //口红
}
class Mirror{
    //镜子
}
