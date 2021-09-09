package com.google.android.gms.internal.measurement;

import java.io.PrintStream;

public final class zzxd {
    private static final zzxe zzbnx;
    private static final int zzbny;

    static final class zza extends zzxe {
        zza() {
        }

        public final void zza(Throwable th, PrintStream printStream) {
            th.printStackTrace(printStream);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    static {
        zzxe zzxe;
        Integer num;
        int i = 1;
        try {
            num = zzsd();
            if (num != null) {
                try {
                    if (num.intValue() >= 19) {
                        zzxe = new zzxi();
                        zzbnx = zzxe;
                        if (num != null) {
                            i = num.intValue();
                        }
                        zzbny = i;
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
                    zzxe = new zza();
                    zzbnx = zzxe;
                    if (num != null) {
                    }
                    zzbny = i;
                }
            }
            zzxe = Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ true ? new zzxh() : new zza();
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
            zzxe = new zza();
            zzbnx = zzxe;
            if (num != null) {
            }
            zzbny = i;
        }
        zzbnx = zzxe;
        if (num != null) {
        }
        zzbny = i;
    }

    public static void zza(Throwable th, PrintStream printStream) {
        zzbnx.zza(th, printStream);
    }

    private static Integer zzsd() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }
}
