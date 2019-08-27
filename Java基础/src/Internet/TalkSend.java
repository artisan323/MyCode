package Internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable {

    private DatagramSocket client;
    private BufferedReader reader;
    private String toIp;
    private int toPort;

    public TalkSend( int port, String ip, int toPort) {
        this.toIp = ip;
        this.toPort = toPort;
        try {
            this.client = new DatagramSocket(port);
            this.reader = new BufferedReader(new InputStreamReader(System.in));

        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true){
            String data;
            try {
                data = reader.readLine();
                byte[] datas = data.getBytes();
                //封装成包裹
                DatagramPacket packet = new DatagramPacket(datas, 0,datas.length,
                        new InetSocketAddress(this.toIp, this.toPort));
                //发送
                client.send(packet);
                if (data.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        client.close();
    }
}
