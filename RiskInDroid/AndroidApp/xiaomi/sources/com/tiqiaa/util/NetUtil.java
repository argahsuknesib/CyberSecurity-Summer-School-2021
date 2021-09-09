package com.tiqiaa.util;

import android.content.Context;

public final class NetUtil {
    public static native byte[] b64decode(String str);

    public static native String b64encode(byte[] bArr, int i);

    public static native String decode(Context context, String str);

    public static native String encode(Context context, String str, int i);
}
