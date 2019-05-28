import model.Subscriber;

import java.util.Arrays;

public class Data {
    private Subscriber[] subscribers = {};

    private static class DataHolder {
        private static final Data HOLDER_INSTANCE = new Data();
    }

    public static Data getInstance() {
        return DataHolder.HOLDER_INSTANCE;
    }

    public Data add(Subscriber subscriber) {
        int length = subscribers.length;
        subscribers = Arrays.copyOf(subscribers, length + 1);
        subscribers[length] = subscriber;
        return this;
    }

    public Data remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= subscribers.length)
            throw new IndexOutOfBoundsException();

        for (int i = index + 1; i < subscribers.length; i++) {
            subscribers[i - 1] = subscribers[i];
        }
        subscribers = Arrays.copyOf(subscribers, subscribers.length - 1);

        return this;
    }

    public Subscriber[] getSubscribers() {
        return subscribers;
    }
}
