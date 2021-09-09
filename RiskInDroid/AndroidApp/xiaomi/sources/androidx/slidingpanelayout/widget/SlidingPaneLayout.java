package androidx.slidingpanelayout.widget;

import _m_j.bh;
import _m_j.cb;
import _m_j.cl;
import _m_j.dh;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.ContextCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    int f2974O000000o;
    View O00000Oo;
    int O00000o;
    float O00000o0;
    boolean O00000oO;
    int O00000oo;
    final dh O0000O0o;
    boolean O0000OOo;
    private int O0000Oo;
    final ArrayList<O00000Oo> O0000Oo0;
    private Drawable O0000OoO;
    private Drawable O0000Ooo;
    private float O0000o;
    private boolean O0000o0;
    private final int O0000o00;
    private float O0000o0O;
    private float O0000o0o;
    private boolean O0000oO;
    private O00000o O0000oO0;
    private final Rect O0000oOO;
    private Method O0000oOo;
    private boolean O0000oo;
    private Field O0000oo0;

    public interface O00000o {
    }

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000oO(android.view.View, int):void
     arg types: [androidx.slidingpanelayout.widget.SlidingPaneLayout, int]
     candidates:
      _m_j.cb.O00000oO(android.view.View, float):void
      _m_j.cb.O00000oO(android.view.View, int):void */
    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2974O000000o = -858993460;
        this.O0000oO = true;
        this.O0000oOO = new Rect();
        this.O0000Oo0 = new ArrayList<>();
        float f = context.getResources().getDisplayMetrics().density;
        this.O0000o00 = (int) ((32.0f * f) + 0.5f);
        setWillNotDraw(false);
        cb.O000000o(this, new O000000o());
        cb.O00000oO((View) this, 1);
        this.O0000O0o = dh.O000000o(this, 0.5f, new O00000o0());
        this.O0000O0o.O0000O0o = f * 400.0f;
    }

    public void setParallaxDistance(int i) {
        this.O00000oo = i;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.O00000oo;
    }

    public void setSliderFadeColor(int i) {
        this.f2974O000000o = i;
    }

    public int getSliderFadeColor() {
        return this.f2974O000000o;
    }

    public void setCoveredFadeColor(int i) {
        this.O0000Oo = i;
    }

    public int getCoveredFadeColor() {
        return this.O0000Oo;
    }

    public void setPanelSlideListener(O00000o o00000o) {
        this.O0000oO0 = o00000o;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0070  */
    public final void O000000o(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        int childCount;
        int i5;
        boolean z;
        int i6;
        Drawable background;
        View view2 = view;
        boolean O00000Oo2 = O00000Oo();
        int width = O00000Oo2 ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = O00000Oo2 ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 != null) {
            boolean z2 = true;
            if (!view.isOpaque() && (Build.VERSION.SDK_INT >= 18 || (background = view.getBackground()) == null || background.getOpacity() != -1)) {
                z2 = false;
            }
            if (z2) {
                i4 = view.getLeft();
                i3 = view.getRight();
                i2 = view.getTop();
                i = view.getBottom();
                childCount = getChildCount();
                i5 = 0;
                while (i5 < childCount) {
                    View childAt = getChildAt(i5);
                    if (childAt != view2) {
                        if (childAt.getVisibility() != 8) {
                            int max = Math.max(O00000Oo2 ? paddingLeft : width, childAt.getLeft());
                            int max2 = Math.max(paddingTop, childAt.getTop());
                            if (O00000Oo2) {
                                z = O00000Oo2;
                                i6 = width;
                            } else {
                                z = O00000Oo2;
                                i6 = paddingLeft;
                            }
                            childAt.setVisibility((max < i4 || max2 < i2 || Math.min(i6, childAt.getRight()) > i3 || Math.min(height, childAt.getBottom()) > i) ? 0 : 4);
                        } else {
                            z = O00000Oo2;
                        }
                        i5++;
                        view2 = view;
                        O00000Oo2 = z;
                    } else {
                        return;
                    }
                }
            }
        }
        i4 = 0;
        i3 = 0;
        i2 = 0;
        i = 0;
        childCount = getChildCount();
        i5 = 0;
        while (i5 < childCount) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.O0000oO = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.O0000oO = true;
        int size = this.O0000Oo0.size();
        for (int i = 0; i < size; i++) {
            this.O0000Oo0.get(i).run();
        }
        this.O0000Oo0.clear();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            } else if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            } else if (mode2 == 0) {
                mode2 = Integer.MIN_VALUE;
                size2 = 300;
            }
        }
        boolean z = false;
        if (mode2 == Integer.MIN_VALUE) {
            i3 = (size2 - getPaddingTop()) - getPaddingBottom();
            i4 = 0;
        } else if (mode2 != 1073741824) {
            i4 = 0;
            i3 = 0;
        } else {
            i4 = (size2 - getPaddingTop()) - getPaddingBottom();
            i3 = i4;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.O00000Oo = null;
        int i13 = i4;
        int i14 = paddingLeft;
        int i15 = 0;
        boolean z2 = false;
        float f = 0.0f;
        while (true) {
            i5 = 8;
            if (i15 >= childCount) {
                break;
            }
            View childAt = getChildAt(i15);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.O00000o0 = z;
            } else {
                if (layoutParams.f2975O000000o > 0.0f) {
                    f += layoutParams.f2975O000000o;
                    if (layoutParams.width == 0) {
                    }
                }
                int i16 = layoutParams.leftMargin + layoutParams.rightMargin;
                if (layoutParams.width == -2) {
                    i11 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i16, Integer.MIN_VALUE);
                } else if (layoutParams.width == -1) {
                    i11 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i16, 1073741824);
                } else {
                    i11 = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                }
                if (layoutParams.height == -2) {
                    i12 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
                } else if (layoutParams.height == -1) {
                    i12 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                } else {
                    i12 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                }
                childAt.measure(i11, i12);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == Integer.MIN_VALUE && measuredHeight > i13) {
                    i13 = Math.min(measuredHeight, i3);
                }
                i14 -= measuredWidth;
                boolean z3 = i14 < 0;
                layoutParams.O00000Oo = z3;
                boolean z4 = z3 | z2;
                if (layoutParams.O00000Oo) {
                    this.O00000Oo = childAt;
                }
                z2 = z4;
            }
            i15++;
            z = false;
        }
        if (z2 || f > 0.0f) {
            int i17 = paddingLeft - this.O0000o00;
            int i18 = 0;
            while (i18 < childCount) {
                View childAt2 = getChildAt(i18);
                if (childAt2.getVisibility() != i5) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i5) {
                        boolean z5 = layoutParams2.width == 0 && layoutParams2.f2975O000000o > 0.0f;
                        if (z5) {
                            i7 = 0;
                        } else {
                            i7 = childAt2.getMeasuredWidth();
                        }
                        if (!z2 || childAt2 == this.O00000Oo) {
                            if (layoutParams2.f2975O000000o > 0.0f) {
                                if (layoutParams2.width != 0) {
                                    i8 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                } else if (layoutParams2.height == -2) {
                                    i8 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
                                } else if (layoutParams2.height == -1) {
                                    i8 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                                } else {
                                    i8 = View.MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824);
                                }
                                if (z2) {
                                    int i19 = paddingLeft - (layoutParams2.leftMargin + layoutParams2.rightMargin);
                                    i6 = i17;
                                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i19, 1073741824);
                                    if (i7 != i19) {
                                        childAt2.measure(makeMeasureSpec, i8);
                                    }
                                    i18++;
                                    i17 = i6;
                                    i5 = 8;
                                } else {
                                    i6 = i17;
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(i7 + ((int) ((layoutParams2.f2975O000000o * ((float) Math.max(0, i14))) / f)), 1073741824), i8);
                                    i18++;
                                    i17 = i6;
                                    i5 = 8;
                                }
                            }
                        } else if (layoutParams2.width < 0 && (i7 > i17 || layoutParams2.f2975O000000o > 0.0f)) {
                            if (!z5) {
                                i9 = 1073741824;
                                i10 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            } else if (layoutParams2.height == -2) {
                                i10 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
                                i9 = 1073741824;
                            } else if (layoutParams2.height == -1) {
                                i9 = 1073741824;
                                i10 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                            } else {
                                i9 = 1073741824;
                                i10 = View.MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824);
                            }
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(i17, i9), i10);
                        }
                    }
                }
                i6 = i17;
                i18++;
                i17 = i6;
                i5 = 8;
            }
        }
        setMeasuredDimension(size, i13 + getPaddingTop() + getPaddingBottom());
        this.O0000o0 = z2;
        if (this.O0000O0o.f14629O000000o != 0 && !z2) {
            this.O0000O0o.O00000Oo();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean O00000Oo2 = O00000Oo();
        if (O00000Oo2) {
            this.O0000O0o.O0000Oo0 = 2;
        } else {
            this.O0000O0o.O0000Oo0 = 1;
        }
        int i10 = i3 - i;
        int paddingRight = O00000Oo2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = O00000Oo2 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.O0000oO) {
            this.O00000o0 = (!this.O0000o0 || !this.O0000OOo) ? 0.0f : 1.0f;
        }
        int i11 = paddingRight;
        int i12 = i11;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.O00000Oo) {
                    int i14 = i10 - paddingLeft;
                    int min = (Math.min(i11, i14 - this.O0000o00) - i12) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.O00000o = min;
                    int i15 = O00000Oo2 ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.O00000o0 = ((i12 + i15) + min) + (measuredWidth / 2) > i14;
                    int i16 = (int) (((float) min) * this.O00000o0);
                    i6 = i15 + i16 + i12;
                    this.O00000o0 = ((float) i16) / ((float) this.O00000o);
                    i5 = 0;
                } else {
                    i5 = (!this.O0000o0 || (i9 = this.O00000oo) == 0) ? 0 : (int) ((1.0f - this.O00000o0) * ((float) i9));
                    i6 = i11;
                }
                if (O00000Oo2) {
                    i7 = (i10 - i6) + i5;
                    i8 = i7 - measuredWidth;
                } else {
                    i8 = i6 - i5;
                    i7 = i8 + measuredWidth;
                }
                childAt.layout(i8, paddingTop, i7, childAt.getMeasuredHeight() + paddingTop);
                i11 += childAt.getWidth();
                i12 = i6;
            }
        }
        if (this.O0000oO) {
            if (this.O0000o0) {
                if (this.O00000oo != 0) {
                    O000000o(this.O00000o0);
                }
                if (((LayoutParams) this.O00000Oo.getLayoutParams()).O00000o0) {
                    O000000o(this.O00000Oo, this.O00000o0, this.f2974O000000o);
                }
            } else {
                for (int i17 = 0; i17 < childCount; i17++) {
                    O000000o(getChildAt(i17), 0.0f, this.f2974O000000o);
                }
            }
            O000000o(this.O00000Oo);
        }
        this.O0000oO = false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.O0000oO = true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.O0000o0) {
            this.O0000OOo = view == this.O00000Oo;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.O0000o0 && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.O0000OOo = !dh.O00000Oo(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.O0000o0 || (this.O00000oO && actionMasked != 0)) {
            this.O0000O0o.O000000o();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.O0000O0o.O000000o();
            return false;
        } else {
            if (actionMasked == 0) {
                this.O00000oO = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.O0000o0o = x;
                this.O0000o = y;
                if (dh.O00000Oo(this.O00000Oo, (int) x, (int) y) && O00000o0(this.O00000Oo)) {
                    z = true;
                    if (!this.O0000O0o.O000000o(motionEvent) || z) {
                        return true;
                    }
                    return false;
                }
            } else if (actionMasked == 2) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float abs = Math.abs(x2 - this.O0000o0o);
                float abs2 = Math.abs(y2 - this.O0000o);
                if (abs > ((float) this.O0000O0o.O00000Oo) && abs2 > abs) {
                    this.O0000O0o.O000000o();
                    this.O00000oO = true;
                    return false;
                }
            }
            z = false;
            if (!this.O0000O0o.O000000o(motionEvent)) {
            }
            return true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.O0000o0) {
            return super.onTouchEvent(motionEvent);
        }
        this.O0000O0o.O00000Oo(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.O0000o0o = x;
            this.O0000o = y;
        } else if (actionMasked == 1 && O00000o0(this.O00000Oo)) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f = x2 - this.O0000o0o;
            float f2 = y2 - this.O0000o;
            int i = this.O0000O0o.O00000Oo;
            if ((f * f) + (f2 * f2) < ((float) (i * i)) && dh.O00000Oo(this.O00000Oo, (int) x2, (int) y2)) {
                O00000o0();
            }
        }
        return true;
    }

    private boolean O00000o0() {
        if (!this.O0000oO && !O00000Oo(0.0f)) {
            return false;
        }
        this.O0000OOo = false;
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((-16777216 & i) >>> 24)) * f)) << 24) | (i & 16777215);
            if (layoutParams.O00000o == null) {
                layoutParams.O00000o = new Paint();
            }
            layoutParams.O00000o.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.O00000o);
            }
            O00000Oo(view);
        } else if (view.getLayerType() != 0) {
            if (layoutParams.O00000o != null) {
                layoutParams.O00000o.setColorFilter(null);
            }
            O00000Oo o00000Oo = new O00000Oo(view);
            this.O0000Oo0.add(o00000Oo);
            cb.O000000o(this, o00000Oo);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.O0000o0 && !layoutParams.O00000Oo && this.O00000Oo != null) {
            canvas.getClipBounds(this.O0000oOO);
            if (O00000Oo()) {
                Rect rect = this.O0000oOO;
                rect.left = Math.max(rect.left, this.O00000Oo.getRight());
            } else {
                Rect rect2 = this.O0000oOO;
                rect2.right = Math.min(rect2.right, this.O00000Oo.getLeft());
            }
            canvas.clipRect(this.O0000oOO);
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(View view) {
        Field field;
        if (Build.VERSION.SDK_INT >= 17) {
            cb.O000000o(view, ((LayoutParams) view.getLayoutParams()).O00000o);
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (!this.O0000oo) {
                try {
                    this.O0000oOo = View.class.getDeclaredMethod("getDisplayList", null);
                } catch (NoSuchMethodException e) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
                }
                try {
                    this.O0000oo0 = View.class.getDeclaredField("mRecreateDisplayList");
                    this.O0000oo0.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
                }
                this.O0000oo = true;
            }
            if (this.O0000oOo == null || (field = this.O0000oo0) == null) {
                view.invalidate();
                return;
            }
            try {
                field.setBoolean(view, true);
                this.O0000oOo.invoke(view, null);
            } catch (Exception e3) {
                Log.e("SlidingPaneLayout", "Error refreshing display list state", e3);
            }
        }
        cb.O000000o(this, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    private boolean O00000Oo(float f) {
        int i;
        if (!this.O0000o0) {
            return false;
        }
        boolean O00000Oo2 = O00000Oo();
        LayoutParams layoutParams = (LayoutParams) this.O00000Oo.getLayoutParams();
        if (O00000Oo2) {
            i = (int) (((float) getWidth()) - ((((float) (getPaddingRight() + layoutParams.rightMargin)) + (f * ((float) this.O00000o))) + ((float) this.O00000Oo.getWidth())));
        } else {
            i = (int) (((float) (getPaddingLeft() + layoutParams.leftMargin)) + (f * ((float) this.O00000o)));
        }
        dh dhVar = this.O0000O0o;
        View view = this.O00000Oo;
        if (!dhVar.O000000o(view, i, view.getTop())) {
            return false;
        }
        O000000o();
        cb.O00000oo(this);
        return true;
    }

    public void computeScroll() {
        if (!this.O0000O0o.O00000o0()) {
            return;
        }
        if (!this.O0000o0) {
            this.O0000O0o.O00000Oo();
        } else {
            cb.O00000oo(this);
        }
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.O0000OoO = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.O0000Ooo = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(ContextCompat.O000000o(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(ContextCompat.O000000o(getContext(), i));
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        int i;
        int i2;
        super.draw(canvas);
        if (O00000Oo()) {
            drawable = this.O0000Ooo;
        } else {
            drawable = this.O0000OoO;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (O00000Oo()) {
                i2 = childAt.getRight();
                i = intrinsicWidth + i2;
            } else {
                int left = childAt.getLeft();
                int i3 = left - intrinsicWidth;
                i = left;
                i2 = i3;
            }
            drawable.setBounds(i2, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    public final void O000000o(float f) {
        boolean z;
        int childCount;
        boolean O00000Oo2 = O00000Oo();
        LayoutParams layoutParams = (LayoutParams) this.O00000Oo.getLayoutParams();
        if (layoutParams.O00000o0) {
            if ((O00000Oo2 ? layoutParams.rightMargin : layoutParams.leftMargin) <= 0) {
                z = true;
                childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt != this.O00000Oo) {
                        int i2 = this.O00000oo;
                        this.O0000o0O = f;
                        int i3 = ((int) ((1.0f - this.O0000o0O) * ((float) i2))) - ((int) ((1.0f - f) * ((float) i2)));
                        if (O00000Oo2) {
                            i3 = -i3;
                        }
                        childAt.offsetLeftAndRight(i3);
                        if (z) {
                            O000000o(childAt, O00000Oo2 ? this.O0000o0O - 1.0f : 1.0f - this.O0000o0O, this.O0000Oo);
                        }
                    }
                }
            }
        }
        z = false;
        childCount = getChildCount();
        while (i < childCount) {
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000o0(View view) {
        if (view == null) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!this.O0000o0 || !layoutParams.O00000o0 || this.O00000o0 <= 0.0f) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        boolean z = this.O0000o0;
        savedState.f2979O000000o = z ? !z || this.O00000o0 == 1.0f : this.O0000OOo;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.f2979O000000o) {
            O00000o0();
        } else if (this.O0000oO || O00000Oo(1.0f)) {
            this.O0000OOo = true;
        }
        this.O0000OOo = savedState.f2979O000000o;
    }

    class O00000o0 extends dh.O000000o {
        O00000o0() {
        }

        public final boolean tryCaptureView(View view, int i) {
            if (SlidingPaneLayout.this.O00000oO) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).O00000Oo;
        }

        public final void onViewDragStateChanged(int i) {
            if (SlidingPaneLayout.this.O0000O0o.f14629O000000o != 0) {
                return;
            }
            if (SlidingPaneLayout.this.O00000o0 == 0.0f) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.O000000o(slidingPaneLayout.O00000Oo);
                SlidingPaneLayout.this.sendAccessibilityEvent(32);
                SlidingPaneLayout.this.O0000OOo = false;
                return;
            }
            SlidingPaneLayout.this.sendAccessibilityEvent(32);
            SlidingPaneLayout.this.O0000OOo = true;
        }

        public final void onViewCaptured(View view, int i) {
            SlidingPaneLayout.this.O000000o();
        }

        public final void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.O00000Oo == null) {
                slidingPaneLayout.O00000o0 = 0.0f;
            } else {
                boolean O00000Oo = slidingPaneLayout.O00000Oo();
                LayoutParams layoutParams = (LayoutParams) slidingPaneLayout.O00000Oo.getLayoutParams();
                int width = slidingPaneLayout.O00000Oo.getWidth();
                if (O00000Oo) {
                    i = (slidingPaneLayout.getWidth() - i) - width;
                }
                slidingPaneLayout.O00000o0 = ((float) (i - ((O00000Oo ? slidingPaneLayout.getPaddingRight() : slidingPaneLayout.getPaddingLeft()) + (O00000Oo ? layoutParams.rightMargin : layoutParams.leftMargin)))) / ((float) slidingPaneLayout.O00000o);
                if (slidingPaneLayout.O00000oo != 0) {
                    slidingPaneLayout.O000000o(slidingPaneLayout.O00000o0);
                }
                if (layoutParams.O00000o0) {
                    slidingPaneLayout.O000000o(slidingPaneLayout.O00000Oo, slidingPaneLayout.O00000o0, slidingPaneLayout.f2974O000000o);
                }
            }
            SlidingPaneLayout.this.invalidate();
        }

        public final void onViewReleased(View view, float f, float f2) {
            int i;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.O00000Oo()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin;
                if (f < 0.0f || (f == 0.0f && SlidingPaneLayout.this.O00000o0 > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.O00000o;
                }
                i = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.O00000Oo.getWidth();
            } else {
                i = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && SlidingPaneLayout.this.O00000o0 > 0.5f)) {
                    i += SlidingPaneLayout.this.O00000o;
                }
            }
            SlidingPaneLayout.this.O0000O0o.O000000o(i, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public final int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.O00000o;
        }

        public final int clampViewPositionHorizontal(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.O00000Oo.getLayoutParams();
            if (SlidingPaneLayout.this.O00000Oo()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin) + SlidingPaneLayout.this.O00000Oo.getWidth());
                return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.O00000o);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + layoutParams.leftMargin;
            return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.O00000o + paddingLeft);
        }

        public final int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        public final void onEdgeDragStarted(int i, int i2) {
            SlidingPaneLayout.this.O0000O0o.O000000o(SlidingPaneLayout.this.O00000Oo, i2);
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int[] O00000oO = {16843137};

        /* renamed from: O000000o  reason: collision with root package name */
        public float f2975O000000o = 0.0f;
        boolean O00000Oo;
        Paint O00000o;
        boolean O00000o0;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, O00000oO);
            this.f2975O000000o = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState.AnonymousClass1 */

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f2979O000000o;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel, null);
            this.f2979O000000o = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2979O000000o ? 1 : 0);
        }
    }

    class O000000o extends bh {
        private final Rect O00000Oo = new Rect();

        O000000o() {
        }

        public final void onInitializeAccessibilityNodeInfo(View view, cl clVar) {
            cl O000000o2 = cl.O000000o(clVar);
            super.onInitializeAccessibilityNodeInfo(view, O000000o2);
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
            int movementGranularities = Build.VERSION.SDK_INT >= 16 ? O000000o2.f13980O000000o.getMovementGranularities() : 0;
            if (Build.VERSION.SDK_INT >= 16) {
                clVar.f13980O000000o.setMovementGranularities(movementGranularities);
            }
            O000000o2.f13980O000000o.recycle();
            clVar.O00000Oo((CharSequence) SlidingPaneLayout.class.getName());
            clVar.O00000Oo(view);
            ViewParent O0000Oo = cb.O0000Oo(view);
            if (O0000Oo instanceof View) {
                clVar.O00000o((View) O0000Oo);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!O000000o(childAt) && childAt.getVisibility() == 0) {
                    cb.O00000oO(childAt, 1);
                    clVar.O00000o0(childAt);
                }
            }
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!O000000o(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        private boolean O000000o(View view) {
            return SlidingPaneLayout.this.O00000o0(view);
        }
    }

    class O00000Oo implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        final View f2977O000000o;

        O00000Oo(View view) {
            this.f2977O000000o = view;
        }

        public final void run() {
            if (this.f2977O000000o.getParent() == SlidingPaneLayout.this) {
                this.f2977O000000o.setLayerType(0, null);
                SlidingPaneLayout.this.O00000Oo(this.f2977O000000o);
            }
            SlidingPaneLayout.this.O0000Oo0.remove(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000Oo() {
        return cb.O0000Oo0(this) == 1;
    }
}
