package _m_j;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public abstract class OOOo00 implements View.OnAttachStateChangeListener, View.OnTouchListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private final float f12332O000000o;
    private final int O00000Oo;
    private final int O00000o;
    final View O00000o0;
    private Runnable O00000oO;
    private Runnable O00000oo;
    private boolean O0000O0o;
    private int O0000OOo;
    private final int[] O0000Oo0 = new int[2];

    public abstract OO0o O000000o();

    public void onViewAttachedToWindow(View view) {
    }

    public OOOo00(View view) {
        this.O00000o0 = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f12332O000000o = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.O00000Oo = ViewConfiguration.getTapTimeout();
        this.O00000o = (this.O00000Oo + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0084, code lost:
        if (r4 != 3) goto L_0x0102;
     */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0110  */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        OOOo000 oOOo000;
        boolean z4 = this.O0000O0o;
        if (z4) {
            View view2 = this.O00000o0;
            OO0o O000000o2 = O000000o();
            if (O000000o2 != null && O000000o2.O00000o0() && (oOOo000 = (OOOo000) O000000o2.b_()) != null && oOOo000.isShown()) {
                MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                int[] iArr = this.O0000Oo0;
                view2.getLocationOnScreen(iArr);
                obtainNoHistory.offsetLocation((float) iArr[0], (float) iArr[1]);
                int[] iArr2 = this.O0000Oo0;
                oOOo000.getLocationOnScreen(iArr2);
                obtainNoHistory.offsetLocation((float) (-iArr2[0]), (float) (-iArr2[1]));
                boolean O000000o3 = oOOo000.O000000o(obtainNoHistory, this.O0000OOo);
                obtainNoHistory.recycle();
                int actionMasked = motionEvent.getActionMasked();
                boolean z5 = (actionMasked == 1 || actionMasked == 3) ? false : true;
                if (O000000o3 && z5) {
                    z3 = true;
                    z = !z3 || !O00000o0();
                }
            }
            z3 = false;
            if (!z3) {
            }
        } else {
            View view3 = this.O00000o0;
            if (view3.isEnabled()) {
                int actionMasked2 = motionEvent.getActionMasked();
                if (actionMasked2 != 0) {
                    if (actionMasked2 != 1) {
                        if (actionMasked2 == 2) {
                            int findPointerIndex = motionEvent.findPointerIndex(this.O0000OOo);
                            if (findPointerIndex >= 0) {
                                float x = motionEvent.getX(findPointerIndex);
                                float y = motionEvent.getY(findPointerIndex);
                                float f = this.f12332O000000o;
                                float f2 = -f;
                                if (!(x >= f2 && y >= f2 && x < ((float) (view3.getRight() - view3.getLeft())) + f && y < ((float) (view3.getBottom() - view3.getTop())) + f)) {
                                    O00000oO();
                                    view3.getParent().requestDisallowInterceptTouchEvent(true);
                                    z2 = true;
                                    z = !z2 && O00000Oo();
                                    if (z) {
                                        long uptimeMillis = SystemClock.uptimeMillis();
                                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                                        this.O00000o0.onTouchEvent(obtain);
                                        obtain.recycle();
                                    }
                                }
                            }
                        }
                    }
                    O00000oO();
                } else {
                    this.O0000OOo = motionEvent.getPointerId(0);
                    if (this.O00000oO == null) {
                        this.O00000oO = new O000000o();
                    }
                    view3.postDelayed(this.O00000oO, (long) this.O00000Oo);
                    if (this.O00000oo == null) {
                        this.O00000oo = new O00000Oo();
                    }
                    view3.postDelayed(this.O00000oo, (long) this.O00000o);
                }
            }
            z2 = false;
            if (!z2) {
            }
            if (z) {
            }
        }
        this.O0000O0o = z;
        return z || z4;
    }

    public void onViewDetachedFromWindow(View view) {
        this.O0000O0o = false;
        this.O0000OOo = -1;
        Runnable runnable = this.O00000oO;
        if (runnable != null) {
            this.O00000o0.removeCallbacks(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public boolean O00000Oo() {
        OO0o O000000o2 = O000000o();
        if (O000000o2 == null || O000000o2.O00000o0()) {
            return true;
        }
        O000000o2.a_();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean O00000o0() {
        OO0o O000000o2 = O000000o();
        if (O000000o2 == null || !O000000o2.O00000o0()) {
            return true;
        }
        O000000o2.O00000Oo();
        return true;
    }

    private void O00000oO() {
        Runnable runnable = this.O00000oo;
        if (runnable != null) {
            this.O00000o0.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.O00000oO;
        if (runnable2 != null) {
            this.O00000o0.removeCallbacks(runnable2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000o() {
        O00000oO();
        View view = this.O00000o0;
        if (view.isEnabled() && !view.isLongClickable() && O00000Oo()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.O0000O0o = true;
        }
    }

    class O000000o implements Runnable {
        O000000o() {
        }

        public final void run() {
            ViewParent parent = OOOo00.this.O00000o0.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    class O00000Oo implements Runnable {
        O00000Oo() {
        }

        public final void run() {
            OOOo00.this.O00000o();
        }
    }
}
