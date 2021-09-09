package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzabm {
    private static final Logger logger = Logger.getLogger(zzabm.class.getName());
    private static final Class<?> zzbqv = zzyv.zzsw();
    private static final Unsafe zzbtj = zzur();
    private static final boolean zzbun = zzk(Long.TYPE);
    private static final boolean zzbuo = zzk(Integer.TYPE);
    private static final zzd zzbup;
    private static final boolean zzbuq = zzut();
    private static final boolean zzbur = zzus();
    private static final long zzbus = ((long) zzi(byte[].class));
    private static final long zzbut = ((long) zzi(boolean[].class));
    private static final long zzbuu = ((long) zzj(boolean[].class));
    private static final long zzbuv = ((long) zzi(int[].class));
    private static final long zzbuw = ((long) zzj(int[].class));
    private static final long zzbux = ((long) zzi(long[].class));
    private static final long zzbuy = ((long) zzj(long[].class));
    private static final long zzbuz = ((long) zzi(float[].class));
    private static final long zzbva = ((long) zzj(float[].class));
    private static final long zzbvb = ((long) zzi(double[].class));
    private static final long zzbvc = ((long) zzj(double[].class));
    private static final long zzbvd = ((long) zzi(Object[].class));
    private static final long zzbve = ((long) zzj(Object[].class));
    private static final long zzbvf = zza(zzuu());
    private static final long zzbvg;
    private static final boolean zzbvh = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }
    }

    static abstract class zzd {
        Unsafe zzbvi;

        zzd(Unsafe unsafe) {
            this.zzbvi = unsafe;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0105  */
    static {
        zzd zzd2;
        Field zza2;
        if (zzbtj != null) {
            if (!zzyv.zzsv()) {
                zzd2 = new zzc(zzbtj);
            } else if (zzbun) {
                zzd2 = new zzb(zzbtj);
            } else if (zzbuo) {
                zzd2 = new zza(zzbtj);
            }
            zzbup = zzd2;
            zza2 = zza(String.class, "value");
            if (zza2 == null || zza2.getType() != char[].class) {
                zza2 = null;
            }
            zzbvg = zza(zza2);
        }
        zzd2 = null;
        zzbup = zzd2;
        zza2 = zza(String.class, "value");
        zza2 = null;
        zzbvg = zza(zza2);
    }

    private zzabm() {
    }

    private static long zza(Field field) {
        zzd zzd2;
        if (field == null || (zzd2 = zzbup) == null) {
            return -1;
        }
        return zzd2.zzbvi.objectFieldOffset(field);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static int zzi(Class<?> cls) {
        if (zzbur) {
            return zzbup.zzbvi.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzj(Class<?> cls) {
        if (zzbur) {
            return zzbup.zzbvi.arrayIndexScale(cls);
        }
        return -1;
    }

    private static boolean zzk(Class<?> cls) {
        if (!zzyv.zzsv()) {
            return false;
        }
        try {
            Class<?> cls2 = zzbqv;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static Unsafe zzur() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzabn());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzus() {
        Unsafe unsafe = zzbtj;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (zzyv.zzsv()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzut() {
        Unsafe unsafe = zzbtj;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (zzuu() == null) {
                return false;
            }
            if (zzyv.zzsv()) {
                return true;
            }
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getInt", Long.TYPE);
            cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            cls.getMethod("putLong", Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static Field zzuu() {
        Field zza2;
        if (zzyv.zzsv() && (zza2 = zza(Buffer.class, "effectiveDirectAddress")) != null) {
            return zza2;
        }
        Field zza3 = zza(Buffer.class, "address");
        if (zza3 == null || zza3.getType() != Long.TYPE) {
            return null;
        }
        return zza3;
    }
}
