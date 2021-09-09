package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkm extends zzaby<zzkm> {
    private static volatile zzkm[] zzasv;
    public Integer zzarl = null;
    public zzkr zzasw = null;
    public zzkr zzasx = null;
    public Boolean zzasy = null;

    public zzkm() {
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public static zzkm[] zzlk() {
        if (zzasv == null) {
            synchronized (zzacc.zzbxg) {
                if (zzasv == null) {
                    zzasv = new zzkm[0];
                }
            }
        }
        return zzasv;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkm)) {
            return false;
        }
        zzkm zzkm = (zzkm) obj;
        Integer num = this.zzarl;
        if (num == null) {
            if (zzkm.zzarl != null) {
                return false;
            }
        } else if (!num.equals(zzkm.zzarl)) {
            return false;
        }
        zzkr zzkr = this.zzasw;
        if (zzkr == null) {
            if (zzkm.zzasw != null) {
                return false;
            }
        } else if (!zzkr.equals(zzkm.zzasw)) {
            return false;
        }
        zzkr zzkr2 = this.zzasx;
        if (zzkr2 == null) {
            if (zzkm.zzasx != null) {
                return false;
            }
        } else if (!zzkr2.equals(zzkm.zzasx)) {
            return false;
        }
        Boolean bool = this.zzasy;
        if (bool == null) {
            if (zzkm.zzasy != null) {
                return false;
            }
        } else if (!bool.equals(zzkm.zzasy)) {
            return false;
        }
        return (this.zzbww == null || this.zzbww.isEmpty()) ? zzkm.zzbww == null || zzkm.zzbww.isEmpty() : this.zzbww.equals(zzkm.zzbww);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzarl;
        int i = 0;
        int hashCode2 = hashCode + (num == null ? 0 : num.hashCode());
        zzkr zzkr = this.zzasw;
        int hashCode3 = (hashCode2 * 31) + (zzkr == null ? 0 : zzkr.hashCode());
        zzkr zzkr2 = this.zzasx;
        int hashCode4 = ((hashCode3 * 31) + (zzkr2 == null ? 0 : zzkr2.hashCode())) * 31;
        Boolean bool = this.zzasy;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i = this.zzbww.hashCode();
        }
        return hashCode5 + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        Integer num = this.zzarl;
        if (num != null) {
            zza += zzabw.zzf(1, num.intValue());
        }
        zzkr zzkr = this.zzasw;
        if (zzkr != null) {
            zza += zzabw.zzb(2, zzkr);
        }
        zzkr zzkr2 = this.zzasx;
        if (zzkr2 != null) {
            zza += zzabw.zzb(3, zzkr2);
        }
        Boolean bool = this.zzasy;
        if (bool == null) {
            return zza;
        }
        bool.booleanValue();
        return zza + zzabw.zzaq(4) + 1;
    }

    public final void zza(zzabw zzabw) throws IOException {
        Integer num = this.zzarl;
        if (num != null) {
            zzabw.zze(1, num.intValue());
        }
        zzkr zzkr = this.zzasw;
        if (zzkr != null) {
            zzabw.zza(2, zzkr);
        }
        zzkr zzkr2 = this.zzasx;
        if (zzkr2 != null) {
            zzabw.zza(3, zzkr2);
        }
        Boolean bool = this.zzasy;
        if (bool != null) {
            zzabw.zza(4, bool.booleanValue());
        }
        super.zza(zzabw);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) throws IOException {
        zzkr zzkr;
        while (true) {
            int zzuw = zzabv.zzuw();
            if (zzuw == 0) {
                return this;
            }
            if (zzuw != 8) {
                if (zzuw == 18) {
                    if (this.zzasw == null) {
                        this.zzasw = new zzkr();
                    }
                    zzkr = this.zzasw;
                } else if (zzuw == 26) {
                    if (this.zzasx == null) {
                        this.zzasx = new zzkr();
                    }
                    zzkr = this.zzasx;
                } else if (zzuw == 32) {
                    this.zzasy = Boolean.valueOf(zzabv.zzux());
                } else if (!super.zza(zzabv, zzuw)) {
                    return this;
                }
                zzabv.zza(zzkr);
            } else {
                this.zzarl = Integer.valueOf(zzabv.zzuy());
            }
        }
    }
}
