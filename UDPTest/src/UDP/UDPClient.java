package UDP;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClient {
        public static void main(String[] args) throws Exception{
            System.out.println("发送端启动中。。。");
            //1.使用DatagramSocket 指定端口
            DatagramSocket client = new DatagramSocket(8887);
            //2.准备数据，一定转成字节数组
            String data = "月色真美";
            byte[] datas = data.getBytes();
            //3。封装成Datagrampacket包裹，需要指定目的地
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                    new InetSocketAddress("localhost", 6668));
            //4.发送包裹
            client.send(packet);
            //5.释放资源
            client.close();
        }
}
