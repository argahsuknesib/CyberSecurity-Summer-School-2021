package _m_j;

import android.content.Context;

public final class gsd {
    public static boolean O000000o(Context context) {
        return context.getSharedPreferences("rn-plugin-perf-trace-config", 0).getBoolean("enable-launch-perf-trace", false);
    }
}
