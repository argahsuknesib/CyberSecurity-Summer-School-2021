package _m_j;

import android.os.SystemClock;
import android.util.Pair;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.az;
import com.xiaomi.push.service.bd;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class eqb {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f15720O000000o;
    private static final AtomicInteger O0000oO0 = new AtomicInteger(0);
    protected int O00000Oo = 0;
    protected volatile long O00000o = 0;
    protected long O00000o0 = -1;
    protected volatile long O00000oO = 0;
    public LinkedList<Pair<Integer, Long>> O00000oo = new LinkedList<>();
    public final Collection<eqe> O0000O0o = new CopyOnWriteArrayList();
    protected final Map<eqg, O000000o> O0000OOo = new ConcurrentHashMap();
    protected eqm O0000Oo;
    protected final Map<eqg, O000000o> O0000Oo0 = new ConcurrentHashMap();
    protected String O0000OoO;
    protected String O0000Ooo;
    protected long O0000o;
    protected final int O0000o0;
    int O0000o00;
    protected eqc O0000o0O;
    protected XMPushService O0000o0o;
    private long O0000oO;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        eqg f15721O000000o;
        eqn O00000Oo;

        public O000000o(eqg eqg, eqn eqn) {
            this.f15721O000000o = eqg;
            this.O00000Oo = eqn;
        }

        public final void O000000o(epq epq) {
            this.f15721O000000o.a(epq);
        }
    }

    static {
        f15720O000000o = false;
        try {
            f15720O000000o = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        eqh.O000000o();
    }

    private static String O000000o(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown";
    }

    public final void O000000o(eqg eqg, eqn eqn) {
        if (eqg != null) {
            this.O0000OOo.put(eqg, new O000000o(eqg, eqn));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    public abstract void O000000o(eqr eqr);

    public abstract void O000000o(az.b bVar);

    public final synchronized void O000000o(String str) {
        if (this.O0000o00 == 0) {
            duv.O000000o("setChallenge hash = " + emk.O000000o(str).substring(0, 8));
            this.O0000OoO = str;
            O000000o(1, 0, null);
            return;
        }
        duv.O000000o("ignore setChallenge because connection was disconnected");
    }

    public abstract void O000000o(String str, String str2);

    public abstract void O000000o(epq[] epqArr);

    public final synchronized boolean O000000o(long j) {
        return this.O0000oO >= j;
    }

    public abstract void O00000Oo(int i, Exception exc);

    public abstract void O00000Oo(epq epq);

    public final void O00000Oo(eqg eqg, eqn eqn) {
        if (eqg != null) {
            this.O0000Oo0.put(eqg, new O000000o(eqg, eqn));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    public abstract void O00000Oo(boolean z);

    public boolean O00000Oo() {
        return false;
    }

    public final eqc O00000o() {
        return this.O0000o0O;
    }

    public String O00000oO() {
        return this.O0000o0O.c();
    }

    public final String O00000oo() {
        return this.O0000o0O.b();
    }

    public final long O0000O0o() {
        return this.O00000oO;
    }

    /* access modifiers changed from: protected */
    public final Map<eqg, O000000o> O0000OOo() {
        return this.O0000OOo;
    }

    public final boolean O0000Oo() {
        return this.O0000o00 == 1;
    }

    public final boolean O0000Oo0() {
        return this.O0000o00 == 0;
    }

    public final int O0000OoO() {
        return this.O00000Oo;
    }

    public final synchronized void O0000Ooo() {
        this.O0000oO = SystemClock.elapsedRealtime();
    }

    protected eqb(XMPushService xMPushService, eqc eqc) {
        String str;
        Class<?> cls = null;
        this.O0000Oo = null;
        this.O0000OoO = "";
        this.O0000Ooo = "";
        this.O0000o00 = 2;
        this.O0000o0 = O0000oO0.getAndIncrement();
        this.O0000oO = 0;
        this.O0000o = 0;
        this.O0000o0O = eqc;
        this.O0000o0o = xMPushService;
        if (this.O0000o0O.m605a() && this.O0000Oo == null) {
            try {
                str = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                str = null;
            }
            if (str != null) {
                try {
                    cls = Class.forName(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (cls == null) {
                this.O0000Oo = new epz(this);
                return;
            }
            try {
                this.O0000Oo = (eqm) cls.getConstructor(eqb.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    public final void O000000o(int i, int i2, Exception exc) {
        int i3 = this.O0000o00;
        if (i != i3) {
            duv.O000000o(String.format("update the connection status. %1$s -> %2$s : %3$s ", O000000o(i3), O000000o(i), bd.a(i2)));
        }
        if (emf.O000000o(this.O0000o0o)) {
            synchronized (this.O00000oo) {
                if (i == 1) {
                    this.O00000oo.clear();
                } else {
                    this.O00000oo.add(new Pair(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                    if (this.O00000oo.size() > 6) {
                        this.O00000oo.remove(0);
                    }
                }
            }
        }
        if (i == 1) {
            this.O0000o0o.a(10);
            if (this.O0000o00 != 0) {
                duv.O000000o("try set connected while not connecting.");
            }
            this.O0000o00 = i;
            for (eqe b : this.O0000O0o) {
                b.b(this);
            }
        } else if (i == 0) {
            if (this.O0000o00 != 2) {
                duv.O000000o("try set connecting while not disconnected.");
            }
            this.O0000o00 = i;
            for (eqe a2 : this.O0000O0o) {
                a2.a(this);
            }
        } else if (i == 2) {
            this.O0000o0o.a(10);
            int i4 = this.O0000o00;
            if (i4 == 0) {
                for (eqe a3 : this.O0000O0o) {
                    a3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i4 == 1) {
                for (eqe a4 : this.O0000O0o) {
                    a4.a(this, i2, exc);
                }
            }
            this.O0000o00 = i;
        }
    }
}
