package entities;

public class Symbol {
    private char symbolChar;
    private String color;

    public Symbol(char symbolChar, String color) {
        this.symbolChar = symbolChar;
        this.color = color;
    }

    public char getSymbolChar() {
        return symbolChar;
    }

    public void setSymbolChar(char symbolChar) {
        this.symbolChar = symbolChar;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
