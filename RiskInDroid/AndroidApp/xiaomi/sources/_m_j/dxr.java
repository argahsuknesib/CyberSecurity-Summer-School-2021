package _m_j;

import _m_j.dxz;
import _m_j.dyq;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;

public final class dxr {

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f15037O000000o;
    public Context O00000Oo;
    public Handler O00000o;
    public boolean O00000o0;
    public dxy O00000oO;
    private final String O00000oo;

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static dxr f15041O000000o = new dxr((byte) 0);
    }

    /* synthetic */ dxr(byte b) {
        this();
    }

    private dxr() {
        this.O00000oo = "MiotMonitorManager";
        this.f15037O000000o = false;
        this.O00000o0 = false;
    }

    public final void O000000o(Context context, boolean z) {
        if (this.O00000oO != null) {
            if (context != null || context.getApplicationContext() != null) {
                this.O00000Oo = context.getApplicationContext();
                if (this.O00000oO.O00000Oo.switchFlag) {
                    dyy.O00000Oo(this.O00000Oo);
                }
            }
        }
    }

    public final dxy O000000o() {
        if (this.O00000oO == null) {
            this.O00000oO = dxz.O000000o.f15051O000000o.f15050O000000o;
            String O000000o2 = dzi.O000000o(this.O00000Oo.getApplicationContext()).O000000o("key_monitor_config");
            if (!TextUtils.isEmpty(O000000o2)) {
                dxz.O000000o.f15051O000000o.O000000o(O000000o2);
            }
        }
        return this.O00000oO;
    }

    public final void O00000Oo() {
        Handler handler;
        if (this.O00000o0) {
            this.f15037O000000o = true;
            final dyp O000000o2 = dyq.O000000o.f15075O000000o.O000000o("fps");
            if (O000000o2 != null && O000000o2.O00000o0() && (handler = this.O00000o) != null) {
                handler.post(new Runnable() {
                    /* class _m_j.dxr.AnonymousClass3 */

                    public final void run() {
                        O000000o2.O000000o();
                    }
                });
            }
        }
    }

    public final void O00000o0() {
        this.f15037O000000o = false;
        dyq.O000000o.f15075O000000o.O00000Oo = false;
    }

    public final void O000000o(final String str, boolean z, boolean z2) {
        final dyp O000000o2 = dyq.O000000o.f15075O000000o.O000000o(str);
        if (O000000o2 != null) {
            O000000o2.O000000o(z);
            if (!z) {
                O000000o2.O00000o();
            } else if (O000000o2.O00000Oo()) {
            } else {
                if (z2) {
                    Handler handler = this.O00000o;
                    if (handler != null) {
                        handler.post(new Runnable() {
                            /* class _m_j.dxr.AnonymousClass2 */

                            public final void run() {
                                if (TextUtils.equals(str, "activity")) {
                                    dyq.O000000o.f15075O000000o.O00000Oo();
                                }
                                O000000o2.O000000o();
                            }
                        });
                        return;
                    }
                    return;
                }
                O000000o2.O000000o();
            }
        }
    }
}
