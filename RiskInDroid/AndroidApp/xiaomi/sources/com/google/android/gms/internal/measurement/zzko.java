package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzko extends zzaby<zzko> {
    private static volatile zzko[] zzatd;
    public String name = null;
    public String zzajf = null;
    private Float zzarb = null;
    public Double zzarc = null;
    public Long zzate = null;

    public zzko() {
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public static zzko[] zzlm() {
        if (zzatd == null) {
            synchronized (zzacc.zzbxg) {
                if (zzatd == null) {
                    zzatd = new zzko[0];
                }
            }
        }
        return zzatd;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzko)) {
            return false;
        }
        zzko zzko = (zzko) obj;
        String str = this.name;
        if (str == null) {
            if (zzko.name != null) {
                return false;
            }
        } else if (!str.equals(zzko.name)) {
            return false;
        }
        String str2 = this.zzajf;
        if (str2 == null) {
            if (zzko.zzajf != null) {
                return false;
            }
        } else if (!str2.equals(zzko.zzajf)) {
            return false;
        }
        Long l = this.zzate;
        if (l == null) {
            if (zzko.zzate != null) {
                return false;
            }
        } else if (!l.equals(zzko.zzate)) {
            return false;
        }
        Float f = this.zzarb;
        if (f == null) {
            if (zzko.zzarb != null) {
                return false;
            }
        } else if (!f.equals(zzko.zzarb)) {
            return false;
        }
        Double d = this.zzarc;
        if (d == null) {
            if (zzko.zzarc != null) {
                return false;
            }
        } else if (!d.equals(zzko.zzarc)) {
            return false;
        }
        return (this.zzbww == null || this.zzbww.isEmpty()) ? zzko.zzbww == null || zzko.zzbww.isEmpty() : this.zzbww.equals(zzko.zzbww);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        String str = this.name;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.zzajf;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.zzate;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        Float f = this.zzarb;
        int hashCode5 = (hashCode4 + (f == null ? 0 : f.hashCode())) * 31;
        Double d = this.zzarc;
        int hashCode6 = (hashCode5 + (d == null ? 0 : d.hashCode())) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i = this.zzbww.hashCode();
        }
        return hashCode6 + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        String str = this.name;
        if (str != null) {
            zza += zzabw.zzc(1, str);
        }
        String str2 = this.zzajf;
        if (str2 != null) {
            zza += zzabw.zzc(2, str2);
        }
        Long l = this.zzate;
        if (l != null) {
            zza += zzabw.zzc(3, l.longValue());
        }
        Float f = this.zzarb;
        if (f != null) {
            f.floatValue();
            zza += zzabw.zzaq(4) + 4;
        }
        Double d = this.zzarc;
        if (d == null) {
            return zza;
        }
        d.doubleValue();
        return zza + zzabw.zzaq(5) + 8;
    }

    public final void zza(zzabw zzabw) throws IOException {
        String str = this.name;
        if (str != null) {
            zzabw.zzb(1, str);
        }
        String str2 = this.zzajf;
        if (str2 != null) {
            zzabw.zzb(2, str2);
        }
        Long l = this.zzate;
        if (l != null) {
            zzabw.zzb(3, l.longValue());
        }
        Float f = this.zzarb;
        if (f != null) {
            zzabw.zza(4, f.floatValue());
        }
        Double d = this.zzarc;
        if (d != null) {
            zzabw.zza(5, d.doubleValue());
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
                this.name = zzabv.readString();
            } else if (zzuw == 18) {
                this.zzajf = zzabv.readString();
            } else if (zzuw == 24) {
                this.zzate = Long.valueOf(zzabv.zzuz());
            } else if (zzuw == 37) {
                this.zzarb = Float.valueOf(Float.intBitsToFloat(zzabv.zzva()));
            } else if (zzuw == 41) {
                this.zzarc = Double.valueOf(Double.longBitsToDouble(zzabv.zzvb()));
            } else if (!super.zza(zzabv, zzuw)) {
                return this;
            }
        }
    }
}
