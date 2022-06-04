package com.github.aetherialmist.exception;

@SuppressWarnings("unused")
public class AetherException extends Exception {

    public AetherException() {
        super();
    }

    public AetherException(String message) {
        super(message);
    }

    public AetherException(String message, Throwable cause) {
        super(message, cause);
    }

    public AetherException(Throwable cause) {
        super(cause);
    }
}
