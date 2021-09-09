package _m_j;

import android.os.Handler;
import android.view.MotionEvent;

public class dem extends dec<dem> {
    private static float O0000ooo = Float.MIN_VALUE;

    /* renamed from: O000000o  reason: collision with root package name */
    public float f14552O000000o;
    public float O00000Oo;
    public float O0000oOO;
    public long O0000oOo = 500;
    public int O0000oo = 1;
    public long O0000oo0 = 500;
    public int O0000ooO = 1;
    private float O000O00o;
    private float O000O0OO;
    private float O000O0Oo;
    private Handler O000O0o;
    private float O000O0o0;
    private int O000O0oO;
    private final Runnable O000O0oo = new Runnable() {
        /* class _m_j.dem.AnonymousClass1 */

        public final void run() {
            dem.this.O00000o();
        }
    };
    private float O00oOoOo;
    private int O00oOooO = 1;
    private float O00oOooo;

    public dem() {
        float f = O0000ooo;
        this.f14552O000000o = f;
        this.O00000Oo = f;
        this.O0000oOO = f;
        this.O0000Ooo = true;
    }

    private void O0000Ooo() {
        Handler handler = this.O000O0o;
        if (handler == null) {
            this.O000O0o = new Handler();
        } else {
            handler.removeCallbacksAndMessages(null);
        }
        this.O000O0o.postDelayed(this.O000O0oo, this.O0000oOo);
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        Handler handler = this.O000O0o;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        this.O000O0oO = 0;
        this.O00oOooO = 0;
        Handler handler = this.O000O0o;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b4  */
    public final void O000000o(MotionEvent motionEvent) {
        boolean z;
        int i = this.O0000O0o;
        int actionMasked = motionEvent.getActionMasked();
        if (i == 0) {
            this.O000O0OO = 0.0f;
            this.O000O0Oo = 0.0f;
            this.O00oOooo = motionEvent.getRawX();
            this.O000O00o = motionEvent.getRawY();
        }
        if (actionMasked == 6 || actionMasked == 5) {
            this.O000O0OO += this.O00oOoOo - this.O00oOooo;
            this.O000O0Oo += this.O000O0o0 - this.O000O00o;
            this.O00oOoOo = deg.O000000o(motionEvent, true);
            this.O000O0o0 = deg.O00000Oo(motionEvent, true);
            this.O00oOooo = this.O00oOoOo;
            this.O000O00o = this.O000O0o0;
        } else {
            this.O00oOoOo = deg.O000000o(motionEvent, true);
            this.O000O0o0 = deg.O00000Oo(motionEvent, true);
        }
        if (this.O00oOooO < motionEvent.getPointerCount()) {
            this.O00oOooO = motionEvent.getPointerCount();
        }
        float f = (this.O00oOoOo - this.O00oOooo) + this.O000O0OO;
        if (this.f14552O000000o == O0000ooo || Math.abs(f) <= this.f14552O000000o) {
            float f2 = (this.O000O0o0 - this.O000O00o) + this.O000O0Oo;
            if (this.O00000Oo == O0000ooo || Math.abs(f2) <= this.O00000Oo) {
                float f3 = (f2 * f2) + (f * f);
                float f4 = this.O0000oOO;
                if (f4 == O0000ooo || f3 <= f4) {
                    z = false;
                    if (!z) {
                        O00000o();
                        return;
                    } else if (i == 0) {
                        if (actionMasked == 0) {
                            O00000oo();
                        }
                        O0000Ooo();
                        return;
                    } else if (i != 2) {
                        return;
                    } else {
                        if (actionMasked == 1) {
                            Handler handler = this.O000O0o;
                            if (handler == null) {
                                this.O000O0o = new Handler();
                            } else {
                                handler.removeCallbacksAndMessages(null);
                            }
                            int i2 = this.O000O0oO + 1;
                            this.O000O0oO = i2;
                            if (i2 != this.O0000oo || this.O00oOooO < this.O0000ooO) {
                                this.O000O0o.postDelayed(this.O000O0oo, this.O0000oo0);
                                return;
                            }
                            O00000oO();
                            O0000O0o();
                            return;
                        } else if (actionMasked == 0) {
                            O0000Ooo();
                            return;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
        z = true;
        if (!z) {
        }
    }
}
