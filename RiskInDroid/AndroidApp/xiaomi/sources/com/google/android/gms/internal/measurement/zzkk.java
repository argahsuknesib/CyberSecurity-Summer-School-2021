package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkk extends zzaby<zzkk> {
    public String zzadm = null;
    public Long zzasp = null;
    private Integer zzasq = null;
    public zzkl[] zzasr = zzkl.zzlj();
    public zzkj[] zzass = zzkj.zzli();
    public zzkd[] zzast = zzkd.zzle();

    public zzkk() {
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkk)) {
            return false;
        }
        zzkk zzkk = (zzkk) obj;
        Long l = this.zzasp;
        if (l == null) {
            if (zzkk.zzasp != null) {
                return false;
            }
        } else if (!l.equals(zzkk.zzasp)) {
            return false;
        }
        String str = this.zzadm;
        if (str == null) {
            if (zzkk.zzadm != null) {
                return false;
            }
        } else if (!str.equals(zzkk.zzadm)) {
            return false;
        }
        Integer num = this.zzasq;
        if (num == null) {
            if (zzkk.zzasq != null) {
                return false;
            }
        } else if (!num.equals(zzkk.zzasq)) {
            return false;
        }
        if (zzacc.equals(this.zzasr, zzkk.zzasr) && zzacc.equals(this.zzass, zzkk.zzass) && zzacc.equals(this.zzast, zzkk.zzast)) {
            return (this.zzbww == null || this.zzbww.isEmpty()) ? zzkk.zzbww == null || zzkk.zzbww.isEmpty() : this.zzbww.equals(zzkk.zzbww);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Long l = this.zzasp;
        int i = 0;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.zzadm;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.zzasq;
        int hashCode4 = (((((((hashCode3 + (num == null ? 0 : num.hashCode())) * 31) + zzacc.hashCode(this.zzasr)) * 31) + zzacc.hashCode(this.zzass)) * 31) + zzacc.hashCode(this.zzast)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i = this.zzbww.hashCode();
        }
        return hashCode4 + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        Long l = this.zzasp;
        if (l != null) {
            zza += zzabw.zzc(1, l.longValue());
        }
        String str = this.zzadm;
        if (str != null) {
            zza += zzabw.zzc(2, str);
        }
        Integer num = this.zzasq;
        if (num != null) {
            zza += zzabw.zzf(3, num.intValue());
        }
        zzkl[] zzklArr = this.zzasr;
        int i = 0;
        if (zzklArr != null && zzklArr.length > 0) {
            int i2 = zza;
            int i3 = 0;
            while (true) {
                zzkl[] zzklArr2 = this.zzasr;
                if (i3 >= zzklArr2.length) {
                    break;
                }
                zzkl zzkl = zzklArr2[i3];
                if (zzkl != null) {
                    i2 += zzabw.zzb(4, zzkl);
                }
                i3++;
            }
            zza = i2;
        }
        zzkj[] zzkjArr = this.zzass;
        if (zzkjArr != null && zzkjArr.length > 0) {
            int i4 = zza;
            int i5 = 0;
            while (true) {
                zzkj[] zzkjArr2 = this.zzass;
                if (i5 >= zzkjArr2.length) {
                    break;
                }
                zzkj zzkj = zzkjArr2[i5];
                if (zzkj != null) {
                    i4 += zzabw.zzb(5, zzkj);
                }
                i5++;
            }
            zza = i4;
        }
        zzkd[] zzkdArr = this.zzast;
        if (zzkdArr != null && zzkdArr.length > 0) {
            while (true) {
                zzkd[] zzkdArr2 = this.zzast;
                if (i >= zzkdArr2.length) {
                    break;
                }
                zzkd zzkd = zzkdArr2[i];
                if (zzkd != null) {
                    zza += zzabw.zzb(6, zzkd);
                }
                i++;
            }
        }
        return zza;
    }

    public final void zza(zzabw zzabw) throws IOException {
        Long l = this.zzasp;
        if (l != null) {
            zzabw.zzb(1, l.longValue());
        }
        String str = this.zzadm;
        if (str != null) {
            zzabw.zzb(2, str);
        }
        Integer num = this.zzasq;
        if (num != null) {
            zzabw.zze(3, num.intValue());
        }
        zzkl[] zzklArr = this.zzasr;
        int i = 0;
        if (zzklArr != null && zzklArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzkl[] zzklArr2 = this.zzasr;
                if (i2 >= zzklArr2.length) {
                    break;
                }
                zzkl zzkl = zzklArr2[i2];
                if (zzkl != null) {
                    zzabw.zza(4, zzkl);
                }
                i2++;
            }
        }
        zzkj[] zzkjArr = this.zzass;
        if (zzkjArr != null && zzkjArr.length > 0) {
            int i3 = 0;
            while (true) {
                zzkj[] zzkjArr2 = this.zzass;
                if (i3 >= zzkjArr2.length) {
                    break;
                }
                zzkj zzkj = zzkjArr2[i3];
                if (zzkj != null) {
                    zzabw.zza(5, zzkj);
                }
                i3++;
            }
        }
        zzkd[] zzkdArr = this.zzast;
        if (zzkdArr != null && zzkdArr.length > 0) {
            while (true) {
                zzkd[] zzkdArr2 = this.zzast;
                if (i >= zzkdArr2.length) {
                    break;
                }
                zzkd zzkd = zzkdArr2[i];
                if (zzkd != null) {
                    zzabw.zza(6, zzkd);
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
                this.zzasp = Long.valueOf(zzabv.zzuz());
            } else if (zzuw == 18) {
                this.zzadm = zzabv.readString();
            } else if (zzuw == 24) {
                this.zzasq = Integer.valueOf(zzabv.zzuy());
            } else if (zzuw == 34) {
                int zzb = zzach.zzb(zzabv, 34);
                zzkl[] zzklArr = this.zzasr;
                int length = zzklArr == null ? 0 : zzklArr.length;
                zzkl[] zzklArr2 = new zzkl[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzasr, 0, zzklArr2, 0, length);
                }
                while (length < zzklArr2.length - 1) {
                    zzklArr2[length] = new zzkl();
                    zzabv.zza(zzklArr2[length]);
                    zzabv.zzuw();
                    length++;
                }
                zzklArr2[length] = new zzkl();
                zzabv.zza(zzklArr2[length]);
                this.zzasr = zzklArr2;
            } else if (zzuw == 42) {
                int zzb2 = zzach.zzb(zzabv, 42);
                zzkj[] zzkjArr = this.zzass;
                int length2 = zzkjArr == null ? 0 : zzkjArr.length;
                zzkj[] zzkjArr2 = new zzkj[(zzb2 + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzass, 0, zzkjArr2, 0, length2);
                }
                while (length2 < zzkjArr2.length - 1) {
                    zzkjArr2[length2] = new zzkj();
                    zzabv.zza(zzkjArr2[length2]);
                    zzabv.zzuw();
                    length2++;
                }
                zzkjArr2[length2] = new zzkj();
                zzabv.zza(zzkjArr2[length2]);
                this.zzass = zzkjArr2;
            } else if (zzuw == 50) {
                int zzb3 = zzach.zzb(zzabv, 50);
                zzkd[] zzkdArr = this.zzast;
                int length3 = zzkdArr == null ? 0 : zzkdArr.length;
                zzkd[] zzkdArr2 = new zzkd[(zzb3 + length3)];
                if (length3 != 0) {
                    System.arraycopy(this.zzast, 0, zzkdArr2, 0, length3);
                }
                while (length3 < zzkdArr2.length - 1) {
                    zzkdArr2[length3] = new zzkd();
                    zzabv.zza(zzkdArr2[length3]);
                    zzabv.zzuw();
                    length3++;
                }
                zzkdArr2[length3] = new zzkd();
                zzabv.zza(zzkdArr2[length3]);
                this.zzast = zzkdArr2;
            } else if (!super.zza(zzabv, zzuw)) {
                return this;
            }
        }
    }
}
