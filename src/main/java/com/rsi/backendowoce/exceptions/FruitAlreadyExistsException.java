package com.rsi.backendowoce.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.CONFLICT)
public class FruitAlreadyExistsException extends RuntimeException {
    private final String title = "Fruit already exists";

    public FruitAlreadyExistsException() {
        super("Fruit already exists");
    }

    public FruitAlreadyExistsException(String message) {
        super(message);
    }

    public FruitAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
