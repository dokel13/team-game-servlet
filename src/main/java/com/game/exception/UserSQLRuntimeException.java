package com.game.exception;

public class UserSQLRuntimeException extends RuntimeException {

    private String message = "User Database Exception!";

    public UserSQLRuntimeException() {
    }

    public UserSQLRuntimeException(Throwable cause, String message) {
        super(cause);
        this.message += message;
    }

    public UserSQLRuntimeException(String message) {
        this.message += message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
