package _m_j;

import _m_j.j;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

public final class m {
    public static Drawable O000000o(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i, theme);
        }
        return resources.getDrawable(i);
    }

    public static Typeface O000000o(Context context, int i) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return O000000o(context, i, new TypedValue(), 0, null, null, false);
    }

    public static abstract class O000000o {
        public abstract void onFontRetrievalFailed(int i);

        public abstract void onFontRetrieved(Typeface typeface);

        public final void callbackSuccessAsync(final Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                /* class _m_j.m.O000000o.AnonymousClass1 */

                public final void run() {
                    O000000o.this.onFontRetrieved(typeface);
                }
            });
        }

        public final void callbackFailAsync(final int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                /* class _m_j.m.O000000o.AnonymousClass2 */

                public final void run() {
                    O000000o.this.onFontRetrievalFailed(i);
                }
            });
        }
    }

    public static Typeface O000000o(Context context, int i, TypedValue typedValue, int i2, O000000o o000000o) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return O000000o(context, i, typedValue, i2, o000000o, null, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.res.Resources.getValue(int, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException}
     arg types: [int, android.util.TypedValue, int]
     candidates:
      ClspMth{android.content.res.Resources.getValue(java.lang.String, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException}
      ClspMth{android.content.res.Resources.getValue(int, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException} */
    public static Typeface O000000o(Context context, int i, TypedValue typedValue, int i2, O000000o o000000o, Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface O000000o2 = O000000o(context, resources, typedValue, i, i2, o000000o, null, z);
        if (O000000o2 != null || o000000o != null) {
            return O000000o2;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0097  */
    private static Typeface O000000o(Context context, Resources resources, TypedValue typedValue, int i, int i2, O000000o o000000o, Handler handler, boolean z) {
        Resources resources2 = resources;
        TypedValue typedValue2 = typedValue;
        int i3 = i;
        int i4 = i2;
        O000000o o000000o2 = o000000o;
        Handler handler2 = handler;
        if (typedValue2.string != null) {
            String charSequence = typedValue2.string.toString();
            if (!charSequence.startsWith("res/")) {
                if (o000000o2 != null) {
                    o000000o2.callbackFailAsync(-3, handler2);
                }
                return null;
            }
            Typeface O000000o2 = t.O000000o(resources2, i3, i4);
            if (O000000o2 != null) {
                if (o000000o2 != null) {
                    o000000o2.callbackSuccessAsync(O000000o2, handler2);
                }
                return O000000o2;
            }
            try {
                if (charSequence.toLowerCase().endsWith(".xml")) {
                    j.O000000o O000000o3 = j.O000000o(resources2.getXml(i3), resources2);
                    if (O000000o3 != null) {
                        return t.O000000o(context, O000000o3, resources, i, i2, o000000o, handler, z);
                    }
                    Log.e("ResourcesCompat", "Failed to find font-family tag");
                    if (o000000o2 != null) {
                        o000000o2.callbackFailAsync(-3, handler2);
                    }
                    return null;
                }
                Context context2 = context;
                Typeface O000000o4 = t.O000000o(context, resources2, i3, charSequence, i4);
                if (o000000o2 != null) {
                    if (O000000o4 != null) {
                        o000000o2.callbackSuccessAsync(O000000o4, handler2);
                    } else {
                        o000000o2.callbackFailAsync(-3, handler2);
                    }
                }
                return O000000o4;
            } catch (XmlPullParserException e) {
                Log.e("ResourcesCompat", "Failed to parse xml resource ".concat(String.valueOf(charSequence)), e);
                if (o000000o2 != null) {
                    o000000o2.callbackFailAsync(-3, handler2);
                }
                return null;
            } catch (IOException e2) {
                Log.e("ResourcesCompat", "Failed to read xml resource ".concat(String.valueOf(charSequence)), e2);
                if (o000000o2 != null) {
                }
                return null;
            }
        } else {
            throw new Resources.NotFoundException("Resource \"" + resources2.getResourceName(i3) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue2);
        }
    }

    public static final class O00000Oo {

        public static class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            private static final Object f2178O000000o = new Object();
            private static Method O00000Oo;
            private static boolean O00000o0;

            public static void O000000o(Resources.Theme theme) {
                synchronized (f2178O000000o) {
                    if (!O00000o0) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            O00000Oo = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e);
                        }
                        O00000o0 = true;
                    }
                    if (O00000Oo != null) {
                        try {
                            O00000Oo.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e2) {
                            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e2);
                            O00000Oo = null;
                        }
                    }
                }
            }
        }
    }
}
