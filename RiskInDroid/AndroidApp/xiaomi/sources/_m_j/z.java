package _m_j;

import _m_j.j;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

class z {
    ConcurrentHashMap<Long, j.O00000Oo> O0000OOo = new ConcurrentHashMap<>();

    interface O000000o<T> {
        boolean O000000o(T t);

        int O00000Oo(T t);
    }

    z() {
    }

    private static <T> T O000000o(T[] tArr, int i, O000000o<T> o000000o) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(o000000o.O00000Oo(t2) - i2) * 2) + (o000000o.O000000o(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    static long O000000o(Typeface typeface) {
        if (typeface == null) {
            return 0;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (NoSuchFieldException e) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e);
            return 0;
        } catch (IllegalAccessException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public FontsContractCompat.O00000Oo O000000o(FontsContractCompat.O00000Oo[] o00000OoArr, int i) {
        return (FontsContractCompat.O00000Oo) O000000o(o00000OoArr, i, new O000000o<FontsContractCompat.O00000Oo>() {
            /* class _m_j.z.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ boolean O000000o(Object obj) {
                return ((FontsContractCompat.O00000Oo) obj).O00000o;
            }

            public final /* bridge */ /* synthetic */ int O00000Oo(Object obj) {
                return ((FontsContractCompat.O00000Oo) obj).O00000o0;
            }
        });
    }

    /* access modifiers changed from: protected */
    public Typeface O000000o(Context context, InputStream inputStream) {
        File O000000o2 = aa.O000000o(context);
        if (O000000o2 == null) {
            return null;
        }
        try {
            if (!aa.O000000o(O000000o2, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(O000000o2.getPath());
            O000000o2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            O000000o2.delete();
        }
    }

    public Typeface O000000o(Context context, CancellationSignal cancellationSignal, FontsContractCompat.O00000Oo[] o00000OoArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (o00000OoArr.length <= 0) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(O000000o(o00000OoArr, i).f2835O000000o);
            try {
                Typeface O000000o2 = O000000o(context, inputStream);
                aa.O000000o(inputStream);
                return O000000o2;
            } catch (IOException unused) {
                aa.O000000o(inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                aa.O000000o(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            aa.O000000o(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            aa.O000000o(inputStream2);
            throw th;
        }
    }

    public Typeface O000000o(Context context, Resources resources, int i, String str, int i2) {
        File O000000o2 = aa.O000000o(context);
        if (O000000o2 == null) {
            return null;
        }
        try {
            if (!aa.O000000o(O000000o2, resources, i)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(O000000o2.getPath());
            O000000o2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            O000000o2.delete();
        }
    }

    public Typeface O000000o(Context context, j.O00000Oo o00000Oo, Resources resources, int i) {
        j.O00000o0 o00000o0 = (j.O00000o0) O000000o(o00000Oo.f1687O000000o, i, new O000000o<j.O00000o0>() {
            /* class _m_j.z.AnonymousClass2 */

            public final /* bridge */ /* synthetic */ boolean O000000o(Object obj) {
                return ((j.O00000o0) obj).O00000o0;
            }

            public final /* bridge */ /* synthetic */ int O00000Oo(Object obj) {
                return ((j.O00000o0) obj).O00000Oo;
            }
        });
        if (o00000o0 == null) {
            return null;
        }
        Typeface O000000o2 = t.O000000o(context, resources, o00000o0.O00000oo, o00000o0.f1689O000000o, i);
        long O000000o3 = O000000o(O000000o2);
        if (O000000o3 != 0) {
            this.O0000OOo.put(Long.valueOf(O000000o3), o00000Oo);
        }
        return O000000o2;
    }
}
