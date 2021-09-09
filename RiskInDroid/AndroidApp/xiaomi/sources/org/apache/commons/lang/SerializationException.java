package org.apache.commons.lang;

import org.apache.commons.lang.exception.NestableRuntimeException;

public class SerializationException extends NestableRuntimeException {
    private static final long serialVersionUID = 4029025366392702726L;

    public SerializationException() {
    }

    public SerializationException(String str) {
        super(str);
    }

    public SerializationException(Throwable th) {
        super(th);
    }

    public SerializationException(String str, Throwable th) {
        super(str, th);
    }
}
