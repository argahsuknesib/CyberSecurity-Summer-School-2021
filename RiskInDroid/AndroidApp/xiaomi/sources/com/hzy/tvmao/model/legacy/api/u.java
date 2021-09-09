package com.hzy.tvmao.model.legacy.api;

import com.hzy.tvmao.utils.DataStoreUtil;
import java.io.Closeable;
import java.io.IOException;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    private static int f4438a = -1;
    private static int b = -1;

    public static void a(int i) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (Math.abs(i - currentTimeMillis) > 60) {
            if (DataStoreUtil.i().putString("now_time", i + "|" + currentTimeMillis)) {
                f4438a = i;
                b = currentTimeMillis;
            }
        } else if (DataStoreUtil.i().remove("now_time")) {
            f4438a = 0;
            b = 0;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
