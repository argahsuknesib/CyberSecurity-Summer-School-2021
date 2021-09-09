package _m_j;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

public final class dh {
    private static final Interpolator O0000oo0 = new Interpolator() {
        /* class _m_j.dh.AnonymousClass1 */

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f14629O000000o;
    public int O00000Oo;
    public float[] O00000o;
    public float[] O00000o0;
    public float[] O00000oO;
    public float[] O00000oo;
    public float O0000O0o;
    public int O0000OOo;
    public View O0000Oo;
    public int O0000Oo0;
    private int O0000OoO = -1;
    private int[] O0000Ooo;
    private float O0000o;
    private int[] O0000o0;
    private int[] O0000o00;
    private int O0000o0O;
    private VelocityTracker O0000o0o;
    private final O000000o O0000oO;
    private OverScroller O0000oO0;
    private boolean O0000oOO;
    private final ViewGroup O0000oOo;
    private final Runnable O0000oo = new Runnable() {
        /* class _m_j.dh.AnonymousClass2 */

        public final void run() {
            dh.this.O00000Oo(0);
        }
    };

    public static abstract class O000000o {
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return 0;
        }

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(View view, int i) {
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public abstract boolean tryCaptureView(View view, int i);
    }

    public static dh O000000o(ViewGroup viewGroup, O000000o o000000o) {
        return new dh(viewGroup.getContext(), viewGroup, o000000o);
    }

    public static dh O000000o(ViewGroup viewGroup, float f, O000000o o000000o) {
        dh O000000o2 = O000000o(viewGroup, o000000o);
        O000000o2.O00000Oo = (int) (((float) O000000o2.O00000Oo) * (1.0f / f));
        return O000000o2;
    }

    private dh(Context context, ViewGroup viewGroup, O000000o o000000o) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (o000000o != null) {
            this.O0000oOo = viewGroup;
            this.O0000oO = o000000o;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.O0000OOo = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.O00000Oo = viewConfiguration.getScaledTouchSlop();
            this.O0000o = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.O0000O0o = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.O0000oO0 = new OverScroller(context, O0000oo0);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    public final void O000000o(View view, int i) {
        if (view.getParent() == this.O0000oOo) {
            this.O0000Oo = view;
            this.O0000OoO = i;
            this.O0000oO.onViewCaptured(view, i);
            O00000Oo(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.O0000oOo + ")");
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
    public final void O000000o() {
        this.O0000OoO = -1;
        float[] fArr = this.O00000o0;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.O00000o, 0.0f);
            Arrays.fill(this.O00000oO, 0.0f);
            Arrays.fill(this.O00000oo, 0.0f);
            Arrays.fill(this.O0000Ooo, 0);
            Arrays.fill(this.O0000o00, 0);
            Arrays.fill(this.O0000o0, 0);
            this.O0000o0O = 0;
        }
        VelocityTracker velocityTracker = this.O0000o0o;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.O0000o0o = null;
        }
    }

    public final void O00000Oo() {
        O000000o();
        if (this.f14629O000000o == 2) {
            int currX = this.O0000oO0.getCurrX();
            int currY = this.O0000oO0.getCurrY();
            this.O0000oO0.abortAnimation();
            int currX2 = this.O0000oO0.getCurrX();
            int currY2 = this.O0000oO0.getCurrY();
            this.O0000oO.onViewPositionChanged(this.O0000Oo, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        O00000Oo(0);
    }

    public final boolean O000000o(View view, int i, int i2) {
        this.O0000Oo = view;
        this.O0000OoO = -1;
        boolean O000000o2 = O000000o(i, i2, 0, 0);
        if (!O000000o2 && this.f14629O000000o == 0 && this.O0000Oo != null) {
            this.O0000Oo = null;
        }
        return O000000o2;
    }

    public final boolean O000000o(int i, int i2) {
        if (this.O0000oOO) {
            return O000000o(i, i2, (int) this.O0000o0o.getXVelocity(this.O0000OoO), (int) this.O0000o0o.getYVelocity(this.O0000OoO));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean O000000o(int i, int i2, int i3, int i4) {
        int left = this.O0000Oo.getLeft();
        int top = this.O0000Oo.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.O0000oO0.abortAnimation();
            O00000Oo(0);
            return false;
        }
        this.O0000oO0.startScroll(left, top, i5, i6, O000000o(this.O0000Oo, i5, i6, i3, i4));
        O00000Oo(2);
        return true;
    }

    private int O000000o(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int O00000Oo2 = O00000Oo(i3, (int) this.O0000O0o, (int) this.O0000o);
        int O00000Oo3 = O00000Oo(i4, (int) this.O0000O0o, (int) this.O0000o);
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
        return (int) ((((float) O000000o(i, O00000Oo2, this.O0000oO.getViewHorizontalDragRange(view))) * f5) + (((float) O000000o(i2, O00000Oo3, this.O0000oO.getViewVerticalDragRange(view))) * f6));
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
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    public final boolean O00000o0() {
        if (this.f14629O000000o == 2) {
            boolean computeScrollOffset = this.O0000oO0.computeScrollOffset();
            int currX = this.O0000oO0.getCurrX();
            int currY = this.O0000oO0.getCurrY();
            int left = currX - this.O0000Oo.getLeft();
            int top = currY - this.O0000Oo.getTop();
            if (left != 0) {
                cb.O0000Oo(this.O0000Oo, left);
            }
            if (top != 0) {
                cb.O0000Oo0(this.O0000Oo, top);
            }
            if (!(left == 0 && top == 0)) {
                this.O0000oO.onViewPositionChanged(this.O0000Oo, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.O0000oO0.getFinalX() && currY == this.O0000oO0.getFinalY()) {
                this.O0000oO0.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.O0000oOo.post(this.O0000oo);
            }
        }
        if (this.f14629O000000o == 2) {
            return true;
        }
        return false;
    }

    private void O000000o(float f, float f2) {
        this.O0000oOO = true;
        this.O0000oO.onViewReleased(this.O0000Oo, f, f2);
        this.O0000oOO = false;
        if (this.f14629O000000o == 1) {
            O00000Oo(0);
        }
    }

    private void O00000o0(int i) {
        if (this.O00000o0 != null && O000000o(i)) {
            this.O00000o0[i] = 0.0f;
            this.O00000o[i] = 0.0f;
            this.O00000oO[i] = 0.0f;
            this.O00000oo[i] = 0.0f;
            this.O0000Ooo[i] = 0;
            this.O0000o00[i] = 0;
            this.O0000o0[i] = 0;
            this.O0000o0O = ((1 << i) ^ -1) & this.O0000o0O;
        }
    }

    private void O00000o0(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (O00000o(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.O00000oO[pointerId] = x;
                this.O00000oo[pointerId] = y;
            }
        }
    }

    public final boolean O000000o(int i) {
        return ((1 << i) & this.O0000o0O) != 0;
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(int i) {
        this.O0000oOo.removeCallbacks(this.O0000oo);
        if (this.f14629O000000o != i) {
            this.f14629O000000o = i;
            this.O0000oO.onViewDragStateChanged(i);
            if (this.f14629O000000o == 0) {
                this.O0000Oo = null;
            }
        }
    }

    private boolean O00000Oo(View view, int i) {
        if (view == this.O0000Oo && this.O0000OoO == i) {
            return true;
        }
        if (view == null || !this.O0000oO.tryCaptureView(view, i)) {
            return false;
        }
        this.O0000OoO = i;
        O000000o(view, i);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00dc, code lost:
        if (r12 != r11) goto L_0x00e4;
     */
    public final boolean O000000o(MotionEvent motionEvent) {
        View O00000Oo2;
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            O000000o();
        }
        if (this.O0000o0o == null) {
            this.O0000o0o = VelocityTracker.obtain();
        }
        this.O0000o0o.addMovement(motionEvent2);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            int pointerId = motionEvent2.getPointerId(actionIndex);
                            float x = motionEvent2.getX(actionIndex);
                            float y = motionEvent2.getY(actionIndex);
                            O000000o(x, y, pointerId);
                            int i = this.f14629O000000o;
                            if (i == 0) {
                                int i2 = this.O0000Ooo[pointerId];
                                int i3 = this.O0000Oo0;
                                if ((i2 & i3) != 0) {
                                    this.O0000oO.onEdgeTouched(i2 & i3, pointerId);
                                }
                            } else if (i == 2 && (O00000Oo2 = O00000Oo((int) x, (int) y)) == this.O0000Oo) {
                                O00000Oo(O00000Oo2, pointerId);
                            }
                        } else if (actionMasked == 6) {
                            O00000o0(motionEvent2.getPointerId(actionIndex));
                        }
                    }
                } else if (!(this.O00000o0 == null || this.O00000o == null)) {
                    int pointerCount = motionEvent.getPointerCount();
                    for (int i4 = 0; i4 < pointerCount; i4++) {
                        int pointerId2 = motionEvent2.getPointerId(i4);
                        if (O00000o(pointerId2)) {
                            float x2 = motionEvent2.getX(i4);
                            float y2 = motionEvent2.getY(i4);
                            float f = x2 - this.O00000o0[pointerId2];
                            float f2 = y2 - this.O00000o[pointerId2];
                            View O00000Oo3 = O00000Oo((int) x2, (int) y2);
                            boolean z = O00000Oo3 != null && O000000o(O00000Oo3, f, f2);
                            if (z) {
                                int left = O00000Oo3.getLeft();
                                int i5 = (int) f;
                                int clampViewPositionHorizontal = this.O0000oO.clampViewPositionHorizontal(O00000Oo3, left + i5, i5);
                                int top = O00000Oo3.getTop();
                                int i6 = (int) f2;
                                int clampViewPositionVertical = this.O0000oO.clampViewPositionVertical(O00000Oo3, top + i6, i6);
                                int viewHorizontalDragRange = this.O0000oO.getViewHorizontalDragRange(O00000Oo3);
                                int viewVerticalDragRange = this.O0000oO.getViewVerticalDragRange(O00000Oo3);
                                if (viewHorizontalDragRange != 0) {
                                    if (viewHorizontalDragRange > 0) {
                                    }
                                }
                                if (viewVerticalDragRange != 0) {
                                    if (viewVerticalDragRange > 0 && clampViewPositionVertical == top) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            O00000Oo(f, f2, pointerId2);
                            if (this.f14629O000000o != 1) {
                                if (z && O00000Oo(O00000Oo3, pointerId2)) {
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
            int pointerId3 = motionEvent2.getPointerId(0);
            O000000o(x3, y3, pointerId3);
            View O00000Oo4 = O00000Oo((int) x3, (int) y3);
            if (O00000Oo4 == this.O0000Oo && this.f14629O000000o == 2) {
                O00000Oo(O00000Oo4, pointerId3);
            }
            int i7 = this.O0000Ooo[pointerId3];
            int i8 = this.O0000Oo0;
            if ((i7 & i8) != 0) {
                this.O0000oO.onEdgeTouched(i7 & i8, pointerId3);
            }
        }
        if (this.f14629O000000o == 1) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dh.O000000o(float, float):void
     arg types: [int, int]
     candidates:
      _m_j.dh.O000000o(android.view.ViewGroup, _m_j.dh$O000000o):_m_j.dh
      _m_j.dh.O000000o(android.view.View, int):void
      _m_j.dh.O000000o(int, int):boolean
      _m_j.dh.O000000o(float, float):void */
    public final void O00000Oo(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            O000000o();
        }
        if (this.O0000o0o == null) {
            this.O0000o0o = VelocityTracker.obtain();
        }
        this.O0000o0o.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View O00000Oo2 = O00000Oo((int) x, (int) y);
            O000000o(x, y, pointerId);
            O00000Oo(O00000Oo2, pointerId);
            int i3 = this.O0000Ooo[pointerId];
            int i4 = this.O0000Oo0;
            if ((i3 & i4) != 0) {
                this.O0000oO.onEdgeTouched(i3 & i4, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f14629O000000o == 1) {
                O00000o();
            }
            O000000o();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f14629O000000o == 1) {
                    O000000o(0.0f, 0.0f);
                }
                O000000o();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x2 = motionEvent.getX(actionIndex);
                float y2 = motionEvent.getY(actionIndex);
                O000000o(x2, y2, pointerId2);
                if (this.f14629O000000o == 0) {
                    O00000Oo(O00000Oo((int) x2, (int) y2), pointerId2);
                    int i5 = this.O0000Ooo[pointerId2];
                    int i6 = this.O0000Oo0;
                    if ((i5 & i6) != 0) {
                        this.O0000oO.onEdgeTouched(i5 & i6, pointerId2);
                        return;
                    }
                    return;
                }
                if (O00000Oo(this.O0000Oo, (int) x2, (int) y2)) {
                    O00000Oo(this.O0000Oo, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                if (this.f14629O000000o == 1 && pointerId3 == this.O0000OoO) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i2 >= pointerCount) {
                            i = -1;
                            break;
                        }
                        int pointerId4 = motionEvent.getPointerId(i2);
                        if (pointerId4 != this.O0000OoO) {
                            View O00000Oo3 = O00000Oo((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                            View view = this.O0000Oo;
                            if (O00000Oo3 == view && O00000Oo(view, pointerId4)) {
                                i = this.O0000OoO;
                                break;
                            }
                        }
                        i2++;
                    }
                    if (i == -1) {
                        O00000o();
                    }
                }
                O00000o0(pointerId3);
            }
        } else if (this.f14629O000000o != 1) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i2 < pointerCount2) {
                int pointerId5 = motionEvent.getPointerId(i2);
                if (O00000o(pointerId5)) {
                    float x3 = motionEvent.getX(i2);
                    float y3 = motionEvent.getY(i2);
                    float f = x3 - this.O00000o0[pointerId5];
                    float f2 = y3 - this.O00000o[pointerId5];
                    O00000Oo(f, f2, pointerId5);
                    if (this.f14629O000000o == 1) {
                        break;
                    }
                    View O00000Oo4 = O00000Oo((int) x3, (int) y3);
                    if (O000000o(O00000Oo4, f, f2) && O00000Oo(O00000Oo4, pointerId5)) {
                        break;
                    }
                }
                i2++;
            }
            O00000o0(motionEvent);
        } else if (O00000o(this.O0000OoO)) {
            int findPointerIndex = motionEvent.findPointerIndex(this.O0000OoO);
            float x4 = motionEvent.getX(findPointerIndex);
            float y4 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.O00000oO;
            int i7 = this.O0000OoO;
            int i8 = (int) (x4 - fArr[i7]);
            int i9 = (int) (y4 - this.O00000oo[i7]);
            int left = this.O0000Oo.getLeft() + i8;
            int top = this.O0000Oo.getTop() + i9;
            int left2 = this.O0000Oo.getLeft();
            int top2 = this.O0000Oo.getTop();
            if (i8 != 0) {
                left = this.O0000oO.clampViewPositionHorizontal(this.O0000Oo, left, i8);
                cb.O0000Oo(this.O0000Oo, left - left2);
            }
            int i10 = left;
            if (i9 != 0) {
                top = this.O0000oO.clampViewPositionVertical(this.O0000Oo, top, i9);
                cb.O0000Oo0(this.O0000Oo, top - top2);
            }
            int i11 = top;
            if (!(i8 == 0 && i9 == 0)) {
                this.O0000oO.onViewPositionChanged(this.O0000Oo, i10, i11, i10 - left2, i11 - top2);
            }
            O00000o0(motionEvent);
        }
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
            int[] iArr = this.O0000o00;
            iArr[i] = iArr[i] | O000000o2;
            this.O0000oO.onEdgeDragStarted(O000000o2 ? 1 : 0, i);
        }
    }

    private boolean O000000o(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if (!((this.O0000Ooo[i] & i2) != i2 || (this.O0000Oo0 & i2) == 0 || (this.O0000o0[i] & i2) == i2 || (this.O0000o00[i] & i2) == i2)) {
            int i3 = this.O00000Oo;
            if (abs > ((float) i3) || abs2 > ((float) i3)) {
                if (abs < abs2 * 0.5f && this.O0000oO.onEdgeLock(i2)) {
                    int[] iArr = this.O0000o0;
                    iArr[i] = iArr[i] | i2;
                    return false;
                } else if ((this.O0000o00[i] & i2) != 0 || abs <= ((float) this.O00000Oo)) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean O000000o(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.O0000oO.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.O0000oO.getViewVerticalDragRange(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f) > ((float) this.O00000Oo) : z2 && Math.abs(f2) > ((float) this.O00000Oo);
        }
        int i = this.O00000Oo;
        return (f * f) + (f2 * f2) > ((float) (i * i));
    }

    private void O00000o() {
        this.O0000o0o.computeCurrentVelocity(1000, this.O0000o);
        O000000o(O000000o(this.O0000o0o.getXVelocity(this.O0000OoO), this.O0000O0o, this.O0000o), O000000o(this.O0000o0o.getYVelocity(this.O0000OoO), this.O0000O0o, this.O0000o));
    }

    public static boolean O00000Oo(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public final View O00000Oo(int i, int i2) {
        for (int childCount = this.O0000oOo.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.O0000oOo.getChildAt(this.O0000oO.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private boolean O00000o(int i) {
        if (O000000o(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void O000000o(float f, float f2, int i) {
        float[] fArr = this.O00000o0;
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
            float[] fArr6 = this.O00000o0;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.O00000o;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.O00000oO;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.O00000oo;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.O0000Ooo;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.O0000o00;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.O0000o0;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.O00000o0 = fArr2;
            this.O00000o = fArr3;
            this.O00000oO = fArr4;
            this.O00000oo = fArr5;
            this.O0000Ooo = iArr;
            this.O0000o00 = iArr2;
            this.O0000o0 = iArr3;
        }
        float[] fArr10 = this.O00000o0;
        this.O00000oO[i] = f;
        fArr10[i] = f;
        float[] fArr11 = this.O00000o;
        this.O00000oo[i] = f2;
        fArr11[i] = f2;
        int[] iArr7 = this.O0000Ooo;
        int i4 = (int) f;
        int i5 = (int) f2;
        if (i4 < this.O0000oOo.getLeft() + this.O0000OOo) {
            i2 = 1;
        }
        if (i5 < this.O0000oOo.getTop() + this.O0000OOo) {
            i2 |= 4;
        }
        if (i4 > this.O0000oOo.getRight() - this.O0000OOo) {
            i2 |= 2;
        }
        if (i5 > this.O0000oOo.getBottom() - this.O0000OOo) {
            i2 |= 8;
        }
        iArr7[i] = i2;
        this.O0000o0O |= 1 << i;
    }
}
