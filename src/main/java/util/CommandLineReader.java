package util;

import exceptions.CharNotLetterException;

import java.util.Scanner;

public class CommandLineReader {
    private Scanner scanner;

    public CommandLineReader() {
        this.scanner = new Scanner(System.in);
    }

    public int readInteger() throws NumberFormatException {
        return Integer.parseInt(scanner.next());
    }

    public char readChar() throws CharNotLetterException {
        char symbol = scanner.next().charAt(0);

        if (!Character.isLetter(symbol))
            throw new CharNotLetterException(symbol);

        return symbol;
    }
}
