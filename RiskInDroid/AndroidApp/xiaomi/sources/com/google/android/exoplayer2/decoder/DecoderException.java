package com.google.android.exoplayer2.decoder;

public class DecoderException extends Exception {
    public DecoderException(String str) {
        super(str);
    }

    public DecoderException(String str, Throwable th) {
        super(str, th);
    }
}
