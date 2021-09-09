package _m_j;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class duv {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f14959O000000o = 2;
    private static Context O00000Oo = null;
    /* access modifiers changed from: private */
    public static String O00000o = ("XMPush-" + Process.myPid());
    private static boolean O00000o0 = false;
    private static dut O00000oO = new O000000o();
    private static final HashMap<Integer, Long> O00000oo = new HashMap<>();
    private static final HashMap<Integer, String> O0000O0o = new HashMap<>();
    private static final Integer O0000OOo = -1;
    private static AtomicInteger O0000Oo0 = new AtomicInteger(1);

    static class O000000o implements dut {

        /* renamed from: O000000o  reason: collision with root package name */
        private String f14960O000000o = duv.O00000o;

        O000000o() {
        }

        public final void O000000o(String str) {
            gsy.O000000o(2, this.f14960O000000o, str);
        }

        public final void O000000o(String str, Throwable th) {
            Log.v(this.f14960O000000o, str, th);
        }
    }

    public static void O000000o() {
        f14959O000000o = 2;
    }

    private static void O000000o(int i, String str) {
        if (i >= f14959O000000o) {
            O00000oO.O000000o(str);
        }
    }

    public static void O000000o(dut dut) {
        O00000oO = dut;
    }

    public static void O000000o(Context context) {
        O00000Oo = context;
        if (esl.O000000o(context)) {
            O00000o0 = true;
        }
    }

    public static void O000000o(Integer num) {
        if (f14959O000000o <= 1 && O00000oo.containsKey(num)) {
            long currentTimeMillis = System.currentTimeMillis() - O00000oo.remove(num).longValue();
            dut dut = O00000oO;
            dut.O000000o(O0000O0o.remove(num) + " ends in " + currentTimeMillis + " ms");
        }
    }

    public static void O000000o(String str) {
        O000000o(2, O0000O0o(str));
    }

    public static int O00000Oo() {
        return f14959O000000o;
    }

    public static void O00000Oo(String str) {
        O000000o(0, O0000O0o(str));
    }

    private static String O00000o() {
        return "[Tid:" + Thread.currentThread().getId() + "] ";
    }

    public static void O00000o(String str) {
        O000000o(4, O0000O0o(str));
    }

    public static void O00000o0(String str) {
        O000000o(1, O0000O0o(str));
    }

    public static Integer O00000oO(String str) {
        if (f14959O000000o > 1) {
            return O0000OOo;
        }
        Integer valueOf = Integer.valueOf(O0000Oo0.incrementAndGet());
        O00000oo.put(valueOf, Long.valueOf(System.currentTimeMillis()));
        O0000O0o.put(valueOf, str);
        dut dut = O00000oO;
        dut.O000000o(str + " starts");
        return valueOf;
    }

    public static void O00000oo(String str) {
        if (O00000o0) {
            O000000o(str);
        } else {
            gsy.O000000o(4, O00000o, O0000O0o(str));
        }
    }

    private static String O0000O0o(String str) {
        return O00000o() + str;
    }

    public static void O000000o(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(O00000o());
        sb.append("[" + str + "] " + str2);
        O000000o(2, sb.toString());
    }

    public static void O000000o(String str, Throwable th) {
        String O0000O0o2 = O0000O0o(str);
        if (4 >= f14959O000000o) {
            O00000oO.O000000o(O0000O0o2, th);
        }
    }

    public static void O000000o(Throwable th) {
        if (4 >= f14959O000000o) {
            O00000oO.O000000o("", th);
        }
    }
}
