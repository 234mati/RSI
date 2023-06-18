package com.rsi.backendowoce.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class NonPositivePriceException extends RuntimeException {
    private final String title = "Non positive price";

    public NonPositivePriceException() {
        super("Price must be positive");
    }

    public NonPositivePriceException(String message) {
        super(message);
    }

    public NonPositivePriceException(String message, Throwable cause) {
        super(message, cause);
    }
}
