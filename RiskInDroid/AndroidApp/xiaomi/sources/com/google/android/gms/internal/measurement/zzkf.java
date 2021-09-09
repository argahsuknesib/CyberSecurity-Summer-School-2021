package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkf extends zzaby<zzkf> {
    private static volatile zzkf[] zzaru;
    public zzki zzarv = null;
    public zzkg zzarw = null;
    public Boolean zzarx = null;
    public String zzary = null;

    public zzkf() {
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public static zzkf[] zzlg() {
        if (zzaru == null) {
            synchronized (zzacc.zzbxg) {
                if (zzaru == null) {
                    zzaru = new zzkf[0];
                }
            }
        }
        return zzaru;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkf)) {
            return false;
        }
        zzkf zzkf = (zzkf) obj;
        zzki zzki = this.zzarv;
        if (zzki == null) {
            if (zzkf.zzarv != null) {
                return false;
            }
        } else if (!zzki.equals(zzkf.zzarv)) {
            return false;
        }
        zzkg zzkg = this.zzarw;
        if (zzkg == null) {
            if (zzkf.zzarw != null) {
                return false;
            }
        } else if (!zzkg.equals(zzkf.zzarw)) {
            return false;
        }
        Boolean bool = this.zzarx;
        if (bool == null) {
            if (zzkf.zzarx != null) {
                return false;
            }
        } else if (!bool.equals(zzkf.zzarx)) {
            return false;
        }
        String str = this.zzary;
        if (str == null) {
            if (zzkf.zzary != null) {
                return false;
            }
        } else if (!str.equals(zzkf.zzary)) {
            return false;
        }
        return (this.zzbww == null || this.zzbww.isEmpty()) ? zzkf.zzbww == null || zzkf.zzbww.isEmpty() : this.zzbww.equals(zzkf.zzbww);
    }

    public final int hashCode() {
        zzki zzki = this.zzarv;
        int i = 0;
        int hashCode = ((getClass().getName().hashCode() + 527) * 31) + (zzki == null ? 0 : zzki.hashCode());
        zzkg zzkg = this.zzarw;
        int hashCode2 = ((hashCode * 31) + (zzkg == null ? 0 : zzkg.hashCode())) * 31;
        Boolean bool = this.zzarx;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.zzary;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i = this.zzbww.hashCode();
        }
        return hashCode4 + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        zzki zzki = this.zzarv;
        if (zzki != null) {
            zza += zzabw.zzb(1, zzki);
        }
        zzkg zzkg = this.zzarw;
        if (zzkg != null) {
            zza += zzabw.zzb(2, zzkg);
        }
        Boolean bool = this.zzarx;
        if (bool != null) {
            bool.booleanValue();
            zza += zzabw.zzaq(3) + 1;
        }
        String str = this.zzary;
        return str != null ? zza + zzabw.zzc(4, str) : zza;
    }

    public final void zza(zzabw zzabw) throws IOException {
        zzki zzki = this.zzarv;
        if (zzki != null) {
            zzabw.zza(1, zzki);
        }
        zzkg zzkg = this.zzarw;
        if (zzkg != null) {
            zzabw.zza(2, zzkg);
        }
        Boolean bool = this.zzarx;
        if (bool != null) {
            zzabw.zza(3, bool.booleanValue());
        }
        String str = this.zzary;
        if (str != null) {
            zzabw.zzb(4, str);
        }
        super.zza(zzabw);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) throws IOException {
        zzace zzace;
        while (true) {
            int zzuw = zzabv.zzuw();
            if (zzuw == 0) {
                return this;
            }
            if (zzuw == 10) {
                if (this.zzarv == null) {
                    this.zzarv = new zzki();
                }
                zzace = this.zzarv;
            } else if (zzuw == 18) {
                if (this.zzarw == null) {
                    this.zzarw = new zzkg();
                }
                zzace = this.zzarw;
            } else if (zzuw == 24) {
                this.zzarx = Boolean.valueOf(zzabv.zzux());
            } else if (zzuw == 34) {
                this.zzary = zzabv.readString();
            } else if (!super.zza(zzabv, zzuw)) {
                return this;
            }
            zzabv.zza(zzace);
        }
    }
}
