package com.hzy.tvmao;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f4474a;
    private static Handler b;
    private static boolean c;

    public static void a() {
        if (!c) {
            c = true;
            HandlerThread handlerThread = new HandlerThread("bkgdThread", 10);
            handlerThread.start();
            f4474a = new Handler(Looper.getMainLooper());
            b = new Handler(handlerThread.getLooper());
        }
    }
}
