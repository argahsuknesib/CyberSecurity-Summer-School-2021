package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkd extends zzaby<zzkd> {
    private static volatile zzkd[] zzark;
    public Integer zzarl = null;
    public zzkh[] zzarm = zzkh.zzlh();
    public zzke[] zzarn = zzke.zzlf();

    public zzkd() {
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public static zzkd[] zzle() {
        if (zzark == null) {
            synchronized (zzacc.zzbxg) {
                if (zzark == null) {
                    zzark = new zzkd[0];
                }
            }
        }
        return zzark;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkd)) {
            return false;
        }
        zzkd zzkd = (zzkd) obj;
        Integer num = this.zzarl;
        if (num == null) {
            if (zzkd.zzarl != null) {
                return false;
            }
        } else if (!num.equals(zzkd.zzarl)) {
            return false;
        }
        if (zzacc.equals(this.zzarm, zzkd.zzarm) && zzacc.equals(this.zzarn, zzkd.zzarn)) {
            return (this.zzbww == null || this.zzbww.isEmpty()) ? zzkd.zzbww == null || zzkd.zzbww.isEmpty() : this.zzbww.equals(zzkd.zzbww);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzarl;
        int i = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + zzacc.hashCode(this.zzarm)) * 31) + zzacc.hashCode(this.zzarn)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i = this.zzbww.hashCode();
        }
        return hashCode2 + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        Integer num = this.zzarl;
        if (num != null) {
            zza += zzabw.zzf(1, num.intValue());
        }
        zzkh[] zzkhArr = this.zzarm;
        int i = 0;
        if (zzkhArr != null && zzkhArr.length > 0) {
            int i2 = zza;
            int i3 = 0;
            while (true) {
                zzkh[] zzkhArr2 = this.zzarm;
                if (i3 >= zzkhArr2.length) {
                    break;
                }
                zzkh zzkh = zzkhArr2[i3];
                if (zzkh != null) {
                    i2 += zzabw.zzb(2, zzkh);
                }
                i3++;
            }
            zza = i2;
        }
        zzke[] zzkeArr = this.zzarn;
        if (zzkeArr != null && zzkeArr.length > 0) {
            while (true) {
                zzke[] zzkeArr2 = this.zzarn;
                if (i >= zzkeArr2.length) {
                    break;
                }
                zzke zzke = zzkeArr2[i];
                if (zzke != null) {
                    zza += zzabw.zzb(3, zzke);
                }
                i++;
            }
        }
        return zza;
    }

    public final void zza(zzabw zzabw) throws IOException {
        Integer num = this.zzarl;
        if (num != null) {
            zzabw.zze(1, num.intValue());
        }
        zzkh[] zzkhArr = this.zzarm;
        int i = 0;
        if (zzkhArr != null && zzkhArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzkh[] zzkhArr2 = this.zzarm;
                if (i2 >= zzkhArr2.length) {
                    break;
                }
                zzkh zzkh = zzkhArr2[i2];
                if (zzkh != null) {
                    zzabw.zza(2, zzkh);
                }
                i2++;
            }
        }
        zzke[] zzkeArr = this.zzarn;
        if (zzkeArr != null && zzkeArr.length > 0) {
            while (true) {
                zzke[] zzkeArr2 = this.zzarn;
                if (i >= zzkeArr2.length) {
                    break;
                }
                zzke zzke = zzkeArr2[i];
                if (zzke != null) {
                    zzabw.zza(3, zzke);
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
            if (zzuw == 8) {
                this.zzarl = Integer.valueOf(zzabv.zzuy());
            } else if (zzuw == 18) {
                int zzb = zzach.zzb(zzabv, 18);
                zzkh[] zzkhArr = this.zzarm;
                int length = zzkhArr == null ? 0 : zzkhArr.length;
                zzkh[] zzkhArr2 = new zzkh[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzarm, 0, zzkhArr2, 0, length);
                }
                while (length < zzkhArr2.length - 1) {
                    zzkhArr2[length] = new zzkh();
                    zzabv.zza(zzkhArr2[length]);
                    zzabv.zzuw();
                    length++;
                }
                zzkhArr2[length] = new zzkh();
                zzabv.zza(zzkhArr2[length]);
                this.zzarm = zzkhArr2;
            } else if (zzuw == 26) {
                int zzb2 = zzach.zzb(zzabv, 26);
                zzke[] zzkeArr = this.zzarn;
                int length2 = zzkeArr == null ? 0 : zzkeArr.length;
                zzke[] zzkeArr2 = new zzke[(zzb2 + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzarn, 0, zzkeArr2, 0, length2);
                }
                while (length2 < zzkeArr2.length - 1) {
                    zzkeArr2[length2] = new zzke();
                    zzabv.zza(zzkeArr2[length2]);
                    zzabv.zzuw();
                    length2++;
                }
                zzkeArr2[length2] = new zzke();
                zzabv.zza(zzkeArr2[length2]);
                this.zzarn = zzkeArr2;
            } else if (!super.zza(zzabv, zzuw)) {
                return this;
            }
        }
    }
}
