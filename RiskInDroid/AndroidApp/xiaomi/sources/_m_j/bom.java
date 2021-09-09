package _m_j;

import android.graphics.Bitmap;
import java.io.File;

public final class bom {

    /* renamed from: O000000o  reason: collision with root package name */
    public bor<O000000o, Bitmap> f13172O000000o;
    public bol O00000Oo;
    private boq O00000o;
    private final int O00000o0 = 0;
    private final Object O00000oO = new Object();

    public bom(bol bol) {
        this.O00000Oo = bol;
    }

    public final void O000000o() {
        synchronized (this.O00000oO) {
            if (this.O00000Oo.O00000oO && (this.O00000o == null || this.O00000o.O00000o0())) {
                File file = new File(this.O00000Oo.f13170O000000o);
                if (file.exists() || file.mkdirs()) {
                    long O000000o2 = brn.O000000o(file);
                    long j = (long) this.O00000Oo.O00000o0;
                    if (O000000o2 > j) {
                        O000000o2 = j;
                    }
                    try {
                        this.O00000o = boq.O000000o(file, O000000o2);
                        boq boq = this.O00000o;
                        bop bop = this.O00000Oo.O0000O0o;
                        if (bop != null) {
                            boq.O0000O0o = bop;
                        }
                        brm.O000000o("create disk cache success");
                    } catch (Throwable th) {
                        this.O00000o = null;
                        brm.O000000o("create disk cache error", th);
                    }
                }
            }
        }
    }

    public final void O00000Oo() {
        bor<O000000o, Bitmap> bor = this.f13172O000000o;
        if (bor != null) {
            bor.O000000o();
        }
    }

    public final void O00000o0() {
        synchronized (this.O00000oO) {
            if (this.O00000o != null && !this.O00000o.O00000o0()) {
                try {
                    this.O00000o.O00000oo();
                    this.O00000o.close();
                } catch (Throwable th) {
                    brm.O000000o(th.getMessage(), th);
                }
                this.O00000o = null;
            }
        }
        O000000o();
    }

    public final void O000000o(String str) {
        O000000o o000000o = new O000000o(this, str);
        if (this.f13172O000000o != null) {
            while (this.f13172O000000o.O00000o(o000000o)) {
                this.f13172O000000o.O00000o0(o000000o);
            }
        }
    }

    public final void O00000Oo(String str) {
        synchronized (this.O00000oO) {
            if (this.O00000o != null && !this.O00000o.O00000o0()) {
                try {
                    boq boq = this.O00000o;
                    boq.O000000o(boq.O0000O0o.O000000o(str));
                } catch (Throwable th) {
                    brm.O000000o(th.getMessage(), th);
                }
            }
        }
    }

    public final void O00000o() {
        synchronized (this.O00000oO) {
            if (this.O00000o != null) {
                try {
                    this.O00000o.O00000o();
                } catch (Throwable th) {
                    brm.O000000o(th.getMessage(), th);
                }
            }
        }
    }

    public final void O00000oO() {
        synchronized (this.O00000oO) {
            if (this.O00000o != null) {
                try {
                    if (!this.O00000o.O00000o0()) {
                        this.O00000o.close();
                    }
                } catch (Throwable th) {
                    brm.O000000o(th.getMessage(), th);
                }
                this.O00000o = null;
            }
        }
    }

    public class O000000o {
        private String O00000Oo;
        private String O00000o0;

        /* synthetic */ O000000o(bom bom, String str) {
            this(str, null);
        }

        private O000000o(String str, bok bok) {
            this.O00000Oo = str;
            this.O00000o0 = null;
        }

        public final boolean equals(Object obj) {
            String str;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O000000o)) {
                return false;
            }
            O000000o o000000o = (O000000o) obj;
            if (!this.O00000Oo.equals(o000000o.O00000Oo)) {
                return false;
            }
            String str2 = this.O00000o0;
            if (str2 == null || (str = o000000o.O00000o0) == null) {
                return true;
            }
            return str2.equals(str);
        }

        public final int hashCode() {
            return this.O00000Oo.hashCode();
        }
    }
}
