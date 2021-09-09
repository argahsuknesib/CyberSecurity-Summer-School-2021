package com.google.android.gms.internal.clearcut;

public class zzcv {
    private static final zzbt zzez = zzbt.zzan();
    private zzbb zzln;
    private volatile zzdo zzlo;
    private volatile zzbb zzlp;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    private final zzdo zzh(zzdo zzdo) {
        if (this.zzlo == null) {
            synchronized (this) {
                if (this.zzlo == null) {
                    this.zzlo = zzdo;
                    this.zzlp = zzbb.zzfi;
                    this.zzlo = zzdo;
                    this.zzlp = zzbb.zzfi;
                }
            }
        }
        return this.zzlo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcv)) {
            return false;
        }
        zzcv zzcv = (zzcv) obj;
        zzdo zzdo = this.zzlo;
        zzdo zzdo2 = zzcv.zzlo;
        return (zzdo == null && zzdo2 == null) ? zzr().equals(zzcv.zzr()) : (zzdo == null || zzdo2 == null) ? zzdo != null ? zzdo.equals(zzcv.zzh(zzdo.zzbe())) : zzh(zzdo2.zzbe()).equals(zzdo2) : zzdo.equals(zzdo2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zzas() {
        if (this.zzlp != null) {
            return this.zzlp.size();
        }
        if (this.zzlo != null) {
            return this.zzlo.zzas();
        }
        return 0;
    }

    public final zzdo zzi(zzdo zzdo) {
        zzdo zzdo2 = this.zzlo;
        this.zzln = null;
        this.zzlp = null;
        this.zzlo = zzdo;
        return zzdo2;
    }

    public final zzbb zzr() {
        if (this.zzlp != null) {
            return this.zzlp;
        }
        synchronized (this) {
            if (this.zzlp != null) {
                zzbb zzbb = this.zzlp;
                return zzbb;
            }
            this.zzlp = this.zzlo == null ? zzbb.zzfi : this.zzlo.zzr();
            zzbb zzbb2 = this.zzlp;
            return zzbb2;
        }
    }
}
