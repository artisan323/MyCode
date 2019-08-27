package 线程;

public class stopThread implements Runnable{
    private boolean flag = true;
    private String name;

    public stopThread(String name) {
        this.name = name;
    }

    public void run() {
        int i = 0;
        while (flag){
            System.out.print(name + "-->" + i++);
        }
    }

    public void terminate(){
        this.flag = false;
    }

    public static void main(String[] args) {
        stopThread st = new stopThread("梅西");
        new Thread(st).start();
        for (int i = 0;i < 99; i++){
            if (i == 88){
                st.terminate();
                System.out.print("线程结束！");
            }
            System.out.println("main-->" + i);
        }
    }
}
