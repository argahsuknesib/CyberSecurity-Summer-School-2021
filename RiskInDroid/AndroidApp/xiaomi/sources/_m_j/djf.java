package _m_j;

import android.util.Log;

public final class djf extends dja {
    public static final djf O00000Oo = new djf();

    /* access modifiers changed from: protected */
    public final void O00000Oo(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (i == 1) {
            Log.v(str, str2, th);
        } else if (i == 2) {
            Log.d(str, str2, th);
        } else if (i == 4) {
            Log.i(str, str2, th);
        } else if (i == 8) {
            Log.w(str, str2, th);
        } else if (i == 16) {
            Log.e(str, str2, th);
        } else if (i == 32) {
            Log.e(str, str2, th);
        }
    }
}
