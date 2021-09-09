package com.swmansion.gesturehandler;

import _m_j.dec;
import _m_j.deg;
import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class PanGestureHandler extends dec<PanGestureHandler> {
    private static float O000OOo = Float.MIN_VALUE;
    private static float O000OOo0 = Float.MAX_VALUE;
    private static int O000OOoO = 1;
    private static int O000OOoo = 10;

    /* renamed from: O000000o  reason: collision with root package name */
    public float f5764O000000o;
    public float O00000Oo;
    public float O0000oOO;
    public float O0000oOo;
    public float O0000oo;
    public float O0000oo0;
    public float O0000ooO;
    public float O0000ooo;
    public float O000O00o;
    public int O000O0OO = O000OOoO;
    public int O000O0Oo = O000OOoo;
    public float O000O0o;
    public float O000O0o0;
    public float O000O0oO;
    public float O000O0oo;
    public float O000OO;
    public float O000OO00;
    public float O000OO0o;
    public boolean O000OOOo;
    private VelocityTracker O000Oo0;
    private float O000Oo00;
    public float O00oOoOo;
    public float O00oOooO;
    public float O00oOooo;

    public PanGestureHandler(Context context) {
        float f = O000OOo;
        this.O000Oo00 = f;
        float f2 = O000OOo0;
        this.f5764O000000o = f2;
        this.O00000Oo = f;
        this.O0000oOO = f;
        this.O0000oOo = f2;
        this.O0000oo0 = f2;
        this.O0000oo = f;
        this.O0000ooO = f;
        this.O0000ooo = f2;
        this.O00oOooO = f2;
        this.O00oOooo = f2;
        this.O000O00o = f2;
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.O000Oo00 = (float) (scaledTouchSlop * scaledTouchSlop);
    }

    public final PanGestureHandler O000000o(float f) {
        this.O000Oo00 = f * f;
        return this;
    }

    public final void O00000Oo() {
        VelocityTracker velocityTracker = this.O000Oo0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.O000Oo0 = null;
        }
    }

    private static void O000000o(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX() - motionEvent.getX();
        float rawY = motionEvent.getRawY() - motionEvent.getY();
        motionEvent.offsetLocation(rawX, rawY);
        velocityTracker.addMovement(motionEvent);
        motionEvent.offsetLocation(-rawX, -rawY);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0186, code lost:
        if (r10 >= r0) goto L_0x01b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01a3, code lost:
        if (r10 >= r1) goto L_0x01b9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0113  */
    public final void O000000o(MotionEvent motionEvent) {
        boolean z;
        int i = this.O0000O0o;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 6 || actionMasked == 5) {
            this.O000O0o += this.O000O0oo - this.O00oOoOo;
            this.O000O0oO += this.O000OO00 - this.O000O0o0;
            this.O000O0oo = deg.O000000o(motionEvent, this.O000OOOo);
            this.O000OO00 = deg.O00000Oo(motionEvent, this.O000OOOo);
            this.O00oOoOo = this.O000O0oo;
            this.O000O0o0 = this.O000OO00;
        } else {
            this.O000O0oo = deg.O000000o(motionEvent, this.O000OOOo);
            this.O000OO00 = deg.O00000Oo(motionEvent, this.O000OOOo);
        }
        if (i != 0 || motionEvent.getPointerCount() < this.O000O0OO) {
            VelocityTracker velocityTracker = this.O000Oo0;
            if (velocityTracker != null) {
                O000000o(velocityTracker, motionEvent);
                this.O000Oo0.computeCurrentVelocity(1000);
                this.O000OO0o = this.O000Oo0.getXVelocity();
                this.O000OO = this.O000Oo0.getYVelocity();
            }
        } else {
            this.O00oOoOo = this.O000O0oo;
            this.O000O0o0 = this.O000OO00;
            this.O000O0o = 0.0f;
            this.O000O0oO = 0.0f;
            this.O000Oo0 = VelocityTracker.obtain();
            O000000o(this.O000Oo0, motionEvent);
            O00000oo();
        }
        boolean z2 = true;
        if (actionMasked == 1) {
            if (i == 4 || i == 2) {
                O0000O0o();
            } else {
                O00000o();
            }
        } else if (actionMasked != 5 || motionEvent.getPointerCount() <= this.O000O0Oo) {
            if (actionMasked == 6 && i == 4 && motionEvent.getPointerCount() < this.O000O0OO) {
                O00000o();
            } else if (i == 2) {
                float f = (this.O000O0oo - this.O00oOoOo) + this.O000O0o;
                float f2 = this.O0000oOO;
                if (f2 == O000OOo || f >= f2) {
                    float f3 = this.O0000oOo;
                    if (f3 == O000OOo0 || f <= f3) {
                        float f4 = (this.O000OO00 - this.O000O0o0) + this.O000O0oO;
                        float f5 = this.O0000ooO;
                        if (f5 == O000OOo || f4 >= f5) {
                            float f6 = this.O0000ooo;
                            if (f6 == O000OOo0 || f4 <= f6) {
                                z = false;
                                if (!z) {
                                    O00000o();
                                    return;
                                }
                                float f7 = (this.O000O0oo - this.O00oOoOo) + this.O000O0o;
                                float f8 = this.f5764O000000o;
                                if (f8 == O000OOo0 || f7 >= f8) {
                                    float f9 = this.O00000Oo;
                                    if (f9 == O000OOo || f7 <= f9) {
                                        float f10 = (this.O000OO00 - this.O000O0o0) + this.O000O0oO;
                                        float f11 = this.O0000oo0;
                                        if (f11 == O000OOo0 || f10 >= f11) {
                                            float f12 = this.O0000oo;
                                            if (f12 == O000OOo || f10 <= f12) {
                                                float f13 = (f7 * f7) + (f10 * f10);
                                                float f14 = this.O000Oo00;
                                                if (f14 == O000OOo0 || f13 < f14) {
                                                    float f15 = this.O000OO0o;
                                                    float f16 = this.O00oOooO;
                                                    if (f16 != O000OOo0) {
                                                        if (f16 >= 0.0f || f15 > f16) {
                                                            float f17 = this.O00oOooO;
                                                            if (f17 >= 0.0f) {
                                                            }
                                                        }
                                                    }
                                                    float f18 = this.O000OO;
                                                    float f19 = this.O00oOooo;
                                                    if (f19 != O000OOo0) {
                                                        if (f19 >= 0.0f || f15 > f19) {
                                                            float f20 = this.O00oOooo;
                                                            if (f20 >= 0.0f) {
                                                            }
                                                        }
                                                    }
                                                    float f21 = (f15 * f15) + (f18 * f18);
                                                    float f22 = this.O000O00o;
                                                    if (f22 == O000OOo0 || f21 < f22) {
                                                        z2 = false;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (z2) {
                                    this.O00oOoOo = this.O000O0oo;
                                    this.O000O0o0 = this.O000OO00;
                                    O00000oO();
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
                z = true;
                if (!z) {
                }
            }
        } else if (i == 4) {
            O00000o0();
        } else {
            O00000o();
        }
    }
}
