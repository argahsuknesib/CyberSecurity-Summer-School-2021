package _m_j;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

public final class jpm implements Closeable, Flushable {

    /* renamed from: O000000o  reason: collision with root package name */
    static final Pattern f2024O000000o = Pattern.compile("[a-z0-9_-]{1,120}");
    static final /* synthetic */ boolean O00000Oo = (!jpm.class.desiredAssertionStatus());
    private static final iqy O0000o0O = new iqy() {
        /* class _m_j.jpm.AnonymousClass1 */

        public final ira O000000o() {
            return ira.O00000Oo;
        }

        public final void a_(iql iql, long j) throws IOException {
            iql.O00000oo(j);
        }

        public final void close() throws IOException {
        }

        public final void flush() throws IOException {
        }
    };
    private long O00000o;
    private final jqq O00000o0;
    private final int O00000oO;
    private long O00000oo;
    private iqm O0000O0o;
    private final LinkedHashMap<String, O00000Oo> O0000OOo;
    private boolean O0000Oo;
    private int O0000Oo0;
    private boolean O0000OoO;
    private boolean O0000Ooo;
    private final Runnable O0000o0;
    private final Executor O0000o00;

    public final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final O00000Oo f2025O000000o;
        boolean O00000Oo;
        final /* synthetic */ jpm O00000o0;
    }

    final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f2026O000000o;
        final long[] O00000Oo;
        final File[] O00000o;
        final File[] O00000o0;
        boolean O00000oO;
        O000000o O00000oo;

        /* access modifiers changed from: package-private */
        public final void O000000o(iqm iqm) throws IOException {
            for (long O0000Oo : this.O00000Oo) {
                iqm.O0000OOo(32).O0000Oo(O0000Oo);
            }
        }
    }

    private boolean O000000o() {
        int i = this.O0000Oo0;
        return i >= 2000 && i >= this.O0000OOo.size();
    }

    private synchronized boolean O00000Oo() {
        return this.O0000OoO;
    }

    private void O00000o() throws IOException {
        while (this.O00000oo > this.O00000o) {
            O000000o(this.O0000OOo.values().iterator().next());
        }
        this.O0000Ooo = false;
    }

    private synchronized void O00000o0() {
        if (O00000Oo()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void flush() throws IOException {
        if (this.O0000Oo) {
            O00000o0();
            O00000o();
            this.O0000O0o.flush();
        }
    }

    private synchronized void O000000o(O000000o o000000o, boolean z) throws IOException {
        O00000Oo o00000Oo = o000000o.f2025O000000o;
        if (o00000Oo.O00000oo == o000000o) {
            for (int i = 0; i < this.O00000oO; i++) {
                this.O00000o0.O000000o(o00000Oo.O00000o[i]);
            }
            this.O0000Oo0++;
            o00000Oo.O00000oo = null;
            if (false || o00000Oo.O00000oO) {
                o00000Oo.O00000oO = true;
                this.O0000O0o.O00000Oo("CLEAN").O0000OOo(32);
                this.O0000O0o.O00000Oo(o00000Oo.f2026O000000o);
                o00000Oo.O000000o(this.O0000O0o);
                this.O0000O0o.O0000OOo(10);
            } else {
                this.O0000OOo.remove(o00000Oo.f2026O000000o);
                this.O0000O0o.O00000Oo("REMOVE").O0000OOo(32);
                this.O0000O0o.O00000Oo(o00000Oo.f2026O000000o);
                this.O0000O0o.O0000OOo(10);
            }
            this.O0000O0o.flush();
            if (this.O00000oo > this.O00000o || O000000o()) {
                this.O0000o00.execute(this.O0000o0);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    private boolean O000000o(O00000Oo o00000Oo) throws IOException {
        if (o00000Oo.O00000oo != null) {
            o00000Oo.O00000oo.O00000Oo = true;
        }
        for (int i = 0; i < this.O00000oO; i++) {
            this.O00000o0.O000000o(o00000Oo.O00000o0[i]);
            this.O00000oo -= o00000Oo.O00000Oo[i];
            o00000Oo.O00000Oo[i] = 0;
        }
        this.O0000Oo0++;
        this.O0000O0o.O00000Oo("REMOVE").O0000OOo(32).O00000Oo(o00000Oo.f2026O000000o).O0000OOo(10);
        this.O0000OOo.remove(o00000Oo.f2026O000000o);
        if (O000000o()) {
            this.O0000o00.execute(this.O0000o0);
        }
        return true;
    }

    public final synchronized void close() throws IOException {
        if (this.O0000Oo) {
            if (!this.O0000OoO) {
                for (O00000Oo o00000Oo : (O00000Oo[]) this.O0000OOo.values().toArray(new O00000Oo[this.O0000OOo.size()])) {
                    if (o00000Oo.O00000oo != null) {
                        O000000o o000000o = o00000Oo.O00000oo;
                        synchronized (o000000o.O00000o0) {
                            o000000o.O00000o0.O000000o(o000000o, false);
                        }
                    }
                }
                O00000o();
                this.O0000O0o.close();
                this.O0000O0o = null;
                this.O0000OoO = true;
                return;
            }
        }
        this.O0000OoO = true;
    }
}
