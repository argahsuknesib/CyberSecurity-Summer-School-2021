package com.mi.global.shop.widget.ptr;

import _m_j.cce;
import _m_j.ccf;
import _m_j.ccg;
import _m_j.cch;
import _m_j.cck;
import _m_j.ire;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public class PtrFrameLayout extends ViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f5031O000000o = false;
    private static int O0000O0o = 1;
    private static byte O0000OOo = 1;
    private static byte O0000Oo0 = 2;
    protected final String O00000Oo;
    protected int O00000o;
    protected View O00000o0;
    boolean O00000oO;
    public int O00000oo;
    private int O0000Oo;
    private int O0000OoO;
    private float O0000Ooo;
    private View O0000o;
    private int O0000o0;
    private int O0000o00;
    private float O0000o0O;
    private boolean O0000o0o;
    private cce O0000oO;
    private ccg O0000oO0;
    private O000000o O0000oOO;
    private PointF O0000oOo;
    private int O0000oo;
    private int O0000oo0;
    private int O0000ooO;
    private byte O0000ooo;
    private int O000O00o;
    private boolean O000O0OO;
    private boolean O000O0Oo;
    private cch O000O0o;
    private MotionEvent O000O0o0;
    private int O000O0oO;
    private long O000O0oo;
    private MotionEvent O00oOoOo;
    private boolean O00oOooO;
    private boolean O00oOooo;

    public PtrFrameLayout(Context context) {
        this(context, null);
    }

    public PtrFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PtrFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        StringBuilder sb = new StringBuilder("ptr-frame-");
        int i2 = O0000O0o + 1;
        O0000O0o = i2;
        sb.append(i2);
        this.O00000Oo = sb.toString();
        this.O00000o = 0;
        this.O0000Oo = 0;
        this.O0000OoO = 0;
        this.O0000Ooo = 1.7f;
        this.O0000o00 = 200;
        this.O0000o0 = 1000;
        this.O0000o0O = 1.2f;
        this.O0000o0o = true;
        this.O00000oO = false;
        this.O0000oO0 = new ccg();
        this.O0000oOo = new PointF();
        this.O00000oo = 0;
        this.O0000oo0 = 0;
        this.O0000ooo = 1;
        this.O00oOooO = false;
        this.O00oOooo = false;
        this.O000O00o = 0;
        this.O000O0OO = false;
        this.O000O0Oo = false;
        this.O000O0oO = 500;
        this.O000O0oo = 0;
        cck.O000000o(getContext());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.ptr_content, R.attr.ptr_duration_to_close, R.attr.ptr_duration_to_close_header, R.attr.ptr_header, R.attr.ptr_keep_header_when_refresh, R.attr.ptr_pull_to_fresh, R.attr.ptr_ratio_of_header_height_to_refresh, R.attr.ptr_resistance}, 0, 0);
        if (obtainStyledAttributes != null) {
            this.O0000Oo = obtainStyledAttributes.getResourceId(3, this.O0000Oo);
            this.O0000OoO = obtainStyledAttributes.getResourceId(0, this.O0000OoO);
            this.O0000Ooo = obtainStyledAttributes.getFloat(7, this.O0000Ooo);
            this.O0000o00 = obtainStyledAttributes.getInt(1, this.O0000o00);
            this.O0000o0 = obtainStyledAttributes.getInt(2, this.O0000o0);
            this.O0000o0O = obtainStyledAttributes.getFloat(6, this.O0000o0O);
            this.O0000o0o = obtainStyledAttributes.getBoolean(4, this.O0000o0o);
            this.O00000oO = obtainStyledAttributes.getBoolean(5, this.O00000oO);
            obtainStyledAttributes.recycle();
        }
        this.O0000oOO = new O000000o();
        this.O0000oo = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x005c, code lost:
        if (r2 == r0) goto L_0x005e;
     */
    public void onFinishInflate() {
        int childCount = getChildCount();
        if (childCount <= 2) {
            if (childCount == 2) {
                int i = this.O0000Oo;
                if (i != 0 && this.O0000o == null) {
                    this.O0000o = findViewById(i);
                }
                int i2 = this.O0000OoO;
                if (i2 != 0 && this.O00000o0 == null) {
                    this.O00000o0 = findViewById(i2);
                }
                if (this.O00000o0 == null || this.O0000o == null) {
                    View childAt = getChildAt(0);
                    View childAt2 = getChildAt(1);
                    if (childAt instanceof ccf) {
                        this.O0000o = childAt;
                    } else {
                        if (childAt2 instanceof ccf) {
                            this.O0000o = childAt2;
                        } else if (this.O00000o0 == null && this.O0000o == null) {
                            this.O0000o = childAt;
                        } else {
                            View view = this.O0000o;
                            if (view == null) {
                                if (this.O00000o0 == childAt) {
                                    childAt = childAt2;
                                }
                                this.O0000o = childAt;
                            }
                        }
                        this.O00000o0 = childAt;
                    }
                    childAt = childAt2;
                    this.O00000o0 = childAt;
                }
            } else if (childCount == 1) {
                this.O00000o0 = getChildAt(0);
            } else {
                CustomTextView customTextView = new CustomTextView(getContext());
                customTextView.setClickable(true);
                customTextView.setTextColor(-39424);
                customTextView.setGravity(17);
                customTextView.setTextSize(20.0f);
                customTextView.setText("The content view in PtrFrameLayout is empty. Do you forget to specify its id in xml layout file?");
                this.O00000o0 = customTextView;
                addView(this.O00000o0);
            }
            super.onFinishInflate();
            return;
        }
        throw new IllegalStateException("PtrFrameLayout only can host 2 elements");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        View view = this.O0000o;
        if (view != null) {
            measureChildWithMargins(view, i, 0, i2, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.O0000o.getLayoutParams();
            this.O0000ooO = this.O0000o.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            this.O00000o = (int) (((float) this.O0000ooO) * this.O0000o0O);
        }
        View view2 = this.O00000o0;
        if (view2 != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            view2.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin, marginLayoutParams2.width), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + marginLayoutParams2.topMargin, marginLayoutParams2.height));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (r0 != 3) goto L_0x00f7;
     */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        cce cce;
        if (!isEnabled() || this.O00000o0 == null || this.O0000o == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.O000O0o0 = motionEvent;
                    float x = motionEvent.getX() - this.O0000oOo.x;
                    float y = (float) ((int) (motionEvent.getY() - this.O0000oOo.y));
                    this.O0000oOo.set(motionEvent.getX(), motionEvent.getY());
                    if (this.O00oOooo && !this.O000O0OO && (Math.abs(x) > ((float) this.O0000oo) || Math.abs(x) > Math.abs(y) * 3.0f)) {
                        if (this.O00000oo == 0) {
                            this.O000O0OO = true;
                        }
                    }
                    if (this.O000O0OO) {
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    boolean z = y > 0.0f;
                    boolean z2 = !z;
                    boolean z3 = this.O00000oo > 0;
                    if (f5031O000000o) {
                        cce cce2 = this.O0000oO;
                        ire.O000000o(this.O00000Oo, "ACTION_MOVE: offsetY:%s, mCurrentPos: %s, moveUp: %s, canMoveUp: %s, moveDown: %s: canMoveDown: %s", Float.valueOf(y), Integer.valueOf(this.O00000oo), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z), Boolean.valueOf(cce2 != null && cce2.O00000Oo()));
                    }
                    if (z && (cce = this.O0000oO) != null && !cce.O00000Oo()) {
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    if ((z2 && z3) || z) {
                        double d = (double) y;
                        double d2 = (double) this.O0000Ooo;
                        Double.isNaN(d);
                        Double.isNaN(d2);
                        O000000o((float) (d / d2));
                        return true;
                    }
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            this.O00oOooO = false;
            if (this.O00000oo <= 0) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (f5031O000000o) {
                ire.O000000o(this.O00000Oo, "call onRelease when user release");
            }
            O00000Oo(false);
            return true;
        }
        this.O00oOoOo = motionEvent;
        this.O0000oOo.set(motionEvent.getX(), motionEvent.getY());
        this.O0000oOO.O000000o();
        this.O00oOooO = true;
        this.O000O0OO = false;
        if (!this.O000O0Oo || this.O00000oo <= 0) {
            super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public final void O000000o(float f) {
        if (f >= 0.0f || this.O00000oo != 0) {
            int i = ((int) f) + this.O00000oo;
            if (i < 0) {
                if (f5031O000000o) {
                    ire.O00000o0(this.O00000Oo, String.format("over top", new Object[0]));
                }
                i = 0;
            }
            this.O00000oo = i;
            O00000oO();
            this.O0000oo0 = this.O00000oo;
        } else if (f5031O000000o) {
            ire.O00000o0(this.O00000Oo, String.format("has reached the top", new Object[0]));
        }
    }

    private void O00000oO() {
        int i;
        int i2;
        int i3 = this.O00000oo;
        int i4 = this.O0000oo0;
        int i5 = i3 - i4;
        if (i5 != 0) {
            if (i4 == 0 && i3 != 0 && this.O0000oO0.O000000o()) {
                if (this.O0000ooo == 1) {
                    this.O0000ooo = 2;
                    this.O0000oO0.O00000Oo(this);
                    if (f5031O000000o) {
                        ire.O00000o0(this.O00000Oo, "PtrUIHandler: onUIRefreshPrepare, mAutoScrollRefreshTag %s", Integer.valueOf(this.O000O00o));
                    }
                }
                if (this.O00oOooO && this.O000O0Oo) {
                    O0000Oo();
                }
            }
            if (this.O0000oo0 != 0 && this.O00000oo == 0) {
                O0000Oo0();
                if (this.O00oOooO && this.O000O0Oo) {
                    O0000OoO();
                }
            }
            if (this.O0000ooo == 2) {
                if (this.O00oOooO && this.O000O00o == 0 && this.O00000oO && this.O0000oo0 < (i2 = this.O00000o) && this.O00000oo >= i2) {
                    O0000O0o();
                }
                if (this.O000O00o == O0000Oo0 && this.O0000oo0 < (i = this.O0000ooO) && this.O00000oo >= i) {
                    O0000O0o();
                }
            }
            if (f5031O000000o) {
                ire.O000000o(this.O00000Oo, "updatePos: change: %s, current: %s last: %s, top: %s, headerHeight: %s", Integer.valueOf(i5), Integer.valueOf(this.O00000oo), Integer.valueOf(this.O0000oo0), Integer.valueOf(this.O00000o0.getTop()), Integer.valueOf(this.O0000ooO));
            }
            this.O0000o.offsetTopAndBottom(i5);
            this.O00000o0.offsetTopAndBottom(i5);
            invalidate();
            int i6 = this.O0000ooO;
            float f = i6 == 0 ? 0.0f : (((float) this.O0000oo0) * 1.0f) / ((float) i6);
            int i7 = this.O0000ooO;
            float f2 = i7 == 0 ? 0.0f : (((float) this.O00000oo) * 1.0f) / ((float) i7);
            if (this.O0000oO0.O000000o()) {
                this.O0000oO0.O000000o(this, this.O00oOooO, this.O0000ooo, this.O0000oo0, this.O00000oo, f, f2);
            }
        }
    }

    public int getHeaderHeight() {
        return this.O0000ooO;
    }

    private void O00000Oo(boolean z) {
        O0000O0o();
        byte b = this.O0000ooo;
        if (b == 3) {
            if (this.O0000o0o) {
                int i = this.O00000oo;
                int i2 = this.O0000ooO;
                if (i > i2 && !z) {
                    this.O0000oOO.O000000o(i2, this.O0000o00);
                    return;
                }
                return;
            }
            O00000oo();
        } else if (b == 4) {
            O000000o(false);
        } else {
            O00000oo();
        }
    }

    public void setRefreshCompleteHook(cch cch) {
        this.O000O0o = cch;
        cch.f13620O000000o = new Runnable() {
            /* class com.mi.global.shop.widget.ptr.PtrFrameLayout.AnonymousClass1 */

            public final void run() {
                if (PtrFrameLayout.f5031O000000o) {
                    ire.O000000o(PtrFrameLayout.this.O00000Oo, "mRefreshCompleteHook resume.");
                }
                PtrFrameLayout.this.O000000o(true);
            }
        };
    }

    private void O00000oo() {
        if (!this.O00oOooO) {
            this.O0000oOO.O000000o(0, this.O0000o0);
        }
    }

    private boolean O0000O0o() {
        if (this.O0000ooo != 2) {
            return false;
        }
        if ((this.O00000oo >= this.O0000ooO && this.O000O00o > 0) || this.O00000oo >= this.O00000o) {
            this.O0000ooo = 3;
            O0000OOo();
        }
        return false;
    }

    private void O0000OOo() {
        this.O000O0oo = System.currentTimeMillis();
        if (this.O0000oO0.O000000o()) {
            this.O0000oO0.O00000o0(this);
            if (f5031O000000o) {
                ire.O00000Oo(this.O00000Oo, "PtrUIHandler: onUIRefreshBegin");
            }
        }
        cce cce = this.O0000oO;
        if (cce != null) {
            cce.O000000o();
        }
    }

    private boolean O0000Oo0() {
        byte b = this.O0000ooo;
        if ((b != 4 && b != 2) || this.O00000oo != 0) {
            return false;
        }
        if (this.O0000oO0.O000000o()) {
            this.O0000oO0.O000000o(this);
            if (f5031O000000o) {
                ire.O00000Oo(this.O00000Oo, "PtrUIHandler: onUIReset");
            }
        }
        this.O0000ooo = 1;
        this.O000O00o = 0;
        return true;
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        if (this.O00000oo > 0 && this.O000O00o > 0) {
            if (f5031O000000o) {
                ire.O000000o(this.O00000Oo, "call onRelease after scroll abort");
            }
            O00000Oo(true);
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        if (this.O00000oo > 0 && this.O000O00o > 0) {
            if (f5031O000000o) {
                ire.O000000o(this.O00000Oo, "call onRelease after scroll finish");
            }
            O00000Oo(true);
        }
    }

    public final void O00000o0() {
        if (f5031O000000o) {
            ire.O00000Oo(this.O00000Oo, "refreshComplete");
        }
        cch cch = this.O000O0o;
        if (cch != null) {
            cch.O00000Oo = 0;
        }
        int currentTimeMillis = (int) (((long) this.O000O0oO) - (System.currentTimeMillis() - this.O000O0oo));
        if (currentTimeMillis <= 0) {
            if (f5031O000000o) {
                ire.O000000o(this.O00000Oo, "performRefreshComplete at once");
            }
            O00000o();
            return;
        }
        postDelayed(new Runnable() {
            /* class com.mi.global.shop.widget.ptr.PtrFrameLayout.AnonymousClass2 */

            public final void run() {
                PtrFrameLayout.this.O00000o();
            }
        }, (long) currentTimeMillis);
        if (f5031O000000o) {
            ire.O00000Oo(this.O00000Oo, "performRefreshComplete after delay: %s", Integer.valueOf(currentTimeMillis));
        }
    }

    public final void O00000o() {
        this.O0000ooo = 4;
        if (!this.O0000oOO.f5034O000000o || this.O000O00o <= 0) {
            O000000o(false);
        } else if (f5031O000000o) {
            ire.O00000Oo(this.O00000Oo, "performRefreshComplete do nothing, scrolling: %s, auto refresh: %s", Boolean.valueOf(this.O0000oOO.f5034O000000o), Integer.valueOf(this.O000O00o));
        }
    }

    public final void O000000o(boolean z) {
        if (this.O00000oo == 0 || z || this.O000O0o == null) {
            if (this.O0000oO0.O000000o()) {
                if (f5031O000000o) {
                    ire.O00000Oo(this.O00000Oo, "PtrUIHandler: onUIRefreshComplete");
                }
                this.O0000oO0.O00000o(this);
            }
            O00000oo();
            O0000Oo0();
            return;
        }
        if (f5031O000000o) {
            ire.O000000o(this.O00000Oo, "notifyUIRefreshComplete mRefreshCompleteHook run.");
        }
        this.O000O0o.O000000o();
    }

    public void setLoadingMinTime(int i) {
        this.O000O0oO = i;
    }

    public void setInterceptEventWhileWorking(boolean z) {
        this.O000O0Oo = z;
    }

    public View getContentView() {
        return this.O00000o0;
    }

    public void setPtrHandler(cce cce) {
        this.O0000oO = cce;
    }

    public final void O000000o(ccf ccf) {
        ccg.O000000o(this.O0000oO0, ccf);
    }

    public float getResistance() {
        return this.O0000Ooo;
    }

    public void setResistance(float f) {
        this.O0000Ooo = f;
    }

    public float getDurationToClose() {
        return (float) this.O0000o00;
    }

    public void setDurationToClose(int i) {
        this.O0000o00 = i;
    }

    public long getDurationToCloseHeader() {
        return (long) this.O0000o0;
    }

    public void setDurationToCloseHeader(int i) {
        this.O0000o0 = i;
    }

    public void setRatioOfHeaderHeightToRefresh(float f) {
        this.O0000o0O = f;
        this.O00000o = (int) (((float) this.O0000ooO) * this.O0000o0O);
    }

    public int getOffsetToRefresh() {
        return this.O00000o;
    }

    public void setOffsetToRefresh(int i) {
        this.O00000o = i;
    }

    public float getRatioOfHeaderToHeightRefresh() {
        return this.O0000o0O;
    }

    public void setKeepHeaderWhenRefresh(boolean z) {
        this.O0000o0o = z;
    }

    public void setPullToRefresh(boolean z) {
        this.O00000oO = z;
    }

    public View getHeaderView() {
        return this.O0000o;
    }

    public void setHeaderView(View view) {
        View view2 = this.O0000o;
        if (!(view2 == null || view == null || view2 == view)) {
            removeView(view2);
        }
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new LayoutParams(-2));
        }
        this.O0000o = view;
        addView(view);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    private void O0000Oo() {
        if (f5031O000000o) {
            ire.O000000o(this.O00000Oo, "send cancel event");
        }
        super.dispatchTouchEvent(MotionEvent.obtain(this.O00oOoOo.getDownTime(), this.O00oOoOo.getEventTime() + ((long) ViewConfiguration.getLongPressTimeout()), 3, this.O00oOoOo.getX(), this.O00oOoOo.getY(), this.O00oOoOo.getMetaState()));
    }

    private void O0000OoO() {
        if (f5031O000000o) {
            ire.O000000o(this.O00000Oo, "send down event");
        }
        MotionEvent motionEvent = this.O000O0o0;
        super.dispatchTouchEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 0, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState()));
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i) {
            super(-1, i);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f5034O000000o = false;
        private Scroller O00000o;
        private int O00000o0;
        private int O00000oO;
        private int O00000oo;

        public O000000o() {
            this.O00000o = new Scroller(PtrFrameLayout.this.getContext());
        }

        public final void run() {
            boolean z = !this.O00000o.computeScrollOffset() || this.O00000o.isFinished();
            int currY = this.O00000o.getCurrY();
            int i = currY - this.O00000o0;
            if (PtrFrameLayout.f5031O000000o && i != 0) {
                ire.O000000o(PtrFrameLayout.this.O00000Oo, "scroll: %s, start: %s, to: %s, mCurrentPos: %s, current :%s, last: %s, delta: %s", Boolean.valueOf(z), Integer.valueOf(this.O00000oO), Integer.valueOf(this.O00000oo), Integer.valueOf(PtrFrameLayout.this.O00000oo), Integer.valueOf(currY), Integer.valueOf(this.O00000o0), Integer.valueOf(i));
            }
            if (!z) {
                this.O00000o0 = currY;
                PtrFrameLayout.this.O000000o((float) i);
                PtrFrameLayout.this.post(this);
                return;
            }
            if (PtrFrameLayout.f5031O000000o) {
                ire.O000000o(PtrFrameLayout.this.O00000Oo, "finish, mCurrentPos:%s", Integer.valueOf(PtrFrameLayout.this.O00000oo));
            }
            O00000Oo();
            PtrFrameLayout.this.O00000Oo();
        }

        private void O00000Oo() {
            this.f5034O000000o = false;
            this.O00000o0 = 0;
            PtrFrameLayout.this.removeCallbacks(this);
        }

        public final void O000000o() {
            if (this.f5034O000000o) {
                if (!this.O00000o.isFinished()) {
                    this.O00000o.forceFinished(true);
                }
                PtrFrameLayout.this.O000000o();
                O00000Oo();
            }
        }

        public final void O000000o(int i, int i2) {
            if (PtrFrameLayout.this.O00000oo != i) {
                this.O00000oO = PtrFrameLayout.this.O00000oo;
                this.O00000oo = i;
                int i3 = i - this.O00000oO;
                if (PtrFrameLayout.f5031O000000o) {
                    ire.O00000Oo(PtrFrameLayout.this.O00000Oo, "tryToScrollTo: start: %s, distance:%s, to:%s", Integer.valueOf(this.O00000oO), Integer.valueOf(i3), Integer.valueOf(i));
                }
                PtrFrameLayout.this.removeCallbacks(this);
                this.O00000o0 = 0;
                this.O00000o = new Scroller(PtrFrameLayout.this.getContext());
                this.O00000o.startScroll(0, 0, 0, i3, i2);
                PtrFrameLayout.this.post(this);
                this.f5034O000000o = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = this.O00000oo;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        View view = this.O0000o;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int i6 = marginLayoutParams.leftMargin + paddingLeft;
            int i7 = ((marginLayoutParams.topMargin + paddingTop) + i5) - this.O0000ooO;
            this.O0000o.layout(i6, i7, this.O0000o.getMeasuredWidth() + i6, this.O0000o.getMeasuredHeight() + i7);
        }
        View view2 = this.O00000o0;
        if (view2 != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            int i8 = paddingLeft + marginLayoutParams2.leftMargin;
            int i9 = paddingTop + marginLayoutParams2.topMargin + i5;
            this.O00000o0.layout(i8, i9, this.O00000o0.getMeasuredWidth() + i8, this.O00000o0.getMeasuredHeight() + i9);
        }
    }
}
