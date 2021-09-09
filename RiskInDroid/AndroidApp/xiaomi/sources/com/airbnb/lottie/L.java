package com.airbnb.lottie;

import _m_j.as;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

public class L {
    public static boolean DBG = false;
    private static int depthPastMaxDepth = 0;
    private static final Set<String> loggedMessages = new HashSet();
    private static String[] sections;
    private static long[] startTimeNs;
    private static int traceDepth = 0;
    private static boolean traceEnabled = false;

    public static void debug(String str) {
        if (DBG) {
            Log.d("LOTTIE", str);
        }
    }

    public static void warn(String str) {
        if (!loggedMessages.contains(str)) {
            Log.w("LOTTIE", str);
            loggedMessages.add(str);
        }
    }

    public static void setTraceEnabled(boolean z) {
        if (traceEnabled != z) {
            traceEnabled = z;
            if (z) {
                sections = new String[20];
                startTimeNs = new long[20];
            }
        }
    }

    public static void beginSection(String str) {
        if (traceEnabled) {
            int i = traceDepth;
            if (i == 20) {
                depthPastMaxDepth++;
                return;
            }
            sections[i] = str;
            startTimeNs[i] = System.nanoTime();
            as.O000000o(str);
            traceDepth++;
        }
    }

    public static float endSection(String str) {
        int i = depthPastMaxDepth;
        if (i > 0) {
            depthPastMaxDepth = i - 1;
            return 0.0f;
        } else if (!traceEnabled) {
            return 0.0f;
        } else {
            int i2 = traceDepth - 1;
            traceDepth = i2;
            if (i2 == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else if (str.equals(sections[traceDepth])) {
                as.O000000o();
                return ((float) (System.nanoTime() - startTimeNs[traceDepth])) / 1000000.0f;
            } else {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + sections[traceDepth] + ".");
            }
        }
    }
}
