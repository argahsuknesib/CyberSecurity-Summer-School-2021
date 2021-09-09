package com.squareup.okhttp;

import java.io.UnsupportedEncodingException;
import okio.ByteString;

public final class Credentials {
    private Credentials() {
    }

    public static String basic(String str, String str2) {
        try {
            return "Basic ".concat(String.valueOf(ByteString.O000000o((str + ":" + str2).getBytes("ISO-8859-1")).O00000Oo()));
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }
}
