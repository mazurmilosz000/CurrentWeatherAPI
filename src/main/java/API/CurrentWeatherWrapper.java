package API;

import java.util.List;

public class CurrentWeatherWrapper {
    class Response {
        List<Weather> weather;


        int visibility; // Visibility, meter. The maximum value of the visibility is 10km
        Main main;
        Wind wind;
        Clouds clouds;

        public List<Weather> getWeather() {
            return weather;
        }

        public void setWeather(List<Weather> weather) {
            this.weather = weather;
        }

        public int getVisibility() {
            return visibility;
        }

        public void setVisibility(int visibility) {
            this.visibility = visibility;
        }

        public Main getMain() {
            return main;
        }

        public void setMain(Main main) {
            this.main = main;
        }

        public Wind getWind() {
            return wind;
        }

        public void setWind(Wind wind) {
            this.wind = wind;
        }

       public Clouds getClouds() {
            return clouds;
        }

        public void setClouds(Clouds clouds) {
            this.clouds = clouds;
        }
    }

    class Weather {
        String main; // Group of weather parameters (Rain, Snow, Extreme etc.)
        String description; // Weather condition within the group

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    class Main {
        double temp; // Temperature. Unit Default: Kelvin;
        double feels_like; // Temperature. This temperature parameter accounts for the human perception of weather.
        double temp_min;
        double temp_max;
        int pressure;
        int humidity; // Humidity in %

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public double getFeels_like() {
            return feels_like;
        }

        public void setFeels_like(double feels_like) {
            this.feels_like = feels_like;
        }

        public double getTemp_min() {
            return temp_min;
        }

        public void setTemp_min(double temp_min) {
            this.temp_min = temp_min;
        }

        public double getTemp_max() {
            return temp_max;
        }

        public void setTemp_max(double temp_max) {
            this.temp_max = temp_max;
        }

        public int getPressure() {
            return pressure;
        }

        public void setPressure(int pressure) {
            this.pressure = pressure;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }
    }

    class Wind {
        double speed; //  Wind speed. Unit Default: meter/sec.

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }
    }

    class Clouds {
        int all; // Cloudiness, %

        public int getAll() {
            return all;
        }

        public void setAll(int all) {
            this.all = all;
        }
    }

}
