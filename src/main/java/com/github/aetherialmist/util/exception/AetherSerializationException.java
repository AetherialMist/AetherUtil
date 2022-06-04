package com.github.aetherialmist.util.exception;

import com.github.aetherialmist.exception.AetherException;

@SuppressWarnings("unused")
public class AetherSerializationException extends AetherException {

    public AetherSerializationException() {
        super();
    }

    public AetherSerializationException(String message) {
        super(message);
    }

    public AetherSerializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AetherSerializationException(Throwable cause) {
        super(cause);
    }
}
