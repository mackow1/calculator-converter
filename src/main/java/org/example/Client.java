package org.example;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        try {
            InetAddress address = InetAddress.getLocalHost();
            DatagramSocket socket = new DatagramSocket();

            while (true) {
                sendRequestToTheServer(socket,address);
                receiveResponseFromServer(socket);
                enterDataToSendToTheServer(socket, address);
                receiveResponseFromServer(socket);
            }
        } catch (SocketTimeoutException ex) {
            System.out.println("Timeout error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void sendRequestToTheServer(DatagramSocket socket, InetAddress address) throws IOException {
        DatagramPacket request = new DatagramPacket(new byte[1], 1, address, 12345);
        socket.send(request);
    }

    private static void receiveResponseFromServer(DatagramSocket socket) throws IOException {
        byte[] buffer = new byte[256];
        DatagramPacket response = new DatagramPacket(buffer, buffer.length);
        socket.receive(response);

        String message = new String(buffer, 0, response.getLength());

        System.out.println(message);
    }

    private static void enterDataToSendToTheServer(DatagramSocket socket, InetAddress address) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            byte[] buffer =scanner.nextLine().
                    getBytes();
            DatagramPacket messageEquation = new DatagramPacket(buffer, buffer.length, address, 12345);
            socket.send(messageEquation);
        }
    }
}