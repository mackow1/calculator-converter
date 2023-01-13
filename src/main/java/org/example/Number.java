package org.example;

public class Number {

    private String symbol;
    private int value;
    public Number(String symbol) {
        this.symbol = symbol;
        // możemy mieć system dziesietny(10), osemkowy(0o7), szesnastkowy(0x1f), binarny(0b1101) i rzymski(LXII),
        this.value = NumberConverter.toDecimal(symbol);
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }

    public int toDecimal() {
        return getValue();
    }

    public String fromDecimalToRoman() {
        return NumberConverter.decimalToRoman(getValue());
    }

    public int fromRomanToDecimal() {
        return NumberConverter.romanToDecimal(getSymbol());
    }

    public String fromDecimalToBinary() {
        return NumberConverter.decimalToBinary(getValue());
    }

    public int fromBinaryToDecimal() {
        return NumberConverter.binaryToDecimal(getSymbol());
    }

    public String fromDecimalToOcta() {
        return NumberConverter.decimalToOcta(getValue());
    }

    public int fromOctaToDecimal() {
        return NumberConverter.octaToDecimal(getSymbol());
    }
}
