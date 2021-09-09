package _m_j;

import _m_j.j;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

public class w extends u {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final Class<?> f2567O000000o;
    protected final Constructor<?> O00000Oo;
    protected final Method O00000o;
    protected final Method O00000o0;
    protected final Method O00000oO;
    protected final Method O00000oo;
    protected final Method O0000O0o;

    public w() {
        Method method;
        Method method2;
        Method method3;
        Constructor<?> constructor;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(new Class[0]);
            method3 = cls2.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
            method2 = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
            method = cls2.getMethod("freeze", new Class[0]);
            method4 = cls2.getMethod("abortCreation", new Class[0]);
            Class<?> cls3 = cls2;
            method5 = O000000o(cls2);
            cls = cls3;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            method5 = null;
            method4 = null;
            constructor = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.f2567O000000o = cls;
        this.O00000Oo = constructor;
        this.O00000o0 = method3;
        this.O00000o = method2;
        this.O00000oO = method;
        this.O00000oo = method4;
        this.O0000O0o = method5;
    }

    private boolean O000000o() {
        if (this.O00000o0 == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.O00000o0 != null;
    }

    private Object O00000Oo() {
        try {
            return this.O00000Oo.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private boolean O000000o(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.O00000o0.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean O000000o(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.O00000o.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public Typeface O000000o(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f2567O000000o, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.O0000O0o.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    private boolean O00000Oo(Object obj) {
        try {
            return ((Boolean) this.O00000oO.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private void O00000o0(Object obj) {
        try {
            this.O00000oo.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final Typeface O000000o(Context context, j.O00000Oo o00000Oo, Resources resources, int i) {
        if (!O000000o()) {
            return super.O000000o(context, o00000Oo, resources, i);
        }
        Object O00000Oo2 = O00000Oo();
        if (O00000Oo2 == null) {
            return null;
        }
        for (j.O00000o0 o00000o0 : o00000Oo.f1687O000000o) {
            if (!O000000o(context, O00000Oo2, o00000o0.f1689O000000o, o00000o0.O00000oO, o00000o0.O00000Oo, o00000o0.O00000o0 ? 1 : 0, FontVariationAxis.fromFontVariationSettings(o00000o0.O00000o))) {
                O00000o0(O00000Oo2);
                return null;
            }
        }
        if (!O00000Oo(O00000Oo2)) {
            return null;
        }
        return O000000o(O00000Oo2);
    }

    public final Typeface O000000o(Context context, CancellationSignal cancellationSignal, FontsContractCompat.O00000Oo[] o00000OoArr, int i) {
        Typeface O000000o2;
        ParcelFileDescriptor openFileDescriptor;
        if (o00000OoArr.length <= 0) {
            return null;
        }
        if (!O000000o()) {
            FontsContractCompat.O00000Oo O000000o3 = O000000o(o00000OoArr, i);
            try {
                openFileDescriptor = context.getContentResolver().openFileDescriptor(O000000o3.f2835O000000o, "r", null);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(O000000o3.O00000o0).setItalic(O000000o3.O00000o).build();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return build;
            } catch (IOException unused) {
                return null;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            Map<Uri, ByteBuffer> O000000o4 = FontsContractCompat.O000000o(context, o00000OoArr, (CancellationSignal) null);
            Object O00000Oo2 = O00000Oo();
            if (O00000Oo2 == null) {
                return null;
            }
            boolean z = false;
            for (FontsContractCompat.O00000Oo o00000Oo : o00000OoArr) {
                ByteBuffer byteBuffer = O000000o4.get(o00000Oo.f2835O000000o);
                if (byteBuffer != null) {
                    if (!O000000o(O00000Oo2, byteBuffer, o00000Oo.O00000Oo, o00000Oo.O00000o0, o00000Oo.O00000o ? 1 : 0)) {
                        O00000o0(O00000Oo2);
                        return null;
                    }
                    z = true;
                }
            }
            if (!z) {
                O00000o0(O00000Oo2);
                return null;
            } else if (O00000Oo(O00000Oo2) && (O000000o2 = O000000o(O00000Oo2)) != null) {
                return Typeface.create(O000000o2, i);
            } else {
                return null;
            }
        }
        throw th;
    }

    public final Typeface O000000o(Context context, Resources resources, int i, String str, int i2) {
        if (!O000000o()) {
            return super.O000000o(context, resources, i, str, i2);
        }
        Object O00000Oo2 = O00000Oo();
        if (O00000Oo2 == null) {
            return null;
        }
        if (!O000000o(context, O00000Oo2, str, 0, -1, -1, null)) {
            O00000o0(O00000Oo2);
            return null;
        } else if (!O00000Oo(O00000Oo2)) {
            return null;
        } else {
            return O000000o(O00000Oo2);
        }
    }

    /* access modifiers changed from: protected */
    public Method O000000o(Class<?> cls) throws NoSuchMethodException {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
