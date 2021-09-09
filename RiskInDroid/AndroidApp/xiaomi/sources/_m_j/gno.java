package _m_j;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;

public final class gno {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final HashMap<String, Typeface> f18049O000000o = new HashMap<>();

    public static Typeface O000000o(Context context, String str) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            Typeface defaultFromStyle = Typeface.defaultFromStyle(0);
            if (TextUtils.isEmpty(str)) {
                return defaultFromStyle;
            }
            Typeface typeface = f18049O000000o.get(str);
            if (typeface == null) {
                try {
                    typeface = Typeface.createFromAsset(context.getAssets(), str);
                } catch (Exception e) {
                    gsy.O000000o(6, "FontManger", "createTypeface exception");
                    e.printStackTrace();
                }
                if (typeface != null) {
                    f18049O000000o.put(str, typeface);
                }
            }
            return typeface != null ? typeface : defaultFromStyle;
        }
        throw new IllegalStateException("Method call should happen from the main thread.");
    }
}
