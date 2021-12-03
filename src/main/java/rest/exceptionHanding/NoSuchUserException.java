package rest.exceptionHanding;

public class NoSuchUserException extends RuntimeException{

    public NoSuchUserException(String message){
        super(message);
    }
}
