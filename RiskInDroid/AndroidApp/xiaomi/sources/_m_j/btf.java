package _m_j;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

public class btf {

    /* renamed from: O000000o  reason: collision with root package name */
    static int f13264O000000o = 1000;
    static boolean O00000Oo = false;
    /* access modifiers changed from: private */
    public static WeakReference<btb> O00000o = null;
    static int O00000o0 = 20;
    /* access modifiers changed from: private */
    public static int O00000oO = 10;

    public static synchronized void O000000o(int i, boolean z, int i2) {
        synchronized (btf.class) {
            f13264O000000o = i;
            O00000Oo = z;
            if (i2 < 10 || i2 > 100) {
                i2 = 20;
            }
            O00000o0 = i2;
            if (i2 / 5 > O00000oO) {
                O00000oO = O00000o0 / 5;
            }
        }
    }

    public static synchronized void O000000o(final bte bte, final Context context) {
        synchronized (btf.class) {
            bsf.O00000o().submit(new Runnable() {
                /* class _m_j.btf.AnonymousClass1 */

                public final void run() {
                    try {
                        synchronized (btf.class) {
                            String l = Long.toString(System.currentTimeMillis());
                            btb O000000o2 = bti.O000000o(btf.O00000o);
                            bti.O000000o(context, O000000o2, bsd.O0000Oo0, btf.f13264O000000o, 2097152, "6");
                            if (O000000o2.O00000oO == null) {
                                O000000o2.O00000oO = new brv(new brx(new brz(new brx())));
                            }
                            bte bte = bte;
                            btc.O000000o(l, brs.O000000o(bte.O000000o(bte.f13263O000000o, bte.O00000Oo, bte.O00000o0)), O000000o2);
                        }
                    } catch (Throwable th) {
                        bsf.O00000Oo(th, "ofm", "aple");
                    }
                }
            });
        }
    }

    public static void O000000o(final Context context) {
        bsf.O00000o().submit(new Runnable() {
            /* class _m_j.btf.AnonymousClass2 */

            public final void run() {
                try {
                    btb O000000o2 = bti.O000000o(btf.O00000o);
                    bti.O000000o(context, O000000o2, bsd.O0000Oo0, btf.f13264O000000o, 2097152, "6");
                    O000000o2.O0000OOo = 14400000;
                    if (O000000o2.O0000O0o == null) {
                        brv brv = new brv(new brx(new brz()));
                        O000000o2.O0000O0o = new btm(new btl(context, new btr(), brv, new String(bsa.O000000o(10)), bwt.O00000oo(context), bww.O0000oOo(context), bww.O0000Ooo(context), bww.O0000O0o(context), bww.O000000o(), Build.MANUFACTURER, Build.DEVICE, bww.O0000ooO(context), bwt.O00000o0(context), Build.MODEL, bwt.O00000o(context), bwt.O00000Oo(context)));
                    }
                    if (TextUtils.isEmpty(O000000o2.O0000Oo0)) {
                        O000000o2.O0000Oo0 = "fKey";
                    }
                    O000000o2.O00000oo = new btv(context, O000000o2.O0000OOo, O000000o2.O0000Oo0, new btt(context, btf.O00000Oo, btf.O00000oO * 1024, btf.O00000o0 * 1024));
                    btc.O000000o(O000000o2);
                } catch (Throwable th) {
                    bsf.O00000Oo(th, "ofm", "uold");
                }
            }
        });
    }
}
