package org.example;

public class NumberConverter {

    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static int romanToDecimal(String symbol) {

        int sum = 0;
        for (int i = symbol.length() - 1; i >= 0; i--) {
            switch (symbol.charAt(i)) {
                case 'I':
                    if (symbol.charAt(i + 1) == 'V' || symbol.charAt(i + 1) == 'X') {
                        sum -= 1;
                    } else {
                        sum += 1;
                    }
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    if (symbol.charAt(i + 1) == 'L' || symbol.charAt(i + 1) == 'C') {
                        sum -= 10;
                    } else {
                        sum += 10;
                    }
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    if (symbol.charAt(i + 1) == 'M' || symbol.charAt(i + 1) == 'D') {
                        sum -= 100;
                    } else {
                        sum += 100;
                    }
                    break;
                case 'M':
                    sum += 1000;
                    break;
            }
        }
        return sum;
    }

    public static String decimalToRoman(int number) {
        String decimal = "";
        while (number >= 1000) {
            decimal += "M";
            number -= 1000;
        }
        if (number >= 900) {
            decimal += "CM";
            number -= 900;
        }
        if (number >= 500) {
            decimal += "D";
            number -= 500;
        }
        if (number >= 400) {
            decimal += "CD";
            number -= 400;
        }
        while (number >= 100) {
            decimal += "C";
            number -= 100;
        }
        if (number >= 90) {
            decimal += "XC";
            number -= 90;
        }
        if (number >= 50) {
            decimal += "L";
            number -= 50;
        }
        if (number >= 40) {
            decimal += "XL";
            number -= 40;
        }
        while (number >= 10) {
            decimal += "X";
            number -= 10;
        }
        if (number == 9) {
            decimal += "IX";
            number -= 9;
        }
        if (number >= 5) {
            decimal += "V";
            number -= 5;
        }
        if (number == 4) {
            decimal += "IV";
            number -= 4;
        }
        while (number >= 1) {
            decimal += "I";
            number -= 1;
        }
        return decimal.toString();
    }

    public static String decimalToBinary(int value) {
        return decimalToPositionalSystem(value, 2);
    }

    private static String decimalToPositionalSystem(int value, int base) {
        String result = "";
        while (value != 0) {
            int index = value % base;
            result = NumberConverter.ALPHABET.charAt(index) + result;
            value /= base;
        }
        return result;
    }

    private static int positionalSystemToDecimal(String value, int base) {
        int result = 0;
        value = value.substring(2);
        for (int i = value.length() - 1, j = 0; i >= 0; i--, j++) {
            int index = NumberConverter.ALPHABET.indexOf(value.charAt(i));
            result += index * Math.pow(base, j);
        }
        return result;
    }

    public static int maciekToDecimal(String value) {
        return positionalSystemToDecimal(value, 35);
    }

    public static String decimalToMaciek(int value) {
        return decimalToPositionalSystem(value, 35);
    }

    public static int binaryToDecimal(String binary) {
        return positionalSystemToDecimal(binary, 2);
    }

    public static String decimalToOcta(int decimal) {
        return decimalToPositionalSystem(decimal, 8);
    }

    public static int octaToDecimal(String octa) {
        return positionalSystemToDecimal(octa, 8);
    }

    public static String decimalToHex(int decimal) {
        return decimalToPositionalSystem(decimal, 16);
    }

    public static int hexToDecimal(String hex) {
        return positionalSystemToDecimal(hex, 16);
    }
}
