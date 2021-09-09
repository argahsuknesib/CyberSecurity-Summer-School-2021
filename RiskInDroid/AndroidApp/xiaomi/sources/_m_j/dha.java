package _m_j;

import _m_j.dgj;
import android.content.Context;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;

public final class dha {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f14631O000000o = 0;
    public static boolean O00000Oo = false;
    public static boolean O00000o = true;
    public static int O00000o0 = 2;
    public static int O00000oO = 20000;
    public static int O00000oo = 20000;
    public static long O0000O0o = 604800000;
    public static String O0000OOo = null;
    public static String O0000Oo = null;
    public static boolean O0000Oo0 = false;
    public static int O0000OoO = 5000;
    public static boolean O0000Ooo = true;
    public static String O0000o0;
    public static String O0000o00;
    private static dha O0000oOo;
    public final NativeCrashHandler O0000o;
    public final dgz O0000o0O;
    public final dhc O0000o0o;
    public final dgy O0000oO;
    public dic O0000oO0;
    /* access modifiers changed from: private */
    public final Context O0000oOO;
    private dgu O0000oo0 = dgu.O000000o();

    private dha(Context context, dic dic, boolean z, dgj.O000000o o000000o) {
        f14631O000000o = 1004;
        Context O000000o2 = dif.O000000o(context);
        this.O0000oOO = O000000o2;
        this.O0000oO0 = dic;
        this.O0000o0O = new dgz(1004, O000000o2, dia.O000000o(), dhv.O000000o(), this.O0000oo0, o000000o, null);
        dgs O000000o3 = dgs.O000000o(O000000o2);
        this.O0000o0o = new dhc(O000000o2, this.O0000o0O, this.O0000oo0, O000000o3);
        this.O0000o = NativeCrashHandler.O000000o(O000000o2, O000000o3, this.O0000o0O, dic, z, null);
        O000000o3.O000OO = this.O0000o;
        this.O0000oO = new dgy(O000000o2, this.O0000oo0, O000000o3, dic, this.O0000o0O);
    }

    public static synchronized void O000000o(Context context, boolean z, dgj.O000000o o000000o) {
        synchronized (dha.class) {
            if (O0000oOo == null) {
                O0000oOo = new dha(context, dic.O000000o(), z, o000000o);
            }
        }
    }

    public static synchronized dha O000000o() {
        dha dha;
        synchronized (dha.class) {
            dha = O0000oOo;
        }
        return dha;
    }

    public final synchronized void O00000Oo() {
        this.O0000o0o.O00000Oo();
        this.O0000o.O00000Oo(false);
        this.O0000oO.O000000o(false);
    }

    public final boolean O00000o0() {
        return this.O0000oO.f14624O000000o.get() != 0;
    }
}
