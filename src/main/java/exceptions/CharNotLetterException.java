package exceptions;

public class CharNotLetterException extends Exception {
    private static String DEFAULT_MESSAGE = "Given char is not a letter";

    private char symbol;

    public char getSymbol() {
        return symbol;
    }

    public CharNotLetterException(char symbol) {
        super(DEFAULT_MESSAGE + ": " + symbol);
        this.symbol = symbol;
    }

    public CharNotLetterException(String message, char symbol) {
        super(message + ": " + symbol);
        this.symbol = symbol;
    }
}
