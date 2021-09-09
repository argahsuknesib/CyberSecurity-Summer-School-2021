package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkh extends zzaby<zzkh> {
    private static volatile zzkh[] zzase;
    public Integer zzarp = null;
    public String zzasf = null;
    public zzkf zzasg = null;

    public zzkh() {
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public static zzkh[] zzlh() {
        if (zzase == null) {
            synchronized (zzacc.zzbxg) {
                if (zzase == null) {
                    zzase = new zzkh[0];
                }
            }
        }
        return zzase;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkh)) {
            return false;
        }
        zzkh zzkh = (zzkh) obj;
        Integer num = this.zzarp;
        if (num == null) {
            if (zzkh.zzarp != null) {
                return false;
            }
        } else if (!num.equals(zzkh.zzarp)) {
            return false;
        }
        String str = this.zzasf;
        if (str == null) {
            if (zzkh.zzasf != null) {
                return false;
            }
        } else if (!str.equals(zzkh.zzasf)) {
            return false;
        }
        zzkf zzkf = this.zzasg;
        if (zzkf == null) {
            if (zzkh.zzasg != null) {
                return false;
            }
        } else if (!zzkf.equals(zzkh.zzasg)) {
            return false;
        }
        return (this.zzbww == null || this.zzbww.isEmpty()) ? zzkh.zzbww == null || zzkh.zzbww.isEmpty() : this.zzbww.equals(zzkh.zzbww);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzarp;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.zzasf;
        int hashCode3 = hashCode2 + (str == null ? 0 : str.hashCode());
        zzkf zzkf = this.zzasg;
        int hashCode4 = ((hashCode3 * 31) + (zzkf == null ? 0 : zzkf.hashCode())) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i = this.zzbww.hashCode();
        }
        return hashCode4 + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        Integer num = this.zzarp;
        if (num != null) {
            zza += zzabw.zzf(1, num.intValue());
        }
        String str = this.zzasf;
        if (str != null) {
            zza += zzabw.zzc(2, str);
        }
        zzkf zzkf = this.zzasg;
        return zzkf != null ? zza + zzabw.zzb(3, zzkf) : zza;
    }

    public final void zza(zzabw zzabw) throws IOException {
        Integer num = this.zzarp;
        if (num != null) {
            zzabw.zze(1, num.intValue());
        }
        String str = this.zzasf;
        if (str != null) {
            zzabw.zzb(2, str);
        }
        zzkf zzkf = this.zzasg;
        if (zzkf != null) {
            zzabw.zza(3, zzkf);
        }
        super.zza(zzabw);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) throws IOException {
        while (true) {
            int zzuw = zzabv.zzuw();
            if (zzuw == 0) {
                return this;
            }
            if (zzuw == 8) {
                this.zzarp = Integer.valueOf(zzabv.zzuy());
            } else if (zzuw == 18) {
                this.zzasf = zzabv.readString();
            } else if (zzuw == 26) {
                if (this.zzasg == null) {
                    this.zzasg = new zzkf();
                }
                zzabv.zza(this.zzasg);
            } else if (!super.zza(zzabv, zzuw)) {
                return this;
            }
        }
    }
}
