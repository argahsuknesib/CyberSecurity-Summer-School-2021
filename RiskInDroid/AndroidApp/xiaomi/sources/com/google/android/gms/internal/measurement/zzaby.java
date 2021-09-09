package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzaby;
import java.io.IOException;

public abstract class zzaby<M extends zzaby<M>> extends zzace {
    protected zzaca zzbww;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzaby zzaby = (zzaby) super.clone();
        zzacc.zza(this, zzaby);
        return zzaby;
    }

    /* access modifiers changed from: protected */
    public int zza() {
        if (this.zzbww == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzbww.size(); i2++) {
            i += this.zzbww.zzau(i2).zza();
        }
        return i;
    }

    public final <T> T zza(zzabz<M, T> zzabz) {
        zzacb zzat;
        zzaca zzaca = this.zzbww;
        if (zzaca == null || (zzat = zzaca.zzat(zzabz.tag >>> 3)) == null) {
            return null;
        }
        return zzat.zzb(zzabz);
    }

    public void zza(zzabw zzabw) throws IOException {
        if (this.zzbww != null) {
            for (int i = 0; i < this.zzbww.size(); i++) {
                this.zzbww.zzau(i).zza(zzabw);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzabv zzabv, int i) throws IOException {
        int position = zzabv.getPosition();
        if (!zzabv.zzak(i)) {
            return false;
        }
        int i2 = i >>> 3;
        zzacg zzacg = new zzacg(i, zzabv.zzc(position, zzabv.getPosition() - position));
        zzacb zzacb = null;
        zzaca zzaca = this.zzbww;
        if (zzaca == null) {
            this.zzbww = new zzaca();
        } else {
            zzacb = zzaca.zzat(i2);
        }
        if (zzacb == null) {
            zzacb = new zzacb();
            this.zzbww.zza(i2, zzacb);
        }
        zzacb.zza(zzacg);
        return true;
    }

    public final /* synthetic */ zzace zzvf() throws CloneNotSupportedException {
        return (zzaby) clone();
    }
}
