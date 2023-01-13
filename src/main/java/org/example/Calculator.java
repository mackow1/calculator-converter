package org.example;

public class Calculator {

    public Number calc(Number a, String operator, Number b) throws Exception {
        int result;
        switch (operator) {
            case "+":
                result = a.getValue() + b.getValue();
                break;
            case "-":
                result = a.getValue() - b.getValue();
                break;
            case "*":
                result = a.getValue() * b.getValue();
                break;
            case "/":
                result = a.getValue() / b.getValue();
                break;
            default:
                throw new Exception("Wrong operator");
        }
        return new Number(String.valueOf(result));
    }
}
