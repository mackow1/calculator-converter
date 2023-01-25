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
                case 'V':
                    sum += 5;
                case 'X':
                    if (symbol.charAt(i + 1) == 'L' || symbol.charAt(i + 1) == 'C') {
                        sum -= 10;
                    } else {
                        sum += 10;
                    }
                case 'L':
                    sum += 50;
                case 'C':
                    if (symbol.charAt(i + 1) == 'M' || symbol.charAt(i + 1) == 'D') {
                        sum -= 100;
                    } else {
                        sum += 100;
                    }
                case 'M':
                    sum += 1000;
            }
        }
        return sum;
    }

    public static String decimalToRoman(int number) {
        String symbol = String.valueOf(number);
        StringBuilder decimal = new StringBuilder();

        String[] symbolArray = symbol.split("");

        int tempNumber = 0;
        for (int i = symbolArray.length - 1; i >= 0; i--) {
            tempNumber = Integer.parseInt(symbolArray[i]);
            if (symbolArray.length - i == 1) {
                switch (tempNumber) {
                    case 1 -> decimal.insert(0, "I");
                    case 2 -> decimal.insert(0, "II");
                    case 3 -> decimal.insert(0, "III");
                    case 4 -> decimal.insert(0, "IV");
                    case 5 -> decimal.insert(0, "V");
                    case 6 -> decimal.insert(0, "VI");
                    case 7 -> decimal.insert(0, "VII");
                    case 8 -> decimal.insert(0, "VIII");
                    case 9 -> decimal.insert(0, "IX");
                    default -> decimal.insert(0, "");
                }
            } else if (symbolArray.length - i == 2) {
                switch (tempNumber) {
                    case 1 -> decimal.insert(0, "X");
                    case 2 -> decimal.insert(0, "XX");
                    case 3 -> decimal.insert(0, "XXX");
                    case 4 -> decimal.insert(0, "XL");
                    case 5 -> decimal.insert(0, "L");
                    case 6 -> decimal.insert(0, "LX");
                    case 7 -> decimal.insert(0, "LXX");
                    case 8 -> decimal.insert(0, "LXXX");
                    case 9 -> decimal.insert(0, "XC");
                    default -> decimal.insert(0, "");
                }
            } else if (symbolArray.length - i == 3) {
                switch (tempNumber) {
                    case 1 -> decimal.insert(0, "C");
                    case 2 -> decimal.insert(0, "CC");
                    case 3 -> decimal.insert(0, "CCC");
                    case 4 -> decimal.insert(0, "CD");
                    case 5 -> decimal.insert(0, "D");
                    case 6 -> decimal.insert(0, "DC");
                    case 7 -> decimal.insert(0, "DCC");
                    case 8 -> decimal.insert(0, "DCCC");
                    case 9 -> decimal.insert(0, "CM");
                    default -> decimal.insert(0, "");
                }
            } else if (symbolArray.length - i == 4) {
                switch (tempNumber) {
                    case 1 -> decimal.insert(0, "M");
                    case 2 -> decimal.insert(0, "MM");
                    case 3 -> decimal.insert(0, "MMM");
                    case 4 -> decimal.insert(0, "MMMM");
                    default -> decimal.insert(0, "");
                }
            }
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
