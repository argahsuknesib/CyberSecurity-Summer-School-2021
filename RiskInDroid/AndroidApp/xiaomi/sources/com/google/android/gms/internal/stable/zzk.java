package com.google.android.gms.internal.stable;

import java.io.PrintStream;

public final class zzk {
    private static final zzl zzahg;
    private static final int zzahh;

    static final class zza extends zzl {
        zza() {
        }

        public final void zza(Throwable th, Throwable th2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    static {
        zzl zzl;
        Integer num;
        int i = 1;
        try {
            num = zzdw();
            if (num != null) {
                try {
                    if (num.intValue() >= 19) {
                        zzl = new zzp();
                        zzahg = zzl;
                        if (num != null) {
                            i = num.intValue();
                        }
                        zzahh = i;
                    }
                } catch (Throwable th) {
                    th = th;
                    PrintStream printStream = System.err;
                    String name = zza.class.getName();
                    StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 132);
                    sb.append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ");
                    sb.append(name);
                    sb.append("will be used. The error is: ");
                    printStream.println(sb.toString());
                    th.printStackTrace(System.err);
                    zzl = new zza();
                    zzahg = zzl;
                    if (num != null) {
                    }
                    zzahh = i;
                }
            }
            zzl = Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ true ? new zzo() : new zza();
        } catch (Throwable th2) {
            th = th2;
            num = null;
            PrintStream printStream2 = System.err;
            String name2 = zza.class.getName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(name2).length() + 132);
            sb2.append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb2.append(name2);
            sb2.append("will be used. The error is: ");
            printStream2.println(sb2.toString());
            th.printStackTrace(System.err);
            zzl = new zza();
            zzahg = zzl;
            if (num != null) {
            }
            zzahh = i;
        }
        zzahg = zzl;
        if (num != null) {
        }
        zzahh = i;
    }

    public static void zza(Throwable th, Throwable th2) {
        zzahg.zza(th, th2);
    }

    private static Integer zzdw() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }
}
