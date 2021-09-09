package com.google.android.gms.internal.gcm;

import java.io.PrintStream;

public final class zzf {
    private static final zzg zzdc;
    private static final int zzdd;

    static final class zzd extends zzg {
        zzd() {
        }

        public final void zzd(Throwable th, Throwable th2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    static {
        zzg zzg;
        Integer num;
        int i = 1;
        try {
            num = zzy();
            if (num != null) {
                try {
                    if (num.intValue() >= 19) {
                        zzg = new zzk();
                        zzdc = zzg;
                        if (num != null) {
                            i = num.intValue();
                        }
                        zzdd = i;
                    }
                } catch (Throwable th) {
                    th = th;
                    PrintStream printStream = System.err;
                    String name = zzd.class.getName();
                    StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 132);
                    sb.append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ");
                    sb.append(name);
                    sb.append("will be used. The error is: ");
                    printStream.println(sb.toString());
                    th.printStackTrace(System.err);
                    zzg = new zzd();
                    zzdc = zzg;
                    if (num != null) {
                    }
                    zzdd = i;
                }
            }
            zzg = Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ true ? new zzj() : new zzd();
        } catch (Throwable th2) {
            th = th2;
            num = null;
            PrintStream printStream2 = System.err;
            String name2 = zzd.class.getName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(name2).length() + 132);
            sb2.append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb2.append(name2);
            sb2.append("will be used. The error is: ");
            printStream2.println(sb2.toString());
            th.printStackTrace(System.err);
            zzg = new zzd();
            zzdc = zzg;
            if (num != null) {
            }
            zzdd = i;
        }
        zzdc = zzg;
        if (num != null) {
        }
        zzdd = i;
    }

    public static void zzd(Throwable th, Throwable th2) {
        zzdc.zzd(th, th2);
    }

    private static Integer zzy() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }
}
