
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(2000);

        System.out.println("服务器准备就绪...");
        System.out.println("服务器信息: " + server.getInetAddress() + " p: " + server.getLocalPort());

        //等待客户端连接
        while (true){
            //得到客户端
            Socket client = server.accept();
            //客户端构建异步线程
            ClientHandler clientHandler = new ClientHandler(client);
            //启动线程
            clientHandler.start();

        }
    }
    private static class ClientHandler extends Thread{
        private Socket socket;
        private boolean flag = true;

        public ClientHandler(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            super.run();
            System.out.println("新客户端连接： " + socket.getInetAddress() + " p: " + socket.getPort());

            try {
                //得到打印流，用于数据输出
                PrintStream socketOutput = new PrintStream(socket.getOutputStream());
                //得到输入流，用于接收数据
                BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                do {
                    //从客户端拿到数据
                    String str = socketInput.readLine();
                    if ("bey".equals(str)){
                        flag = false;
                        socketOutput.println("bye");
                    }else {
                        //打印到屏幕
                        System.out.println(str);
                        socketOutput.println("您发送数据长度："  + str.length());
                    }
                }while (flag);

                socketInput.close();

            } catch (IOException e) {
                System.out.println("异常断连");
            }finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("客户端" + socket.getPort() + "退出");
        }
    }
}
