import com.google.gson.Gson;
import controller.Controller;
import controller.dataManagers.CSVDataManager;
import controller.dataManagers.JSONDataManager;
import model.Subscriber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        new Controller().init();
    }
}
