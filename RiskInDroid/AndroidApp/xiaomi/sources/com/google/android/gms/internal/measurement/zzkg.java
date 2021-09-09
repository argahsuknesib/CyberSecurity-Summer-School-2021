package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkg extends zzaby<zzkg> {
    public Integer zzarz = null;
    public Boolean zzasa = null;
    public String zzasb = null;
    public String zzasc = null;
    public String zzasd = null;

    public zzkg() {
        this.zzbww = null;
        this.zzbxh = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzkg zzb(zzabv zzabv) throws IOException {
        int zzuy;
        while (true) {
            int zzuw = zzabv.zzuw();
            if (zzuw == 0) {
                return this;
            }
            if (zzuw == 8) {
                try {
                    zzuy = zzabv.zzuy();
                    if (zzuy < 0 || zzuy > 4) {
                        StringBuilder sb = new StringBuilder(46);
                        sb.append(zzuy);
                        sb.append(" is not a valid enum ComparisonType");
                    } else {
                        this.zzarz = Integer.valueOf(zzuy);
                    }
                } catch (IllegalArgumentException unused) {
                    zzabv.zzam(zzabv.getPosition());
                    zza(zzabv, zzuw);
                }
            } else if (zzuw == 16) {
                this.zzasa = Boolean.valueOf(zzabv.zzux());
            } else if (zzuw == 26) {
                this.zzasb = zzabv.readString();
            } else if (zzuw == 34) {
                this.zzasc = zzabv.readString();
            } else if (zzuw == 42) {
                this.zzasd = zzabv.readString();
            } else if (!super.zza(zzabv, zzuw)) {
                return this;
            }
        }
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append(zzuy);
        sb2.append(" is not a valid enum ComparisonType");
        throw new IllegalArgumentException(sb2.toString());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkg)) {
            return false;
        }
        zzkg zzkg = (zzkg) obj;
        Integer num = this.zzarz;
        if (num == null) {
            if (zzkg.zzarz != null) {
                return false;
            }
        } else if (!num.equals(zzkg.zzarz)) {
            return false;
        }
        Boolean bool = this.zzasa;
        if (bool == null) {
            if (zzkg.zzasa != null) {
                return false;
            }
        } else if (!bool.equals(zzkg.zzasa)) {
            return false;
        }
        String str = this.zzasb;
        if (str == null) {
            if (zzkg.zzasb != null) {
                return false;
            }
        } else if (!str.equals(zzkg.zzasb)) {
            return false;
        }
        String str2 = this.zzasc;
        if (str2 == null) {
            if (zzkg.zzasc != null) {
                return false;
            }
        } else if (!str2.equals(zzkg.zzasc)) {
            return false;
        }
        String str3 = this.zzasd;
        if (str3 == null) {
            if (zzkg.zzasd != null) {
                return false;
            }
        } else if (!str3.equals(zzkg.zzasd)) {
            return false;
        }
        return (this.zzbww == null || this.zzbww.isEmpty()) ? zzkg.zzbww == null || zzkg.zzbww.isEmpty() : this.zzbww.equals(zzkg.zzbww);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzarz;
        int i = 0;
        int intValue = (hashCode + (num == null ? 0 : num.intValue())) * 31;
        Boolean bool = this.zzasa;
        int hashCode2 = (intValue + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.zzasb;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.zzasc;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.zzasd;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i = this.zzbww.hashCode();
        }
        return hashCode5 + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        Integer num = this.zzarz;
        if (num != null) {
            zza += zzabw.zzf(1, num.intValue());
        }
        Boolean bool = this.zzasa;
        if (bool != null) {
            bool.booleanValue();
            zza += zzabw.zzaq(2) + 1;
        }
        String str = this.zzasb;
        if (str != null) {
            zza += zzabw.zzc(3, str);
        }
        String str2 = this.zzasc;
        if (str2 != null) {
            zza += zzabw.zzc(4, str2);
        }
        String str3 = this.zzasd;
        return str3 != null ? zza + zzabw.zzc(5, str3) : zza;
    }

    public final void zza(zzabw zzabw) throws IOException {
        Integer num = this.zzarz;
        if (num != null) {
            zzabw.zze(1, num.intValue());
        }
        Boolean bool = this.zzasa;
        if (bool != null) {
            zzabw.zza(2, bool.booleanValue());
        }
        String str = this.zzasb;
        if (str != null) {
            zzabw.zzb(3, str);
        }
        String str2 = this.zzasc;
        if (str2 != null) {
            zzabw.zzb(4, str2);
        }
        String str3 = this.zzasd;
        if (str3 != null) {
            zzabw.zzb(5, str3);
        }
        super.zza(zzabw);
    }
}
