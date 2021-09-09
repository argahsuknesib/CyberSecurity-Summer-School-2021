package com.xiaomi.smarthome.library.common.widget.drawerlayout;

import _m_j.ab;
import _m_j.bh;
import _m_j.bk;
import _m_j.cb;
import _m_j.cl;
import _m_j.grb;
import _m_j.grc;
import _m_j.grd;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup implements grc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final int[] f9312O000000o = {16842931};
    public static final boolean O00000Oo = (Build.VERSION.SDK_INT >= 19);
    static final O00000o0 O0000Oo;
    private static final boolean O0000OoO;
    final grd O00000o;
    final grd O00000o0;
    int O00000oO;
    boolean O00000oo;
    List<O0000OOo> O0000O0o;
    CharSequence O0000OOo;
    CharSequence O0000Oo0;
    private final O00000Oo O0000Ooo;
    private Paint O0000o;
    private int O0000o0;
    private float O0000o00;
    private int O0000o0O;
    private float O0000o0o;
    private final O0000Oo0 O0000oO;
    private final O0000Oo0 O0000oO0;
    private boolean O0000oOO;
    private boolean O0000oOo;
    private int O0000oo;
    private int O0000oo0;
    private int O0000ooO;
    private int O0000ooo;
    private float O000O00o;
    private float O000O0OO;
    private Drawable O000O0Oo;
    private Object O000O0o;
    private Drawable O000O0o0;
    private boolean O000O0oO;
    private Drawable O000O0oo;
    private Drawable O000OO;
    private Drawable O000OO00;
    private Drawable O000OO0o;
    private final ArrayList<View> O000OOOo;
    private Drawable O00oOoOo;
    private boolean O00oOooO;
    @Deprecated
    private O0000OOo O00oOooo;

    interface O00000o0 {
        int O000000o(Object obj);

        Drawable O000000o(Context context);

        void O000000o(View view);

        void O000000o(View view, Object obj, int i);

        void O000000o(ViewGroup.MarginLayoutParams marginLayoutParams, Object obj, int i);
    }

    public interface O0000OOo {
    }

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 21) {
            z = false;
        }
        O0000OoO = z;
        if (Build.VERSION.SDK_INT >= 21) {
            O0000Oo = new O00000o();
        } else {
            O0000Oo = new O0000O0o();
        }
    }

    private Paint getScrimPaint() {
        if (this.O0000o == null) {
            this.O0000o = new Paint();
        }
        return this.O0000o;
    }

    static class O0000O0o implements O00000o0 {
        public final int O000000o(Object obj) {
            return 0;
        }

        public final Drawable O000000o(Context context) {
            return null;
        }

        public final void O000000o(View view) {
        }

        public final void O000000o(View view, Object obj, int i) {
        }

        public final void O000000o(ViewGroup.MarginLayoutParams marginLayoutParams, Object obj, int i) {
        }

        O0000O0o() {
        }
    }

    static class O00000o implements O00000o0 {
        O00000o() {
        }

        public final void O000000o(View view) {
            grb.O000000o(view);
        }

        public final void O000000o(View view, Object obj, int i) {
            grb.O000000o(view, obj, i);
        }

        public final void O000000o(ViewGroup.MarginLayoutParams marginLayoutParams, Object obj, int i) {
            grb.O000000o(marginLayoutParams, obj, i);
        }

        public final int O000000o(Object obj) {
            return grb.O000000o(obj);
        }

        public final Drawable O000000o(Context context) {
            return grb.O000000o(context);
        }
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000oO(android.view.View, int):void
     arg types: [com.xiaomi.smarthome.library.common.widget.drawerlayout.DrawerLayout, int]
     candidates:
      _m_j.cb.O00000oO(android.view.View, float):void
      _m_j.cb.O00000oO(android.view.View, int):void */
    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000Ooo = new O00000Oo();
        this.O0000o0O = -1728053248;
        this.O0000oOo = true;
        this.O0000oo0 = 3;
        this.O0000oo = 3;
        this.O0000ooO = 3;
        this.O0000ooo = 3;
        this.O000O0oo = null;
        this.O000OO00 = null;
        this.O000OO0o = null;
        this.O000OO = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.O0000o0 = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.O0000oO0 = new O0000Oo0(3);
        this.O0000oO = new O0000Oo0(5);
        this.O00000o0 = grd.O000000o(this, this.O0000oO0);
        grd grd = this.O00000o0;
        grd.O0000Ooo = 1;
        grd.O0000Oo = f2;
        this.O0000oO0.O00000Oo = grd;
        this.O00000o = grd.O000000o(this, this.O0000oO);
        grd grd2 = this.O00000o;
        grd2.O0000Ooo = 2;
        grd2.O0000Oo = f2;
        this.O0000oO.O00000Oo = grd2;
        setFocusableInTouchMode(true);
        cb.O00000oO((View) this, 1);
        cb.O000000o(this, new O000000o());
        setMotionEventSplittingEnabled(false);
        if (cb.O0000ooo(this)) {
            O0000Oo.O000000o((View) this);
            this.O000O0Oo = O0000Oo.O000000o(context);
        }
        this.O0000o00 = f * 10.0f;
        this.O000OOOo = new ArrayList<>();
    }

    public void setDrawerElevation(float f) {
        this.O0000o00 = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (O00000o(childAt)) {
                cb.O0000Oo(childAt, this.O0000o00);
            }
        }
    }

    public float getDrawerElevation() {
        if (O0000OoO) {
            return this.O0000o00;
        }
        return 0.0f;
    }

    public final void O000000o(Object obj, boolean z) {
        this.O000O0o = obj;
        this.O000O0oO = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void setScrimColor(int i) {
        this.O0000o0O = i;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(O0000OOo o0000OOo) {
        List<O0000OOo> list;
        O0000OOo o0000OOo2 = this.O00oOooo;
        if (!(o0000OOo2 == null || o0000OOo2 == null || (list = this.O0000O0o) == null)) {
            list.remove(o0000OOo2);
        }
        if (!(o0000OOo == null || o0000OOo == null)) {
            if (this.O0000O0o == null) {
                this.O0000O0o = new ArrayList();
            }
            this.O0000O0o.add(o0000OOo);
        }
        this.O00oOooo = o0000OOo;
    }

    public void setDrawerLockMode(int i) {
        O000000o(i, 3);
        O000000o(i, 5);
    }

    private void O000000o(int i, int i2) {
        View O000000o2;
        int O000000o3 = bk.O000000o(i2, cb.O0000Oo0(this));
        if (i2 == 3) {
            this.O0000oo0 = i;
        } else if (i2 == 5) {
            this.O0000oo = i;
        } else if (i2 == 8388611) {
            this.O0000ooO = i;
        } else if (i2 == 8388613) {
            this.O0000ooo = i;
        }
        if (i != 0) {
            (O000000o3 == 3 ? this.O00000o0 : this.O00000o).O000000o();
        }
        if (i == 1) {
            View O000000o4 = O000000o(O000000o3);
            if (O000000o4 != null) {
                O00000oO(O000000o4);
            }
        } else if (i == 2 && (O000000o2 = O000000o(O000000o3)) != null) {
            O0000OOo(O000000o2);
        }
    }

    public final int O000000o(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        if (O00000o(view)) {
            int i5 = ((LayoutParams) view.getLayoutParams()).f9313O000000o;
            int O0000Oo02 = cb.O0000Oo0(this);
            if (i5 == 3) {
                int i6 = this.O0000oo0;
                if (i6 != 3) {
                    return i6;
                }
                if (O0000Oo02 == 0) {
                    i = this.O0000ooO;
                } else {
                    i = this.O0000ooo;
                }
                if (i != 3) {
                    return i;
                }
                return 0;
            } else if (i5 == 5) {
                int i7 = this.O0000oo;
                if (i7 != 3) {
                    return i7;
                }
                if (O0000Oo02 == 0) {
                    i2 = this.O0000ooo;
                } else {
                    i2 = this.O0000ooO;
                }
                if (i2 != 3) {
                    return i2;
                }
                return 0;
            } else if (i5 == 8388611) {
                int i8 = this.O0000ooO;
                if (i8 != 3) {
                    return i8;
                }
                if (O0000Oo02 == 0) {
                    i3 = this.O0000oo0;
                } else {
                    i3 = this.O0000oo;
                }
                if (i3 != 3) {
                    return i3;
                }
                return 0;
            } else if (i5 != 8388613) {
                return 0;
            } else {
                int i9 = this.O0000ooo;
                if (i9 != 3) {
                    return i9;
                }
                if (O0000Oo02 == 0) {
                    i4 = this.O0000oo;
                } else {
                    i4 = this.O0000oo0;
                }
                if (i4 != 3) {
                    return i4;
                }
                return 0;
            }
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || O00000o(childAt)) && (!z || childAt != view)) {
                cb.O00000oO(childAt, 4);
            } else {
                cb.O00000oO(childAt, 1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.O00000Oo) {
            layoutParams.O00000Oo = f;
            List<O0000OOo> list = this.O0000O0o;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.O0000O0o.get(size);
                }
            }
        }
    }

    static float O00000Oo(View view) {
        return ((LayoutParams) view.getLayoutParams()).O00000Oo;
    }

    /* access modifiers changed from: package-private */
    public final int O00000o0(View view) {
        return bk.O000000o(((LayoutParams) view.getLayoutParams()).f9313O000000o, cb.O0000Oo0(this));
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(View view, int i) {
        return (O00000o0(view) & i) == i;
    }

    private View O00000Oo() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).O00000o & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final View O000000o(int i) {
        int O000000o2 = bk.O000000o(i, cb.O0000Oo0(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((O00000o0(childAt) & 7) == O000000o2) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.O0000oOo = true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.O0000oOo = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        String str;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
                if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        boolean z = this.O000O0o != null && cb.O0000ooo(this);
        int O0000Oo02 = cb.O0000Oo0(this);
        int childCount = getChildCount();
        boolean z2 = false;
        boolean z3 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z) {
                    int O000000o2 = bk.O000000o(layoutParams.f9313O000000o, O0000Oo02);
                    if (cb.O0000ooo(childAt)) {
                        O0000Oo.O000000o(childAt, this.O000O0o, O000000o2);
                    } else {
                        O0000Oo.O000000o(layoutParams, this.O000O0o, O000000o2);
                    }
                }
                if (O0000O0o(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - layoutParams.leftMargin) - layoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - layoutParams.topMargin) - layoutParams.bottomMargin, 1073741824));
                } else if (O00000o(childAt)) {
                    if (O0000OoO) {
                        float O0000oOO2 = cb.O0000oOO(childAt);
                        float f = this.O0000o00;
                        if (O0000oOO2 != f) {
                            cb.O0000Oo(childAt, f);
                        }
                    }
                    int O00000o02 = O00000o0(childAt) & 7;
                    boolean z4 = O00000o02 == 3;
                    if ((!z4 || !z2) && (z4 || !z3)) {
                        if (z4) {
                            z2 = true;
                        } else {
                            z3 = true;
                        }
                        childAt.measure(getChildMeasureSpec(i, this.O0000o0 + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), getChildMeasureSpec(i2, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
                    } else {
                        StringBuilder sb = new StringBuilder("Child drawer has absolute gravity ");
                        if ((O00000o02 & 3) != 3) {
                            str = (O00000o02 & 5) == 5 ? "RIGHT" : Integer.toHexString(O00000o02);
                        } else {
                            str = "LEFT";
                        }
                        sb.append(str);
                        sb.append(" but this DrawerLayout already has a drawer view along that edge");
                        throw new IllegalStateException(sb.toString());
                    }
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
        }
    }

    private static boolean O000000o(Drawable drawable, int i) {
        if (drawable == null || !ab.O000000o(drawable)) {
            return false;
        }
        ab.O00000Oo(drawable, i);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        this.O0000oOO = true;
        int i6 = i3 - i;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (O0000O0o(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (O000000o(childAt, 3)) {
                        float f2 = (float) measuredWidth;
                        i5 = (-measuredWidth) + ((int) (layoutParams.O00000Oo * f2));
                        f = ((float) (measuredWidth + i5)) / f2;
                    } else {
                        float f3 = (float) measuredWidth;
                        int i8 = i6 - ((int) (layoutParams.O00000Oo * f3));
                        f = ((float) (i6 - i8)) / f3;
                        i5 = i8;
                    }
                    boolean z2 = f != layoutParams.O00000Oo;
                    int i9 = layoutParams.f9313O000000o & 112;
                    if (i9 == 16) {
                        int i10 = i4 - i2;
                        int i11 = (i10 - measuredHeight) / 2;
                        if (i11 < layoutParams.topMargin) {
                            i11 = layoutParams.topMargin;
                        } else if (i11 + measuredHeight > i10 - layoutParams.bottomMargin) {
                            i11 = (i10 - layoutParams.bottomMargin) - measuredHeight;
                        }
                        childAt.layout(i5, i11, measuredWidth + i5, measuredHeight + i11);
                    } else if (i9 != 80) {
                        childAt.layout(i5, layoutParams.topMargin, measuredWidth + i5, layoutParams.topMargin + measuredHeight);
                    } else {
                        int i12 = i4 - i2;
                        childAt.layout(i5, (i12 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i12 - layoutParams.bottomMargin);
                    }
                    if (z2) {
                        O000000o(childAt, f);
                    }
                    int i13 = layoutParams.O00000Oo > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i13) {
                        childAt.setVisibility(i13);
                    }
                }
            }
        }
        this.O0000oOO = false;
        this.O0000oOo = false;
    }

    public void requestLayout() {
        if (!this.O0000oOO) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).O00000Oo);
        }
        this.O0000o0o = f;
        if (this.O00000o0.O00000Oo() || this.O00000o.O00000Oo()) {
            cb.O00000oo(this);
        }
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.O000O0Oo = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.O000O0Oo;
    }

    public void setStatusBarBackground(int i) {
        this.O000O0Oo = i != 0 ? ContextCompat.O000000o(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.O000O0Oo = new ColorDrawable(i);
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        int O000000o2;
        super.onDraw(canvas);
        if (this.O000O0oO && this.O000O0Oo != null && (O000000o2 = O0000Oo.O000000o(this.O000O0o)) > 0) {
            this.O000O0Oo.setBounds(0, 0, getWidth(), O000000o2);
            this.O000O0Oo.draw(canvas);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        Canvas canvas2 = canvas;
        View view2 = view;
        int height = getHeight();
        boolean O0000O0o2 = O0000O0o(view);
        int width = getWidth();
        int save = canvas.save();
        int i2 = 0;
        if (O0000O0o2) {
            int childCount = getChildCount();
            i = width;
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != view2 && childAt.getVisibility() == 0) {
                    Drawable background = childAt.getBackground();
                    if ((background != null && background.getOpacity() == -1) && O00000o(childAt) && childAt.getHeight() >= height) {
                        if (O000000o(childAt, 3)) {
                            int right = childAt.getRight();
                            if (right > i3) {
                                i3 = right;
                            }
                        } else {
                            int left = childAt.getLeft();
                            if (left < i) {
                                i = left;
                            }
                        }
                    }
                }
            }
            canvas2.clipRect(i3, 0, i, getHeight());
            i2 = i3;
        } else {
            i = width;
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas2.restoreToCount(save);
        float f = this.O0000o0o;
        if (f > 0.0f && O0000O0o2) {
            int i5 = this.O0000o0O;
            getScrimPaint().setColor((i5 & 16777215) | (((int) (((float) ((-16777216 & i5) >>> 24)) * f)) << 24));
            canvas.drawRect((float) i2, 0.0f, (float) i, (float) getHeight(), getScrimPaint());
        } else if (this.O00oOoOo != null && O000000o(view2, 3)) {
            int intrinsicWidth = this.O00oOoOo.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(((float) right2) / ((float) this.O00000o0.O0000OoO), 1.0f));
            this.O00oOoOo.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.O00oOoOo.setAlpha((int) (max * 255.0f));
            this.O00oOoOo.draw(canvas2);
        } else if (this.O000O0o0 != null && O000000o(view2, 5)) {
            int intrinsicWidth2 = this.O000O0o0.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min(((float) (getWidth() - left2)) / ((float) this.O00000o.O0000OoO), 1.0f));
            this.O000O0o0.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.O000O0o0.setAlpha((int) (max2 * 255.0f));
            this.O000O0o0.draw(canvas2);
        }
        return drawChild;
    }

    private static boolean O0000O0o(View view) {
        return ((LayoutParams) view.getLayoutParams()).f9313O000000o == 0;
    }

    static boolean O00000o(View view) {
        int O000000o2 = bk.O000000o(((LayoutParams) view.getLayoutParams()).f9313O000000o, cb.O0000Oo0(view));
        return ((O000000o2 & 3) == 0 && (O000000o2 & 5) == 0) ? false : true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View O00000Oo2;
        this.O00000o0.O00000Oo(motionEvent);
        this.O00000o.O00000Oo(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.O000O00o = x;
            this.O000O0OO = y;
            this.O00oOooO = false;
            this.O00000oo = false;
        } else if (action == 1) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            View O000000o2 = this.O00000o0.O000000o((int) x2, (int) y2);
            if (O000000o2 != null && O0000O0o(O000000o2)) {
                float f = x2 - this.O000O00o;
                float f2 = y2 - this.O000O0OO;
                int i = this.O00000o0.O00000Oo;
                if (!((f * f) + (f2 * f2) >= ((float) (i * i)) || (O00000Oo2 = O00000Oo()) == null || O000000o(O00000Oo2) == 2)) {
                    z = false;
                    O000000o(z);
                    this.O00oOooO = false;
                }
            }
            z = true;
            O000000o(z);
            this.O00oOooO = false;
        } else if (action == 3) {
            O000000o(true);
            this.O00oOooO = false;
            this.O00000oo = false;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.O00oOooO = z;
        if (z) {
            O000000o(true);
        }
    }

    private void O000000o(boolean z) {
        boolean z2;
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (O00000o(childAt) && (!z || layoutParams.O00000o0)) {
                int width = childAt.getWidth();
                if (O000000o(childAt, 3)) {
                    z2 = this.O00000o0.O000000o(childAt, -width, childAt.getTop());
                } else {
                    z2 = this.O00000o.O000000o(childAt, getWidth(), childAt.getTop());
                }
                z3 |= z2;
                layoutParams.O00000o0 = false;
            }
        }
        this.O0000oO0.O000000o();
        this.O0000oO.O000000o();
        if (z3) {
            invalidate();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.library.common.widget.drawerlayout.DrawerLayout.O000000o(android.view.View, boolean):void
     arg types: [android.view.View, int]
     candidates:
      com.xiaomi.smarthome.library.common.widget.drawerlayout.DrawerLayout.O000000o(int, int):void
      com.xiaomi.smarthome.library.common.widget.drawerlayout.DrawerLayout.O000000o(android.graphics.drawable.Drawable, int):boolean
      com.xiaomi.smarthome.library.common.widget.drawerlayout.DrawerLayout.O000000o(android.view.View, float):void
      com.xiaomi.smarthome.library.common.widget.drawerlayout.DrawerLayout.O000000o(java.lang.Object, boolean):void
      com.xiaomi.smarthome.library.common.widget.drawerlayout.DrawerLayout.O000000o(android.view.View, int):boolean
      _m_j.grc.O000000o(java.lang.Object, boolean):void
      com.xiaomi.smarthome.library.common.widget.drawerlayout.DrawerLayout.O000000o(android.view.View, boolean):void */
    private void O0000OOo(View view) {
        if (O00000o(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.O0000oOo) {
                layoutParams.O00000Oo = 1.0f;
                layoutParams.O00000o = 1;
                O000000o(view, true);
            } else {
                layoutParams.O00000o |= 2;
                if (O000000o(view, 3)) {
                    this.O00000o0.O000000o(view, 0, view.getTop());
                } else {
                    this.O00000o.O000000o(view, getWidth() - view.getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public final void O00000oO(View view) {
        if (O00000o(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.O0000oOo) {
                layoutParams.O00000Oo = 0.0f;
                layoutParams.O00000o = 0;
            } else {
                layoutParams.O00000o |= 4;
                if (O000000o(view, 3)) {
                    this.O00000o0.O000000o(view, -view.getWidth(), view.getTop());
                } else {
                    this.O00000o.O000000o(view, getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z = false;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (!O00000o(childAt)) {
                    this.O000OOOo.add(childAt);
                } else if (O00000o(childAt)) {
                    if ((((LayoutParams) childAt.getLayoutParams()).O00000o & 1) == 1) {
                        childAt.addFocusables(arrayList, i, i2);
                        z = true;
                    }
                } else {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
            }
            if (!z) {
                int size = this.O000OOOo.size();
                for (int i4 = 0; i4 < size; i4++) {
                    View view = this.O000OOOo.get(i4);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                }
            }
            this.O000OOOo.clear();
        }
    }

    public final View O000000o() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (O00000o(childAt)) {
                if (O00000o(childAt)) {
                    if (((LayoutParams) childAt.getLayoutParams()).O00000Oo > 0.0f) {
                        return childAt;
                    }
                } else {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
            }
        }
        return null;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View O000000o2 = O000000o();
        if (O000000o2 != null && O000000o(O000000o2) == 0) {
            O000000o(false);
        }
        if (O000000o2 != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        View O000000o2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!(savedState.f9318O000000o == 0 || (O000000o2 = O000000o(savedState.f9318O000000o)) == null)) {
            O0000OOo(O000000o2);
        }
        if (savedState.O00000Oo != 3) {
            O000000o(savedState.O00000Oo, 3);
        }
        if (savedState.O00000o0 != 3) {
            O000000o(savedState.O00000o0, 5);
        }
        if (savedState.O00000o != 3) {
            O000000o(savedState.O00000o, 8388611);
        }
        if (savedState.O00000oO != 3) {
            O000000o(savedState.O00000oO, 8388613);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            boolean z = true;
            boolean z2 = layoutParams.O00000o == 1;
            if (layoutParams.O00000o != 2) {
                z = false;
            }
            if (z2 || z) {
                savedState.f9318O000000o = layoutParams.f9313O000000o;
            } else {
                i++;
            }
        }
        savedState.O00000Oo = this.O0000oo0;
        savedState.O00000o0 = this.O0000oo;
        savedState.O00000o = this.O0000ooO;
        savedState.O00000oO = this.O0000ooo;
        return savedState;
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (O00000Oo() != null || O00000o(view)) {
            cb.O00000oO(view, 4);
        } else {
            cb.O00000oO(view, 1);
        }
        if (!O00000Oo) {
            cb.O000000o(view, this.O0000Ooo);
        }
    }

    public static boolean O00000oo(View view) {
        return (cb.O0000O0o(view) == 4 || cb.O0000O0o(view) == 2) ? false : true;
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.xiaomi.smarthome.library.common.widget.drawerlayout.DrawerLayout.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        int f9318O000000o = 0;
        int O00000Oo;
        int O00000o;
        int O00000o0;
        int O00000oO;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f9318O000000o = parcel.readInt();
            this.O00000Oo = parcel.readInt();
            this.O00000o0 = parcel.readInt();
            this.O00000o = parcel.readInt();
            this.O00000oO = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f9318O000000o);
            parcel.writeInt(this.O00000Oo);
            parcel.writeInt(this.O00000o0);
            parcel.writeInt(this.O00000o);
            parcel.writeInt(this.O00000oO);
        }
    }

    class O0000Oo0 extends grd.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final int f9316O000000o;
        grd O00000Oo;
        private final Runnable O00000o = new Runnable() {
            /* class com.xiaomi.smarthome.library.common.widget.drawerlayout.DrawerLayout.O0000Oo0.AnonymousClass1 */

            public final void run() {
                int i;
                View view;
                O0000Oo0 o0000Oo0 = O0000Oo0.this;
                int i2 = o0000Oo0.O00000Oo.O0000OoO;
                boolean z = o0000Oo0.f9316O000000o == 3;
                if (z) {
                    view = DrawerLayout.this.O000000o(3);
                    i = (view != null ? -view.getWidth() : 0) + i2;
                } else {
                    view = DrawerLayout.this.O000000o(5);
                    i = DrawerLayout.this.getWidth() - i2;
                }
                if (view == null) {
                    return;
                }
                if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && DrawerLayout.this.O000000o(view) == 0) {
                    o0000Oo0.O00000Oo.O000000o(view, i, view.getTop());
                    ((LayoutParams) view.getLayoutParams()).O00000o0 = true;
                    DrawerLayout.this.invalidate();
                    o0000Oo0.O00000Oo();
                    DrawerLayout drawerLayout = DrawerLayout.this;
                    if (!drawerLayout.O00000oo) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        int childCount = drawerLayout.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            drawerLayout.getChildAt(i3).dispatchTouchEvent(obtain);
                        }
                        obtain.recycle();
                        drawerLayout.O00000oo = true;
                    }
                }
            }
        };

        public O0000Oo0(int i) {
            this.f9316O000000o = i;
        }

        public final void O000000o() {
            DrawerLayout.this.removeCallbacks(this.O00000o);
        }

        public final boolean O000000o(View view) {
            return DrawerLayout.O00000o(view) && DrawerLayout.this.O000000o(view, this.f9316O000000o) && DrawerLayout.this.O000000o(view) == 0;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.smarthome.library.common.widget.drawerlayout.DrawerLayout.O000000o(android.view.View, boolean):void
         arg types: [android.view.View, int]
         candidates:
          com.xiaomi.smarthome.library.common.widget.drawerlayout.DrawerLayout.O000000o(int, int):void
          com.xiaomi.smarthome.library.common.widget.drawerlayout.DrawerLayout.O000000o(android.graphics.drawable.Drawable, int):boolean
          com.xiaomi.smarthome.library.common.widget.drawerlayout.DrawerLayout.O000000o(android.view.View, float):void
          com.xiaomi.smarthome.library.common.widget.drawerlayout.DrawerLayout.O000000o(java.lang.Object, boolean):void
          com.xiaomi.smarthome.library.common.widget.drawerlayout.DrawerLayout.O000000o(android.view.View, int):boolean
          _m_j.grc.O000000o(java.lang.Object, boolean):void
          com.xiaomi.smarthome.library.common.widget.drawerlayout.DrawerLayout.O000000o(android.view.View, boolean):void */
        public final void O000000o(int i) {
            View rootView;
            DrawerLayout drawerLayout = DrawerLayout.this;
            View view = this.O00000Oo.O0000o00;
            int i2 = drawerLayout.O00000o0.f18176O000000o;
            int i3 = drawerLayout.O00000o.f18176O000000o;
            int i4 = 2;
            if (i2 == 1 || i3 == 1) {
                i4 = 1;
            } else if (!(i2 == 2 || i3 == 2)) {
                i4 = 0;
            }
            if (view != null && i == 0) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams.O00000Oo == 0.0f) {
                    LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                    if ((layoutParams2.O00000o & 1) == 1) {
                        layoutParams2.O00000o = 0;
                        if (drawerLayout.O0000O0o != null) {
                            for (int size = drawerLayout.O0000O0o.size() - 1; size >= 0; size--) {
                                drawerLayout.O0000O0o.get(size);
                            }
                        }
                        drawerLayout.O000000o(view, false);
                        if (drawerLayout.hasWindowFocus() && (rootView = drawerLayout.getRootView()) != null) {
                            rootView.sendAccessibilityEvent(32);
                        }
                    }
                } else if (layoutParams.O00000Oo == 1.0f) {
                    LayoutParams layoutParams3 = (LayoutParams) view.getLayoutParams();
                    if ((layoutParams3.O00000o & 1) == 0) {
                        layoutParams3.O00000o = 1;
                        if (drawerLayout.O0000O0o != null) {
                            for (int size2 = drawerLayout.O0000O0o.size() - 1; size2 >= 0; size2--) {
                                drawerLayout.O0000O0o.get(size2);
                            }
                        }
                        drawerLayout.O000000o(view, true);
                        if (drawerLayout.hasWindowFocus()) {
                            drawerLayout.sendAccessibilityEvent(32);
                        }
                        view.requestFocus();
                    }
                }
            }
            if (i4 != drawerLayout.O00000oO) {
                drawerLayout.O00000oO = i4;
                if (drawerLayout.O0000O0o != null) {
                    for (int size3 = drawerLayout.O0000O0o.size() - 1; size3 >= 0; size3--) {
                        drawerLayout.O0000O0o.get(size3);
                    }
                }
            }
        }

        public final void O000000o(View view, int i) {
            float f;
            int width = view.getWidth();
            if (DrawerLayout.this.O000000o(view, 3)) {
                f = (float) (i + width);
            } else {
                f = (float) (DrawerLayout.this.getWidth() - i);
            }
            float f2 = f / ((float) width);
            DrawerLayout.this.O000000o(view, f2);
            view.setVisibility(f2 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        public final void O00000Oo(View view) {
            ((LayoutParams) view.getLayoutParams()).O00000o0 = false;
            O00000Oo();
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo() {
            int i = 3;
            if (this.f9316O000000o == 3) {
                i = 5;
            }
            View O000000o2 = DrawerLayout.this.O000000o(i);
            if (O000000o2 != null) {
                DrawerLayout.this.O00000oO(O000000o2);
            }
        }

        public final void O000000o(View view, float f) {
            int i;
            float O00000Oo2 = DrawerLayout.O00000Oo(view);
            int width = view.getWidth();
            if (DrawerLayout.this.O000000o(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && O00000Oo2 > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f < 0.0f || (f == 0.0f && O00000Oo2 > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            grd grd = this.O00000Oo;
            int top = view.getTop();
            if (grd.O0000o0) {
                grd.O000000o(i, top, (int) grd.O0000Oo0.getXVelocity(grd.O00000o0), (int) grd.O0000Oo0.getYVelocity(grd.O00000o0));
                DrawerLayout.this.invalidate();
                return;
            }
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }

        public final void O00000o0() {
            DrawerLayout.this.postDelayed(this.O00000o, 160);
        }

        public final void O000000o(int i, int i2) {
            View view;
            if ((i & 1) == 1) {
                view = DrawerLayout.this.O000000o(3);
            } else {
                view = DrawerLayout.this.O000000o(5);
            }
            if (view != null && DrawerLayout.this.O000000o(view) == 0) {
                this.O00000Oo.O000000o(view, i2);
            }
        }

        public final int O00000o0(View view) {
            if (DrawerLayout.O00000o(view)) {
                return view.getWidth();
            }
            return 0;
        }

        public final int O00000Oo(View view, int i) {
            if (DrawerLayout.this.O000000o(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public final int O00000o(View view) {
            return view.getTop();
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f9313O000000o = 0;
        public float O00000Oo;
        public int O00000o;
        public boolean O00000o0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f9312O000000o);
            this.f9313O000000o = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f9313O000000o = layoutParams.f9313O000000o;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    class O000000o extends bh {
        private final Rect O00000Oo = new Rect();

        O000000o() {
        }

        public final void onInitializeAccessibilityNodeInfo(View view, cl clVar) {
            if (DrawerLayout.O00000Oo) {
                super.onInitializeAccessibilityNodeInfo(view, clVar);
            } else {
                cl O000000o2 = cl.O000000o(clVar);
                super.onInitializeAccessibilityNodeInfo(view, O000000o2);
                clVar.O00000Oo(view);
                ViewParent O0000Oo = cb.O0000Oo(view);
                if (O0000Oo instanceof View) {
                    clVar.O00000o((View) O0000Oo);
                }
                Rect rect = this.O00000Oo;
                O000000o2.O000000o(rect);
                clVar.O00000Oo(rect);
                O000000o2.O00000o0(rect);
                clVar.O00000o(rect);
                clVar.O00000oO(O000000o2.O00000Oo());
                clVar.O000000o(O000000o2.f13980O000000o.getPackageName());
                clVar.O00000Oo(O000000o2.f13980O000000o.getClassName());
                clVar.O00000oO(O000000o2.f13980O000000o.getContentDescription());
                clVar.O0000Oo(O000000o2.f13980O000000o.isEnabled());
                clVar.O0000OOo(O000000o2.f13980O000000o.isClickable());
                clVar.O00000o0(O000000o2.f13980O000000o.isFocusable());
                clVar.O00000o(O000000o2.f13980O000000o.isFocused());
                clVar.O00000oo(O000000o2.O00000o0());
                clVar.O0000O0o(O000000o2.f13980O000000o.isSelected());
                clVar.O0000Oo0(O000000o2.f13980O000000o.isLongClickable());
                clVar.O000000o(O000000o2.f13980O000000o.getActions());
                O000000o2.f13980O000000o.recycle();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (DrawerLayout.O00000oo(childAt)) {
                        clVar.O00000o0(childAt);
                    }
                }
            }
            clVar.O00000Oo((CharSequence) DrawerLayout.class.getName());
            clVar.O00000o0(false);
            clVar.O00000o(false);
            clVar.O00000Oo(cl.O000000o.f13981O000000o);
            clVar.O00000Oo(cl.O000000o.O00000Oo);
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            CharSequence charSequence;
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View O000000o2 = DrawerLayout.this.O000000o();
            if (O000000o2 == null) {
                return true;
            }
            int O00000o0 = DrawerLayout.this.O00000o0(O000000o2);
            DrawerLayout drawerLayout = DrawerLayout.this;
            int O000000o3 = bk.O000000o(O00000o0, cb.O0000Oo0(drawerLayout));
            if (O000000o3 == 3) {
                charSequence = drawerLayout.O0000OOo;
            } else if (O000000o3 == 5) {
                charSequence = drawerLayout.O0000Oo0;
            } else {
                charSequence = null;
            }
            if (charSequence == null) {
                return true;
            }
            text.add(charSequence);
            return true;
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.O00000Oo || DrawerLayout.O00000oo(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    final class O00000Oo extends bh {
        O00000Oo() {
        }

        public final void onInitializeAccessibilityNodeInfo(View view, cl clVar) {
            super.onInitializeAccessibilityNodeInfo(view, clVar);
            if (!DrawerLayout.O00000oo(view)) {
                clVar.O00000o((View) null);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0032  */
    public void onRtlPropertiesChanged(int i) {
        Drawable drawable;
        int O0000Oo02;
        Drawable drawable2;
        if (!O0000OoO) {
            int O0000Oo03 = cb.O0000Oo0(this);
            if (O0000Oo03 == 0) {
                Drawable drawable3 = this.O000O0oo;
                if (drawable3 != null) {
                    O000000o(drawable3, O0000Oo03);
                    drawable = this.O000O0oo;
                    this.O00oOoOo = drawable;
                    O0000Oo02 = cb.O0000Oo0(this);
                    if (O0000Oo02 == 0) {
                        Drawable drawable4 = this.O000OO00;
                        if (drawable4 != null) {
                            O000000o(drawable4, O0000Oo02);
                            drawable2 = this.O000OO00;
                            this.O000O0o0 = drawable2;
                        }
                    } else {
                        Drawable drawable5 = this.O000O0oo;
                        if (drawable5 != null) {
                            O000000o(drawable5, O0000Oo02);
                            drawable2 = this.O000O0oo;
                            this.O000O0o0 = drawable2;
                        }
                    }
                    drawable2 = this.O000OO;
                    this.O000O0o0 = drawable2;
                }
            } else {
                Drawable drawable6 = this.O000OO00;
                if (drawable6 != null) {
                    O000000o(drawable6, O0000Oo03);
                    drawable = this.O000OO00;
                    this.O00oOoOo = drawable;
                    O0000Oo02 = cb.O0000Oo0(this);
                    if (O0000Oo02 == 0) {
                    }
                    drawable2 = this.O000OO;
                    this.O000O0o0 = drawable2;
                }
            }
            drawable = this.O000OO0o;
            this.O00oOoOo = drawable;
            O0000Oo02 = cb.O0000Oo0(this);
            if (O0000Oo02 == 0) {
            }
            drawable2 = this.O000OO;
            this.O000O0o0 = drawable2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (r0 != 3) goto L_0x0073;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b A[LOOP:0: B:8:0x0024->B:20:0x005b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0059 A[SYNTHETIC] */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        View O000000o2;
        boolean z3;
        boolean z4;
        int actionMasked = motionEvent.getActionMasked();
        boolean O000000o3 = this.O00000o0.O000000o(motionEvent) | this.O00000o.O000000o(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    grd grd = this.O00000o0;
                    int length = grd.O00000o.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            z3 = false;
                            break;
                        }
                        if ((grd.O0000OOo & (1 << i)) != 0) {
                            float f = grd.O00000oo[i] - grd.O00000o[i];
                            float f2 = grd.O0000O0o[i] - grd.O00000oO[i];
                            if ((f * f) + (f2 * f2) > ((float) (grd.O00000Oo * grd.O00000Oo))) {
                                z4 = true;
                                if (!z4) {
                                    z3 = true;
                                    break;
                                }
                                i++;
                            }
                        }
                        z4 = false;
                        if (!z4) {
                        }
                    }
                    if (z3) {
                        this.O0000oO0.O000000o();
                        this.O0000oO.O000000o();
                    }
                }
                z = false;
            }
            O000000o(true);
            this.O00oOooO = false;
            this.O00000oo = false;
            z = false;
        } else {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.O000O00o = x;
            this.O000O0OO = y;
            z = this.O0000o0o > 0.0f && (O000000o2 = this.O00000o0.O000000o((int) x, (int) y)) != null && O0000O0o(O000000o2);
            this.O00oOooO = false;
            this.O00000oo = false;
        }
        if (!O000000o3 && !z) {
            int childCount = getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    z2 = false;
                    break;
                } else if (((LayoutParams) getChildAt(i2).getLayoutParams()).O00000o0) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            return z2 || this.O00000oo;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (O000000o() != null) {
                keyEvent.startTracking();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }
}
