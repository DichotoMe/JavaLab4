package model;

import java.util.Arrays;

public class SubscriberManager {
    private Subscriber[] subscribers;

    public SubscriberManager(Subscriber[] subscribers) {
        this.subscribers = subscribers;
    }

    public Subscriber[] getAll() {
        return subscribers;
    }

    public Subscriber[] getWithStartChar(char startChar) {
        int count = 0;
        Subscriber[] filteredSubscribers = new Subscriber[subscribers.length];
        for (Subscriber subscriber : subscribers) {
            char symbol = subscriber.getFirstName().charAt(0);
            if (symbol == Character.toLowerCase(startChar) ||
                symbol == Character.toUpperCase(startChar)) {
                filteredSubscribers[count] = subscriber;
                count++;
            }
        }

        if (filteredSubscribers.length == 0)
            return null;
        else
            return Arrays.copyOf(filteredSubscribers, count);
    }

    public Subscriber[] getAllWithPhoneNumber() {
        int count = 0;
        Subscriber[] filteredSubscribers = new Subscriber[subscribers.length];
        for (Subscriber subscriber : subscribers)
            if (subscriber.getPhoneNumber() != null) {
                filteredSubscribers[count] = subscriber;
                count++;
            }

        if (filteredSubscribers.length == 0)
            return null;
        else
            return Arrays.copyOf(filteredSubscribers, count);

    }
}
