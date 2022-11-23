package API.Exceptions;

public class CityNameException extends Exception{
    public CityNameException() {
        super("Cannot find that city");
    }
}
