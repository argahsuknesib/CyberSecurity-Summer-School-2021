package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzks extends zzaby<zzks> {
    private static volatile zzks[] zzaum;
    public String name = null;
    public String zzajf = null;
    private Float zzarb = null;
    public Double zzarc = null;
    public Long zzate = null;
    public Long zzaun = null;

    public zzks() {
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public static zzks[] zzlo() {
        if (zzaum == null) {
            synchronized (zzacc.zzbxg) {
                if (zzaum == null) {
                    zzaum = new zzks[0];
                }
            }
        }
        return zzaum;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzks)) {
            return false;
        }
        zzks zzks = (zzks) obj;
        Long l = this.zzaun;
        if (l == null) {
            if (zzks.zzaun != null) {
                return false;
            }
        } else if (!l.equals(zzks.zzaun)) {
            return false;
        }
        String str = this.name;
        if (str == null) {
            if (zzks.name != null) {
                return false;
            }
        } else if (!str.equals(zzks.name)) {
            return false;
        }
        String str2 = this.zzajf;
        if (str2 == null) {
            if (zzks.zzajf != null) {
                return false;
            }
        } else if (!str2.equals(zzks.zzajf)) {
            return false;
        }
        Long l2 = this.zzate;
        if (l2 == null) {
            if (zzks.zzate != null) {
                return false;
            }
        } else if (!l2.equals(zzks.zzate)) {
            return false;
        }
        Float f = this.zzarb;
        if (f == null) {
            if (zzks.zzarb != null) {
                return false;
            }
        } else if (!f.equals(zzks.zzarb)) {
            return false;
        }
        Double d = this.zzarc;
        if (d == null) {
            if (zzks.zzarc != null) {
                return false;
            }
        } else if (!d.equals(zzks.zzarc)) {
            return false;
        }
        return (this.zzbww == null || this.zzbww.isEmpty()) ? zzks.zzbww == null || zzks.zzbww.isEmpty() : this.zzbww.equals(zzks.zzbww);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Long l = this.zzaun;
        int i = 0;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.name;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.zzajf;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l2 = this.zzate;
        int hashCode5 = (hashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Float f = this.zzarb;
        int hashCode6 = (hashCode5 + (f == null ? 0 : f.hashCode())) * 31;
        Double d = this.zzarc;
        int hashCode7 = (hashCode6 + (d == null ? 0 : d.hashCode())) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i = this.zzbww.hashCode();
        }
        return hashCode7 + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        Long l = this.zzaun;
        if (l != null) {
            zza += zzabw.zzc(1, l.longValue());
        }
        String str = this.name;
        if (str != null) {
            zza += zzabw.zzc(2, str);
        }
        String str2 = this.zzajf;
        if (str2 != null) {
            zza += zzabw.zzc(3, str2);
        }
        Long l2 = this.zzate;
        if (l2 != null) {
            zza += zzabw.zzc(4, l2.longValue());
        }
        Float f = this.zzarb;
        if (f != null) {
            f.floatValue();
            zza += zzabw.zzaq(5) + 4;
        }
        Double d = this.zzarc;
        if (d == null) {
            return zza;
        }
        d.doubleValue();
        return zza + zzabw.zzaq(6) + 8;
    }

    public final void zza(zzabw zzabw) throws IOException {
        Long l = this.zzaun;
        if (l != null) {
            zzabw.zzb(1, l.longValue());
        }
        String str = this.name;
        if (str != null) {
            zzabw.zzb(2, str);
        }
        String str2 = this.zzajf;
        if (str2 != null) {
            zzabw.zzb(3, str2);
        }
        Long l2 = this.zzate;
        if (l2 != null) {
            zzabw.zzb(4, l2.longValue());
        }
        Float f = this.zzarb;
        if (f != null) {
            zzabw.zza(5, f.floatValue());
        }
        Double d = this.zzarc;
        if (d != null) {
            zzabw.zza(6, d.doubleValue());
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
                this.zzaun = Long.valueOf(zzabv.zzuz());
            } else if (zzuw == 18) {
                this.name = zzabv.readString();
            } else if (zzuw == 26) {
                this.zzajf = zzabv.readString();
            } else if (zzuw == 32) {
                this.zzate = Long.valueOf(zzabv.zzuz());
            } else if (zzuw == 45) {
                this.zzarb = Float.valueOf(Float.intBitsToFloat(zzabv.zzva()));
            } else if (zzuw == 49) {
                this.zzarc = Double.valueOf(Double.longBitsToDouble(zzabv.zzvb()));
            } else if (!super.zza(zzabv, zzuw)) {
                return this;
            }
        }
    }
}
