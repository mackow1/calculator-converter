package org.example;

import java.io.IOException;
import java.net.SocketException;

public class Main {
    public static void main(String[] args) {
        int port = 12345;
        String[] equation;
        try {
            Server server = new Server(port);
            equation = server.listenAndCommunicate().split(" ");
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
                    case "hex" -> server.sendResult("0x" + c.fromDecimalToHex());
                    case "oct" -> server.sendResult("0o" + c.fromDecimalToOcta());
                    case "dec" -> server.sendResult(c.getValue() + "");
                    case "rom" -> server.sendResult(c.fromDecimalToRoman());
                    case "bin" -> server.sendResult("0b" + c.fromDecimalToBinary());
                    case "mac" -> server.sendResult("0m" + c.fromDecimalToMac());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (SocketException e) {
            System.out.println("Socket error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }


    }
}