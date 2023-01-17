package org.example;

public class NumberConverter {

    public static int romanToDecimal(String symbol) {
        String tempSubstring = symbol;
        String ms = null;
        String ds = null;
        String cs = null;
        String ls = null;
        String xs = null;
        String vs = null;
        String is = null;

        if (tempSubstring.contains("M")) {
            ms = tempSubstring.substring(0, tempSubstring.lastIndexOf('M') + 1);
            tempSubstring = tempSubstring.substring(tempSubstring.lastIndexOf('M') + 1);
        }
        if (tempSubstring.contains("D")) {
            ds = tempSubstring.substring(0, tempSubstring.lastIndexOf('D') + 1);
            tempSubstring = tempSubstring.substring(tempSubstring.lastIndexOf('D') + 1);
        }
        if (tempSubstring.contains("C")) {
            cs = tempSubstring.substring(0, tempSubstring.lastIndexOf('C') + 1);
            tempSubstring = tempSubstring.substring(tempSubstring.lastIndexOf('C') + 1);
        }
        if (tempSubstring.contains("L")) {
            ls = tempSubstring.substring(0, tempSubstring.lastIndexOf('L') + 1);
            tempSubstring = tempSubstring.substring(tempSubstring.lastIndexOf('L') + 1);
        }
        if (tempSubstring.contains("X")) {
            xs = tempSubstring.substring(0, tempSubstring.lastIndexOf('X') + 1);
            tempSubstring = tempSubstring.substring(tempSubstring.lastIndexOf('X') + 1);
        }
        if (tempSubstring.contains("V")) {
            vs = tempSubstring;
        }
        if (tempSubstring.contains("I") && !tempSubstring.contains("V")) {
            is = tempSubstring;
        }

        int sum = 0;
        if (ms != null) {
            sum += ms.contains("C") ? (ms.length() - 2) * 1000 + 900 : ms.length() * 1000;
        }
        if (ds != null) {
            sum += ds.contains("C") ? 400 : 500;
        }
        if (cs != null) {
            sum += cs.contains("X") ? (cs.length() - 2) * 100 + 90 : cs.length() * 100;
        }
        if (ls != null) {
            sum += ls.contains("X") ? 40 : 50;
        }
        if (xs != null) {
            sum += xs.contains("I") ? (xs.length() - 2) * 10 + 9 : xs.length() * 10;
        }
        if (vs != null) {
            sum += vs.contains("I") ? 4 : 5;
        }
        if (is != null) {
            sum += is.length();
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
            if (i == 3) {
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
            } else if (i == 2) {
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
            } else if (i == 1) {
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
            } else if (i == 0) {
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
        return "0b" + Integer.toBinaryString(value);
    }

    public static int binaryToDecimal(String binary) {
        if (binary.contains("0b")) {
            binary = binary.substring(2);
        }
        return Integer.parseInt(binary, 2);
    }

    public static String decimalToOcta(int decimal) {
        StringBuilder octa = new StringBuilder();
        while (decimal != 0) {
            int rest = decimal % 8;
            decimal = decimal / 8;
            octa.insert(0, rest);
        }
        return octa.toString();
    }

    public static int octaToDecimal(String octa) {
        octa = octa.substring(2);
        int sum = 0;
        int counter = 0;
        for (int i = octa.length() - 1; i >= 0; i--) {
            sum += Integer.parseInt(String.valueOf(octa.charAt(i))) * Math.pow(8, counter);
            counter++;
        }
        return sum;
    }

    public static String decimalToHex(int decimal) {
        String hexNumber = "";
        while (decimal != 0) {
            if (decimal >= 4096) {
                hexNumber += decimalToHexSwitch(decimal / 4096);
                decimal = decimal % 4096;
            } else if (decimal >= 256) {
                hexNumber += decimalToHexSwitch(decimal / 256);
                decimal = decimal % 256;
            } else if (decimal >= 16) {
                hexNumber += decimalToHexSwitch(decimal / 16);
                decimal = decimal % 16;
            } else if (decimal >= 1) {
                hexNumber += decimalToHexSwitch(decimal);
                decimal = 0;
            }
        }
        return hexNumber;
    }

    private static String decimalToHexSwitch(int number) {
        return switch (number) {
            case 1 -> "1";
            case 2 -> "2";
            case 3 -> "3";
            case 4 -> "4";
            case 5 -> "5";
            case 6 -> "6";
            case 7 -> "7";
            case 8 -> "8";
            case 9 -> "9";
            case 10 -> "A";
            case 11 -> "B";
            case 12 -> "C";
            case 13 -> "D";
            case 14 -> "E";
            case 15 -> "F";
            default -> "";
        };
    }

    public static int hexToDecimal(String hex) {
        hex = hex.substring(2);
        String quota = "0123456789ABCDEF";
        int result = 0;
        int power = 1;

        for (int i = hex.length() - 1; i >= 0; i--) {
            int tempIndex = quota.indexOf(hex.charAt(i));
            result += tempIndex * power;
            power *= 16;
        }
        return result;
    }

    public static int toDecimal(String symbol) {
        return Integer.parseInt(symbol);
    }
}
