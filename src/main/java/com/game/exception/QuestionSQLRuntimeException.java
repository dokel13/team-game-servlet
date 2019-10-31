package com.game.exception;

public class QuestionSQLRuntimeException extends RuntimeException {

    private String message = "Question Database Exception!";

    public QuestionSQLRuntimeException() {
    }

    public QuestionSQLRuntimeException(String message) {
        this.message = "Question Database Exception! " + message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
