package org.example;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SocketException {
        DatagramSocket datagramSocket = new DatagramSocket(12345);
        Server server = new Server(datagramSocket);
        String[] equation = server.receiveData().toLowerCase().split(" ");

        String symbolA = equation[0];
        String operator = equation[1];
        String symbolB = equation[2];
        String numericSystem = "dec";
        if (equation.length == 4) {
            numericSystem = equation[3];
        }

        Number a = new Number(symbolA);
        Number b = new Number(symbolB);
        Calculator calculator = new Calculator();
        try {
            Number c = calculator.calc(a, operator, b);
            switch (numericSystem) {
                case "hex" -> System.out.println("0x" + c.fromDecimalToHex());
                case "oct" -> System.out.println("0o" + c.fromDecimalToOcta());
                case "dec" -> System.out.println(c.getValue());
                case "rom" -> System.out.println(c.fromDecimalToRoman());
                case "bin" -> System.out.println("0b" + c.fromDecimalToBinary());
                case "mac" -> System.out.println("0m" + c.fromDecimalToMac());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}