package view;

import model.Subscriber;

public class CommandLine {
    public static final String INPUT_METHOD = String.format(
            "%s%n%s%n%s",
            "Choose the desired input method:",
            "Press 1 to read from json",
            "Press 2 to read from CSV\n"
    );

    public static final String MENU = String.format(
            "%s%n%s%n%s%n%s%n%s",
            "Choose the desired action:",
            "Press 1 to list all subscribers",
            "Press 2 to list all subscribers whose name starts with the specified letter",
            "Press 3 to list all subscribers with a phone number",
            "Press 4 to exit.\n"
    );
    public static final String HEADER = String.format(
            "%10s%18s%15s%15s%25s",
            "FirstName",
            "MiddleName",
            "LastName",
            "Phone number",
            "Address"
    );
    public static final String INVALID_INPUT = String.format(
            "%n%s",
            "Invalid input"
    );
    public static final String UNEXPECTED_ERROR = String.format(
            "%n%s",
            "Unexpected error"
    );

    public static final String EXIT = String.format("%n%s", "Exiting");

    public void displayInputMethod() {
        printLine(INPUT_METHOD);
    }

    public void displayMenu() {
        printLine(MENU);
    }

    public void listSubsribers(Subscriber[] subscribers) {
        if(subscribers == null || subscribers.length == 0) {
            System.out.println("\nNo matches found.\n");
            return;
        }
        printLine(HEADER);

        for (Subscriber subscriber : subscribers)
            printLine(subscriber);

        printLine();
    }

    public void printLine() {
        System.out.println();
    }

    public void printLine(Object object) {
        System.out.println(object);
    }
}
