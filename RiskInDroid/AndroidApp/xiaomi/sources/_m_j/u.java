package _m_j;

import _m_j.j;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class u extends z {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Class<?> f2522O000000o = null;
    private static Constructor<?> O00000Oo = null;
    private static Method O00000o = null;
    private static Method O00000o0 = null;
    private static boolean O00000oO = false;

    u() {
    }

    private static void O000000o() {
        Method method;
        Class<?> cls;
        Method method2;
        if (!O00000oO) {
            O00000oO = true;
            Constructor<?> constructor = null;
            try {
                cls = Class.forName("android.graphics.FontFamily");
                Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
                method = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
                method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
                constructor = constructor2;
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                Log.e("TypefaceCompatApi21Impl", e.getClass().getName(), e);
                method2 = null;
                cls = null;
                method = null;
            }
            O00000Oo = constructor;
            f2522O000000o = cls;
            O00000o0 = method;
            O00000o = method2;
        }
    }

    private static File O000000o(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static Object O00000Oo() {
        O000000o();
        try {
            return O00000Oo.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static Typeface O000000o(Object obj) {
        O000000o();
        try {
            Object newInstance = Array.newInstance(f2522O000000o, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) O00000o.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean O000000o(Object obj, String str, int i, boolean z) {
        O000000o();
        try {
            return ((Boolean) O00000o0.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public Typeface O000000o(Context context, CancellationSignal cancellationSignal, FontsContractCompat.O00000Oo[] o00000OoArr, int i) {
        FileInputStream fileInputStream;
        if (o00000OoArr.length <= 0) {
            return null;
        }
        FontsContractCompat.O00000Oo O000000o2 = O000000o(o00000OoArr, i);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(O000000o2.f2835O000000o, "r", null);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                File O000000o3 = O000000o(openFileDescriptor);
                if (O000000o3 != null) {
                    if (O000000o3.canRead()) {
                        Typeface createFromFile = Typeface.createFromFile(O000000o3);
                        if (openFileDescriptor != null) {
                            openFileDescriptor.close();
                        }
                        return createFromFile;
                    }
                }
                fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                Typeface O000000o4 = super.O000000o(context, fileInputStream);
                fileInputStream.close();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return O000000o4;
            } catch (Throwable th) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                throw th;
            }
        } catch (IOException unused) {
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public Typeface O000000o(Context context, j.O00000Oo o00000Oo, Resources resources, int i) {
        Object O00000Oo2 = O00000Oo();
        j.O00000o0[] o00000o0Arr = o00000Oo.f1687O000000o;
        int length = o00000o0Arr.length;
        int i2 = 0;
        while (i2 < length) {
            j.O00000o0 o00000o0 = o00000o0Arr[i2];
            File O000000o2 = aa.O000000o(context);
            if (O000000o2 == null) {
                return null;
            }
            try {
                if (!aa.O000000o(O000000o2, resources, o00000o0.O00000oo)) {
                    O000000o2.delete();
                    return null;
                } else if (!O000000o(O00000Oo2, O000000o2.getPath(), o00000o0.O00000Oo, o00000o0.O00000o0)) {
                    return null;
                } else {
                    O000000o2.delete();
                    i2++;
                }
            } catch (RuntimeException unused) {
                return null;
            } finally {
                O000000o2.delete();
            }
        }
        return O000000o(O00000Oo2);
    }
}
