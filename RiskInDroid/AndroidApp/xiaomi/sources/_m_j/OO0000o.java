package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
public final class OO0000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f6703O000000o = new ThreadLocal<>();
    private static final WeakHashMap<Context, SparseArray<O000000o>> O00000Oo = new WeakHashMap<>(0);
    private static final Object O00000o0 = new Object();

    public static ColorStateList O000000o(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList O00000o = O00000o(context, i);
        if (O00000o != null) {
            return O00000o;
        }
        ColorStateList O00000o02 = O00000o0(context, i);
        if (O00000o02 == null) {
            return ContextCompat.O00000Oo(context, i);
        }
        synchronized (O00000o0) {
            SparseArray sparseArray = O00000Oo.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                O00000Oo.put(context, sparseArray);
            }
            sparseArray.append(i, new O000000o(O00000o02, context.getResources().getConfiguration()));
        }
        return O00000o02;
    }

    public static Drawable O00000Oo(Context context, int i) {
        return o0OOoOoo.O000000o().O000000o(context, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        return null;
     */
    private static ColorStateList O00000o(Context context, int i) {
        O000000o o000000o;
        synchronized (O00000o0) {
            SparseArray sparseArray = O00000Oo.get(context);
            if (!(sparseArray == null || sparseArray.size() <= 0 || (o000000o = (O000000o) sparseArray.get(i)) == null)) {
                if (o000000o.O00000Oo.equals(context.getResources().getConfiguration())) {
                    ColorStateList colorStateList = o000000o.f6704O000000o;
                    return colorStateList;
                }
                sparseArray.remove(i);
            }
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final ColorStateList f6704O000000o;
        final Configuration O00000Oo;

        O000000o(ColorStateList colorStateList, Configuration configuration) {
            this.f6704O000000o = colorStateList;
            this.O00000Oo = configuration;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.res.Resources.getValue(int, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException}
     arg types: [int, android.util.TypedValue, int]
     candidates:
      ClspMth{android.content.res.Resources.getValue(java.lang.String, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException}
      ClspMth{android.content.res.Resources.getValue(int, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException} */
    private static ColorStateList O00000o0(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue typedValue = f6703O000000o.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            f6703O000000o.set(typedValue);
        }
        boolean z = true;
        resources.getValue(i, typedValue, true);
        if (typedValue.type < 28 || typedValue.type > 31) {
            z = false;
        }
        if (z) {
            return null;
        }
        Resources resources2 = context.getResources();
        try {
            return h.O000000o(resources2, resources2.getXml(i), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }
}
