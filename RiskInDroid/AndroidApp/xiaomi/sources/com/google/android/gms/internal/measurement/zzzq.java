package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzzq;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzzq<MessageType extends zzzq<MessageType, BuilderType>, BuilderType> extends zzyu<MessageType, BuilderType> {
    private static Map<Object, zzzq<?, ?>> zzbsa = new ConcurrentHashMap();
    protected zzabk zzbry = zzabk.zzuq();
    private int zzbrz = -1;

    public static abstract class zza<MessageType extends zza<MessageType, BuilderType>, BuilderType> extends zzzq<MessageType, BuilderType> implements zzaam {
        protected zzzm<Object> zzbsb = zzzm.zzti();
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class zzb {
        private static final int zzbsc = 1;
        private static final int zzbsd = 2;
        public static final int zzbse = 3;
        private static final int zzbsf = 4;
        private static final int zzbsg = 5;
        public static final int zzbsh = 6;
        public static final int zzbsi = 7;
        private static final /* synthetic */ int[] zzbsj = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzbsk = 1;
        private static final int zzbsl = 2;
        private static final /* synthetic */ int[] zzbsm = {1, 2};
        private static final int zzbsn = 1;
        private static final int zzbso = 2;
        private static final /* synthetic */ int[] zzbsp = {1, 2};
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    static <T extends zzzq<?, ?>> T zzf(Class<T> cls) {
        T t = (zzzq) zzbsa.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzzq) zzbsa.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t != null) {
            return t;
        }
        String valueOf = String.valueOf(cls.getName());
        throw new IllegalStateException(valueOf.length() != 0 ? "Unable to get default instance for: ".concat(valueOf) : new String("Unable to get default instance for: "));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzzq) zza(6, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzaat.zzud().zzt(this).equals(this, (zzzq) obj);
    }

    public int hashCode() {
        if (this.zzbqt != 0) {
            return this.zzbqt;
        }
        this.zzbqt = zzaat.zzud().zzt(this).hashCode(this);
        return this.zzbqt;
    }

    public String toString() {
        return zzaan.zza(this, super.toString());
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);
}
