package controller;

import controller.dataManagers.CSVDataManager;
import controller.dataManagers.JSONDataManager;
import exceptions.CharNotLetterException;
import model.Subscriber;
import model.SubscriberManager;
import util.CommandLineReader;
import view.CommandLine;

import static view.CommandLine.*;

public class Controller {
    private SubscriberManager manager;
    private CommandLine cl;
    private CommandLineReader reader;

    public Controller() {
        cl = new CommandLine();
        reader = new CommandLineReader();
    }

    private void setData(Subscriber[] data) {
        manager = new SubscriberManager(data);
    }

    public void init() {
        int inputMethod;
        int action;

        input : while (true) {
            cl.displayInputMethod();

            try {
                inputMethod = reader.readInteger();
            } catch (NumberFormatException e) {
                cl.printLine(INVALID_INPUT + "\n");
                continue;
            } catch (Exception e) {
                cl.printLine(UNEXPECTED_ERROR + "\n");
                continue;
            }

            switch (inputMethod) {
                case 1: {
                    setData(new JSONDataManager().readData("Subscribers.json"));
                    break;
                }
                case 2: {
                    setData(new CSVDataManager().readData("Subscribers.csv"));
                    break;
                }
                default: {
                    cl.printLine(UNEXPECTED_ERROR);
                    break;
                }
            }

            cl.displayMenu();
            try {
                action = reader.readInteger();
            } catch (NumberFormatException e) {
                cl.printLine(INVALID_INPUT + "\n");
                continue;
            } catch (Exception e) {
                cl.printLine(UNEXPECTED_ERROR + "\n");
                continue;
            }

            switch (action) {
                case 1: {
                    cl.listSubsribers(manager.getAll());
                    break;
                }
                case 2: {
                    char startLetter;
                    cl.printLine("Enter the first letter of the names of contacts to display: \n");

                    try {
                        startLetter = reader.readChar();
                    } catch (CharNotLetterException e) {
                        cl.printLine(INVALID_INPUT + ". " + e.getMessage() + "\n");
                        break;
                    } catch (Exception e) {
                        cl.printLine(UNEXPECTED_ERROR + "\n");
                        continue;
                    }

                    cl.listSubsribers(manager.getWithStartChar(startLetter));
                    break;
                }
                case 3: {
                    cl.listSubsribers(manager.getAllWithPhoneNumber());
                    break;
                }
                case 4: break input;
                default: {
                    cl.printLine(UNEXPECTED_ERROR);
                    break;
                }

            }
        }
        cl.printLine(EXIT);
    }
}
