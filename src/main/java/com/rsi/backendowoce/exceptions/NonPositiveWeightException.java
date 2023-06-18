package com.rsi.backendowoce.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class NonPositiveWeightException extends RuntimeException {
    private final String title = "Non positive weight";

    public NonPositiveWeightException() {
        super("Weight must be positive");
    }

    public NonPositiveWeightException(String message) {
        super(message);
    }

    public NonPositiveWeightException(String message, Throwable cause) {
        super(message, cause);
    }
}
