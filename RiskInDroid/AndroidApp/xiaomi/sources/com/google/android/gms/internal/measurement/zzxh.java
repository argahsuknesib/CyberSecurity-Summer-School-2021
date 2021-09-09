package com.google.android.gms.internal.measurement;

import java.io.PrintStream;
import java.util.List;

final class zzxh extends zzxe {
    private final zzxf zzbod = new zzxf();

    zzxh() {
    }

    public final void zza(Throwable th, PrintStream printStream) {
        th.printStackTrace(printStream);
        List<Throwable> zza = this.zzbod.zza(th, false);
        if (zza != null) {
            synchronized (zza) {
                for (Throwable printStackTrace : zza) {
                    printStream.print("Suppressed: ");
                    printStackTrace.printStackTrace(printStream);
                }
            }
        }
    }
}
