package controller.dataManagers;

public interface DataManager<T> {
    T[] readData(String path);
    void writeData(String path, T[] data);
}