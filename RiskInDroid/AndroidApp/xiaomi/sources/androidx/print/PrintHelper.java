package androidx.print;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;

public final class PrintHelper {

    /* renamed from: O000000o  reason: collision with root package name */
    static final boolean f2928O000000o = (Build.VERSION.SDK_INT < 20 || Build.VERSION.SDK_INT > 23);
    static final boolean O00000Oo;
    BitmapFactory.Options O00000o = null;
    final Context O00000o0;
    final Object O00000oO = new Object();
    int O00000oo = 2;
    int O0000O0o = 2;
    int O0000OOo = 1;

    static {
        boolean z = false;
        if (Build.VERSION.SDK_INT != 23) {
            z = true;
        }
        O00000Oo = z;
    }

    public PrintHelper(Context context) {
        this.O00000o0 = context;
    }
}
