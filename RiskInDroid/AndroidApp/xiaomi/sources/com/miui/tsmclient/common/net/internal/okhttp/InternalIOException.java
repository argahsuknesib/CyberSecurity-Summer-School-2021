package com.miui.tsmclient.common.net.internal.okhttp;

import java.io.IOException;

public class InternalIOException extends IOException {
    private int mErrorCode;

    public InternalIOException(int i) {
        this.mErrorCode = i;
    }

    public InternalIOException(int i, String str) {
        super(str);
        this.mErrorCode = i;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }
}
