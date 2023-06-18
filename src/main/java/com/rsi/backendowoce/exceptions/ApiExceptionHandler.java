package com.rsi.backendowoce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(FruitNotFoundException.class)
    public ResponseEntity<?> fruitNotFoundException(FruitNotFoundException exception,
                                                    WebRequest request) {

        ApiException apiException = ApiException.builder()
                .title(exception.getTitle())
                .source(request.getDescription(false))
                .details(exception.getMessage()).build();

        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FruitAlreadyExistsException.class)
    public ResponseEntity<?> fruitAlreadyExistsException(FruitAlreadyExistsException exception,
                                                    WebRequest request) {

        ApiException apiException = ApiException.builder()
                .title(exception.getTitle())
                .source(request.getDescription(false))
                .details(exception.getMessage()).build();

        return new ResponseEntity<>(apiException, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NonPositiveWeightException.class)
    public ResponseEntity<?> nonPositiveWeightException(NonPositiveWeightException exception,
                                                    WebRequest request) {

        ApiException apiException = ApiException.builder()
                .title(exception.getTitle())
                .source(request.getDescription(false))
                .details(exception.getMessage()).build();

        return new ResponseEntity<>(apiException, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NonPositivePriceException.class)
    public ResponseEntity<?> nonPositivePriceException(NonPositivePriceException exception,
                                                    WebRequest request) {

        ApiException apiException = ApiException.builder()
                .title(exception.getTitle())
                .source(request.getDescription(false))
                .details(exception.getMessage()).build();

        return new ResponseEntity<>(apiException, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception exception, WebRequest request) {

        ApiException apiException = ApiException.builder()
                .title("Entity does not exist")
                .source(request.getDescription(false))
                .details(exception.getMessage()).build();

        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
}
