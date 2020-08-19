package by.innowise.by.innowise.petProject.handlers;

import by.innowise.by.innowise.petProject.exception.RestExceptionDto;
import by.innowise.by.innowise.petProject.exception.UserAlreadyExistException;
import by.innowise.by.innowise.petProject.exception.UserNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {
            UserAlreadyExistException.class,
            UserNotFoundException.class
    })

    protected ResponseEntity<Object> handleConflict(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RestExceptionDto(ex));
    }
}
