package no.nordicsemi.android.dfu.internal.exception;

import java.io.IOException;

public class SizeValidationException extends IOException {
    private static final long serialVersionUID = -6467104024030837875L;

    public SizeValidationException(String str) {
        super(str);
    }
}
