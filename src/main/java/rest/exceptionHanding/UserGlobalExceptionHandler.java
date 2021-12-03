package rest.exceptionHanding;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<UserIncorrectData> handleException(NoSuchUserException exception){
        UserIncorrectData userIncorrectData = new UserIncorrectData();
        userIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(userIncorrectData, HttpStatus.NOT_FOUND );
    }
    @ExceptionHandler
    public ResponseEntity<UserIncorrectData> handleException(Exception exception){
        UserIncorrectData userIncorrectData = new UserIncorrectData();
        userIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(userIncorrectData, HttpStatus.BAD_REQUEST  );
    }
}