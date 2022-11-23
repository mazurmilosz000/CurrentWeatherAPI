package API.Exceptions;

public class ApiKeyAuthorizedException extends Exception{
    public ApiKeyAuthorizedException() {

        super("Check correctness of your API Key");
    }
}
