package controller.dataManagers;

import com.google.gson.Gson;
import model.Subscriber;

public class JSONDataManager implements DataManager<Subscriber> {

    public Subscriber[] readData(String path){
        Gson gson = new Gson();
        return gson.fromJson(FileManager.readFile(path), Subscriber[].class);
    }

    public void writeData(String path, Subscriber[] data){
        Gson gson = new Gson();
        FileManager.writeToFile(path, gson.toJson(data));
    }
}