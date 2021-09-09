package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzfd {
    private static final Logger logger = Logger.getLogger(zzfd.class.getName());
    private static final Class<?> zzfb = zzaw.zzy();
    private static final boolean zzfy = zzeg();
    private static final Unsafe zzmh = zzef();
    private static final boolean zzpg = zzi(Long.TYPE);
    private static final boolean zzph = zzi(Integer.TYPE);
    private static final zzd zzpi;
    private static final boolean zzpj = zzeh();
    /* access modifiers changed from: private */
    public static final long zzpk = ((long) zzg(byte[].class));
    private static final long zzpl = ((long) zzg(boolean[].class));
    private static final long zzpm = ((long) zzh(boolean[].class));
    private static final long zzpn = ((long) zzg(int[].class));
    private static final long zzpo = ((long) zzh(int[].class));
    private static final long zzpp = ((long) zzg(long[].class));
    private static final long zzpq = ((long) zzh(long[].class));
    private static final long zzpr = ((long) zzg(float[].class));
    private static final long zzps = ((long) zzh(float[].class));
    private static final long zzpt = ((long) zzg(double[].class));
    private static final long zzpu = ((long) zzh(double[].class));
    private static final long zzpv = ((long) zzg(Object[].class));
    private static final long zzpw = ((long) zzh(Object[].class));
    private static final long zzpx = zzb(zzei());
    private static final long zzpy;
    /* access modifiers changed from: private */
    public static final boolean zzpz = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            Memory.pokeByte((int) (j & -1), b);
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzfd.zzpz) {
                zzfd.zzb(obj, j, z);
            } else {
                zzfd.zzc(obj, j, z);
            }
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (j2 & -1), bArr, (int) j, (int) j3);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzfd.zzpz) {
                zzfd.zza(obj, j, b);
            } else {
                zzfd.zzb(obj, j, b);
            }
        }

        public final boolean zzl(Object obj, long j) {
            return zzfd.zzpz ? zzfd.zzr(obj, j) : zzfd.zzs(obj, j);
        }

        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        public final byte zzx(Object obj, long j) {
            return zzfd.zzpz ? zzfd.zzp(obj, j) : zzfd.zzq(obj, j);
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzfd.zzpz) {
                zzfd.zzb(obj, j, z);
            } else {
                zzfd.zzc(obj, j, z);
            }
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzfd.zzpz) {
                zzfd.zza(obj, j, b);
            } else {
                zzfd.zzb(obj, j, b);
            }
        }

        public final boolean zzl(Object obj, long j) {
            return zzfd.zzpz ? zzfd.zzr(obj, j) : zzfd.zzs(obj, j);
        }

        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        public final byte zzx(Object obj, long j) {
            return zzfd.zzpz ? zzfd.zzp(obj, j) : zzfd.zzq(obj, j);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            this.zzqa.putByte(j, b);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzqa.putDouble(obj, j, d);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzqa.putFloat(obj, j, f);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzqa.putBoolean(obj, j, z);
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            this.zzqa.copyMemory(bArr, zzfd.zzpk + j, (Object) null, j2, j3);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzqa.putByte(obj, j, b);
        }

        public final boolean zzl(Object obj, long j) {
            return this.zzqa.getBoolean(obj, j);
        }

        public final float zzm(Object obj, long j) {
            return this.zzqa.getFloat(obj, j);
        }

        public final double zzn(Object obj, long j) {
            return this.zzqa.getDouble(obj, j);
        }

        public final byte zzx(Object obj, long j) {
            return this.zzqa.getByte(obj, j);
        }
    }

    static abstract class zzd {
        Unsafe zzqa;

        zzd(Unsafe unsafe) {
            this.zzqa = unsafe;
        }

        public final long zza(Field field) {
            return this.zzqa.objectFieldOffset(field);
        }

        public abstract void zza(long j, byte b);

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public final void zza(Object obj, long j, int i) {
            this.zzqa.putInt(obj, j, i);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzqa.putLong(obj, j, j2);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zza(byte[] bArr, long j, long j2, long j3);

        public abstract void zze(Object obj, long j, byte b);

        public final int zzj(Object obj, long j) {
            return this.zzqa.getInt(obj, j);
        }

        public final long zzk(Object obj, long j) {
            return this.zzqa.getLong(obj, j);
        }

        public abstract boolean zzl(Object obj, long j);

        public abstract float zzm(Object obj, long j);

        public abstract double zzn(Object obj, long j);

        public abstract byte zzx(Object obj, long j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0105  */
    static {
        zzd zzd2;
        Field zzb2;
        if (zzmh != null) {
            if (!zzaw.zzx()) {
                zzd2 = new zzc(zzmh);
            } else if (zzpg) {
                zzd2 = new zzb(zzmh);
            } else if (zzph) {
                zzd2 = new zza(zzmh);
            }
            zzpi = zzd2;
            zzb2 = zzb(String.class, "value");
            if (zzb2 == null || zzb2.getType() != char[].class) {
                zzb2 = null;
            }
            zzpy = zzb(zzb2);
        }
        zzd2 = null;
        zzpi = zzd2;
        zzb2 = zzb(String.class, "value");
        zzb2 = null;
        zzpy = zzb(zzb2);
    }

    private zzfd() {
    }

    static byte zza(byte[] bArr, long j) {
        return zzpi.zzx(bArr, zzpk + j);
    }

    static long zza(Field field) {
        return zzpi.zza(field);
    }

    static void zza(long j, byte b) {
        zzpi.zza(j, b);
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = ((((int) j) ^ -1) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzj(obj, j2) & ((255 << i) ^ -1)));
    }

    static void zza(Object obj, long j, double d) {
        zzpi.zza(obj, j, d);
    }

    static void zza(Object obj, long j, float f) {
        zzpi.zza(obj, j, f);
    }

    static void zza(Object obj, long j, int i) {
        zzpi.zza(obj, j, i);
    }

    static void zza(Object obj, long j, long j2) {
        zzpi.zza(obj, j, j2);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzpi.zzqa.putObject(obj, j, obj2);
    }

    static void zza(Object obj, long j, boolean z) {
        zzpi.zza(obj, j, z);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzpi.zze(bArr, zzpk + j, b);
    }

    static void zza(byte[] bArr, long j, long j2, long j3) {
        zzpi.zza(bArr, j, j2, j3);
    }

    private static long zzb(Field field) {
        zzd zzd2;
        if (field == null || (zzd2 = zzpi) == null) {
            return -1;
        }
        return zzd2.zza(field);
    }

    static long zzb(ByteBuffer byteBuffer) {
        return zzpi.zzk(byteBuffer, zzpx);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzj(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    static boolean zzed() {
        return zzfy;
    }

    static boolean zzee() {
        return zzpj;
    }

    static Unsafe zzef() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzfe());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzeg() {
        Unsafe unsafe = zzmh;
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
            if (zzaw.zzx()) {
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

    private static boolean zzeh() {
        Unsafe unsafe = zzmh;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (zzei() == null) {
                return false;
            }
            if (zzaw.zzx()) {
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

    private static Field zzei() {
        Field zzb2;
        if (zzaw.zzx() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    private static int zzg(Class<?> cls) {
        if (zzfy) {
            return zzpi.zzqa.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzh(Class<?> cls) {
        if (zzfy) {
            return zzpi.zzqa.arrayIndexScale(cls);
        }
        return -1;
    }

    private static boolean zzi(Class<?> cls) {
        if (!zzaw.zzx()) {
            return false;
        }
        try {
            Class<?> cls2 = zzfb;
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

    static int zzj(Object obj, long j) {
        return zzpi.zzj(obj, j);
    }

    static long zzk(Object obj, long j) {
        return zzpi.zzk(obj, j);
    }

    static boolean zzl(Object obj, long j) {
        return zzpi.zzl(obj, j);
    }

    static float zzm(Object obj, long j) {
        return zzpi.zzm(obj, j);
    }

    static double zzn(Object obj, long j) {
        return zzpi.zzn(obj, j);
    }

    static Object zzo(Object obj, long j) {
        return zzpi.zzqa.getObject(obj, j);
    }

    /* access modifiers changed from: private */
    public static byte zzp(Object obj, long j) {
        return (byte) (zzj(obj, -4 & j) >>> ((int) (((j ^ -1) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzj(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static boolean zzr(Object obj, long j) {
        return zzp(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }
}
