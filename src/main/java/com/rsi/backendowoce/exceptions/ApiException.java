package com.rsi.backendowoce.exceptions;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ApiException {
    private String source;
    private String title;
    private String details;

    @Builder
    public ApiException(String source, String title, String details) {
        this.source = source;
        this.title = title;
        this.details = details;
    }
}
