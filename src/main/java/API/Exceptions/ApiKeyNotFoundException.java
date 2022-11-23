package API.Exceptions;

public class ApiKeyNotFoundException extends Exception{
    public ApiKeyNotFoundException() {
        super("Cannot find API key");
    }
}
