package com.google.android.gms.internal.measurement;

final class zzfh implements Runnable {
    private final /* synthetic */ int zzaix;
    private final /* synthetic */ String zzaiy;
    private final /* synthetic */ Object zzaiz;
    private final /* synthetic */ Object zzaja;
    private final /* synthetic */ Object zzajb;
    private final /* synthetic */ zzfg zzajc;

    zzfh(zzfg zzfg, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzajc = zzfg;
        this.zzaix = i;
        this.zzaiy = str;
        this.zzaiz = obj;
        this.zzaja = obj2;
        this.zzajb = obj3;
    }

    public final void run() {
        char c;
        zzfg zzfg;
        zzfr zzgf = this.zzajc.zzacw.zzgf();
        if (!zzgf.isInitialized()) {
            this.zzajc.zza(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.zzajc.zzaim == 0) {
            if (this.zzajc.zzgg().zzds()) {
                zzfg = this.zzajc;
                c = 'C';
            } else {
                zzfg = this.zzajc;
                c = 'c';
            }
            char unused = zzfg.zzaim = c;
        }
        if (this.zzajc.zzadu < 0) {
            long unused2 = this.zzajc.zzadu = 12451;
        }
        char charAt = "01VDIWEA?".charAt(this.zzaix);
        char zza = this.zzajc.zzaim;
        long zzb = this.zzajc.zzadu;
        String zza2 = zzfg.zza(true, this.zzaiy, this.zzaiz, this.zzaja, this.zzajb);
        StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 24);
        sb.append("2");
        sb.append(charAt);
        sb.append(zza);
        sb.append(zzb);
        sb.append(":");
        sb.append(zza2);
        String sb2 = sb.toString();
        if (sb2.length() > 1024) {
            sb2 = this.zzaiy.substring(0, 1024);
        }
        zzgf.zzajt.zzc(sb2, 1);
    }
}
