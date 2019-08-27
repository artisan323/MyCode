package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPserver {
    public static void main(String[] args)throws Exception{
        System.out.println("接受端启动中...");
        //1.使用DatagramSocket 指定端口
        DatagramSocket server = new DatagramSocket(6668);
        //2.准备数据，一定转成字节数组
        byte[] container = new byte[1024 * 60];
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);
        //3。阻塞式接受包裹receive
        server.receive(packet);
        //4.分析数据
        byte[] datas = packet.getData();
        int len = datas.length;
        System.out.println(new String(datas,0,len));
        //5.释放资源
        server.close();
    }
}
