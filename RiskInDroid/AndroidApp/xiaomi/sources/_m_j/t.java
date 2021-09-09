package _m_j;

import _m_j.j;
import _m_j.m;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.provider.FontsContractCompat;

@SuppressLint({"NewApi"})
public final class t {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final z f2485O000000o;
    private static final o0oOo0O0<String, Typeface> O00000Oo = new o0oOo0O0<>(16);

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f2485O000000o = new y();
        } else if (Build.VERSION.SDK_INT >= 28) {
            f2485O000000o = new x();
        } else if (Build.VERSION.SDK_INT >= 26) {
            f2485O000000o = new w();
        } else if (Build.VERSION.SDK_INT >= 24 && v.O000000o()) {
            f2485O000000o = new v();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f2485O000000o = new u();
        } else {
            f2485O000000o = new z();
        }
    }

    public static Typeface O000000o(Resources resources, int i, int i2) {
        return O00000Oo.get(O00000Oo(resources, i, i2));
    }

    private static String O00000Oo(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface O000000o(Context context, j.O000000o o000000o, Resources resources, int i, int i2, m.O000000o o000000o2, Handler handler, boolean z) {
        Typeface typeface;
        int i3;
        if (o000000o instanceof j.O00000o) {
            j.O00000o o00000o = (j.O00000o) o000000o;
            boolean z2 = false;
            if (!z ? o000000o2 == null : o00000o.O00000o0 == 0) {
                z2 = true;
            }
            if (z) {
                i3 = o00000o.O00000Oo;
            } else {
                i3 = -1;
            }
            typeface = FontsContractCompat.O000000o(context, o00000o.f1688O000000o, o000000o2, handler, z2, i3, i2);
        } else {
            typeface = f2485O000000o.O000000o(context, (j.O00000Oo) o000000o, resources, i2);
            if (o000000o2 != null) {
                if (typeface != null) {
                    o000000o2.callbackSuccessAsync(typeface, handler);
                } else {
                    o000000o2.callbackFailAsync(-3, handler);
                }
            }
        }
        if (typeface != null) {
            O00000Oo.put(O00000Oo(resources, i, i2), typeface);
        }
        return typeface;
    }

    public static Typeface O000000o(Context context, Resources resources, int i, String str, int i2) {
        Typeface O000000o2 = f2485O000000o.O000000o(context, resources, i, str, i2);
        if (O000000o2 != null) {
            O00000Oo.put(O00000Oo(resources, i, i2), O000000o2);
        }
        return O000000o2;
    }

    public static Typeface O000000o(Context context, FontsContractCompat.O00000Oo[] o00000OoArr, int i) {
        return f2485O000000o.O000000o(context, (CancellationSignal) null, o00000OoArr, i);
    }

    public static Typeface O000000o(Context context, Typeface typeface, int i) {
        j.O00000Oo o00000Oo;
        if (context != null) {
            if (Build.VERSION.SDK_INT < 21) {
                z zVar = f2485O000000o;
                long O000000o2 = z.O000000o(typeface);
                Typeface typeface2 = null;
                if (O000000o2 == 0) {
                    o00000Oo = null;
                } else {
                    o00000Oo = zVar.O0000OOo.get(Long.valueOf(O000000o2));
                }
                if (o00000Oo != null) {
                    typeface2 = f2485O000000o.O000000o(context, o00000Oo, context.getResources(), i);
                }
                if (typeface2 != null) {
                    return typeface2;
                }
            }
            return Typeface.create(typeface, i);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }
}
