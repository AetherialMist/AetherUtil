package com.github.aetherialmist.exception;

@SuppressWarnings("unused")
public class AetherRuntimeException extends RuntimeException {

    public AetherRuntimeException() {
        super();
    }

    public AetherRuntimeException(String message) {
        super(message);
    }

    public AetherRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AetherRuntimeException(Throwable cause) {
        super(cause);
    }
}
