package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkl extends zzaby<zzkl> {
    private static volatile zzkl[] zzasu;
    public String value = null;
    public String zzny = null;

    public zzkl() {
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public static zzkl[] zzlj() {
        if (zzasu == null) {
            synchronized (zzacc.zzbxg) {
                if (zzasu == null) {
                    zzasu = new zzkl[0];
                }
            }
        }
        return zzasu;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkl)) {
            return false;
        }
        zzkl zzkl = (zzkl) obj;
        String str = this.zzny;
        if (str == null) {
            if (zzkl.zzny != null) {
                return false;
            }
        } else if (!str.equals(zzkl.zzny)) {
            return false;
        }
        String str2 = this.value;
        if (str2 == null) {
            if (zzkl.value != null) {
                return false;
            }
        } else if (!str2.equals(zzkl.value)) {
            return false;
        }
        return (this.zzbww == null || this.zzbww.isEmpty()) ? zzkl.zzbww == null || zzkl.zzbww.isEmpty() : this.zzbww.equals(zzkl.zzbww);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        String str = this.zzny;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.value;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i = this.zzbww.hashCode();
        }
        return hashCode3 + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        String str = this.zzny;
        if (str != null) {
            zza += zzabw.zzc(1, str);
        }
        String str2 = this.value;
        return str2 != null ? zza + zzabw.zzc(2, str2) : zza;
    }

    public final void zza(zzabw zzabw) throws IOException {
        String str = this.zzny;
        if (str != null) {
            zzabw.zzb(1, str);
        }
        String str2 = this.value;
        if (str2 != null) {
            zzabw.zzb(2, str2);
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
                this.zzny = zzabv.readString();
            } else if (zzuw == 18) {
                this.value = zzabv.readString();
            } else if (!super.zza(zzabv, zzuw)) {
                return this;
            }
        }
    }
}
