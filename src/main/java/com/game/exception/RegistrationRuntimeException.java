package com.game.exception;

public class RegistrationRuntimeException extends RuntimeException {

    private String message = "Registration Exception!";

    public RegistrationRuntimeException() {
    }

    public RegistrationRuntimeException(Throwable cause, String message) {
        super(cause);
        this.message += message;
    }

    public RegistrationRuntimeException(String message) {
        this.message += message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
