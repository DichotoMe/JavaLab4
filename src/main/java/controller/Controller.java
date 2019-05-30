package controller;

import controller.dataManagers.CSVDataManager;
import controller.dataManagers.JSONDataManager;
import exceptions.CharNotLetterException;
import model.Subscriber;
import model.SubscriberManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.CommandLineReader;
import view.CommandLine;

import static view.CommandLine.*;

public class Controller {
    private SubscriberManager manager;
    private CommandLine cl;
    private CommandLineReader reader;

    private Logger consoleLogger = LogManager.getLogger("Console");
    private Logger debugLogger = LogManager.getLogger("Debug");
    private Logger errorLogger = LogManager.getLogger("Error");

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
            debugLogger.debug("Displayed input method picker");
            try {
                debugLogger.debug("Picked an input method");
                inputMethod = reader.readInteger();
            } catch (NumberFormatException e) {
                errorLogger.error(e);
                consoleLogger.info("\n" + INVALID_INPUT + "\n");
                errorLogger.error(INVALID_INPUT, e);
                continue;
            } catch (Exception e) {
                consoleLogger.info("\n" + UNEXPECTED_ERROR + "\n");
                errorLogger.error(UNEXPECTED_ERROR, e);
                continue;
            }

            switch (inputMethod) {
                case 1: {
                    debugLogger.debug("Reading from json");
                    setData(new JSONDataManager().readData("files/Subscribers.json"));
                    break;
                }
                case 2: {
                    debugLogger.debug("Reading from csv");
                    setData(new CSVDataManager().readData("files/Subscribers.csv"));
                    break;
                }
                default: {
                    consoleLogger.info("\n" + INVALID_INPUT + "\n");
                    errorLogger.error(INVALID_INPUT);
                    continue;
                }
            }

            cl.displayMenu();
            debugLogger.debug("Displayed action picker");
            try {
                debugLogger.debug("Picked an action");
                action = reader.readInteger();
            } catch (NumberFormatException e) {
                consoleLogger.info("\n" + INVALID_INPUT + "\n");
                errorLogger.error(INVALID_INPUT, e);
                continue ;
            } catch (Exception e) {
                consoleLogger.info("\n" + UNEXPECTED_ERROR + "\n");
                errorLogger.error(UNEXPECTED_ERROR, e);
                continue;
            }

            switch (action) {
                case 1: {
                    debugLogger.debug("Displayed action 1 result");
                    cl.listSubsribers(manager.getAll());
                    break;
                }
                case 2: {
                    char startLetter;
                    debugLogger.debug("Displayed action 2 help");
                    consoleLogger.info("Enter the first letter of the names of contacts to display: \n");

                    try {
                        debugLogger.debug("Picked a letter in action 2");
                        startLetter = reader.readChar();
                    } catch (CharNotLetterException e) {
                        consoleLogger.info("\n" + INVALID_INPUT + ". " + e.getMessage() + "\n");
                        errorLogger.error(INVALID_INPUT, e);
                        continue ;
                    } catch (Exception e) {
                        consoleLogger.info("\n" + UNEXPECTED_ERROR + "\n");
                        errorLogger.error(UNEXPECTED_ERROR, e);
                        continue  ;
                    }

                    debugLogger.debug("Displayed action 2 result");
                    cl.listSubsribers(manager.getWithStartChar(startLetter));
                    break;
                }
                case 3: {
                    debugLogger.debug("Displayed action 3 result");
                    cl.listSubsribers(manager.getAllWithPhoneNumber());
                    break;
                }
                case 4: {
                    debugLogger.debug("Exiting");
                    break input;
                }
                default: {
                    consoleLogger.info("\n" + INVALID_INPUT + "\n");
                    errorLogger.error(INVALID_INPUT);
                    break;
                }

            }
        }
        consoleLogger.info(EXIT);
    }
}
