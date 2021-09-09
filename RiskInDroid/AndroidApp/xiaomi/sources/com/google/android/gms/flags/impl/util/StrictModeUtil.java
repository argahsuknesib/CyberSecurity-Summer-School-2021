package com.google.android.gms.flags.impl.util;

import android.os.StrictMode;
import java.util.concurrent.Callable;

public class StrictModeUtil {
    /* JADX INFO: finally extract failed */
    public static <T> T runWithLaxStrictMode(Callable<T> callable) throws Exception {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
            T call = callable.call();
            StrictMode.setThreadPolicy(threadPolicy);
            return call;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicy);
            throw th;
        }
    }
}
