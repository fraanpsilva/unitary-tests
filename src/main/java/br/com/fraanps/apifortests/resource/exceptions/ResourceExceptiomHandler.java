package br.com.fraanps.apifortests.resource.exceptions;

import br.com.fraanps.apifortests.services.exceptions.ObjectNotfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptiomHandler {

    @ExceptionHandler(ObjectNotfoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotfoundException ex, HttpServletRequest request){

        StandardError error = new StandardError(LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
