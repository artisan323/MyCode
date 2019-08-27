package Internet2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("----------Server----------");
        //1、指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        //2、阻塞式等待连接 accept
        Socket client = server.accept();
        System.out.println("客户端启动");
        //3、操作输入输出流
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String data = dis.readUTF();
        System.out.println(data);
        //4、关闭资源
        dis.close();
        client.close();
    }
}
