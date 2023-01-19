package org.example;

public class Number {

    private String symbol;
    private int value;
    public Number(String symbol) {
        this.symbol = symbol;
        // możemy mieć system dziesietny(10), osemkowy(0o7), szesnastkowy(0x1f), binarny(0b1101) i rzymski(LXII),
        if (symbol.contains("0o")) {
            this.value = this.fromOctaToDecimal();
        } else if (symbol.contains("0x")) {
            this.value = this.fromHexToDecimal();
        } else if (symbol.contains("0b")) {
            this.value = this.fromBinaryToDecimal();
        } else if (symbol.matches("[MDCLXVI]*")) {
            this.value = this.fromRomanToDecimal();
        } else if (symbol.matches("[0-9]*")) {
            this.value = Integer.parseInt(symbol);
        } else if (symbol.startsWith("0m")) {
            this.value = this.fromMacToDecimal();
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
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

    public String fromDecimalToHex() {
        return NumberConverter.decimalToHex(getValue());
    }

    public int fromHexToDecimal() {
        return NumberConverter.hexToDecimal(getSymbol());
    }

    public int fromMacToDecimal() {
        return NumberConverter.maciekToDecimal(getSymbol());
    }

    public String fromDecimalToMac() {
        return NumberConverter.decimalToMaciek(getValue());
    }
}
