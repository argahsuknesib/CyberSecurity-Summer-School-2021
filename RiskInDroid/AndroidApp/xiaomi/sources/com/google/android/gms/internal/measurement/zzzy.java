package com.google.android.gms.internal.measurement;

public class zzzy {
    private static final zzzi zzbsw = zzzi.zzte();
    private zzyw zzbsx;
    private volatile zzaal zzbsy;
    private volatile zzyw zzbsz;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    private final zzaal zzb(zzaal zzaal) {
        if (this.zzbsy == null) {
            synchronized (this) {
                if (this.zzbsy == null) {
                    this.zzbsy = zzaal;
                    this.zzbsz = zzyw.zzbqx;
                    this.zzbsy = zzaal;
                    this.zzbsz = zzyw.zzbqx;
                }
            }
        }
        return this.zzbsy;
    }

    private final zzyw zztp() {
        if (this.zzbsz != null) {
            return this.zzbsz;
        }
        synchronized (this) {
            if (this.zzbsz != null) {
                zzyw zzyw = this.zzbsz;
                return zzyw;
            }
            this.zzbsz = this.zzbsy == null ? zzyw.zzbqx : this.zzbsy.zztp();
            zzyw zzyw2 = this.zzbsz;
            return zzyw2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzzy)) {
            return false;
        }
        zzzy zzzy = (zzzy) obj;
        zzaal zzaal = this.zzbsy;
        zzaal zzaal2 = zzzy.zzbsy;
        return (zzaal == null && zzaal2 == null) ? zztp().equals(zzzy.zztp()) : (zzaal == null || zzaal2 == null) ? zzaal != null ? zzaal.equals(zzzy.zzb(zzaal.zztz())) : zzb(zzaal2.zztz()).equals(zzaal2) : zzaal.equals(zzaal2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzaal zzc(zzaal zzaal) {
        zzaal zzaal2 = this.zzbsy;
        this.zzbsx = null;
        this.zzbsz = null;
        this.zzbsy = zzaal;
        return zzaal2;
    }
}
