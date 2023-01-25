package org.example;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private DatagramSocket socket;
    private InetAddress clientAddress;
    private int clientPort;

    public Server(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public String listenAndCommunicate() throws IOException {
        while (true) {
            DatagramPacket request = new DatagramPacket(new byte[1], 1);
            socket.receive(request);

            String welcomeMessage = "Welcome to the calculator converter. Please enter the equation you would like to solve.";
            byte[] buffer = welcomeMessage.getBytes();

            this.clientAddress = request.getAddress();
            this.clientPort = request.getPort();

            DatagramPacket response = new DatagramPacket(buffer, buffer.length, this.clientAddress, this.clientPort);
            socket.send(response);

            buffer = new byte[256];
            request = new DatagramPacket(buffer, buffer.length);
            socket.receive(request);

            String equation = new String(buffer, 0, request.getLength());
            System.out.println(equation);

            return equation;
        }
    }

    public void sendResult(String result) throws IOException {
        result = "The result of the equation is " + result;
        byte[] buffer = result.getBytes();
        DatagramPacket resultMessage = new DatagramPacket(buffer, buffer.length, this.clientAddress, this.clientPort);
        socket.send(resultMessage);
    }
}
