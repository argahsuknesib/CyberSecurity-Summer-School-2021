package _m_j;

import _m_j.fk;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;

public final class fj implements fa {
    private static final fj O0000Oo0 = new fj();

    /* renamed from: O000000o  reason: collision with root package name */
    int f16437O000000o = 0;
    int O00000Oo = 0;
    boolean O00000o = true;
    boolean O00000o0 = true;
    Handler O00000oO;
    final fb O00000oo = new fb(this);
    Runnable O0000O0o = new Runnable() {
        /* class _m_j.fj.AnonymousClass1 */

        public final void run() {
            fj fjVar = fj.this;
            if (fjVar.O00000Oo == 0) {
                fjVar.O00000o0 = true;
                fjVar.O00000oo.O000000o(Lifecycle.Event.ON_PAUSE);
            }
            fj.this.O000000o();
        }
    };
    fk.O000000o O0000OOo = new fk.O000000o() {
        /* class _m_j.fj.AnonymousClass2 */

        public final void O000000o() {
            fj fjVar = fj.this;
            fjVar.f16437O000000o++;
            if (fjVar.f16437O000000o == 1 && fjVar.O00000o) {
                fjVar.O00000oo.O000000o(Lifecycle.Event.ON_START);
                fjVar.O00000o = false;
            }
        }

        public final void O00000Oo() {
            fj fjVar = fj.this;
            fjVar.O00000Oo++;
            if (fjVar.O00000Oo != 1) {
                return;
            }
            if (fjVar.O00000o0) {
                fjVar.O00000oo.O000000o(Lifecycle.Event.ON_RESUME);
                fjVar.O00000o0 = false;
                return;
            }
            fjVar.O00000oO.removeCallbacks(fjVar.O0000O0o);
        }
    };

    public static void O000000o(Context context) {
        fj fjVar = O0000Oo0;
        fjVar.O00000oO = new Handler();
        fjVar.O00000oo.O000000o(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new et() {
            /* class _m_j.fj.AnonymousClass3 */

            public final void onActivityCreated(Activity activity, Bundle bundle) {
                fk.O00000Oo(activity).f16509O000000o = fj.this.O0000OOo;
            }

            public final void onActivityPaused(Activity activity) {
                fj fjVar = fj.this;
                fjVar.O00000Oo--;
                if (fjVar.O00000Oo == 0) {
                    fjVar.O00000oO.postDelayed(fjVar.O0000O0o, 700);
                }
            }

            public final void onActivityStopped(Activity activity) {
                fj fjVar = fj.this;
                fjVar.f16437O000000o--;
                fjVar.O000000o();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        if (this.f16437O000000o == 0 && this.O00000o0) {
            this.O00000oo.O000000o(Lifecycle.Event.ON_STOP);
            this.O00000o = true;
        }
    }

    private fj() {
    }

    public final Lifecycle getLifecycle() {
        return this.O00000oo;
    }
}
