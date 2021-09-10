package com.google.android.gms.internal.measurement;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public class zzabp extends Enum<zzabp> {
    public static final zzabp zzbvj = new zzabp("DOUBLE", 0, zzabu.DOUBLE, 1);
    public static final zzabp zzbvk = new zzabp("FLOAT", 1, zzabu.FLOAT, 5);
    public static final zzabp zzbvl = new zzabp("INT64", 2, zzabu.LONG, 0);
    public static final zzabp zzbvm = new zzabp("UINT64", 3, zzabu.LONG, 0);
    public static final zzabp zzbvn = new zzabp("INT32", 4, zzabu.INT, 0);
    public static final zzabp zzbvo = new zzabp("FIXED64", 5, zzabu.LONG, 1);
    public static final zzabp zzbvp = new zzabp("FIXED32", 6, zzabu.INT, 5);
    public static final zzabp zzbvq = new zzabp("BOOL", 7, zzabu.BOOLEAN, 0);
    public static final zzabp zzbvr = new zzabq("STRING", 8, zzabu.STRING, 2);
    public static final zzabp zzbvs = new zzabr("GROUP", 9, zzabu.MESSAGE, 3);
    public static final zzabp zzbvt = new zzabs("MESSAGE", 10, zzabu.MESSAGE, 2);
    public static final zzabp zzbvu = new zzabt("BYTES", 11, zzabu.BYTE_STRING, 2);
    public static final zzabp zzbvv = new zzabp("UINT32", 12, zzabu.INT, 0);
    public static final zzabp zzbvw = new zzabp("ENUM", 13, zzabu.ENUM, 0);
    public static final zzabp zzbvx = new zzabp("SFIXED32", 14, zzabu.INT, 5);
    public static final zzabp zzbvy = new zzabp("SFIXED64", 15, zzabu.LONG, 1);
    public static final zzabp zzbvz = new zzabp("SINT32", 16, zzabu.INT, 0);
    public static final zzabp zzbwa = new zzabp("SINT64", 17, zzabu.LONG, 0);
    private static final /* synthetic */ zzabp[] zzbwd = {zzbvj, zzbvk, zzbvl, zzbvm, zzbvn, zzbvo, zzbvp, zzbvq, zzbvr, zzbvs, zzbvt, zzbvu, zzbvv, zzbvw, zzbvx, zzbvy, zzbvz, zzbwa};
    private final zzabu zzbwb;
    private final int zzbwc;

    private zzabp(String str, int i, zzabu zzabu, int i2) {
        this.zzbwb = zzabu;
        this.zzbwc = i2;
    }

    /* synthetic */ zzabp(String str, int i, zzabu zzabu, int i2, zzabo zzabo) {
        this(str, i, zzabu, i2);
    }

    public static zzabp[] values() {
        return (zzabp[]) zzbwd.clone();
    }

    public final zzabu zzuv() {
        return this.zzbwb;
    }
}
