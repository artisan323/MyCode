package Internet2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("----------Client----------");
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入用户名：");
        String uname = console.readLine();
        System.out.print("请输入密码：");
        String upwd = console.readLine();

        //1、建立连接 使用Socket创建客户端+服务地址和端口
        Socket client = new Socket("localhost", 8888);
        //2、操作输入输出流
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("unema=" + uname + "&" + "upwd=" + upwd);
        dos.flush();
        //3、释放资源
        dos.close();
    }
}
