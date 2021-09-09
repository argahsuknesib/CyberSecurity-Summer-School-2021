package _m_j;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public final class grd {
    private static final Interpolator O0000oo0 = new Interpolator() {
        /* class _m_j.grd.AnonymousClass1 */

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f18176O000000o;
    public int O00000Oo;
    public float[] O00000o;
    public int O00000o0 = -1;
    public float[] O00000oO;
    public float[] O00000oo;
    public float[] O0000O0o;
    public int O0000OOo;
    public float O0000Oo;
    public VelocityTracker O0000Oo0;
    public int O0000OoO;
    public int O0000Ooo;
    private int[] O0000o;
    public boolean O0000o0;
    public View O0000o00;
    private int[] O0000o0O;
    private int[] O0000o0o;
    private cx O0000oO;
    private float O0000oO0;
    private final O000000o O0000oOO;
    private final ViewGroup O0000oOo;
    private final Runnable O0000oo = new Runnable() {
        /* class _m_j.grd.AnonymousClass2 */

        public final void run() {
            grd.this.O000000o(0);
        }
    };

    public static abstract class O000000o {
        public void O000000o(int i) {
        }

        public void O000000o(int i, int i2) {
        }

        public void O000000o(View view, float f) {
        }

        public void O000000o(View view, int i) {
        }

        public abstract boolean O000000o(View view);

        public int O00000Oo(View view, int i) {
            return 0;
        }

        public void O00000Oo(View view) {
        }

        public int O00000o(View view) {
            return 0;
        }

        public int O00000o0(View view) {
            return 0;
        }

        public void O00000o0() {
        }
    }

    private grd(Context context, ViewGroup viewGroup, O000000o o000000o) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (o000000o != null) {
            this.O0000oOo = viewGroup;
            this.O0000oOO = o000000o;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.O0000OoO = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.O00000Oo = viewConfiguration.getScaledTouchSlop();
            this.O0000oO0 = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.O0000Oo = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.O0000oO = cx.O000000o(context, O0000oo0);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    public final void O000000o(View view, int i) {
        if (view.getParent() == this.O0000oOo) {
            this.O0000o00 = view;
            this.O00000o0 = i;
            this.O0000oOO.O00000Oo(view);
            O000000o(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.O0000oOo + ")");
    }

    public final void O000000o() {
        this.O00000o0 = -1;
        O00000o0();
        VelocityTracker velocityTracker = this.O0000Oo0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.O0000Oo0 = null;
        }
    }

    public final boolean O000000o(View view, int i, int i2) {
        this.O0000o00 = view;
        this.O00000o0 = -1;
        boolean O000000o2 = O000000o(i, i2, 0, 0);
        if (!O000000o2 && this.f18176O000000o == 0 && this.O0000o00 != null) {
            this.O0000o00 = null;
        }
        return O000000o2;
    }

    public final boolean O000000o(int i, int i2, int i3, int i4) {
        int left = this.O0000o00.getLeft();
        int top = this.O0000o00.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.O0000oO.f14386O000000o.abortAnimation();
            O000000o(0);
            return false;
        }
        this.O0000oO.O000000o(left, top, i5, i6, O000000o(this.O0000o00, i5, i6, i3, i4));
        O000000o(2);
        return true;
    }

    private int O000000o(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int O00000Oo2 = O00000Oo(i3, (int) this.O0000Oo, (int) this.O0000oO0);
        int O00000Oo3 = O00000Oo(i4, (int) this.O0000Oo, (int) this.O0000oO0);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(O00000Oo2);
        int abs4 = Math.abs(O00000Oo3);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        if (O00000Oo2 != 0) {
            f2 = (float) abs3;
            f = (float) i5;
        } else {
            f2 = (float) abs;
            f = (float) i6;
        }
        float f5 = f2 / f;
        if (O00000Oo3 != 0) {
            f4 = (float) abs4;
            f3 = (float) i5;
        } else {
            f4 = (float) abs2;
            f3 = (float) i6;
        }
        float f6 = f4 / f3;
        return (int) ((((float) O000000o(i, O00000Oo2, this.O0000oOO.O00000o0(view))) * f5) + (((float) O000000o(i2, O00000Oo3, 0)) * f6));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    private int O000000o(int i, int i2, int i3) {
        int i4;
        if (i == 0) {
            return 0;
        }
        int width = this.O0000oOo.getWidth();
        float f = (float) (width / 2);
        float O000000o2 = f + (O000000o(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * f);
        int abs = Math.abs(i2);
        if (abs > 0) {
            i4 = Math.round(Math.abs(O000000o2 / ((float) abs)) * 1000.0f) * 4;
        } else {
            i4 = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(i4, 600);
    }

    private static int O00000Oo(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs > i3) {
            return i > 0 ? i3 : -i3;
        }
        return i;
    }

    private static float O000000o(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs > f3) {
            return f > 0.0f ? f3 : -f3;
        }
        return f;
    }

    private static float O000000o(float f) {
        double d = (double) (f - 0.5f);
        Double.isNaN(d);
        return (float) Math.sin((double) ((float) (d * 0.4712389167638204d)));
    }

    public final boolean O00000Oo() {
        if (this.f18176O000000o == 2) {
            boolean computeScrollOffset = this.O0000oO.f14386O000000o.computeScrollOffset();
            int currX = this.O0000oO.f14386O000000o.getCurrX();
            int currY = this.O0000oO.f14386O000000o.getCurrY();
            int left = currX - this.O0000o00.getLeft();
            int top = currY - this.O0000o00.getTop();
            if (left != 0) {
                this.O0000o00.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.O0000o00.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.O0000oOO.O000000o(this.O0000o00, currX);
            }
            if (computeScrollOffset && currX == this.O0000oO.f14386O000000o.getFinalX() && currY == this.O0000oO.f14386O000000o.getFinalY()) {
                this.O0000oO.f14386O000000o.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.O0000oOo.post(this.O0000oo);
            }
        }
        if (this.f18176O000000o == 2) {
            return true;
        }
        return false;
    }

    private void O00000Oo(float f) {
        this.O0000o0 = true;
        this.O0000oOO.O000000o(this.O0000o00, f);
        this.O0000o0 = false;
        if (this.f18176O000000o == 1) {
            O000000o(0);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(float[], float):void}
     arg types: [float[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(long[], long):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void} */
    private void O00000o0() {
        float[] fArr = this.O00000o;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.O00000oO, 0.0f);
            Arrays.fill(this.O00000oo, 0.0f);
            Arrays.fill(this.O0000O0o, 0.0f);
            Arrays.fill(this.O0000o0O, 0);
            Arrays.fill(this.O0000o0o, 0);
            Arrays.fill(this.O0000o, 0);
            this.O0000OOo = 0;
        }
    }

    private void O00000Oo(int i) {
        float[] fArr = this.O00000o;
        if (fArr != null) {
            fArr[i] = 0.0f;
            this.O00000oO[i] = 0.0f;
            this.O00000oo[i] = 0.0f;
            this.O0000O0o[i] = 0.0f;
            this.O0000o0O[i] = 0;
            this.O0000o0o[i] = 0;
            this.O0000o[i] = 0;
            this.O0000OOo = ((1 << i) ^ -1) & this.O0000OOo;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i) {
        this.O0000oOo.removeCallbacks(this.O0000oo);
        if (this.f18176O000000o != i) {
            this.f18176O000000o = i;
            this.O0000oOO.O000000o(i);
            if (this.f18176O000000o == 0) {
                this.O0000o00 = null;
            }
        }
    }

    private boolean O00000Oo(View view, int i) {
        if (view == this.O0000o00 && this.O00000o0 == i) {
            return true;
        }
        if (view == null || !this.O0000oOO.O000000o(view)) {
            return false;
        }
        this.O00000o0 = i;
        O000000o(view, i);
        return true;
    }

    private void O00000Oo(float f, float f2, int i) {
        boolean O000000o2 = O000000o(f, f2, i, 1);
        if (O000000o(f2, f, i, 4)) {
            O000000o2 |= true;
        }
        if (O000000o(f, f2, i, 2)) {
            O000000o2 |= true;
        }
        if (O000000o(f2, f, i, 8)) {
            O000000o2 |= true;
        }
        if (O000000o2) {
            int[] iArr = this.O0000o0o;
            iArr[i] = iArr[i] | O000000o2;
            this.O0000oOO.O000000o(O000000o2 ? 1 : 0, i);
        }
    }

    private boolean O000000o(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if (!((this.O0000o0O[i] & i2) != i2 || (this.O0000Ooo & i2) == 0 || (this.O0000o[i] & i2) == i2 || (this.O0000o0o[i] & i2) == i2)) {
            int i3 = this.O00000Oo;
            if ((abs > ((float) i3) || abs2 > ((float) i3)) && (this.O0000o0o[i] & i2) == 0 && abs > ((float) this.O00000Oo)) {
                return true;
            }
        }
        return false;
    }

    private boolean O000000o(View view, float f) {
        if (view == null) {
            return false;
        }
        return (this.O0000oOO.O00000o0(view) > 0) && Math.abs(f) > ((float) this.O00000Oo);
    }

    private void O00000o() {
        this.O0000Oo0.computeCurrentVelocity(1000, this.O0000oO0);
        float O000000o2 = O000000o(this.O0000Oo0.getXVelocity(this.O00000o0), this.O0000Oo, this.O0000oO0);
        O000000o(this.O0000Oo0.getYVelocity(this.O00000o0), this.O0000Oo, this.O0000oO0);
        O00000Oo(O000000o2);
    }

    private void O00000o0(int i, int i2, int i3) {
        int left = this.O0000o00.getLeft();
        int top = this.O0000o00.getTop();
        if (i2 != 0) {
            i = this.O0000oOO.O00000Oo(this.O0000o00, i);
            this.O0000o00.offsetLeftAndRight(i - left);
        }
        if (i3 != 0) {
            this.O0000o00.offsetTopAndBottom(this.O0000oOO.O00000o(this.O0000o00) - top);
        }
        if (i2 != 0 || i3 != 0) {
            this.O0000oOO.O000000o(this.O0000o00, i);
        }
    }

    private boolean O00000Oo(int i, int i2) {
        return O00000Oo(this.O0000o00, i, i2);
    }

    private static boolean O00000Oo(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public final View O000000o(int i, int i2) {
        for (int childCount = this.O0000oOo.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.O0000oOo.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public static grd O000000o(ViewGroup viewGroup, O000000o o000000o) {
        grd grd = new grd(viewGroup.getContext(), viewGroup, o000000o);
        grd.O00000Oo = (int) (((float) grd.O00000Oo) * 1.0f);
        grd.O00000Oo *= 8;
        return grd;
    }

    private void O000000o(float f, float f2, int i) {
        float[] fArr = this.O00000o;
        int i2 = 0;
        if (fArr == null || fArr.length <= i) {
            int i3 = i + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            float[] fArr6 = this.O00000o;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.O00000oO;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.O00000oo;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.O0000O0o;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.O0000o0O;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.O0000o0o;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.O0000o;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.O00000o = fArr2;
            this.O00000oO = fArr3;
            this.O00000oo = fArr4;
            this.O0000O0o = fArr5;
            this.O0000o0O = iArr;
            this.O0000o0o = iArr2;
            this.O0000o = iArr3;
        }
        float[] fArr10 = this.O00000o;
        this.O00000oo[i] = f;
        fArr10[i] = f;
        float[] fArr11 = this.O00000oO;
        this.O0000O0o[i] = f2;
        fArr11[i] = f2;
        int[] iArr7 = this.O0000o0O;
        int i4 = (int) f;
        int i5 = (int) f2;
        if (i4 < this.O0000oOo.getLeft() + this.O0000OoO) {
            i2 = 1;
        }
        if (i5 < this.O0000oOo.getTop() + this.O0000OoO) {
            i2 |= 4;
        }
        if (i4 > this.O0000oOo.getRight() - this.O0000OoO) {
            i2 |= 2;
        }
        if (i5 > this.O0000oOo.getBottom() - this.O0000OoO) {
            i2 |= 8;
        }
        iArr7[i] = i2;
        this.O0000OOo |= 1 << i;
    }

    private void O00000o0(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            float x = motionEvent.getX(i);
            float y = motionEvent.getY(i);
            this.O00000oo[pointerId] = x;
            this.O0000O0o[pointerId] = y;
        }
    }

    public final boolean O000000o(MotionEvent motionEvent) {
        View O000000o2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            O000000o();
        }
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = VelocityTracker.obtain();
        }
        this.O0000Oo0.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            int pointerId = motionEvent.getPointerId(actionIndex);
                            float x = motionEvent.getX(actionIndex);
                            float y = motionEvent.getY(actionIndex);
                            O000000o(x, y, pointerId);
                            int i = this.f18176O000000o;
                            if (i == 0) {
                                if ((this.O0000o0O[pointerId] & this.O0000Ooo) != 0) {
                                    this.O0000oOO.O00000o0();
                                }
                            } else if (i == 2 && (O000000o2 = O000000o((int) x, (int) y)) == this.O0000o00) {
                                O00000Oo(O000000o2, pointerId);
                            }
                        } else if (actionMasked == 6) {
                            O00000Oo(motionEvent.getPointerId(actionIndex));
                        }
                    }
                } else if (!(this.O00000o == null || this.O00000oO == null)) {
                    for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
                        int pointerId2 = motionEvent.getPointerId(i2);
                        if (pointerId2 < this.O00000o.length) {
                            float x2 = motionEvent.getX(i2);
                            float y2 = motionEvent.getY(i2);
                            float f = x2 - this.O00000o[pointerId2];
                            float f2 = y2 - this.O00000oO[pointerId2];
                            View O000000o3 = O000000o((int) x2, (int) y2);
                            boolean z = O000000o3 != null && O000000o(O000000o3, f);
                            if (z) {
                                int left = O000000o3.getLeft();
                                int O00000Oo2 = this.O0000oOO.O00000Oo(O000000o3, ((int) f) + left);
                                O000000o3.getTop();
                                this.O0000oOO.O00000o(O000000o3);
                                int O00000o02 = this.O0000oOO.O00000o0(O000000o3);
                                if (O00000o02 != 0) {
                                    if (O00000o02 > 0 && O00000Oo2 == left) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            O00000Oo(f, f2, pointerId2);
                            if (this.f18176O000000o != 1) {
                                if (z && O00000Oo(O000000o3, pointerId2)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    O00000o0(motionEvent);
                }
            }
            O000000o();
        } else {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            int pointerId3 = motionEvent.getPointerId(0);
            O000000o(x3, y3, pointerId3);
            View O000000o4 = O000000o((int) x3, (int) y3);
            if (O000000o4 == this.O0000o00 && this.f18176O000000o == 2) {
                O00000Oo(O000000o4, pointerId3);
            }
            if ((this.O0000o0O[pointerId3] & this.O0000Ooo) != 0) {
                this.O0000oOO.O00000o0();
            }
        }
        return this.f18176O000000o == 1;
    }

    public final void O00000Oo(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            O000000o();
        }
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = VelocityTracker.obtain();
        }
        this.O0000Oo0.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View O000000o2 = O000000o((int) x, (int) y);
            O000000o(x, y, pointerId);
            O00000Oo(O000000o2, pointerId);
            if ((this.O0000o0O[pointerId] & this.O0000Ooo) != 0) {
                this.O0000oOO.O00000o0();
            }
        } else if (actionMasked == 1) {
            if (this.f18176O000000o == 1) {
                O00000o();
            }
            O000000o();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f18176O000000o == 1) {
                    O00000Oo(0.0f);
                }
                O000000o();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x2 = motionEvent.getX(actionIndex);
                float y2 = motionEvent.getY(actionIndex);
                O000000o(x2, y2, pointerId2);
                if (this.f18176O000000o == 0) {
                    O00000Oo(O000000o((int) x2, (int) y2), pointerId2);
                    if ((this.O0000o0O[pointerId2] & this.O0000Ooo) != 0) {
                        this.O0000oOO.O00000o0();
                    }
                } else if (O00000Oo((int) x2, (int) y2)) {
                    O00000Oo(this.O0000o00, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                if (this.f18176O000000o == 1 && pointerId3 == this.O00000o0) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i2 >= pointerCount) {
                            i = -1;
                            break;
                        }
                        int pointerId4 = motionEvent.getPointerId(i2);
                        if (pointerId4 != this.O00000o0) {
                            View O000000o3 = O000000o((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                            View view = this.O0000o00;
                            if (O000000o3 == view && O00000Oo(view, pointerId4)) {
                                i = this.O00000o0;
                                break;
                            }
                        }
                        i2++;
                    }
                    if (i == -1) {
                        O00000o();
                    }
                }
                O00000Oo(pointerId3);
            }
        } else if (this.f18176O000000o == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.O00000o0);
            float x3 = motionEvent.getX(findPointerIndex);
            float y3 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.O00000oo;
            int i3 = this.O00000o0;
            int i4 = (int) (x3 - fArr[i3]);
            int left = this.O0000o00.getLeft() + i4;
            this.O0000o00.getTop();
            O00000o0(left, i4, (int) (y3 - this.O0000O0o[i3]));
            O00000o0(motionEvent);
        } else {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i2 < pointerCount2) {
                int pointerId5 = motionEvent.getPointerId(i2);
                float x4 = motionEvent.getX(i2);
                float y4 = motionEvent.getY(i2);
                float f = x4 - this.O00000o[pointerId5];
                O00000Oo(f, y4 - this.O00000oO[pointerId5], pointerId5);
                if (this.f18176O000000o == 1) {
                    break;
                }
                View O000000o4 = O000000o((int) x4, (int) y4);
                if (O000000o(O000000o4, f) && O00000Oo(O000000o4, pointerId5)) {
                    break;
                }
                i2++;
            }
            O00000o0(motionEvent);
        }
    }
}
