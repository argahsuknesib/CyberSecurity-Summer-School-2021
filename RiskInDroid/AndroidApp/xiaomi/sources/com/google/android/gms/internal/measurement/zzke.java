package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzke extends zzaby<zzke> {
    private static volatile zzke[] zzaro;
    public Integer zzarp = null;
    public String zzarq = null;
    public zzkf[] zzarr = zzkf.zzlg();
    private Boolean zzars = null;
    public zzkg zzart = null;

    public zzke() {
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public static zzke[] zzlf() {
        if (zzaro == null) {
            synchronized (zzacc.zzbxg) {
                if (zzaro == null) {
                    zzaro = new zzke[0];
                }
            }
        }
        return zzaro;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzke)) {
            return false;
        }
        zzke zzke = (zzke) obj;
        Integer num = this.zzarp;
        if (num == null) {
            if (zzke.zzarp != null) {
                return false;
            }
        } else if (!num.equals(zzke.zzarp)) {
            return false;
        }
        String str = this.zzarq;
        if (str == null) {
            if (zzke.zzarq != null) {
                return false;
            }
        } else if (!str.equals(zzke.zzarq)) {
            return false;
        }
        if (!zzacc.equals(this.zzarr, zzke.zzarr)) {
            return false;
        }
        Boolean bool = this.zzars;
        if (bool == null) {
            if (zzke.zzars != null) {
                return false;
            }
        } else if (!bool.equals(zzke.zzars)) {
            return false;
        }
        zzkg zzkg = this.zzart;
        if (zzkg == null) {
            if (zzke.zzart != null) {
                return false;
            }
        } else if (!zzkg.equals(zzke.zzart)) {
            return false;
        }
        return (this.zzbww == null || this.zzbww.isEmpty()) ? zzke.zzbww == null || zzke.zzbww.isEmpty() : this.zzbww.equals(zzke.zzbww);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzarp;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.zzarq;
        int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + zzacc.hashCode(this.zzarr)) * 31;
        Boolean bool = this.zzars;
        int hashCode4 = hashCode3 + (bool == null ? 0 : bool.hashCode());
        zzkg zzkg = this.zzart;
        int hashCode5 = ((hashCode4 * 31) + (zzkg == null ? 0 : zzkg.hashCode())) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i = this.zzbww.hashCode();
        }
        return hashCode5 + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        Integer num = this.zzarp;
        if (num != null) {
            zza += zzabw.zzf(1, num.intValue());
        }
        String str = this.zzarq;
        if (str != null) {
            zza += zzabw.zzc(2, str);
        }
        zzkf[] zzkfArr = this.zzarr;
        if (zzkfArr != null && zzkfArr.length > 0) {
            int i = 0;
            while (true) {
                zzkf[] zzkfArr2 = this.zzarr;
                if (i >= zzkfArr2.length) {
                    break;
                }
                zzkf zzkf = zzkfArr2[i];
                if (zzkf != null) {
                    zza += zzabw.zzb(3, zzkf);
                }
                i++;
            }
        }
        Boolean bool = this.zzars;
        if (bool != null) {
            bool.booleanValue();
            zza += zzabw.zzaq(4) + 1;
        }
        zzkg zzkg = this.zzart;
        return zzkg != null ? zza + zzabw.zzb(5, zzkg) : zza;
    }

    public final void zza(zzabw zzabw) throws IOException {
        Integer num = this.zzarp;
        if (num != null) {
            zzabw.zze(1, num.intValue());
        }
        String str = this.zzarq;
        if (str != null) {
            zzabw.zzb(2, str);
        }
        zzkf[] zzkfArr = this.zzarr;
        if (zzkfArr != null && zzkfArr.length > 0) {
            int i = 0;
            while (true) {
                zzkf[] zzkfArr2 = this.zzarr;
                if (i >= zzkfArr2.length) {
                    break;
                }
                zzkf zzkf = zzkfArr2[i];
                if (zzkf != null) {
                    zzabw.zza(3, zzkf);
                }
                i++;
            }
        }
        Boolean bool = this.zzars;
        if (bool != null) {
            zzabw.zza(4, bool.booleanValue());
        }
        zzkg zzkg = this.zzart;
        if (zzkg != null) {
            zzabw.zza(5, zzkg);
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
                this.zzarq = zzabv.readString();
            } else if (zzuw == 26) {
                int zzb = zzach.zzb(zzabv, 26);
                zzkf[] zzkfArr = this.zzarr;
                int length = zzkfArr == null ? 0 : zzkfArr.length;
                zzkf[] zzkfArr2 = new zzkf[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzarr, 0, zzkfArr2, 0, length);
                }
                while (length < zzkfArr2.length - 1) {
                    zzkfArr2[length] = new zzkf();
                    zzabv.zza(zzkfArr2[length]);
                    zzabv.zzuw();
                    length++;
                }
                zzkfArr2[length] = new zzkf();
                zzabv.zza(zzkfArr2[length]);
                this.zzarr = zzkfArr2;
            } else if (zzuw == 32) {
                this.zzars = Boolean.valueOf(zzabv.zzux());
            } else if (zzuw == 42) {
                if (this.zzart == null) {
                    this.zzart = new zzkg();
                }
                zzabv.zza(this.zzart);
            } else if (!super.zza(zzabv, zzuw)) {
                return this;
            }
        }
    }
}
