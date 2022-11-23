package API.Exceptions;

public class EmptyRequestException extends Exception{
    public EmptyRequestException() {
        super("You have to type city name");
    }
}
