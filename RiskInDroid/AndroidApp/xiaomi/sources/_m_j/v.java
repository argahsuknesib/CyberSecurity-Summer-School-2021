package _m_j;

import _m_j.j;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.provider.FontsContractCompat;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

final class v extends z {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Class<?> f2546O000000o;
    private static final Constructor<?> O00000Oo;
    private static final Method O00000o;
    private static final Method O00000o0;

    v() {
    }

    static {
        Method method;
        Method method2;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method2 = null;
            method = null;
        }
        O00000Oo = constructor;
        f2546O000000o = cls;
        O00000o0 = method;
        O00000o = method2;
    }

    public static boolean O000000o() {
        if (O00000o0 == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return O00000o0 != null;
    }

    private static Object O00000Oo() {
        try {
            return O00000Oo.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static boolean O000000o(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) O00000o0.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface O000000o(Object obj) {
        try {
            Object newInstance = Array.newInstance(f2546O000000o, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) O00000o.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final Typeface O000000o(Context context, CancellationSignal cancellationSignal, FontsContractCompat.O00000Oo[] o00000OoArr, int i) {
        Object O00000Oo2 = O00000Oo();
        if (O00000Oo2 == null) {
            return null;
        }
        o0OO00OO o0oo00oo = new o0OO00OO();
        for (FontsContractCompat.O00000Oo o00000Oo : o00000OoArr) {
            Uri uri = o00000Oo.f2835O000000o;
            ByteBuffer byteBuffer = (ByteBuffer) o0oo00oo.get(uri);
            if (byteBuffer == null) {
                byteBuffer = aa.O000000o(context, (CancellationSignal) null, uri);
                o0oo00oo.put(uri, byteBuffer);
            }
            if (byteBuffer == null || !O000000o(O00000Oo2, byteBuffer, o00000Oo.O00000Oo, o00000Oo.O00000o0, o00000Oo.O00000o)) {
                return null;
            }
        }
        Typeface O000000o2 = O000000o(O00000Oo2);
        if (O000000o2 == null) {
            return null;
        }
        return Typeface.create(O000000o2, i);
    }

    public final Typeface O000000o(Context context, j.O00000Oo o00000Oo, Resources resources, int i) {
        Object O00000Oo2 = O00000Oo();
        if (O00000Oo2 == null) {
            return null;
        }
        for (j.O00000o0 o00000o0 : o00000Oo.f1687O000000o) {
            ByteBuffer O000000o2 = aa.O000000o(context, resources, o00000o0.O00000oo);
            if (O000000o2 == null || !O000000o(O00000Oo2, O000000o2, o00000o0.O00000oO, o00000o0.O00000Oo, o00000o0.O00000o0)) {
                return null;
            }
        }
        return O000000o(O00000Oo2);
    }
}
