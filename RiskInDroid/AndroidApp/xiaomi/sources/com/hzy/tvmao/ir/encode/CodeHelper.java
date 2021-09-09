package com.hzy.tvmao.ir.encode;

import android.content.Context;

public class CodeHelper {
    static native synchronized byte[][] enc(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, byte[] bArr, String str);

    public static native synchronized boolean init(Context context, String str);

    static native synchronized int initRemote(int i, int i2, String[] strArr);

    static native synchronized void release(int i);

    static {
        try {
            System.loadLibrary("kksdk");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
