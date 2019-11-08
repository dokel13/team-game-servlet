package com.game.exception;

public class AccessForbiddenRuntimeException extends RuntimeException {

    public AccessForbiddenRuntimeException() {
    }

    public AccessForbiddenRuntimeException(String message) {
        super(message);
    }
}
