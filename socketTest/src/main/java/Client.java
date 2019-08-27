import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();

        //设置超时时间
        socket.setSoTimeout(30000);
        //连接本机
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(), 2000),30000);

        System.out.println("已发起连接。。。");
        System.out.println("客户端信息： " + socket.getLocalAddress() + " p: " +  socket.getLocalPort());
        System.out.println("服务器信息： " + socket.getInetAddress() + " p: " + socket.getPort());

        todo(socket);

    }

    private static void todo(Socket cilent) throws IOException {
        //构建键盘输入流
        InputStream is = System.in;
        BufferedReader input = new BufferedReader(new InputStreamReader(is));

        //得到socket输出流，并转换为打印流
        OutputStream outputStream = cilent.getOutputStream();
        PrintStream socketPrintStream = new PrintStream(outputStream);

        //得到socket输入流，转换为bufferedReader
        InputStream inputStream = cilent.getInputStream();
        BufferedReader socketBufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        boolean flag = true;
        do {
            //从键盘读取一行
            String str = input.readLine();
            //发送到服务器
            socketPrintStream.println(str);
            //从服务器读取一行
            String echo = socketBufferedReader.readLine();
            if ("bey".equals(str)){
                flag = false;
            }else {
                System.out.println(echo);
            }
        }while (flag);
        System.out.println("客户端退出");
    }

}
