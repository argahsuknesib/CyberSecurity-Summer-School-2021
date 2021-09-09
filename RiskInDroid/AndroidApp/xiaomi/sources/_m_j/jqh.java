package _m_j;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import ss.ss.gK.o;

public final class jqh {

    /* renamed from: O000000o  reason: collision with root package name */
    public final jot f2055O000000o;
    jqf O00000Oo;
    private jou O00000o;
    jqr O00000o0;
    private final jpb O00000oO;
    private boolean O00000oo;
    private boolean O0000O0o;
    private jqa O0000OOo;

    public jqh(jpb jpb, jot jot) {
        this.O00000oO = jpb;
        this.f2055O000000o = jot;
        this.O00000Oo = new jqf(jot, O00000o0());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0.O000000o(r8) == false) goto L_0x0015;
     */
    private jqr O00000Oo(int i, int i2, int i3, boolean z, boolean z2) throws IOException, o {
        while (true) {
            jqr O000000o2 = O000000o(i, i2, i3, z);
            synchronized (this.O00000oO) {
                if (O000000o2.O00000oO == 0) {
                    return O000000o2;
                }
            }
            O000000o(new IOException());
        }
        while (true) {
        }
    }

    private void O00000Oo(jqr jqr) {
        int size = jqr.O0000Oo0.size();
        for (int i = 0; i < size; i++) {
            if (jqr.O0000Oo0.get(i).get() == this) {
                jqr.O0000Oo0.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private jqo O00000o0() {
        return jpn.O00000Oo.O000000o(this.O00000oO);
    }

    public final synchronized jqr O000000o() {
        return this.O00000o0;
    }

    public final void O000000o(jqr jqr) {
        jqr.O0000Oo0.add(new WeakReference(this));
    }

    public final void O000000o(IOException iOException) {
        synchronized (this.O00000oO) {
            if (this.O00000o0 != null && this.O00000o0.O00000oO == 0) {
                if (!(this.O00000o == null || iOException == null)) {
                    this.O00000Oo.O000000o(this.O00000o, iOException);
                }
                this.O00000o = null;
            }
        }
        O000000o(true, false, true);
    }

    public final void O000000o(boolean z, jqa jqa) {
        synchronized (this.O00000oO) {
            if (jqa != null) {
                if (jqa == this.O0000OOo) {
                    if (!z) {
                        this.O00000o0.O00000oO++;
                    }
                }
            }
            throw new IllegalStateException("expected " + this.O0000OOo + " but was " + jqa);
        }
        O000000o(z, false, true);
    }

    public final void O00000Oo() {
        O000000o(false, true, false);
    }

    public final String toString() {
        return this.f2055O000000o.toString();
    }

    public final jqa O000000o(int i, int i2, int i3, boolean z, boolean z2) throws o, IOException {
        jqa jqa;
        try {
            jqr O00000Oo2 = O00000Oo(i, i2, i3, z, z2);
            if (O00000Oo2.O00000o != null) {
                jqa = new jpw(this, O00000Oo2.O00000o);
            } else {
                O00000Oo2.O00000Oo.setSoTimeout(i2);
                O00000Oo2.O00000oo.O000000o().O000000o((long) i2, TimeUnit.MILLISECONDS);
                O00000Oo2.O0000O0o.O000000o().O000000o((long) i3, TimeUnit.MILLISECONDS);
                jqa = new jpv(this, O00000Oo2.O00000oo, O00000Oo2.O0000O0o);
            }
            synchronized (this.O00000oO) {
                this.O0000OOo = jqa;
            }
            return jqa;
        } catch (IOException e) {
            throw new o(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002c, code lost:
        if (r1 != null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002e, code lost:
        r1 = r8.O00000Oo.O000000o();
        r0 = r8.O00000oO;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0036, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r8.O00000o = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0039, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x003e, code lost:
        r0 = new _m_j.jqr(r1);
        O000000o(r0);
        r1 = r8.O00000oO;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0048, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        _m_j.jpn.O00000Oo.O000000o(r8.O00000oO, r0);
        r8.O00000o0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0054, code lost:
        if (r8.O0000O0o != false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0056, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0057, code lost:
        r0.O000000o(r9, r10, r11, r8.f2055O000000o.O00000oo, r12);
        O00000o0().O00000Oo(r0.f2064O000000o);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x006c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0074, code lost:
        throw new java.io.IOException("Canceled");
     */
    private jqr O000000o(int i, int i2, int i3, boolean z) throws IOException, o {
        synchronized (this.O00000oO) {
            if (this.O00000oo) {
                throw new IllegalStateException("released");
            } else if (this.O0000OOo != null) {
                throw new IllegalStateException("stream != null");
            } else if (!this.O0000O0o) {
                jqr jqr = this.O00000o0;
                if (jqr != null && !jqr.O0000Oo) {
                    return jqr;
                }
                jqr O000000o2 = jpn.O00000Oo.O000000o(this.O00000oO, this.f2055O000000o, this);
                if (O000000o2 != null) {
                    this.O00000o0 = O000000o2;
                    return O000000o2;
                }
                jou jou = this.O00000o;
            } else {
                throw new IOException("Canceled");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(boolean z, boolean z2, boolean z3) {
        jqr jqr;
        synchronized (this.O00000oO) {
            if (z3) {
                try {
                    this.O0000OOo = null;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (z2) {
                this.O00000oo = true;
            }
            if (this.O00000o0 != null) {
                if (z) {
                    this.O00000o0.O0000Oo = true;
                }
                if (this.O0000OOo == null && (this.O00000oo || this.O00000o0.O0000Oo)) {
                    O00000Oo(this.O00000o0);
                    if (this.O00000o0.O0000Oo0.isEmpty()) {
                        this.O00000o0.O0000OoO = System.nanoTime();
                        if (jpn.O00000Oo.O00000Oo(this.O00000oO, this.O00000o0)) {
                            jqr = this.O00000o0;
                            this.O00000o0 = null;
                        }
                    }
                    jqr = null;
                    this.O00000o0 = null;
                }
            }
            jqr = null;
        }
        if (jqr != null) {
            jqp.O000000o(jqr.O00000Oo);
        }
    }
}
