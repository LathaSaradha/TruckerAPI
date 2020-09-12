package org.example.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class AlertsNotFoundException extends RuntimeException {
    public AlertsNotFoundException(String s) {
        super(s);
    }
}
