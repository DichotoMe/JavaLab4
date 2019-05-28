package exceptions;

public class CSVFormatException extends Exception {
    private static String DEFAULT_MESSAGE = "CSV format is invalid";

    public CSVFormatException() {
        super(DEFAULT_MESSAGE);
    }

    public CSVFormatException(String message) {
        super(message);
    }
}