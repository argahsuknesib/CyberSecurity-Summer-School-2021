package com.xiaomi.onetrack.c;

import android.os.Handler;
import android.os.HandlerThread;

public class a {
    private static String b = "onetrack_db";
    private static Handler c;

    private static void a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    HandlerThread handlerThread = new HandlerThread(b);
                    handlerThread.start();
                    c = new Handler(handlerThread.getLooper());
                }
            }
        }
    }

    public static void a(Runnable runnable) {
        a();
        c.post(runnable);
    }
}
