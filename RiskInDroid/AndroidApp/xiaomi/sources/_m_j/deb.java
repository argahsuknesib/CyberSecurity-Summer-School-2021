package _m_j;

import android.os.Handler;
import android.view.MotionEvent;

public class deb extends dec<deb> {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f14542O000000o = 1;
    public int O00000Oo = 1;
    private long O0000oOO = 800;
    private long O0000oOo = 160;
    private float O0000oo;
    private float O0000oo0;
    private Handler O0000ooO;
    private int O0000ooo;
    private final Runnable O00oOooO = new Runnable() {
        /* class _m_j.deb.AnonymousClass1 */

        public final void run() {
            deb.this.O00000o();
        }
    };

    private boolean O00000o0(MotionEvent motionEvent) {
        if (this.O0000ooo != this.O00000Oo) {
            return false;
        }
        if (((this.f14542O000000o & 1) == 0 || motionEvent.getRawX() - this.O0000oo0 <= ((float) this.O0000oOo)) && (((this.f14542O000000o & 2) == 0 || this.O0000oo0 - motionEvent.getRawX() <= ((float) this.O0000oOo)) && (((this.f14542O000000o & 4) == 0 || this.O0000oo - motionEvent.getRawY() <= ((float) this.O0000oOo)) && ((this.f14542O000000o & 8) == 0 || motionEvent.getRawY() - this.O0000oo <= ((float) this.O0000oOo))))) {
            return false;
        }
        this.O0000ooO.removeCallbacksAndMessages(null);
        O00000oO();
        O0000O0o();
        return true;
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        Handler handler = this.O0000ooO;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        Handler handler = this.O0000ooO;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(MotionEvent motionEvent) {
        int i = this.O0000O0o;
        if (i == 0) {
            this.O0000oo0 = motionEvent.getRawX();
            this.O0000oo = motionEvent.getRawY();
            O00000oo();
            this.O0000ooo = 1;
            Handler handler = this.O0000ooO;
            if (handler == null) {
                this.O0000ooO = new Handler();
            } else {
                handler.removeCallbacksAndMessages(null);
            }
            this.O0000ooO.postDelayed(this.O00oOooO, this.O0000oOO);
        }
        if (i == 2) {
            O00000o0(motionEvent);
            if (motionEvent.getPointerCount() > this.O0000ooo) {
                this.O0000ooo = motionEvent.getPointerCount();
            }
            if (motionEvent.getActionMasked() == 1 && !O00000o0(motionEvent)) {
                O00000o();
            }
        }
    }
}
