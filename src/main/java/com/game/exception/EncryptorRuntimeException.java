package com.game.exception;

public class EncryptorRuntimeException extends RuntimeException {

    private String message = "Encryptor Exception!";

    public EncryptorRuntimeException() {
    }

    public EncryptorRuntimeException(Throwable cause, String message) {
        super(cause);
        this.message += message;
    }

    public EncryptorRuntimeException(String message) {
        this.message += message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
