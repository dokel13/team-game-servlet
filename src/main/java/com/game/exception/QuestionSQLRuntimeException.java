package com.game.exception;

public class QuestionSQLRuntimeException extends RuntimeException {

    private String message = "Question Database Exception!";

    public QuestionSQLRuntimeException() {
    }

    public QuestionSQLRuntimeException(Throwable cause, String message) {
        super(cause);
        this.message += message;
    }

    public QuestionSQLRuntimeException(String message) {
        this.message += message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
