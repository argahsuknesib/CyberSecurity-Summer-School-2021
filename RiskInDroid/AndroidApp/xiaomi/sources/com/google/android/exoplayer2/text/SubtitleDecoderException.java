package com.google.android.exoplayer2.text;

public class SubtitleDecoderException extends Exception {
    public SubtitleDecoderException(String str) {
        super(str);
    }

    public SubtitleDecoderException(Exception exc) {
        super(exc);
    }

    public SubtitleDecoderException(String str, Throwable th) {
        super(str, th);
    }
}
