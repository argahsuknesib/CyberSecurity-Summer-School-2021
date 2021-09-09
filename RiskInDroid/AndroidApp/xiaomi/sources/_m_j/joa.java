package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;

public final class joa {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: O000000o  reason: collision with root package name */
    private static Context f1992O000000o;

    public static Context O000000o() {
        if (f1992O000000o == null) {
            try {
                f1992O000000o = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception e) {
                throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e);
            }
        }
        return f1992O000000o;
    }
}
