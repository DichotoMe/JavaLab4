package controller.dataManagers;

import exceptions.CSVFormatException;
import model.Subscriber;

public class CSVDataManager implements DataManager<Subscriber> {

    public Subscriber[] readData(String path) {

        String[] stringData = FileManager.readFile(path).split("\n");
        Subscriber[] data = new Subscriber[stringData.length];

        for (int i = 0; i < data.length; i++)
            try {
                data[i] = Subscriber.fromCSV(stringData[i]);
            } catch (CSVFormatException e) {
                data[i] = null;
            }

        return data;
    }

    public void writeData(String path, Subscriber[] data) {

        String[] stringData = new String[data.length];
        for (int i = 0; i < stringData.length; i++)
            stringData[i] = data[i].toCSV();

        FileManager.writeToFile(path, String.join("\n", stringData));
    }
}