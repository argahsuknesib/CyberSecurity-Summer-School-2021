package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.a.a.g;

public class UTDevice {
    @Deprecated
    public static String getUtdid(Context context) {
        return d(context);
    }

    @Deprecated
    public static String getUtdidForUpdate(Context context) {
        return e(context);
    }

    private static String d(Context context) {
        a b = b.b(context);
        return (b == null || g.m101a(b.f())) ? "ffffffffffffffffffffffff" : b.f();
    }

    private static String e(Context context) {
        String h = c.a(context).h();
        return (h == null || g.m101a(h)) ? "ffffffffffffffffffffffff" : h;
    }
}
