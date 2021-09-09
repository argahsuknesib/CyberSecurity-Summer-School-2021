package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzki extends zzaby<zzki> {
    public Integer zzash = null;
    public String zzasi = null;
    public Boolean zzasj = null;
    public String[] zzask = zzach.zzbxq;

    public zzki() {
        this.zzbww = null;
        this.zzbxh = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: zze */
    public final zzki zzb(zzabv zzabv) throws IOException {
        int zzuy;
        while (true) {
            int zzuw = zzabv.zzuw();
            if (zzuw == 0) {
                return this;
            }
            if (zzuw == 8) {
                try {
                    zzuy = zzabv.zzuy();
                    if (zzuy < 0 || zzuy > 6) {
                        StringBuilder sb = new StringBuilder(41);
                        sb.append(zzuy);
                        sb.append(" is not a valid enum MatchType");
                    } else {
                        this.zzash = Integer.valueOf(zzuy);
                    }
                } catch (IllegalArgumentException unused) {
                    zzabv.zzam(zzabv.getPosition());
                    zza(zzabv, zzuw);
                }
            } else if (zzuw == 18) {
                this.zzasi = zzabv.readString();
            } else if (zzuw == 24) {
                this.zzasj = Boolean.valueOf(zzabv.zzux());
            } else if (zzuw == 34) {
                int zzb = zzach.zzb(zzabv, 34);
                String[] strArr = this.zzask;
                int length = strArr == null ? 0 : strArr.length;
                String[] strArr2 = new String[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzask, 0, strArr2, 0, length);
                }
                while (length < strArr2.length - 1) {
                    strArr2[length] = zzabv.readString();
                    zzabv.zzuw();
                    length++;
                }
                strArr2[length] = zzabv.readString();
                this.zzask = strArr2;
            } else if (!super.zza(zzabv, zzuw)) {
                return this;
            }
        }
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append(zzuy);
        sb2.append(" is not a valid enum MatchType");
        throw new IllegalArgumentException(sb2.toString());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzki)) {
            return false;
        }
        zzki zzki = (zzki) obj;
        Integer num = this.zzash;
        if (num == null) {
            if (zzki.zzash != null) {
                return false;
            }
        } else if (!num.equals(zzki.zzash)) {
            return false;
        }
        String str = this.zzasi;
        if (str == null) {
            if (zzki.zzasi != null) {
                return false;
            }
        } else if (!str.equals(zzki.zzasi)) {
            return false;
        }
        Boolean bool = this.zzasj;
        if (bool == null) {
            if (zzki.zzasj != null) {
                return false;
            }
        } else if (!bool.equals(zzki.zzasj)) {
            return false;
        }
        if (!zzacc.equals(this.zzask, zzki.zzask)) {
            return false;
        }
        return (this.zzbww == null || this.zzbww.isEmpty()) ? zzki.zzbww == null || zzki.zzbww.isEmpty() : this.zzbww.equals(zzki.zzbww);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzash;
        int i = 0;
        int intValue = (hashCode + (num == null ? 0 : num.intValue())) * 31;
        String str = this.zzasi;
        int hashCode2 = (intValue + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.zzasj;
        int hashCode3 = (((hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31) + zzacc.hashCode(this.zzask)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i = this.zzbww.hashCode();
        }
        return hashCode3 + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        Integer num = this.zzash;
        if (num != null) {
            zza += zzabw.zzf(1, num.intValue());
        }
        String str = this.zzasi;
        if (str != null) {
            zza += zzabw.zzc(2, str);
        }
        Boolean bool = this.zzasj;
        if (bool != null) {
            bool.booleanValue();
            zza += zzabw.zzaq(3) + 1;
        }
        String[] strArr = this.zzask;
        if (strArr == null || strArr.length <= 0) {
            return zza;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr2 = this.zzask;
            if (i >= strArr2.length) {
                return zza + i2 + (i3 * 1);
            }
            String str2 = strArr2[i];
            if (str2 != null) {
                i3++;
                i2 += zzabw.zzfm(str2);
            }
            i++;
        }
    }

    public final void zza(zzabw zzabw) throws IOException {
        Integer num = this.zzash;
        if (num != null) {
            zzabw.zze(1, num.intValue());
        }
        String str = this.zzasi;
        if (str != null) {
            zzabw.zzb(2, str);
        }
        Boolean bool = this.zzasj;
        if (bool != null) {
            zzabw.zza(3, bool.booleanValue());
        }
        String[] strArr = this.zzask;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.zzask;
                if (i >= strArr2.length) {
                    break;
                }
                String str2 = strArr2[i];
                if (str2 != null) {
                    zzabw.zzb(4, str2);
                }
                i++;
            }
        }
        super.zza(zzabw);
    }
}
