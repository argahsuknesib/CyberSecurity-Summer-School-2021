package com.xiaomi.smarthome.library.common.widget.nestscroll;

import _m_j.bo;
import _m_j.br;
import _m_j.bs;
import _m_j.bv;
import _m_j.cb;
import _m_j.cx;
import _m_j.grf;
import _m_j.grg;
import _m_j.grh;
import _m_j.gri;
import _m_j.grj;
import _m_j.gsy;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class PullHeaderLayout extends ViewGroup implements bo, bs {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static final String f9320O000000o = "PullHeaderLayout";
    static final int O00000Oo = gri.O000000o(40.0f);
    public static final int O00000o = gri.O000000o(260.0f);
    static final int O00000o0 = gri.O000000o(32.0f);
    public static final int O00000oO = gri.O000000o(197.0f);
    public static final int O00000oo = gri.O000000o(63.0f);
    protected int O0000O0o;
    protected int O0000OOo;
    protected ImageView O0000Oo;
    protected Drawable O0000Oo0;
    protected View O0000OoO;
    protected grg O0000Ooo;
    protected int O0000o;
    protected grf O0000o0;
    protected View O0000o00;
    protected VelocityTracker O0000o0O;
    protected ValueAnimator O0000o0o;
    protected int O0000oO;
    protected int O0000oO0;
    protected boolean O0000oOO;
    protected int O0000oOo;
    protected int O0000oo;
    protected int O0000oo0;
    protected int O0000ooO;
    protected int O0000ooo;
    protected final bv O000O00o;
    protected final br O000O0OO;
    protected cx O000O0Oo;
    public boolean O000O0o;
    public float O000O0o0;
    boolean O000O0oO;
    boolean O000O0oo;
    public boolean O000OO;
    public View O000OO00;
    public View O000OO0o;
    boolean O000OOOo;
    private boolean O000OOo;
    private Runnable O000OOo0;
    private int O000OOoO;
    private int O000OOoo;
    private boolean O000Oo0;
    private int O000Oo00;
    private float O000Oo0O;
    private float O000Oo0o;
    private O00000Oo O000OoO;
    private boolean O000OoO0;
    private Runnable O000OoOO;
    private Runnable O000OoOo;
    private boolean O000Ooo;
    private List<grh> O000Ooo0;
    private State O00O0Oo;
    protected O000000o O00oOoOo;
    protected final int[] O00oOooO;
    protected final int[] O00oOooo;

    public interface O000000o {
    }

    public interface O00000Oo {
    }

    public enum State {
        RESET,
        PULL,
        LOADING,
        State,
        COMPLETE
    }

    public PullHeaderLayout(Context context) {
        this(context, null);
    }

    public PullHeaderLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PullHeaderLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000O0o = 0;
        this.O0000OOo = 0;
        this.O0000o = 0;
        this.O0000oO0 = 0;
        this.O0000oO = -1;
        this.O0000oOO = false;
        this.O0000oOo = 0;
        this.O00oOooO = new int[2];
        this.O00oOooo = new int[2];
        this.O000O0o0 = 0.0f;
        this.O000O0o = true;
        this.O000OOo0 = new Runnable() {
            /* class com.xiaomi.smarthome.library.common.widget.nestscroll.PullHeaderLayout.AnonymousClass1 */

            public final void run() {
                PullHeaderLayout pullHeaderLayout = PullHeaderLayout.this;
                pullHeaderLayout.O000O0o = false;
                pullHeaderLayout.O000000o((float) pullHeaderLayout.O0000o0.O00000oO);
            }
        };
        this.O000O0oO = false;
        this.O000OOo = false;
        this.O000O0oo = false;
        this.O00O0Oo = State.RESET;
        this.O000OoOO = new Runnable() {
            /* class com.xiaomi.smarthome.library.common.widget.nestscroll.PullHeaderLayout.AnonymousClass4 */

            public final void run() {
                PullHeaderLayout.this.O000000o(State.RESET);
            }
        };
        this.O000OoOo = new Runnable() {
            /* class com.xiaomi.smarthome.library.common.widget.nestscroll.PullHeaderLayout.AnonymousClass5 */

            public final void run() {
                gsy.O00000Oo(PullHeaderLayout.f9320O000000o, "auto refresh");
                PullHeaderLayout pullHeaderLayout = PullHeaderLayout.this;
                pullHeaderLayout.O000OO = true;
                if (!(pullHeaderLayout.O000OO00 == null || PullHeaderLayout.this.O000OO00.getVisibility() == 0)) {
                    PullHeaderLayout.this.O000OO00.setVisibility(0);
                }
                PullHeaderLayout.this.O000000o(State.LOADING);
            }
        };
        this.O000OOOo = false;
        this.O000Ooo0 = new ArrayList();
        this.O000Ooo = false;
        int i2 = O00000oO;
        int i3 = O00000o;
        int i4 = O00000oo;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.phl_action, R.attr.phl_content, R.attr.phl_header, R.attr.phl_header_expand_height, R.attr.phl_header_height, R.attr.phl_header_shrink_height});
            i2 = obtainStyledAttributes.getDimensionPixelOffset(4, O00000oO);
            i3 = obtainStyledAttributes.getDimensionPixelOffset(3, O00000o);
            i4 = obtainStyledAttributes.getDimensionPixelOffset(5, O00000oo);
            this.O0000O0o = obtainStyledAttributes.getResourceId(2, this.O0000O0o);
            this.O0000OOo = obtainStyledAttributes.getResourceId(1, this.O0000OOo);
            this.O0000Oo0 = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
        }
        this.O0000o0 = new grf(i2, i3, i4);
        ViewConfiguration.get(getContext());
        this.O000O00o = new bv();
        this.O000O0OO = new br(this);
        setNestedScrollingEnabled(true);
        this.O000O0Oo = cx.O000000o(getContext(), new DecelerateInterpolator(3.0f));
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.O0000oo0 = viewConfiguration.getScaledTouchSlop();
        this.O0000oo = viewConfiguration.getScaledMinimumFlingVelocity();
        this.O0000ooO = viewConfiguration.getScaledMaximumFlingVelocity();
        this.O000OOoo = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.O000O0OO.O000000o(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.O000O0OO.f13211O000000o;
    }

    public boolean startNestedScroll(int i) {
        gsy.O00000Oo(f9320O000000o, "startNestedScroll in");
        return this.O000O0OO.O000000o(i, 0);
    }

    public void stopNestedScroll() {
        this.O000O0OO.O00000Oo(0);
    }

    public boolean hasNestedScrollingParent() {
        gsy.O00000Oo(f9320O000000o, "hasNestedScrollingParent in");
        return this.O000O0OO.O000000o(0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        gsy.O00000Oo(f9320O000000o, "dispatchNestedScroll in");
        return this.O000O0OO.O000000o(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        gsy.O00000Oo(f9320O000000o, "dispatchNestedPreScroll in");
        return this.O000O0OO.O000000o(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        gsy.O00000Oo(f9320O000000o, "dispatchNestedFling bool=".concat(String.valueOf(this.O000O0OO.O000000o(f, f2, z))));
        return true;
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        gsy.O00000Oo(f9320O000000o, "dispatchNestedPreFling in");
        return this.O000O0OO.O000000o(f, f2);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        gsy.O00000Oo(f9320O000000o, "onStartNestedScroll in nestedScrollAxes=".concat(String.valueOf(i)));
        return (i & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        gsy.O00000Oo(f9320O000000o, "onNestedScrollAccepted in");
        this.O000O00o.O000000o(i, 0);
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View view) {
        gsy.O00000Oo(f9320O000000o, "onStopNestedScroll in");
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        gsy.O00000Oo(f9320O000000o, "onNestedScroll in");
        this.O000O0oo = true;
        int O000000o2 = O000000o((float) i4);
        dispatchNestedScroll(0, O000000o2, 0, i4 - O000000o2, null);
        this.O000O0oo = false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        gsy.O00000Oo(f9320O000000o, "onNestedPreScroll in");
        if (i2 > 0 && this.O0000o0.O000000o()) {
            int O000000o2 = O000000o((float) i2);
            iArr[0] = 0;
            iArr[1] = O000000o2;
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        String str = f9320O000000o;
        gsy.O00000Oo(str, "onNestedFling consumed=" + z + ",velocityY=" + f2);
        this.O000O0o0 = f2;
        if (!z) {
            return false;
        }
        O000000o((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        gsy.O00000Oo(f9320O000000o, "onNestedPreFling in");
        return false;
    }

    private boolean O000000o(int i) {
        int i2 = this.O0000o0.O00000oO;
        float f = (float) i;
        boolean O00000Oo2 = O00000Oo(f);
        String str = f9320O000000o;
        gsy.O00000Oo(str, "flingWithNestedDispatch in canFling=" + O00000Oo2 + ",scroll=" + ((int) this.O0000o0.O00000o) + ",maxScroll=" + i2);
        if (O00000Oo2 && !this.O0000o0.O00000Oo()) {
            O00000Oo(i);
        } else if (!dispatchNestedPreFling(0.0f, f)) {
            dispatchNestedFling(0.0f, f, O00000Oo2);
        }
        return O00000Oo2;
    }

    private boolean O00000Oo(float f) {
        gsy.O00000Oo(f9320O000000o, "shouldFlingWithNestedDispatch velocityY=".concat(String.valueOf(f)));
        if (f > 0.0f && !this.O0000o0.O000000o()) {
            return false;
        }
        if (f >= 0.0f || !O000000o(this.O0000o00)) {
            return true;
        }
        return false;
    }

    private static boolean O000000o(View view) {
        if (Build.VERSION.SDK_INT < 14) {
            if (!(view instanceof AbsListView)) {
                return cb.O00000Oo(view, 1) || view.getScrollY() < 0;
            }
            AbsListView absListView = (AbsListView) view;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        } else if (!(view instanceof RecyclerView)) {
            return cb.O00000Oo(view, 1);
        } else {
            RecyclerView.LayoutManager layoutManager = ((RecyclerView) view).getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                return view.canScrollVertically(-1);
            }
            if (((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() <= 1) {
                return false;
            }
            return view.canScrollVertically(-1);
        }
    }

    public int getNestedScrollAxes() {
        gsy.O00000Oo(f9320O000000o, "getNestedScrollAxes in");
        return this.O000O00o.O000000o();
    }

    public void setOnPullListener(O000000o o000000o) {
        this.O00oOoOo = o000000o;
    }

    public void setActionDrawable(Drawable drawable) {
        this.O0000Oo0 = drawable;
    }

    public View getIconView() {
        return this.O0000Oo;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006c, code lost:
        if (r2 == r0) goto L_0x006e;
     */
    public void onFinishInflate() {
        int childCount = getChildCount();
        if (childCount <= 2) {
            if (childCount == 2) {
                int i = this.O0000O0o;
                if (i != 0 && this.O0000OoO == null) {
                    this.O0000OoO = findViewById(i);
                }
                int i2 = this.O0000OOo;
                if (i2 != 0 && this.O0000o00 == null) {
                    this.O0000o00 = findViewById(i2);
                }
                if (this.O0000o00 == null || this.O0000OoO == null) {
                    View childAt = getChildAt(0);
                    View childAt2 = getChildAt(1);
                    if (childAt instanceof grg) {
                        this.O0000OoO = childAt;
                        this.O0000o00 = childAt2;
                        this.O0000Ooo = (grg) this.O0000OoO;
                    } else if (childAt2 instanceof grg) {
                        this.O0000OoO = childAt2;
                        this.O0000o00 = childAt;
                        this.O0000Ooo = (grg) this.O0000OoO;
                    } else {
                        if (this.O0000o00 == null && this.O0000OoO == null) {
                            this.O0000OoO = childAt;
                        } else {
                            View view = this.O0000OoO;
                            if (view == null) {
                                if (this.O0000o00 == childAt) {
                                    childAt = childAt2;
                                }
                                this.O0000OoO = childAt;
                            }
                        }
                        childAt = childAt2;
                        this.O0000o00 = childAt;
                    }
                }
            } else if (childCount == 1) {
                this.O0000o00 = getChildAt(0);
            }
            this.O000OO0o = this.O0000o00;
            this.O000OO00 = this.O0000OoO.findViewById(R.id.ll_loading);
            setActionDrawable(this.O0000Oo0);
            super.onFinishInflate();
            return;
        }
        throw new IllegalStateException("FlyRefreshLayout only can host 2 elements");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        View view = this.O0000OoO;
        if (view != null) {
            measureChildWithMargins(view, i, 0, i2, 0);
        }
        View view2 = this.O0000o00;
        if (view2 != null) {
            measureChildWithMargins(view2, i, 0, i2, this.O0000o0.O00000Oo);
        }
    }

    private void O000000o(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.O0000oO) {
            int i = action == 0 ? 1 : 0;
            this.O0000oOo = (int) motionEvent.getY(i);
            this.O0000oO = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.O0000o0O;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void O000000o() {
        this.O0000oOO = false;
        VelocityTracker velocityTracker = this.O0000o0O;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.O0000o0O = null;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.O0000oOO) {
            return true;
        }
        if (!isEnabled()) {
            return false;
        }
        int i = action & 255;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    int i2 = this.O0000oO;
                    if (i2 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i2);
                        if (findPointerIndex == -1) {
                            String str = f9320O000000o;
                            gsy.O000000o(6, str, "Invalid pointerId=" + i2 + " in onInterceptTouchEvent");
                        } else {
                            int y = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y - this.O0000oOo) > this.O0000oo0 && (2 & getNestedScrollAxes()) == 0) {
                                this.O0000oOO = true;
                                this.O0000oOo = y;
                                if (this.O0000o0O == null) {
                                    this.O0000o0O = VelocityTracker.obtain();
                                }
                                this.O0000o0O.addMovement(motionEvent);
                                this.O0000ooo = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i != 3) {
                    if (i == 6) {
                        O000000o(motionEvent);
                    }
                }
            }
            this.O0000oOO = false;
            this.O0000oO = -1;
            O000000o();
            stopNestedScroll();
        } else {
            this.O0000oOo = (int) motionEvent.getY();
            this.O0000oO = motionEvent.getPointerId(0);
            VelocityTracker velocityTracker = this.O0000o0O;
            if (velocityTracker == null) {
                this.O0000o0O = VelocityTracker.obtain();
            } else {
                velocityTracker.clear();
            }
            this.O0000o0O.addMovement(motionEvent);
            this.O0000oOO = !this.O000O0Oo.f14386O000000o.isFinished();
            startNestedScroll(2);
        }
        return this.O0000oOO;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        int i;
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.O0000ooo = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.O0000ooo);
        if (actionMasked == 0) {
            boolean z = !this.O000O0Oo.f14386O000000o.isFinished();
            this.O0000oOO = z;
            if (z && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.O000O0Oo.f14386O000000o.isFinished()) {
                this.O000O0Oo.f14386O000000o.abortAnimation();
            }
            this.O0000oOo = (int) motionEvent.getY();
            this.O0000oO = motionEvent.getPointerId(0);
            startNestedScroll(2);
            this.O000OOo = true;
        } else if (actionMasked != 1) {
            if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.O0000oO);
                if (findPointerIndex == -1) {
                    gsy.O000000o(6, f9320O000000o, "Invalid pointerId=" + this.O0000oO + " in onTouchEvent");
                } else {
                    int y = (int) motionEvent.getY(findPointerIndex);
                    int i2 = this.O0000oOo - y;
                    if (dispatchNestedPreScroll(0, i2, this.O00oOooo, this.O00oOooO)) {
                        i2 -= this.O00oOooo[1];
                        obtain.offsetLocation(0.0f, (float) this.O00oOooO[1]);
                        this.O0000ooo += this.O00oOooO[1];
                    }
                    if (!this.O0000oOO && Math.abs(i2) > this.O0000oo0) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.O0000oOO = true;
                        if (i2 > 0) {
                            i2 -= this.O0000oo0;
                        } else {
                            i2 += this.O0000oo0;
                        }
                    }
                    if (this.O0000oOO) {
                        this.O0000oOo = y - this.O00oOooO[1];
                        int O000000o2 = O000000o((float) i2);
                        if (dispatchNestedScroll(0, O000000o2, 0, i2 - O000000o2, this.O00oOooO)) {
                            int i3 = this.O0000oOo;
                            int[] iArr = this.O00oOooO;
                            this.O0000oOo = i3 - iArr[1];
                            obtain.offsetLocation(0.0f, (float) iArr[1]);
                            this.O0000ooo += this.O00oOooO[1];
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.O0000oOO && getChildCount() > 0) {
                    this.O0000oO = -1;
                    O000000o();
                }
                this.O000OOo = false;
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.O0000oOo = (int) motionEvent.getY(actionIndex);
                this.O0000oO = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                O000000o(motionEvent);
                int findPointerIndex2 = motionEvent.findPointerIndex(this.O0000oO);
                if (findPointerIndex2 != -1) {
                    this.O0000oOo = (int) motionEvent.getY(findPointerIndex2);
                } else {
                    this.O0000oOo = (int) motionEvent.getY();
                }
            }
        } else if (this.O0000oOO) {
            VelocityTracker velocityTracker = this.O0000o0O;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(1000, (float) this.O0000ooO);
                i = (int) velocityTracker.getYVelocity(this.O0000oO);
            } else {
                i = 0;
            }
            if (Math.abs(i) > this.O0000oo) {
                O000000o(-i);
            }
            this.O0000oO = -1;
            O000000o();
            this.O000OOo = false;
        }
        VelocityTracker velocityTracker2 = this.O0000o0O;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void O00000Oo(int i) {
        this.O0000o = 2;
        gsy.O00000Oo(f9320O000000o, "fling start1");
        this.O000O0Oo.f14386O000000o.abortAnimation();
        this.O000O0Oo.O000000o((int) this.O0000o0.O00000o, i < 0 ? -3000 : 3000, this.O0000o0.O00000oO);
        cb.O00000oo(this);
    }

    /* access modifiers changed from: protected */
    public final int O000000o(float f) {
        gsy.O00000Oo(f9320O000000o, "moveBy ".concat(String.valueOf(f)));
        int O000000o2 = this.O0000o0.O000000o(f);
        int i = ((int) this.O0000o0.O00000o) - ((int) this.O0000o0.O00000o);
        if (i == 0) {
            if (!this.O000O0oO && this.O0000o == 1 && (this.O000OOo || this.O000O0oo)) {
                this.O000O0oO = true;
            }
            return 0;
        }
        if (this.O0000o != 1) {
            this.O0000o = 1;
            this.O000O0oO = false;
        }
        if (this.O0000o == 1) {
            if (f < 0.0f) {
                this.O0000oO0 = 2;
            } else if (f > 0.0f) {
                this.O0000oO0 = 1;
            }
        }
        View view = this.O0000o00;
        if (view != null) {
            view.offsetTopAndBottom(-i);
        }
        ImageView imageView = this.O0000Oo;
        if (imageView != null) {
            imageView.offsetTopAndBottom(-i);
        }
        String str = f9320O000000o;
        StringBuilder sb = new StringBuilder("mHeaderView.offsetTopAndBottom ");
        int i2 = -i;
        sb.append(i2);
        gsy.O00000Oo(str, sb.toString());
        this.O0000OoO.offsetTopAndBottom(i2);
        return O000000o2;
    }

    public void computeScroll() {
        gsy.O00000Oo(f9320O000000o, "computeScroll");
        if (this.O000O0Oo.f14386O000000o.computeScrollOffset()) {
            int i = (int) this.O0000o0.O00000o;
            int currY = this.O000O0Oo.f14386O000000o.getCurrY();
            if (i != currY) {
                O000000o((float) (currY - i));
            }
            cb.O00000oo(this);
        }
    }

    private void O00000o0(int i) {
        this.O0000o = 2;
        gsy.O00000Oo(f9320O000000o, "scroll start");
        this.O000O0Oo.f14386O000000o.abortAnimation();
        this.O000O0Oo.O000000o(0, (int) this.O0000o0.O00000o, 0, i, 300);
        cb.O00000oo(this);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public void setRefreshHeader(View view) {
        View view2;
        if (view != null && view != (view2 = this.O000OO00)) {
            removeView(view2);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            this.O000OO00 = view;
            addView(this.O000OO00);
        }
    }

    public void setRefreshListener(O00000Oo o00000Oo) {
        this.O000OoO = o00000Oo;
    }

    public final void O000000o(State state) {
        this.O00O0Oo = state;
        View view = this.O000OO00;
        grh grh = view instanceof grh ? (grh) view : null;
        int i = AnonymousClass6.f9326O000000o[state.ordinal()];
        if (i == 1) {
            if (grh != null) {
                grh.O000000o();
            }
            O00000Oo();
        } else if (i == 2) {
            if (grh != null) {
                grh.O00000Oo();
            }
            O00000o0();
        } else if (i != 3) {
            if (i == 4) {
                if (grh != null) {
                    grh.O00000o();
                }
                O00000oO();
            }
        } else if (!this.O000OO) {
            if (grh != null) {
                grh.O00000o0();
            }
            O00000o();
        }
    }

    /* renamed from: com.xiaomi.smarthome.library.common.widget.nestscroll.PullHeaderLayout$6  reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f9326O000000o = new int[State.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f9326O000000o[State.RESET.ordinal()] = 1;
            f9326O000000o[State.PULL.ordinal()] = 2;
            f9326O000000o[State.LOADING.ordinal()] = 3;
            try {
                f9326O000000o[State.COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void O00000Oo() {
        if (!this.O000Ooo) {
            for (int i = 0; i < this.O000Ooo0.size(); i++) {
                grh grh = this.O000Ooo0.get(i);
                if (grh != null) {
                    grh.O000000o();
                }
            }
        }
    }

    private void O00000o0() {
        if (!this.O000Ooo) {
            for (int i = 0; i < this.O000Ooo0.size(); i++) {
                grh grh = this.O000Ooo0.get(i);
                if (grh != null) {
                    grh.O00000Oo();
                }
            }
        }
    }

    private void O00000o() {
        if (!this.O000Ooo) {
            for (int i = 0; i < this.O000Ooo0.size(); i++) {
                grh grh = this.O000Ooo0.get(i);
                if (grh != null) {
                    grh.O00000o0();
                }
            }
        }
    }

    private void O00000oO() {
        if (!this.O000Ooo) {
            for (int i = 0; i < this.O000Ooo0.size(); i++) {
                grh grh = this.O000Ooo0.get(i);
                if (grh != null) {
                    grh.O00000o();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.O000Ooo = true;
        super.onDetachedFromWindow();
        this.O000Ooo0.clear();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.O000Ooo = false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        grf grf = this.O0000o0;
        int i5 = (int) (((float) grf.f18179O000000o) - grf.O00000o);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        View view = this.O0000OoO;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int i6 = marginLayoutParams.leftMargin + paddingLeft;
            int i7 = marginLayoutParams.topMargin + paddingTop;
            this.O0000OoO.layout(i6, i7, this.O0000OoO.getMeasuredWidth() + i6, this.O0000OoO.getMeasuredHeight() + i7);
        }
        View view2 = this.O0000o00;
        if (view2 != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            int i8 = paddingLeft + marginLayoutParams2.leftMargin;
            int i9 = paddingTop + marginLayoutParams2.topMargin + i5;
            this.O0000o00.layout(i8, i9, this.O0000o00.getMeasuredWidth() + i8, this.O0000o00.getMeasuredHeight() + i9);
        }
        if (this.O000O0o) {
            O000000o(((float) this.O0000o0.O00000oO) * 0.97f);
            this.O000O0o = false;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getX() <= getResources().getDisplayMetrics().density * 20.0f) {
            return false;
        }
        if (actionMasked == 1 || actionMasked == 3) {
            if (this.O0000o0.O00000Oo()) {
                gsy.O00000Oo(f9320O000000o, "tryBounceBack isOverHeight");
                this.O0000o0o = ObjectAnimator.ofFloat((float) ((int) this.O0000o0.O00000o), 0.0f);
                this.O0000o0o.setInterpolator(new DecelerateInterpolator());
                this.O0000o0o.setDuration(200L);
                this.O0000o0o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.xiaomi.smarthome.library.common.widget.nestscroll.PullHeaderLayout.AnonymousClass2 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        PullHeaderLayout.this.O000000o(((Float) valueAnimator.getAnimatedValue()).floatValue() - ((float) ((int) PullHeaderLayout.this.O0000o0.O00000o)));
                    }
                });
                this.O0000o0o.addListener(new grj() {
                    /* class com.xiaomi.smarthome.library.common.widget.nestscroll.PullHeaderLayout.AnonymousClass3 */

                    public final void onAnimationEnd(Animator animator) {
                        PullHeaderLayout.this.O0000o = 0;
                    }
                });
                this.O0000o0o.start();
                this.O0000o = 3;
                grf grf = this.O0000o0;
                if ((-grf.O00000o) / grf.O00000o0 > 0.2f) {
                    this.O000OOOo = true;
                }
            } else if (Math.abs(this.O000O0o0) <= 0.0f) {
                int i = (int) this.O0000o0.O00000o;
                int i2 = this.O0000o0.O00000oO;
                float f = (float) i;
                float f2 = (float) i2;
                float f3 = 0.3f * f2;
                if (f <= f3) {
                    O00000o0(-i);
                } else {
                    if (f > f3) {
                        float f4 = f2 * 0.97f;
                        if (f < f4) {
                            O00000o0((int) (f4 - f));
                        }
                    }
                    float f5 = f2 * 0.97f;
                    if (f > f5 && i < i2) {
                        O00000o0(-((int) (f5 - f)));
                    }
                }
            }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (isEnabled() && this.O000OO0o != null) {
            int actionMasked2 = motionEvent.getActionMasked();
            if (actionMasked2 != 0) {
                if (actionMasked2 != 1) {
                    if (actionMasked2 == 2) {
                        gsy.O00000Oo(f9320O000000o, "ACTION_MOVE");
                        if (this.O000Oo00 == -1) {
                            gsy.O000000o(6, f9320O000000o, "Got ACTION_MOVE event but don't have an active pointer id.");
                        } else if (!this.O0000o0.O00000Oo()) {
                            O000000o(State.RESET);
                        } else {
                            float y = motionEvent.getY();
                            int findPointerIndex = motionEvent.findPointerIndex(this.O000Oo00);
                            if (findPointerIndex != -1) {
                                y = motionEvent.getY(findPointerIndex);
                            }
                            float f6 = (y - this.O000Oo0O) * 0.5f;
                            this.O000Oo0O = y;
                            if (!this.O000OoO0 && Math.abs(y - this.O000Oo0o) > ((float) this.O000OOoo)) {
                                this.O000OoO0 = true;
                            }
                            if (this.O000OoO0 && Math.round(f6) != 0) {
                                View view = this.O000OO00;
                                if (!(view == null || view.getVisibility() == 0)) {
                                    this.O000OO00.setVisibility(0);
                                }
                                if (!this.O000OOOo && this.O0000o0.O00000Oo() && ((float) Math.abs((int) this.O0000o0.O00000o)) >= this.O0000o0.O00000o0) {
                                    this.O000OOOo = true;
                                }
                                if (this.O00O0Oo == State.RESET && this.O0000o0.O00000Oo()) {
                                    O000000o(State.PULL);
                                }
                            }
                        }
                    } else if (actionMasked2 != 3) {
                        if (actionMasked2 == 5) {
                            gsy.O00000Oo(f9320O000000o, "ACTION_POINTER_DOWN");
                            int actionIndex = motionEvent.getActionIndex();
                            if (actionIndex < 0) {
                                gsy.O000000o(6, f9320O000000o, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                            } else {
                                this.O000Oo0O = motionEvent.getY(actionIndex);
                                this.O000Oo00 = motionEvent.getPointerId(actionIndex);
                            }
                        } else if (actionMasked2 == 6) {
                            gsy.O00000Oo(f9320O000000o, "ACTION_POINTER_UP");
                            O000000o(motionEvent);
                            int findPointerIndex2 = motionEvent.findPointerIndex(this.O000Oo00);
                            if (findPointerIndex2 != -1) {
                                this.O000Oo0O = motionEvent.getY(findPointerIndex2);
                            }
                        }
                    }
                }
                gsy.O00000Oo(f9320O000000o, "ACTION_UP ACTION_CANCEL");
                this.O000Oo0 = false;
                if (this.O00O0Oo == State.PULL && !this.O000Oo0 && this.O000OOOo) {
                    O000000o(State.LOADING);
                } else if (this.O00O0Oo != State.LOADING) {
                    O000000o(State.RESET);
                }
                this.O000Oo00 = -1;
            } else {
                gsy.O00000Oo(f9320O000000o, "ACTION_DOWN");
                if (motionEvent.getPointerCount() > 0) {
                    this.O000Oo00 = motionEvent.getPointerId(0);
                    float y2 = motionEvent.getY(0);
                    this.O000Oo0O = y2;
                    this.O000Oo0o = y2;
                } else {
                    float y3 = motionEvent.getY();
                    this.O000Oo0O = y3;
                    this.O000Oo0o = y3;
                }
                this.O000OO = false;
                this.O000Oo0 = true;
                this.O000OoO0 = false;
                this.O000OOoO = this.O000OO0o.getTop();
                removeCallbacks(this.O000OoOO);
                removeCallbacks(this.O000OoOo);
                this.O000OOOo = false;
                this.O000O0o0 = 0.0f;
            }
        }
        return dispatchTouchEvent;
    }
}
