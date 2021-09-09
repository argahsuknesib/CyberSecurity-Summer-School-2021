package androidx.versionedparcelable;

import _m_j.jy;
import _m_j.o0O0OOO0;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class VersionedParcel {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final o0O0OOO0<String, Method> f3026O000000o;
    protected final o0O0OOO0<String, Method> O00000Oo;
    protected final o0O0OOO0<String, Class> O00000o0;

    /* access modifiers changed from: protected */
    public abstract void O000000o();

    /* access modifiers changed from: protected */
    public abstract void O000000o(int i);

    /* access modifiers changed from: protected */
    public abstract void O000000o(Parcelable parcelable);

    /* access modifiers changed from: protected */
    public abstract void O000000o(CharSequence charSequence);

    /* access modifiers changed from: protected */
    public abstract void O000000o(String str);

    /* access modifiers changed from: protected */
    public abstract void O000000o(boolean z);

    /* access modifiers changed from: protected */
    public abstract void O000000o(byte[] bArr);

    /* access modifiers changed from: protected */
    public abstract VersionedParcel O00000Oo();

    /* access modifiers changed from: protected */
    public abstract boolean O00000Oo(int i);

    /* access modifiers changed from: protected */
    public abstract String O00000o();

    /* access modifiers changed from: protected */
    public abstract int O00000o0();

    /* access modifiers changed from: protected */
    public abstract void O00000o0(int i);

    /* access modifiers changed from: protected */
    public abstract byte[] O00000oO();

    /* access modifiers changed from: protected */
    public abstract CharSequence O00000oo();

    /* access modifiers changed from: protected */
    public abstract <T extends Parcelable> T O0000O0o();

    /* access modifiers changed from: protected */
    public abstract boolean O0000OOo();

    public VersionedParcel(o0O0OOO0<String, Method> o0o0ooo0, o0O0OOO0<String, Method> o0o0ooo02, o0O0OOO0<String, Class> o0o0ooo03) {
        this.f3026O000000o = o0o0ooo0;
        this.O00000Oo = o0o0ooo02;
        this.O00000o0 = o0o0ooo03;
    }

    public final void O000000o(boolean z, int i) {
        O00000o0(i);
        O000000o(z);
    }

    public final void O00000Oo(byte[] bArr) {
        O00000o0(2);
        O000000o(bArr);
    }

    public final void O000000o(CharSequence charSequence, int i) {
        O00000o0(i);
        O000000o(charSequence);
    }

    public final void O000000o(int i, int i2) {
        O00000o0(i2);
        O000000o(i);
    }

    public final void O00000Oo(String str) {
        O00000o0(7);
        O000000o(str);
    }

    public final void O000000o(Parcelable parcelable, int i) {
        O00000o0(i);
        O000000o(parcelable);
    }

    public final boolean O00000Oo(boolean z, int i) {
        if (!O00000Oo(i)) {
            return z;
        }
        return O0000OOo();
    }

    public final int O00000Oo(int i, int i2) {
        if (!O00000Oo(i2)) {
            return i;
        }
        return O00000o0();
    }

    public final String O00000o0(String str) {
        if (!O00000Oo(7)) {
            return str;
        }
        return O00000o();
    }

    public final byte[] O00000o0(byte[] bArr) {
        if (!O00000Oo(2)) {
            return bArr;
        }
        return O00000oO();
    }

    public final <T extends Parcelable> T O00000Oo(T t, int i) {
        if (!O00000Oo(i)) {
            return t;
        }
        return O0000O0o();
    }

    public final CharSequence O00000Oo(CharSequence charSequence, int i) {
        if (!O00000Oo(i)) {
            return charSequence;
        }
        return O00000oo();
    }

    public final void O000000o(jy jyVar) {
        O00000o0(1);
        O00000Oo(jyVar);
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(jy jyVar) {
        if (jyVar == null) {
            O000000o((String) null);
            return;
        }
        O00000o(jyVar);
        VersionedParcel O00000Oo2 = O00000Oo();
        O000000o(jyVar, O00000Oo2);
        O00000Oo2.O000000o();
    }

    private void O00000o(jy jyVar) {
        try {
            O000000o(O00000Oo((Class<? extends jy>) jyVar.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(jyVar.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    public final <T extends jy> T O00000o0(T t) {
        if (!O00000Oo(1)) {
            return t;
        }
        return O0000Oo0();
    }

    /* access modifiers changed from: protected */
    public final <T extends jy> T O0000Oo0() {
        String O00000o = O00000o();
        if (O00000o == null) {
            return null;
        }
        return O000000o(O00000o, O00000Oo());
    }

    private <T extends jy> void O000000o(T t, VersionedParcel versionedParcel) {
        try {
            O000000o(t.getClass()).invoke(null, t, versionedParcel);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        }
    }

    private Method O000000o(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.O00000Oo.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class O00000Oo2 = O00000Oo(cls);
        System.currentTimeMillis();
        Method declaredMethod = O00000Oo2.getDeclaredMethod("write", cls, VersionedParcel.class);
        this.O00000Oo.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    private Class O00000Oo(Class<? extends jy> cls) throws ClassNotFoundException {
        Class cls2 = this.O00000o0.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.O00000o0.put(cls.getName(), cls3);
        return cls3;
    }

    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th) {
            super(th);
        }
    }

    private <T extends jy> T O000000o(String str, VersionedParcel versionedParcel) {
        try {
            Method method = this.f3026O000000o.get(str);
            if (method == null) {
                System.currentTimeMillis();
                method = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
                this.f3026O000000o.put(str, method);
            }
            return (jy) method.invoke(null, versionedParcel);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        }
    }
}
