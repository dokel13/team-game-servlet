package com.game.exception;

public class AccessForbiddenException extends RuntimeException {

    public AccessForbiddenException() {
    }

    public AccessForbiddenException(String message) {
        super(message);
    }
}
