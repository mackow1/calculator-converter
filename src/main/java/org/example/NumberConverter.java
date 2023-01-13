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
        return "";
    }

    public static int toDecimal(String symbol) {
        return Integer.parseInt(symbol);
    }
}
