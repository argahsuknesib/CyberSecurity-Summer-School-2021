package com.mi.global.shop.widget.pulltorefresh;

import _m_j.cb;
import _m_j.ccl;
import _m_j.cdy;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import com.mi.global.shop.util.SkinUtil;

public class SimplePullToRefreshLayout extends ViewGroup {
    private static final String O0000o = "SimplePullToRefreshLayout";
    private static final State O0000oO0 = State.RESET;

    /* renamed from: O000000o  reason: collision with root package name */
    protected LoadingLayout f5041O000000o;
    public View O00000Oo;
    public int O00000o;
    long O00000o0;
    public int O00000oO;
    public int O00000oo;
    public int O0000O0o;
    public boolean O0000OOo;
    DecelerateInterpolator O0000Oo;
    public O00000o O0000Oo0;
    DecelerateInterpolator O0000OoO;
    boolean O0000Ooo = false;
    final Animation O0000o0 = new Animation() {
        /* class com.mi.global.shop.widget.pulltorefresh.SimplePullToRefreshLayout.AnonymousClass4 */

        public final void applyTransformation(float f, Transformation transformation) {
            int paddingTop = SimplePullToRefreshLayout.this.getPaddingTop();
            if (SimplePullToRefreshLayout.this.O00000o != SimplePullToRefreshLayout.this.O00000oo || SimplePullToRefreshLayout.this.getState() == State.MANUAL_REFRESHING) {
                paddingTop = SimplePullToRefreshLayout.this.O00000o + ((int) (((float) ((SimplePullToRefreshLayout.this.O00000oo - SimplePullToRefreshLayout.this.O00000o) + SimplePullToRefreshLayout.this.O00000oO)) * f));
            }
            int top = paddingTop - SimplePullToRefreshLayout.this.O00000Oo.getTop();
            int top2 = SimplePullToRefreshLayout.this.O00000Oo.getTop();
            if (top + top2 < 0) {
                top = 0 - top2;
            }
            SimplePullToRefreshLayout.this.setTargetOffsetTopAndBottom(top);
        }
    };
    final Animation O0000o00 = new Animation() {
        /* class com.mi.global.shop.widget.pulltorefresh.SimplePullToRefreshLayout.AnonymousClass3 */

        public final void applyTransformation(float f, Transformation transformation) {
            int paddingTop = SimplePullToRefreshLayout.this.getPaddingTop();
            if (SimplePullToRefreshLayout.this.O00000o != SimplePullToRefreshLayout.this.O00000oo) {
                paddingTop = SimplePullToRefreshLayout.this.O00000o + ((int) (((float) (SimplePullToRefreshLayout.this.O00000oo - SimplePullToRefreshLayout.this.O00000o)) * f));
            }
            int top = paddingTop - SimplePullToRefreshLayout.this.O00000Oo.getTop();
            int top2 = SimplePullToRefreshLayout.this.O00000Oo.getTop();
            if (top + top2 < 0) {
                top = 0 - top2;
            }
            SimplePullToRefreshLayout.this.setTargetOffsetTopAndBottom(top);
        }
    };
    public final Animation.AnimationListener O0000o0O = new O000000o() {
        /* class com.mi.global.shop.widget.pulltorefresh.SimplePullToRefreshLayout.AnonymousClass5 */

        public final void onAnimationEnd(Animation animation) {
            SimplePullToRefreshLayout.this.O0000O0o = 0;
        }
    };
    public final Animation.AnimationListener O0000o0o = new O000000o() {
        /* class com.mi.global.shop.widget.pulltorefresh.SimplePullToRefreshLayout.AnonymousClass6 */

        public final void onAnimationEnd(Animation animation) {
            SimplePullToRefreshLayout simplePullToRefreshLayout = SimplePullToRefreshLayout.this;
            simplePullToRefreshLayout.O0000O0o = simplePullToRefreshLayout.O00000oO;
            if (SimplePullToRefreshLayout.this.O0000Oo0 != null) {
                SimplePullToRefreshLayout.this.O0000Oo0.onRefresh();
            }
        }
    };
    private State O0000oO = O0000oO0;
    private float O0000oOO;
    private O0000O0o O0000oOo;
    private O00000Oo O0000oo;
    private O00000o0 O0000oo0;
    private float O0000ooO;
    private float O0000ooo;
    private final Runnable O000O00o = new Runnable() {
        /* class com.mi.global.shop.widget.pulltorefresh.SimplePullToRefreshLayout.AnonymousClass1 */

        public final void run() {
            SimplePullToRefreshLayout simplePullToRefreshLayout = SimplePullToRefreshLayout.this;
            simplePullToRefreshLayout.O0000OOo = true;
            int paddingTop = simplePullToRefreshLayout.O0000O0o + SimplePullToRefreshLayout.this.getPaddingTop();
            Animation.AnimationListener animationListener = SimplePullToRefreshLayout.this.O0000o0o;
            simplePullToRefreshLayout.O00000o = paddingTop;
            simplePullToRefreshLayout.O0000o0.reset();
            simplePullToRefreshLayout.O0000o0.setAnimationListener(animationListener);
            if (simplePullToRefreshLayout.O0000Ooo) {
                if (SkinUtil.O00000oo != 0) {
                    simplePullToRefreshLayout.O0000o0.setDuration((long) SkinUtil.O00000oo);
                } else {
                    simplePullToRefreshLayout.O0000o0.setDuration(simplePullToRefreshLayout.O00000o0 * 3);
                }
                simplePullToRefreshLayout.O0000o0.setInterpolator(simplePullToRefreshLayout.O0000OoO);
            } else {
                simplePullToRefreshLayout.O0000o0.setDuration(simplePullToRefreshLayout.O00000o0);
                simplePullToRefreshLayout.O0000o0.setInterpolator(simplePullToRefreshLayout.O0000Oo);
            }
            simplePullToRefreshLayout.O00000Oo.startAnimation(simplePullToRefreshLayout.O0000o0);
        }
    };
    private final Runnable O000O0OO = new Runnable() {
        /* class com.mi.global.shop.widget.pulltorefresh.SimplePullToRefreshLayout.AnonymousClass2 */

        public final void run() {
            SimplePullToRefreshLayout simplePullToRefreshLayout = SimplePullToRefreshLayout.this;
            simplePullToRefreshLayout.O0000OOo = true;
            int paddingTop = simplePullToRefreshLayout.O0000O0o + SimplePullToRefreshLayout.this.getPaddingTop();
            Animation.AnimationListener animationListener = SimplePullToRefreshLayout.this.O0000o0O;
            simplePullToRefreshLayout.O00000o = paddingTop;
            simplePullToRefreshLayout.O0000o00.reset();
            simplePullToRefreshLayout.O0000o00.setDuration(simplePullToRefreshLayout.O00000o0);
            simplePullToRefreshLayout.O0000o00.setAnimationListener(animationListener);
            simplePullToRefreshLayout.O0000o00.setInterpolator(simplePullToRefreshLayout.O0000Oo);
            simplePullToRefreshLayout.O00000Oo.startAnimation(simplePullToRefreshLayout.O0000o00);
        }
    };
    private int O00oOooO;
    private final int O00oOooo = 100;

    public interface O00000Oo {
        void O000000o(int i);
    }

    public interface O00000o {
        void onRefresh();
    }

    public interface O00000o0 {
    }

    public interface O0000O0o {
    }

    public SimplePullToRefreshLayout(Context context) {
        super(context);
        O000000o(context, false);
    }

    public SimplePullToRefreshLayout(Context context, boolean z) {
        super(context);
        O000000o(context, z);
    }

    public SimplePullToRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context, false);
    }

    public SimplePullToRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context, false);
    }

    private void O000000o(Context context, boolean z) {
        float f = context.getResources().getDisplayMetrics().density;
        if (SkinUtil.O00000oO && SkinUtil.O000000o("KEY_FESTIVAL_PULL_GIF_ITEM") != null) {
            this.O0000Ooo = true;
        }
        this.O0000oOO = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        this.f5041O000000o = O00000Oo(context, z);
        this.O0000Oo = new DecelerateInterpolator(2.0f);
        this.O0000OoO = new DecelerateInterpolator(4.0f);
        this.O00000o0 = 600;
        this.O00oOooO = (int) (f * 0.0f);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (this.O00000Oo == null) {
            if (getChildCount() <= 1 || isInEditMode()) {
                this.O00000Oo = getChildAt(0);
                this.O00000oo = this.O00000Oo.getTop() + getPaddingTop();
            } else {
                throw new IllegalStateException("SimplePullToRefreshLayout can host only one direct child");
            }
        }
        removeAllViews();
        addView(this.f5041O000000o);
        addView(this.O00000Oo);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 2 && !isInEditMode()) {
            throw new IllegalStateException("SimplePullToRefreshLayout can host only one direct child");
        } else if (getChildCount() == 2) {
            getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), Integer.MIN_VALUE));
            getChildAt(1).measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = this.O0000O0o + getPaddingTop();
            int paddingLeft2 = (measuredWidth - getPaddingLeft()) - getPaddingRight();
            int paddingTop2 = (measuredHeight - getPaddingTop()) - getPaddingBottom();
            int measuredHeight2 = this.f5041O000000o.getMeasuredHeight();
            if (!this.O0000Ooo || this.f5041O000000o.getGif_bg() == null) {
                this.O00000oO = measuredHeight2;
            } else {
                this.O00000oO = cdy.O000000o(100.0f);
            }
            if (getState() == State.RESET) {
                this.f5041O000000o.layout(paddingLeft, (-measuredHeight2) + paddingTop, paddingLeft2, paddingTop);
            } else {
                LoadingLayout loadingLayout = this.f5041O000000o;
                int i5 = this.O00oOooO;
                loadingLayout.layout(paddingLeft, (-measuredHeight2) + paddingTop + i5, paddingLeft2, i5 + paddingTop);
            }
            if (getChildCount() >= 2) {
                getChildAt(1).layout(paddingLeft, paddingTop, paddingLeft2 + paddingLeft, paddingTop2 + paddingTop);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        if (O00000Oo()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else if (this.O0000OOo) {
                    return false;
                } else {
                    float y = motionEvent.getY() - this.O0000ooo;
                    if (y <= this.O0000oOO) {
                        return false;
                    }
                    int round = Math.round(y / 2.2222223f);
                    int top = this.O00000Oo.getTop();
                    if (round < 0) {
                        round = 0;
                    }
                    setTargetOffsetTopAndBottom((round - top) + getPaddingTop());
                    this.O0000ooO = motionEvent.getY();
                    int round2 = Math.round(Math.min(this.O0000ooo - this.O0000ooO, 0.0f) / 2.2222223f);
                    if (!this.O0000Ooo || this.f5041O000000o.getGif_bg() == null) {
                        i = this.f5041O000000o.getMeasuredHeight();
                    } else {
                        i = cdy.O000000o(100.0f);
                    }
                    if (this.O0000oO != State.PULL_TO_REFRESH && i >= Math.abs(round2)) {
                        setState(State.PULL_TO_REFRESH);
                    } else if (this.O0000oO == State.PULL_TO_REFRESH && i < Math.abs(round2)) {
                        setState(State.RELEASE_TO_REFRESH);
                    }
                    return true;
                }
            }
            if (this.O0000oO == State.RELEASE_TO_REFRESH && this.O0000Oo0 != null) {
                setState(State.REFRESHING);
                return true;
            } else if (O00000Oo()) {
                return true;
            } else {
                setState(State.RESET);
                return false;
            }
        } else {
            float y2 = motionEvent.getY();
            this.O0000ooo = y2;
            this.O0000ooO = y2;
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        if (r0.getChildAt(0).getTop() < r0.getPaddingTop()) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004d, code lost:
        if (r0.getScrollY() > 0) goto L_0x005c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005e  */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = false;
        if (this.O0000OOo && action == 0) {
            float y = motionEvent.getY();
            this.O0000ooo = y;
            this.O0000ooO = y;
            this.O0000OOo = false;
        }
        if (isEnabled() && !this.O0000OOo) {
            boolean z2 = true;
            if (Build.VERSION.SDK_INT < 14) {
                View view = this.O00000Oo;
                if (view instanceof AbsListView) {
                    AbsListView absListView = (AbsListView) view;
                    if (absListView.getChildCount() > 0) {
                        if (absListView.getFirstVisiblePosition() <= 0) {
                        }
                        if (!z2) {
                            z = onTouchEvent(motionEvent);
                        }
                    }
                }
            } else {
                View view2 = this.O00000Oo;
                if (view2 != null) {
                    z2 = cb.O00000Oo(view2, -1);
                    if (!z2) {
                    }
                }
            }
            z2 = false;
            if (!z2) {
            }
        }
        return !z ? super.onInterceptTouchEvent(motionEvent) : z;
    }

    public enum State {
        RESET(0),
        PULL_TO_REFRESH(1),
        RELEASE_TO_REFRESH(2),
        REFRESHING(8),
        MANUAL_REFRESHING(9);
        
        private int mIntValue;

        static State mapIntToValue(int i) {
            for (State state : values()) {
                if (i == state.getIntValue()) {
                    return state;
                }
            }
            return RESET;
        }

        private State(int i) {
            this.mIntValue = i;
        }

        /* access modifiers changed from: package-private */
        public final int getIntValue() {
            return this.mIntValue;
        }
    }

    private LoadingLayout O00000Oo(Context context, boolean z) {
        if (this.O0000Ooo) {
            return new FestivalLoadingLayout(context);
        }
        return new ccl(context, z);
    }

    public void setTargetOffsetTopAndBottom(int i) {
        this.O00000Oo.offsetTopAndBottom(i);
        this.O0000O0o = this.O00000Oo.getTop() - getPaddingTop();
        this.f5041O000000o.offsetTopAndBottom(i);
        if (Build.VERSION.SDK_INT < 11) {
            invalidate();
        }
        O00000Oo o00000Oo = this.O0000oo;
        if (o00000Oo != null) {
            o00000Oo.O000000o(this.O00000Oo.getTop());
        }
        Log.d("OffsetTopAndBottom", "===========" + this.O00000Oo.getTop());
    }

    public void setOnContentOffsetListener(O00000Oo o00000Oo) {
        this.O0000oo = o00000Oo;
    }

    /* renamed from: com.mi.global.shop.widget.pulltorefresh.SimplePullToRefreshLayout$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f5048O000000o = new int[State.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f5048O000000o[State.RESET.ordinal()] = 1;
            f5048O000000o[State.PULL_TO_REFRESH.ordinal()] = 2;
            f5048O000000o[State.RELEASE_TO_REFRESH.ordinal()] = 3;
            f5048O000000o[State.REFRESHING.ordinal()] = 4;
            f5048O000000o[State.MANUAL_REFRESHING.ordinal()] = 5;
        }
    }

    /* access modifiers changed from: package-private */
    public final void setState(State state) {
        this.O0000oO = state;
        int i = AnonymousClass7.f5048O000000o[this.O0000oO.ordinal()];
        if (i == 1) {
            this.f5041O000000o.O00000o();
            post(this.O000O0OO);
        } else if (i == 2) {
            LoadingLayout loadingLayout = this.f5041O000000o;
            if (loadingLayout.O00000oO != null) {
                loadingLayout.O00000oO.setText(loadingLayout.O00000oo);
            }
            loadingLayout.O00000Oo.setVisibility(0);
        } else if (i == 3) {
            LoadingLayout loadingLayout2 = this.f5041O000000o;
            if (loadingLayout2.O00000oO != null) {
                loadingLayout2.O00000oO.setText(loadingLayout2.O0000O0o);
            }
        } else if (i == 4 || i == 5) {
            this.f5041O000000o.O00000o0();
            post(this.O000O00o);
        }
    }

    public State getState() {
        return this.O0000oO;
    }

    private boolean O00000Oo() {
        return this.O0000oO == State.REFRESHING || this.O0000oO == State.MANUAL_REFRESHING;
    }

    public final void O000000o() {
        if (O00000Oo()) {
            setState(State.RESET);
        }
    }

    public void setOnRefreshListener(O00000o o00000o) {
        this.O0000Oo0 = o00000o;
    }

    class O000000o implements Animation.AnimationListener {
        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(SimplePullToRefreshLayout simplePullToRefreshLayout, byte b) {
            this();
        }
    }

    public void setTransparentViewHeight(int i) {
        this.O00oOooO = (int) (((float) i) * getContext().getResources().getDisplayMetrics().density);
    }

    public void setOnRefreshEndListener(O00000o0 o00000o0) {
        this.O0000oo0 = o00000o0;
    }

    public void setUsingFestivalStyle(boolean z) {
        this.O0000Ooo = z;
    }

    public void setOnStateChangeListener(O0000O0o o0000O0o) {
        this.O0000oOo = o0000O0o;
    }
}
