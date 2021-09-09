package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkp extends zzaby<zzkp> {
    public zzkq[] zzatf = zzkq.zzln();

    public zzkp() {
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkp)) {
            return false;
        }
        zzkp zzkp = (zzkp) obj;
        if (!zzacc.equals(this.zzatf, zzkp.zzatf)) {
            return false;
        }
        return (this.zzbww == null || this.zzbww.isEmpty()) ? zzkp.zzbww == null || zzkp.zzbww.isEmpty() : this.zzbww.equals(zzkp.zzbww);
    }

    public final int hashCode() {
        return ((((getClass().getName().hashCode() + 527) * 31) + zzacc.hashCode(this.zzatf)) * 31) + ((this.zzbww == null || this.zzbww.isEmpty()) ? 0 : this.zzbww.hashCode());
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        zzkq[] zzkqArr = this.zzatf;
        if (zzkqArr != null && zzkqArr.length > 0) {
            int i = 0;
            while (true) {
                zzkq[] zzkqArr2 = this.zzatf;
                if (i >= zzkqArr2.length) {
                    break;
                }
                zzkq zzkq = zzkqArr2[i];
                if (zzkq != null) {
                    zza += zzabw.zzb(1, zzkq);
                }
                i++;
            }
        }
        return zza;
    }

    public final void zza(zzabw zzabw) throws IOException {
        zzkq[] zzkqArr = this.zzatf;
        if (zzkqArr != null && zzkqArr.length > 0) {
            int i = 0;
            while (true) {
                zzkq[] zzkqArr2 = this.zzatf;
                if (i >= zzkqArr2.length) {
                    break;
                }
                zzkq zzkq = zzkqArr2[i];
                if (zzkq != null) {
                    zzabw.zza(1, zzkq);
                }
                i++;
            }
        }
        super.zza(zzabw);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) throws IOException {
        while (true) {
            int zzuw = zzabv.zzuw();
            if (zzuw == 0) {
                return this;
            }
            if (zzuw == 10) {
                int zzb = zzach.zzb(zzabv, 10);
                zzkq[] zzkqArr = this.zzatf;
                int length = zzkqArr == null ? 0 : zzkqArr.length;
                zzkq[] zzkqArr2 = new zzkq[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzatf, 0, zzkqArr2, 0, length);
                }
                while (length < zzkqArr2.length - 1) {
                    zzkqArr2[length] = new zzkq();
                    zzabv.zza(zzkqArr2[length]);
                    zzabv.zzuw();
                    length++;
                }
                zzkqArr2[length] = new zzkq();
                zzabv.zza(zzkqArr2[length]);
                this.zzatf = zzkqArr2;
            } else if (!super.zza(zzabv, zzuw)) {
                return this;
            }
        }
    }
}
