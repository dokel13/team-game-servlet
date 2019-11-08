package com.game.exception;

public class LoginRuntimeException extends RuntimeException {

    private String message = "Login Exception!";

    public LoginRuntimeException() {
    }

    public LoginRuntimeException(Throwable cause, String message) {
        super(cause);
        this.message += message;
    }

    public LoginRuntimeException(String message) {
        this.message += message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
