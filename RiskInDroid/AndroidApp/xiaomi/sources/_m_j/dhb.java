package _m_j;

import android.content.Context;

public final class dhb {

    /* renamed from: O000000o  reason: collision with root package name */
    private static dhb f14634O000000o;
    private dgu O00000Oo;
    private dgz O00000o;
    private dgs O00000o0;
    private Context O00000oO;

    static /* synthetic */ void O000000o(dhb dhb) {
        did.O00000o0("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.agent.GameAgent");
            dhb.O00000o0.getClass();
            dif.O000000o(cls, "sdkPackageName", "com.tencent.bugly");
            did.O00000o0("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            did.O000000o("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    private dhb(Context context) {
        dha O000000o2 = dha.O000000o();
        if (O000000o2 != null) {
            this.O00000Oo = dgu.O000000o();
            this.O00000o0 = dgs.O000000o(context);
            this.O00000o = O000000o2.O0000o0O;
            this.O00000oO = context;
            dic.O000000o().O000000o(new Runnable() {
                /* class _m_j.dhb.AnonymousClass1 */

                public final void run() {
                    dhb.O000000o(dhb.this);
                }
            });
        }
    }

    public static dhb O000000o(Context context) {
        if (f14634O000000o == null) {
            f14634O000000o = new dhb(context);
        }
        return f14634O000000o;
    }
}
