import com.google.gson.Gson;
import controller.Controller;
import controller.dataManagers.CSVDataManager;
import controller.dataManagers.JSONDataManager;
import model.Subscriber;

public class Main {
    public static void main(String[] args) {
        new Controller().init();
    }
}
