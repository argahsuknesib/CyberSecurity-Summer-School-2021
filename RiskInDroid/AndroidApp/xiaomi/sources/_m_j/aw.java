package _m_j;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class aw {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Method f12654O000000o;
    private static Method O00000Oo;

    static {
        if (Build.VERSION.SDK_INT < 21) {
            try {
                Class<?> cls = Class.forName("libcore.icu.ICU");
                if (cls != null) {
                    f12654O000000o = cls.getMethod("getScript", String.class);
                    O00000Oo = cls.getMethod("addLikelySubtags", String.class);
                }
            } catch (Exception e) {
                f12654O000000o = null;
                O00000Oo = null;
                Log.w("ICUCompat", e);
            }
        } else if (Build.VERSION.SDK_INT < 24) {
            try {
                O00000Oo = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    public static String O000000o(Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) O00000Oo.invoke(null, locale)).getScript();
            } catch (InvocationTargetException e) {
                Log.w("ICUCompat", e);
                return locale.getScript();
            } catch (IllegalAccessException e2) {
                Log.w("ICUCompat", e2);
                return locale.getScript();
            }
        } else {
            String O00000Oo2 = O00000Oo(locale);
            if (O00000Oo2 != null) {
                return O000000o(O00000Oo2);
            }
            return null;
        }
    }

    private static String O000000o(String str) {
        try {
            if (f12654O000000o != null) {
                return (String) f12654O000000o.invoke(null, str);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return null;
    }

    private static String O00000Oo(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (O00000Oo != null) {
                return (String) O00000Oo.invoke(null, locale2);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return locale2;
    }
}
