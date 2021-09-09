package com.tsmclient.smartcard.exception;

import java.io.IOException;

public class NfcEeIOException extends IOException {
    private int mErrorCode;

    public NfcEeIOException(String str) {
        this(str, 0);
    }

    public NfcEeIOException(String str, int i) {
        super(str);
        this.mErrorCode = i;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }
}
