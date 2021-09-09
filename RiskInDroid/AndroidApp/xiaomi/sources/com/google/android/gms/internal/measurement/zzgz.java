package com.google.android.gms.internal.measurement;

final class zzgz implements Runnable {
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ String zzanj;
    private final /* synthetic */ zzeu zzank;

    zzgz(zzgn zzgn, zzeu zzeu, String str) {
        this.zzanf = zzgn;
        this.zzank = zzeu;
        this.zzanj = str;
    }

    public final void run() {
        this.zzanf.zzajp.zzkx();
        this.zzanf.zzajp.zzc(this.zzank, this.zzanj);
    }
}
