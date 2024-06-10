package br.com.msclients.exception.handler;

import br.com.msclients.exception.CpfUniqueViolationException;
import br.com.msclients.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request, BindingResult result){
        String error = "Method argument not valid";
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        StandardError err = new StandardError(Instant.now(), status.value(), error, "Invalid field(s)", request.getMethod(), request.getRequestURI(), result);
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(CpfUniqueViolationException.class)
    public ResponseEntity<StandardError> userUniqueViolation(CpfUniqueViolationException e, HttpServletRequest request){
        String error = "Cpf unique violation";
        HttpStatus status = HttpStatus.CONFLICT;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getMethod(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getMethod(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
