package com.google.android.gms.internal.measurement;

final class zzio extends zzem {
    private final /* synthetic */ zzii zzape;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzio(zzii zzii, zzhi zzhi) {
        super(zzhi);
        this.zzape = zzii;
    }

    public final void run() {
        this.zzape.zzge().zzip().log("Tasks have been queued for a long time");
    }
}
