package _m_j;

import _m_j.erk;
import _m_j.erm;
import android.os.SystemClock;
import com.xiaomi.push.fg;
import com.xiaomi.push.fh;
import com.xiaomi.push.fi;
import com.xiaomi.push.gg;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.az;
import java.net.UnknownHostException;
import java.util.Hashtable;

public final class ero {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final int f15751O000000o = fg.c.a();
    private static long O00000Oo = 0;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        static Hashtable<Integer, Long> f15752O000000o = new Hashtable<>();
    }

    public static void O000000o() {
        if (O00000Oo == 0 || SystemClock.elapsedRealtime() - O00000Oo > 7200000) {
            O00000Oo = SystemClock.elapsedRealtime();
            O000000o(f15751O000000o);
        }
    }

    public static synchronized void O000000o(int i) {
        synchronized (ero.class) {
            if (i < 16777215) {
                O000000o.f15752O000000o.put(Integer.valueOf(i | 0), Long.valueOf(System.currentTimeMillis()));
                return;
            }
            duv.O00000o("stats key should less than 16777215");
        }
    }

    public static void O00000Oo() {
        O000000o(f15751O000000o, (String) null, -1);
    }

    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b7 A[Catch:{ NullPointerException -> 0x00c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b9 A[Catch:{ NullPointerException -> 0x00c2 }] */
    public static void O000000o(String str, Exception exc) {
        fg fgVar;
        Throwable cause;
        try {
            erk.O000000o(exc);
            boolean z = exc instanceof gg;
            Throwable th = exc;
            if (z) {
                Throwable a2 = ((gg) exc).a();
                th = exc;
                if (a2 != null) {
                    th = ((gg) exc).a();
                }
            }
            erk.O000000o o000000o = new erk.O000000o();
            String message = th.getMessage();
            if (th.getCause() != null) {
                message = th.getCause().getMessage();
            }
            int O000000o2 = eqd.O000000o(th);
            String str2 = th.getClass().getSimpleName() + ":" + message;
            if (O000000o2 != 0) {
                o000000o.f15746O000000o = fg.a(fg.v.a() + O000000o2);
                if (o000000o.f15746O000000o == fg.G && (cause = th.getCause()) != null && (cause instanceof UnknownHostException)) {
                    fgVar = fg.F;
                }
                if (o000000o.f15746O000000o == fg.D || o000000o.f15746O000000o == fg.E || o000000o.f15746O000000o == fg.G) {
                    o000000o.O00000Oo = str2;
                }
                fh O00000o0 = erm.O000000o.f15749O000000o.O00000o0();
                O00000o0.O000000o(o000000o.f15746O000000o.a());
                O00000o0.f37c = o000000o.O00000Oo;
                O00000o0.f36b = str;
                if (!(erm.O000000o() == null || erm.O000000o().f15747O000000o == null)) {
                    O00000o0.O00000o0(!emf.O00000Oo(erm.O000000o().f15747O000000o) ? 1 : 0);
                }
                erm.O000000o.f15749O000000o.O000000o(O00000o0);
            }
            fgVar = fg.E;
            o000000o.f15746O000000o = fgVar;
            o000000o.O00000Oo = str2;
            fh O00000o02 = erm.O000000o.f15749O000000o.O00000o0();
            O00000o02.O000000o(o000000o.f15746O000000o.a());
            O00000o02.f37c = o000000o.O00000Oo;
            O00000o02.f36b = str;
            O00000o02.O00000o0(!emf.O00000Oo(erm.O000000o().f15747O000000o) ? 1 : 0);
            erm.O000000o.f15749O000000o.O000000o(O00000o02);
        } catch (NullPointerException unused) {
        }
    }

    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b6 A[Catch:{ NullPointerException -> 0x00c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b8 A[Catch:{ NullPointerException -> 0x00c1 }] */
    public static void O00000Oo(String str, Exception exc) {
        fg fgVar;
        try {
            erk.O000000o(exc);
            boolean z = exc instanceof gg;
            Throwable th = exc;
            if (z) {
                Throwable a2 = ((gg) exc).a();
                th = exc;
                if (a2 != null) {
                    th = ((gg) exc).a();
                }
            }
            erk.O000000o o000000o = new erk.O000000o();
            String message = th.getMessage();
            int O000000o2 = eqd.O000000o(th);
            String str2 = th.getClass().getSimpleName() + ":" + message;
            if (O000000o2 == 105) {
                fgVar = fg.X;
            } else if (O000000o2 == 199) {
                fgVar = fg.aa;
            } else if (O000000o2 != 499) {
                fgVar = O000000o2 != 109 ? O000000o2 != 110 ? fg.ab : fg.Z : fg.Y;
            } else {
                o000000o.f15746O000000o = fg.ad;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    fgVar = fg.ac;
                }
                if (o000000o.f15746O000000o == fg.aa || o000000o.f15746O000000o == fg.ab || o000000o.f15746O000000o == fg.ad) {
                    o000000o.O00000Oo = str2;
                }
                fh O00000o0 = erm.O000000o.f15749O000000o.O00000o0();
                O00000o0.O000000o(o000000o.f15746O000000o.a());
                O00000o0.f37c = o000000o.O00000Oo;
                O00000o0.f36b = str;
                if (!(erm.O000000o() == null || erm.O000000o().f15747O000000o == null)) {
                    O00000o0.O00000o0(!emf.O00000Oo(erm.O000000o().f15747O000000o) ? 1 : 0);
                }
                erm.O000000o.f15749O000000o.O000000o(O00000o0);
            }
            o000000o.f15746O000000o = fgVar;
            o000000o.O00000Oo = str2;
            fh O00000o02 = erm.O000000o.f15749O000000o.O00000o0();
            O00000o02.O000000o(o000000o.f15746O000000o.a());
            O00000o02.f37c = o000000o.O00000Oo;
            O00000o02.f36b = str;
            O00000o02.O00000o0(!emf.O00000Oo(erm.O000000o().f15747O000000o) ? 1 : 0);
            erm.O000000o.f15749O000000o.O000000o(O00000o02);
        } catch (NullPointerException unused) {
        }
    }

    public static void O000000o(String str, int i, Exception exc) {
        fh O00000o0 = erm.O000000o.f15749O000000o.O00000o0();
        if (!(erm.O000000o() == null || erm.O000000o().f15747O000000o == null)) {
            O00000o0.O00000o0(emf.O00000Oo(erm.O000000o().f15747O000000o) ? 1 : 0);
        }
        if (i > 0) {
            O00000o0.O000000o(fg.l.a());
            O00000o0.f36b = str;
            O00000o0.O00000Oo(i);
            erm.O000000o.f15749O000000o.O000000o(O00000o0);
            return;
        }
        try {
            erk.O000000o(exc);
            erk.O000000o o000000o = new erk.O000000o();
            String message = exc.getMessage();
            if (exc.getCause() != null) {
                message = exc.getCause().getMessage();
            }
            String str2 = exc.getClass().getSimpleName() + ":" + message;
            int O000000o2 = eqd.O000000o(exc);
            if (O000000o2 != 0) {
                o000000o.f15746O000000o = fg.a(fg.l.a() + O000000o2);
            }
            if (o000000o.f15746O000000o == null) {
                o000000o.f15746O000000o = fg.t;
            }
            if (o000000o.f15746O000000o == fg.t) {
                o000000o.O00000Oo = str2;
            }
            O00000o0.O000000o(o000000o.f15746O000000o.a());
            O00000o0.f37c = o000000o.O00000Oo;
            O00000o0.f36b = str;
            erm.O000000o.f15749O000000o.O000000o(O00000o0);
        } catch (NullPointerException unused) {
        }
    }

    public static void O000000o(XMPushService xMPushService, az.b bVar) {
        erh erh = new erh(xMPushService, bVar);
        erh.O00000Oo.a(erh);
        erh.O00000o0 = erh.f15743O000000o.m119a();
    }

    public static synchronized void O000000o(int i, String str, int i2) {
        synchronized (ero.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i3 = i | 0;
            if (O000000o.f15752O000000o.containsKey(Integer.valueOf(i3))) {
                fh O00000o0 = erm.O000000o.f15749O000000o.O00000o0();
                O00000o0.O000000o(i);
                O00000o0.O00000Oo((int) (currentTimeMillis - O000000o.f15752O000000o.get(Integer.valueOf(i3)).longValue()));
                O00000o0.f36b = str;
                if (i2 >= 0) {
                    O00000o0.O00000o0(i2);
                }
                erm.O000000o.f15749O000000o.O000000o(O00000o0);
                O000000o.f15752O000000o.remove(Integer.valueOf(i));
                return;
            }
            duv.O00000o("stats key not found");
        }
    }

    public static void O000000o(int i, int i2, String str, int i3) {
        fh O00000o0 = erm.O000000o.f15749O000000o.O00000o0();
        O00000o0.O000000o((byte) 0);
        O00000o0.O000000o(i);
        O00000o0.O00000Oo(i2);
        O00000o0.f36b = str;
        O00000o0.O00000o0(i3);
        erm.O000000o.f15749O000000o.O000000o(O00000o0);
    }

    public static void O00000Oo(int i) {
        fh O00000o0 = erm.O000000o.f15749O000000o.O00000o0();
        O00000o0.O000000o(fg.k.a());
        O00000o0.O00000o0(i);
        erm.O000000o.f15749O000000o.O000000o(O00000o0);
    }

    public static byte[] O00000o0() {
        fi O00000Oo2 = erm.O000000o.f15749O000000o.O00000Oo();
        if (O00000Oo2 != null) {
            return eru.O000000o(O00000Oo2);
        }
        return null;
    }
}
