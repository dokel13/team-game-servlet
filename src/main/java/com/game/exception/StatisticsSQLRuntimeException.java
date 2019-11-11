package com.game.exception;

public class StatisticsSQLRuntimeException extends RuntimeException {

    private String message = "Statistics Database Exception!";

    public StatisticsSQLRuntimeException() {
    }

    public StatisticsSQLRuntimeException(Throwable cause, String message) {
        super(cause);
        this.message += message;
    }

    public StatisticsSQLRuntimeException(String message) {
        this.message += message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
