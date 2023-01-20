package org.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {

    private DatagramSocket datagramSocket;
    private byte[] buffer = new byte[256];

    public Server(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    public String receiveData() {
        String messageFromUser = null;
        try {
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(datagramPacket);
            InetAddress inetAddress = datagramPacket.getAddress();
            int datagramPort = datagramPacket.getPort();
            messageFromUser = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return messageFromUser;
    }
}
