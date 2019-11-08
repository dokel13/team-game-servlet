package com.game.exception;

public class GameSQLRuntimeException extends RuntimeException {

    private String message = "Game Database Exception!";

    public GameSQLRuntimeException() {
    }

    public GameSQLRuntimeException(Throwable cause, String message) {
        super(cause);
        this.message += message;
    }

    public GameSQLRuntimeException(String message) {
        this.message += message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
