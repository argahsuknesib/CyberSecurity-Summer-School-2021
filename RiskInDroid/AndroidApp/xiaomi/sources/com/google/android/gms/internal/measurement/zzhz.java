package com.google.android.gms.internal.measurement;

final class zzhz implements Runnable {
    private final /* synthetic */ zzhk zzanw;
    private final /* synthetic */ boolean zzaoc;

    zzhz(zzhk zzhk, boolean z) {
        this.zzanw = zzhk;
        this.zzaoc = z;
    }

    public final void run() {
        this.zzanw.zzi(this.zzaoc);
    }
}
