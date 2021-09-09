package com.hzy.tvmao.model.legacy.api;

import android.content.Context;

public class StreamHelper2 {
    public static native synchronized byte[] dec(byte[] bArr);

    public static native synchronized byte[] enc(byte[] bArr);

    public static native synchronized boolean init(Context context, String str);

    static {
        try {
            System.loadLibrary("kksdk");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
