package org.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

    private DatagramSocket datagramSocket;
    private InetAddress inetAddress;
    private byte[] buffer;

    public Client(DatagramSocket datagramSocket, InetAddress inetAddress) {
        this.datagramSocket = datagramSocket;
        this.inetAddress = inetAddress;
    }

    public void sendDataAndReceive() {
        Scanner scanner = new Scanner(System.in);
        try {
            String message = scanner.nextLine();
            buffer = message.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, inetAddress, 12345);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(datagramPacket);
            String messageFromServer = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println("The result is: " + messageFromServer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
