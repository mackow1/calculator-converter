package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String symbolA = null;
        String symbolB = null;
        String operator = null;
        String numericSystem = null;

        try {
            System.out.print("Enter first number: ");
            symbolA = scanner.next();
            System.out.print("Enter second number: ");
            symbolB = scanner.next();
            System.out.print("Enter operator: ");
            operator = scanner.next();
            System.out.print("Enter system you want to display(hex, oct, dec, rom, bin): ");
            numericSystem = scanner.next();
        } catch (InputMismatchException e) {
            System.out.println("Conversion error");
        } catch (Exception e) {
            System.out.println("Something is wrong");
        } finally {
            scanner.close();
        }

        Number a = new Number(symbolA);
        Number b = new Number(symbolB);
        Calculator calculator = new Calculator();
        try {
            Number c = calculator.calc(a, operator, b);
            System.out.println(c.getValue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}