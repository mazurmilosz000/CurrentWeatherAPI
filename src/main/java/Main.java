import API.APIHandler;
import API.Coordinates;

public class Main {
    public static void main(String[] args) throws Exception {


        APIHandler apiHandler = new APIHandler();
        Coordinates coordinates = apiHandler.getCoordinates("");
        apiHandler.checkCurrentWeather(coordinates);


    }
}
