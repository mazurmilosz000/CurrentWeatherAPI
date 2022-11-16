package API;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Objects;
import java.util.Properties;

public class APIHandler {
    public APIHandler() {  }
    Gson gson = new Gson();

    // method to take an ApiKey from app.properties
    private String getApiKey() throws IOException {
        Properties appProps = new Properties();
        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().
                getResource("")).getPath();
        String appConfigPath = rootPath + "app.properties";
        appProps.load(new FileInputStream(appConfigPath));

         return appProps.getProperty("apiKey");

    }

    // method to take coordinates (latitude, longitude) of given city
    public Coordinates getCoordinates(String cityName) throws Exception {


        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("http://api.openweathermap.org/geo/1.0/direct?q=" +
                        cityName + "&limit=5&appid=" + getApiKey())).build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> getResponse = client.send(getRequest, HttpResponse.BodyHandlers.ofString());

        GeoCodingWrapper[] data = gson.fromJson(getResponse.body(), GeoCodingWrapper[].class);

        return new Coordinates(data[0].getLat(), data[0].getLon());

    }

    // method to get data of weather in given city
    public void checkCurrentWeather(Coordinates coor) throws Exception {
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.openweathermap.org/data/2.5/weather?lat=" +
                        coor.getLat() + "&lon=" + coor.getLon() + "&appid=" + getApiKey())).build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> getResponse = client.send(getRequest, HttpResponse.BodyHandlers.ofString());

        CurrentWeatherWrapper.Response data = gson.fromJson(getResponse.body(), CurrentWeatherWrapper.Response.class);

        System.out.println("Current weather: " + data.getWeather().get(0).getMain());
        System.out.println("Description: " + data.getWeather().get(0).getDescription());
        System.out.println("Visibility: " + data.getVisibility());
        System.out.println("Temperature: " + data.getMain().getTemp());
        System.out.println("Sensed temperature: " + data.getMain().getFeels_like());
        System.out.println("Sensed temperature: " + data.getMain().getFeels_like());
        System.out.println("Minimum temperature: " + data.getMain().getTemp_min());
        System.out.println("Maximum temperature: " + data.getMain().getTemp_max());
        System.out.println("Pressure: " + data.getMain().getPressure());
        System.out.println("Humidity: " + data.getMain().getHumidity());
        System.out.println("Wind speed: " + data.getWind().getSpeed());
        System.out.println("percentage cloudiness " + data.getClouds().getAll());

    }
}
