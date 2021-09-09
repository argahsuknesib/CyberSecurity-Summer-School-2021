package _m_j;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class cr implements View.OnTouchListener {
    private static final int O0000oO0 = ViewConfiguration.getTapTimeout();

    /* renamed from: O000000o  reason: collision with root package name */
    final O000000o f14266O000000o = new O000000o();
    final View O00000Oo;
    boolean O00000o;
    boolean O00000o0;
    boolean O00000oO;
    private final Interpolator O00000oo = new AccelerateInterpolator();
    private Runnable O0000O0o;
    private float[] O0000OOo = {0.0f, 0.0f};
    private int O0000Oo;
    private float[] O0000Oo0 = {Float.MAX_VALUE, Float.MAX_VALUE};
    private int O0000OoO;
    private float[] O0000Ooo = {0.0f, 0.0f};
    private boolean O0000o;
    private float[] O0000o0 = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] O0000o00 = {0.0f, 0.0f};
    private boolean O0000o0O;
    private boolean O0000o0o;

    static float O000000o(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    static int O000000o(int i, int i2) {
        if (i > i2) {
            return i2;
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public abstract void O000000o(int i);

    public abstract boolean O00000Oo(int i);

    public cr(View view) {
        this.O00000Oo = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        float[] fArr = this.O0000o0;
        float f = ((float) ((int) ((displayMetrics.density * 1575.0f) + 0.5f))) / 1000.0f;
        fArr[0] = f;
        fArr[1] = f;
        float[] fArr2 = this.O0000o00;
        float f2 = ((float) ((int) ((displayMetrics.density * 315.0f) + 0.5f))) / 1000.0f;
        fArr2[0] = f2;
        fArr2[1] = f2;
        this.O0000Oo = 1;
        float[] fArr3 = this.O0000Oo0;
        fArr3[0] = Float.MAX_VALUE;
        fArr3[1] = Float.MAX_VALUE;
        float[] fArr4 = this.O0000OOo;
        fArr4[0] = 0.2f;
        fArr4[1] = 0.2f;
        float[] fArr5 = this.O0000Ooo;
        fArr5[0] = 0.001f;
        fArr5[1] = 0.001f;
        this.O0000OoO = O0000oO0;
        O000000o o000000o = this.f14266O000000o;
        o000000o.f14267O000000o = 500;
        o000000o.O00000Oo = 500;
    }

    public final cr O000000o(boolean z) {
        if (this.O0000o0o && !z) {
            O00000Oo();
        }
        this.O0000o0o = z;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x007d;
     */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        if (!this.O0000o0o) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                }
            }
            O00000Oo();
            if (this.O0000o || !this.O00000oO) {
                return false;
            }
            return true;
        }
        this.O00000o = true;
        this.O0000o0O = false;
        float O000000o2 = O000000o(0, motionEvent.getX(), (float) view.getWidth(), (float) this.O00000Oo.getWidth());
        float O000000o3 = O000000o(1, motionEvent.getY(), (float) view.getHeight(), (float) this.O00000Oo.getHeight());
        O000000o o000000o = this.f14266O000000o;
        o000000o.O00000o0 = O000000o2;
        o000000o.O00000o = O000000o3;
        if (!this.O00000oO && O000000o()) {
            if (this.O0000O0o == null) {
                this.O0000O0o = new O00000Oo();
            }
            this.O00000oO = true;
            this.O00000o0 = true;
            if (this.O0000o0O || (i = this.O0000OoO) <= 0) {
                this.O0000O0o.run();
            } else {
                cb.O000000o(this.O00000Oo, this.O0000O0o, (long) i);
            }
            this.O0000o0O = true;
        }
        if (this.O0000o) {
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o() {
        O000000o o000000o = this.f14266O000000o;
        int O00000o02 = o000000o.O00000o0();
        int O00000Oo2 = o000000o.O00000Oo();
        return O00000o02 != 0 && O00000Oo(O00000o02);
    }

    private void O00000Oo() {
        if (this.O00000o0) {
            this.O00000oO = false;
        } else {
            this.f14266O000000o.O000000o();
        }
    }

    private float O000000o(int i, float f, float f2, float f3) {
        float O000000o2 = O000000o(this.O0000OOo[i], f2, this.O0000Oo0[i], f);
        if (O000000o2 == 0.0f) {
            return 0.0f;
        }
        float f4 = this.O0000Ooo[i];
        float f5 = this.O0000o00[i];
        float f6 = this.O0000o0[i];
        float f7 = f4 * f3;
        if (O000000o2 > 0.0f) {
            return O000000o(O000000o2 * f7, f5, f6);
        }
        return -O000000o((-O000000o2) * f7, f5, f6);
    }

    private float O000000o(float f, float f2, float f3, float f4) {
        float f5;
        float O000000o2 = O000000o(f * f2, 0.0f, f3);
        float O000000o3 = O000000o(f2 - f4, O000000o2) - O000000o(f4, O000000o2);
        if (O000000o3 < 0.0f) {
            f5 = -this.O00000oo.getInterpolation(-O000000o3);
        } else if (O000000o3 <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.O00000oo.getInterpolation(O000000o3);
        }
        return O000000o(f5, -1.0f, 1.0f);
    }

    private float O000000o(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.O0000Oo;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                return (!this.O00000oO || this.O0000Oo != 1) ? 0.0f : 1.0f;
            }
        } else if (i == 2 && f < 0.0f) {
            return f / (-f2);
        }
    }

    class O00000Oo implements Runnable {
        O00000Oo() {
        }

        public final void run() {
            if (cr.this.O00000oO) {
                if (cr.this.O00000o0) {
                    cr crVar = cr.this;
                    crVar.O00000o0 = false;
                    O000000o o000000o = crVar.f14266O000000o;
                    o000000o.O00000oO = AnimationUtils.currentAnimationTimeMillis();
                    o000000o.O0000Oo0 = -1;
                    o000000o.O00000oo = o000000o.O00000oO;
                    o000000o.O0000Oo = 0.5f;
                    o000000o.O0000O0o = 0;
                    o000000o.O0000OOo = 0;
                }
                O000000o o000000o2 = cr.this.f14266O000000o;
                if ((o000000o2.O0000Oo0 > 0 && AnimationUtils.currentAnimationTimeMillis() > o000000o2.O0000Oo0 + ((long) o000000o2.O0000OoO)) || !cr.this.O000000o()) {
                    cr.this.O00000oO = false;
                    return;
                }
                if (cr.this.O00000o) {
                    cr crVar2 = cr.this;
                    crVar2.O00000o = false;
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    crVar2.O00000Oo.onTouchEvent(obtain);
                    obtain.recycle();
                }
                if (o000000o2.O00000oo != 0) {
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    float O000000o2 = o000000o2.O000000o(currentAnimationTimeMillis);
                    o000000o2.O00000oo = currentAnimationTimeMillis;
                    float f = ((float) (currentAnimationTimeMillis - o000000o2.O00000oo)) * ((-4.0f * O000000o2 * O000000o2) + (O000000o2 * 4.0f));
                    o000000o2.O0000O0o = (int) (o000000o2.O00000o0 * f);
                    o000000o2.O0000OOo = (int) (f * o000000o2.O00000o);
                    cr.this.O000000o(o000000o2.O0000OOo);
                    cb.O000000o(cr.this.O00000Oo, this);
                    return;
                }
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f14267O000000o;
        int O00000Oo;
        float O00000o;
        float O00000o0;
        long O00000oO = Long.MIN_VALUE;
        long O00000oo = 0;
        int O0000O0o = 0;
        int O0000OOo = 0;
        float O0000Oo;
        long O0000Oo0 = -1;
        int O0000OoO;

        O000000o() {
        }

        public final void O000000o() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.O0000OoO = cr.O000000o((int) (currentAnimationTimeMillis - this.O00000oO), this.O00000Oo);
            this.O0000Oo = O000000o(currentAnimationTimeMillis);
            this.O0000Oo0 = currentAnimationTimeMillis;
        }

        /* access modifiers changed from: package-private */
        public final float O000000o(long j) {
            if (j < this.O00000oO) {
                return 0.0f;
            }
            long j2 = this.O0000Oo0;
            if (j2 < 0 || j < j2) {
                return cr.O000000o(((float) (j - this.O00000oO)) / ((float) this.f14267O000000o), 0.0f, 1.0f) * 0.5f;
            }
            long j3 = j - j2;
            float f = this.O0000Oo;
            return (1.0f - f) + (f * cr.O000000o(((float) j3) / ((float) this.O0000OoO), 0.0f, 1.0f));
        }

        public final int O00000Oo() {
            float f = this.O00000o0;
            return (int) (f / Math.abs(f));
        }

        public final int O00000o0() {
            float f = this.O00000o;
            return (int) (f / Math.abs(f));
        }
    }
}
