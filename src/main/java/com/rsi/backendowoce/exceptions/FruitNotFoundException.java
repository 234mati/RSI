package com.rsi.backendowoce.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FruitNotFoundException extends RuntimeException {
    private final String title = "Fruit not found";


    public FruitNotFoundException() {
        super("Fruit not found");
    }

    public FruitNotFoundException(String message) {
        super(message);
    }

    public FruitNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
