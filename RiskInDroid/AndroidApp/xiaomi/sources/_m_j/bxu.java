package _m_j;

import android.content.ComponentName;
import android.content.Context;
import com.mi.blockcanary.SingleThreadFactory;
import com.mi.blockcanary.ui.DisplayActivity;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class bxu {
    private static final Executor O00000o = Executors.newSingleThreadExecutor(new SingleThreadFactory("File-IO"));
    private static bxu O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public bxw f13391O000000o;
    public boolean O00000Oo = false;

    private bxu() {
        bxw.O000000o(bxv.O00000oO());
        this.f13391O000000o = bxw.O000000o();
        this.f13391O000000o.O000000o((bxx) bxv.O00000oO());
        bxv.O00000oO();
        bxv.O00000oO();
        this.f13391O000000o.O000000o(new byd());
    }

    public static bxu O000000o(Context context, bxv bxv) {
        bxv.O000000o(context, bxv);
        bxv.O00000oO();
        O00000o.execute(new Runnable(context.getApplicationContext(), DisplayActivity.class, false) {
            /* class _m_j.bxu.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ Context f13392O000000o;
            final /* synthetic */ Class O00000Oo;
            final /* synthetic */ boolean O00000o0 = false;

            {
                this.f13392O000000o = r1;
                this.O00000Oo = r2;
            }

            public final void run() {
                bxu.O000000o(this.f13392O000000o, this.O00000Oo, this.O00000o0);
            }
        });
        return O000000o();
    }

    private static bxu O000000o() {
        if (O00000o0 == null) {
            synchronized (bxu.class) {
                if (O00000o0 == null) {
                    O00000o0 = new bxu();
                }
            }
        }
        return O00000o0;
    }

    public static void O000000o(Context context, Class<?> cls, boolean z) {
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls), z ? 1 : 2, 1);
    }
}
