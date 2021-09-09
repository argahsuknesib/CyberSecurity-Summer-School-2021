package androidx.appcompat.widget;

import _m_j.Oo;
import _m_j.bk;
import _m_j.cb;
import _m_j.o00;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.xiaomi.smarthome.R;

public class LinearLayoutCompat extends ViewGroup {
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    /* access modifiers changed from: package-private */
    public int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getLocationOffset(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getNextLocationOffset(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int measureNullChild(int i) {
        return 0;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.Oo.O000000o(int, boolean):boolean
     arg types: [int, int]
     candidates:
      _m_j.Oo.O000000o(int, int):int
      _m_j.Oo.O000000o(int, boolean):boolean */
    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        Oo O000000o2 = Oo.O000000o(context, attributeSet, new int[]{16842927, 16842948, 16843046, 16843047, 16843048, R.attr.divider, R.attr.dividerPadding, R.attr.measureWithLargestChild, R.attr.showDividers}, i, 0);
        cb.O000000o(this, context, new int[]{16842927, 16842948, 16843046, 16843047, 16843048, R.attr.divider, R.attr.dividerPadding, R.attr.measureWithLargestChild, R.attr.showDividers}, attributeSet, O000000o2.f12340O000000o, i);
        int O000000o3 = O000000o2.O000000o(1, -1);
        if (O000000o3 >= 0) {
            setOrientation(O000000o3);
        }
        int O000000o4 = O000000o2.O000000o(0, -1);
        if (O000000o4 >= 0) {
            setGravity(O000000o4);
        }
        boolean O000000o5 = O000000o2.O000000o(2, true);
        if (!O000000o5) {
            setBaselineAligned(O000000o5);
        }
        this.mWeightSum = O000000o2.f12340O000000o.getFloat(4, -1.0f);
        this.mBaselineAlignedChildIndex = O000000o2.O000000o(3, -1);
        this.mUseLargestChild = O000000o2.O000000o(7, false);
        setDividerDrawable(O000000o2.O000000o(5));
        this.mShowDividers = O000000o2.O000000o(8, 0);
        this.mDividerPadding = O000000o2.O00000oO(6, 0);
        O000000o2.f12340O000000o.recycle();
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.mDivider) {
            this.mDivider = drawable;
            boolean z = false;
            if (drawable != null) {
                this.mDividerWidth = drawable.getIntrinsicWidth();
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.mDivider != null) {
            if (this.mOrientation == 1) {
                drawDividersVertical(canvas);
            } else {
                drawDividersHorizontal(canvas);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void drawDividersVertical(Canvas canvas) {
        int i;
        int virtualChildCount = getVirtualChildCount();
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View virtualChildAt = getVirtualChildAt(i2);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i2))) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LayoutParams) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                i = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                i = virtualChildAt2.getBottom() + ((LayoutParams) virtualChildAt2.getLayoutParams()).bottomMargin;
            }
            drawHorizontalDivider(canvas, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawDividersHorizontal(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int virtualChildCount = getVirtualChildCount();
        boolean O000000o2 = o00.O000000o(this);
        for (int i5 = 0; i5 < virtualChildCount; i5++) {
            View virtualChildAt = getVirtualChildAt(i5);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i5))) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (O000000o2) {
                    i4 = virtualChildAt.getRight() + layoutParams.rightMargin;
                } else {
                    i4 = (virtualChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerWidth;
                }
                drawVerticalDivider(canvas, i4);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (O000000o2) {
                    i3 = virtualChildAt2.getLeft() - layoutParams2.leftMargin;
                    i2 = this.mDividerWidth;
                } else {
                    i = virtualChildAt2.getRight() + layoutParams2.rightMargin;
                    drawVerticalDivider(canvas, i);
                }
            } else if (O000000o2) {
                i = getPaddingLeft();
                drawVerticalDivider(canvas, i);
            } else {
                i3 = getWidth() - getPaddingRight();
                i2 = this.mDividerWidth;
            }
            i = i3 - i2;
            drawVerticalDivider(canvas, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    public void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public int getBaseline() {
        int i;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.mBaselineAlignedChildIndex;
        if (childCount > i2) {
            View childAt = getChildAt(i2);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i3 = this.mBaselineChildTop;
                if (this.mOrientation == 1 && (i = this.mGravity & 112) != 48) {
                    if (i == 16) {
                        i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                    } else if (i == 80) {
                        i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                    }
                }
                return i3 + ((LayoutParams) childAt.getLayoutParams()).topMargin + baseline;
            } else if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = i;
    }

    /* access modifiers changed from: package-private */
    public View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        }
        if ((this.mShowDividers & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0336  */
    public void measureVertical(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        float f;
        int i8;
        int i9;
        boolean z;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        float f2;
        int i17;
        int i18;
        int i19;
        View view;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        boolean z2;
        int i25;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i26 = this.mBaselineAlignedChildIndex;
        boolean z3 = this.mUseLargestChild;
        float f3 = 0.0f;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = 0;
        int i31 = 0;
        int i32 = 0;
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = false;
        while (true) {
            int i33 = 8;
            int i34 = i30;
            if (i32 < virtualChildCount) {
                View virtualChildAt = getVirtualChildAt(i32);
                if (virtualChildAt == null) {
                    this.mTotalLength += measureNullChild(i32);
                    i12 = virtualChildCount;
                    i30 = i34;
                    i13 = mode2;
                    int i35 = i32;
                    i14 = i27;
                    i16 = i28;
                    i15 = i35;
                } else {
                    int i36 = i27;
                    if (virtualChildAt.getVisibility() != 8) {
                        if (hasDividerBeforeChildAt(i32)) {
                            this.mTotalLength += this.mDividerHeight;
                        }
                        LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                        f2 = f3 + layoutParams.O0000O0o;
                        if (mode2 == 1073741824 && layoutParams.height == 0 && layoutParams.O0000O0o > 0.0f) {
                            int i37 = this.mTotalLength;
                            this.mTotalLength = Math.max(i37, layoutParams.topMargin + i37 + layoutParams.bottomMargin);
                            i21 = i29;
                            view = virtualChildAt;
                            i22 = i31;
                            i12 = virtualChildCount;
                            i24 = i36;
                            i23 = i28;
                            z4 = true;
                            i18 = i32;
                            int i38 = i34;
                            i13 = mode2;
                            i17 = i38;
                        } else {
                            int i39 = i28;
                            if (layoutParams.height != 0 || layoutParams.O0000O0o <= 0.0f) {
                                i25 = Integer.MIN_VALUE;
                            } else {
                                layoutParams.height = -2;
                                i25 = 0;
                            }
                            i24 = i36;
                            i23 = i39;
                            int i40 = i29;
                            View view2 = virtualChildAt;
                            i12 = virtualChildCount;
                            int i41 = i34;
                            i13 = mode2;
                            i17 = i41;
                            i22 = i31;
                            i18 = i32;
                            measureChildBeforeLayout(virtualChildAt, i32, i, 0, i2, f2 == 0.0f ? this.mTotalLength : 0);
                            int i42 = i25;
                            if (i42 != Integer.MIN_VALUE) {
                                layoutParams.height = i42;
                            }
                            int measuredHeight = view2.getMeasuredHeight();
                            int i43 = this.mTotalLength;
                            view = view2;
                            this.mTotalLength = Math.max(i43, i43 + measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin + getNextLocationOffset(view));
                            i21 = z3 ? Math.max(measuredHeight, i40) : i40;
                        }
                        if (i26 >= 0 && i26 == i18 + 1) {
                            this.mBaselineChildTop = this.mTotalLength;
                        }
                        if (i18 >= i26 || layoutParams.O0000O0o <= 0.0f) {
                            if (mode == 1073741824 || layoutParams.width != -1) {
                                z2 = false;
                            } else {
                                z2 = true;
                                z6 = true;
                            }
                            int i44 = layoutParams.leftMargin + layoutParams.rightMargin;
                            int measuredWidth = view.getMeasuredWidth() + i44;
                            i19 = Math.max(i23, measuredWidth);
                            i14 = View.combineMeasuredStates(i24, view.getMeasuredState());
                            z5 = z5 && layoutParams.width == -1;
                            if (layoutParams.O0000O0o > 0.0f) {
                                if (!z2) {
                                    i44 = measuredWidth;
                                }
                                i17 = Math.max(i17, i44);
                                i20 = i22;
                            } else {
                                if (!z2) {
                                    i44 = measuredWidth;
                                }
                                i20 = Math.max(i22, i44);
                            }
                        } else {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                    } else {
                        int i45 = i29;
                        view = virtualChildAt;
                        i20 = i31;
                        i12 = virtualChildCount;
                        i19 = i28;
                        i18 = i32;
                        int i46 = i34;
                        i13 = mode2;
                        i17 = i46;
                        f2 = f3;
                        i14 = i36;
                        i21 = i45;
                    }
                    i15 = getChildrenSkipCount(view, i18) + i18;
                    i29 = i21;
                    i30 = i17;
                    f3 = f2;
                    int i47 = i19;
                    i31 = i20;
                    i16 = i47;
                }
                mode2 = i13;
                virtualChildCount = i12;
                int i48 = i15 + 1;
                i28 = i16;
                i27 = i14;
                i32 = i48;
            } else {
                int i49 = i27;
                int i50 = i29;
                int i51 = i31;
                int i52 = virtualChildCount;
                int i53 = i28;
                int i54 = i34;
                int i55 = mode2;
                int i56 = i54;
                if (this.mTotalLength > 0) {
                    i3 = i52;
                    if (hasDividerBeforeChildAt(i3)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                } else {
                    i3 = i52;
                }
                if (z3) {
                    i4 = i55;
                    if (i4 == Integer.MIN_VALUE || i4 == 0) {
                        this.mTotalLength = 0;
                        int i57 = 0;
                        while (i57 < i3) {
                            View virtualChildAt2 = getVirtualChildAt(i57);
                            if (virtualChildAt2 == null) {
                                this.mTotalLength += measureNullChild(i57);
                            } else if (virtualChildAt2.getVisibility() == i33) {
                                i57 += getChildrenSkipCount(virtualChildAt2, i57);
                            } else {
                                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                                int i58 = this.mTotalLength;
                                this.mTotalLength = Math.max(i58, i58 + i50 + layoutParams2.topMargin + layoutParams2.bottomMargin + getNextLocationOffset(virtualChildAt2));
                            }
                            i57++;
                            i33 = 8;
                        }
                    }
                } else {
                    i4 = i55;
                }
                this.mTotalLength += getPaddingTop() + getPaddingBottom();
                int i59 = i2;
                int i60 = i50;
                int resolveSizeAndState = View.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumHeight()), i59, 0);
                int i61 = (16777215 & resolveSizeAndState) - this.mTotalLength;
                if (z4 || (i61 != 0 && f3 > 0.0f)) {
                    float f4 = this.mWeightSum;
                    if (f4 > 0.0f) {
                        f3 = f4;
                    }
                    this.mTotalLength = 0;
                    float f5 = f3;
                    int i62 = 0;
                    int i63 = i49;
                    int i64 = i51;
                    i6 = i63;
                    while (i62 < i3) {
                        View virtualChildAt3 = getVirtualChildAt(i62);
                        if (virtualChildAt3.getVisibility() != 8) {
                            LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                            float f6 = layoutParams3.O0000O0o;
                            if (f6 > 0.0f) {
                                int i65 = (int) ((((float) i61) * f6) / f5);
                                i8 = i61 - i65;
                                f = f5 - f6;
                                int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams3.leftMargin + layoutParams3.rightMargin, layoutParams3.width);
                                if (layoutParams3.height != 0 || i4 != 1073741824) {
                                    int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i65;
                                    if (measuredHeight2 < 0) {
                                        measuredHeight2 = 0;
                                    }
                                    i65 = measuredHeight2;
                                } else if (i65 <= 0) {
                                    i11 = 1073741824;
                                    i65 = 0;
                                    virtualChildAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i65, i11));
                                    i6 = View.combineMeasuredStates(i6, virtualChildAt3.getMeasuredState() & -256);
                                }
                                i11 = 1073741824;
                                virtualChildAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i65, i11));
                                i6 = View.combineMeasuredStates(i6, virtualChildAt3.getMeasuredState() & -256);
                            } else {
                                i8 = i61;
                                f = f5;
                            }
                            int i66 = layoutParams3.leftMargin + layoutParams3.rightMargin;
                            int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i66;
                            i53 = Math.max(i53, measuredWidth2);
                            if (mode != 1073741824) {
                                i9 = i6;
                                i10 = -1;
                                if (layoutParams3.width == -1) {
                                    z = true;
                                    if (!z) {
                                        i66 = measuredWidth2;
                                    }
                                    i64 = Math.max(i64, i66);
                                    boolean z7 = !z5 && layoutParams3.width == i10;
                                    int i67 = this.mTotalLength;
                                    this.mTotalLength = Math.max(i67, virtualChildAt3.getMeasuredHeight() + i67 + layoutParams3.topMargin + layoutParams3.bottomMargin + getNextLocationOffset(virtualChildAt3));
                                    z5 = z7;
                                    i61 = i8;
                                    i6 = i9;
                                }
                            } else {
                                i9 = i6;
                                i10 = -1;
                            }
                            z = false;
                            if (!z) {
                            }
                            i64 = Math.max(i64, i66);
                            if (!z5) {
                            }
                            int i672 = this.mTotalLength;
                            this.mTotalLength = Math.max(i672, virtualChildAt3.getMeasuredHeight() + i672 + layoutParams3.topMargin + layoutParams3.bottomMargin + getNextLocationOffset(virtualChildAt3));
                            z5 = z7;
                            i61 = i8;
                            i6 = i9;
                        } else {
                            f = f5;
                        }
                        i62++;
                        f5 = f;
                    }
                    i5 = i;
                    this.mTotalLength += getPaddingTop() + getPaddingBottom();
                    i7 = i64;
                } else {
                    i7 = Math.max(i51, i56);
                    if (z3 && i4 != 1073741824) {
                        for (int i68 = 0; i68 < i3; i68++) {
                            View virtualChildAt4 = getVirtualChildAt(i68);
                            if (!(virtualChildAt4 == null || virtualChildAt4.getVisibility() == 8 || ((LayoutParams) virtualChildAt4.getLayoutParams()).O0000O0o <= 0.0f)) {
                                virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i60, 1073741824));
                            }
                        }
                    }
                    i5 = i;
                    i6 = i49;
                }
                if (z5 || mode == 1073741824) {
                    i7 = i53;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(i7 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i5, i6), resolveSizeAndState);
                if (z6) {
                    forceUniformWidth(i3, i59);
                    return;
                }
                return;
            }
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x03c9, code lost:
        if (r4 < 0) goto L_0x03c2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01d7  */
    public void measureHorizontal(int i, int i2) {
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        float f;
        int i12;
        boolean z;
        int baseline;
        int i13;
        int i14;
        boolean z2;
        boolean z3;
        float f2;
        int i15;
        int i16;
        View view;
        int i17;
        boolean z4;
        int measuredHeight;
        int baseline2;
        int i18;
        int i19 = i;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr2 = this.mMaxAscent;
        int[] iArr3 = this.mMaxDescent;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z5 = this.mBaselineAligned;
        boolean z6 = this.mUseLargestChild;
        int i20 = 1073741824;
        boolean z7 = mode == 1073741824;
        float f3 = 0.0f;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        boolean z8 = false;
        int i26 = 0;
        boolean z9 = true;
        boolean z10 = false;
        while (true) {
            iArr = iArr3;
            if (i21 >= virtualChildCount) {
                break;
            }
            View virtualChildAt = getVirtualChildAt(i21);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i21);
                f2 = f3;
                i15 = i21;
                z3 = z6;
                z2 = z5;
            } else {
                if (virtualChildAt.getVisibility() != 8) {
                    if (hasDividerBeforeChildAt(i21)) {
                        this.mTotalLength += this.mDividerWidth;
                    }
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    f2 = f3 + layoutParams.O0000O0o;
                    if (mode == i20 && layoutParams.width == 0 && layoutParams.O0000O0o > 0.0f) {
                        if (z7) {
                            this.mTotalLength += layoutParams.leftMargin + layoutParams.rightMargin;
                        } else {
                            int i27 = this.mTotalLength;
                            this.mTotalLength = Math.max(i27, layoutParams.leftMargin + i27 + layoutParams.rightMargin);
                        }
                        if (z5) {
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                            virtualChildAt.measure(makeMeasureSpec, makeMeasureSpec);
                            i16 = i21;
                            z3 = z6;
                            z2 = z5;
                            view = virtualChildAt;
                        } else {
                            i16 = i21;
                            z3 = z6;
                            z2 = z5;
                            view = virtualChildAt;
                            i17 = 1073741824;
                            z8 = true;
                            if (mode2 == i17 && layoutParams.height == -1) {
                                z4 = true;
                                z10 = true;
                            } else {
                                z4 = false;
                            }
                            int i28 = layoutParams.topMargin + layoutParams.bottomMargin;
                            measuredHeight = view.getMeasuredHeight() + i28;
                            i26 = View.combineMeasuredStates(i26, view.getMeasuredState());
                            if (z2 && (baseline2 = view.getBaseline()) != -1) {
                                int i29 = ((((layoutParams.O0000OOo >= 0 ? this.mGravity : layoutParams.O0000OOo) & 112) >> 4) & -2) >> 1;
                                iArr2[i29] = Math.max(iArr2[i29], baseline2);
                                iArr[i29] = Math.max(iArr[i29], measuredHeight - baseline2);
                            }
                            i23 = Math.max(i23, measuredHeight);
                            z9 = !z9 && layoutParams.height == -1;
                            if (layoutParams.O0000O0o <= 0.0f) {
                                if (!z4) {
                                    i28 = measuredHeight;
                                }
                                i25 = Math.max(i25, i28);
                            } else {
                                int i30 = i25;
                                if (z4) {
                                    measuredHeight = i28;
                                }
                                i24 = Math.max(i24, measuredHeight);
                                i25 = i30;
                            }
                        }
                    } else {
                        if (layoutParams.width != 0 || layoutParams.O0000O0o <= 0.0f) {
                            i18 = Integer.MIN_VALUE;
                        } else {
                            layoutParams.width = -2;
                            i18 = 0;
                        }
                        i16 = i21;
                        z3 = z6;
                        z2 = z5;
                        View view2 = virtualChildAt;
                        measureChildBeforeLayout(virtualChildAt, i16, i, f2 == 0.0f ? this.mTotalLength : 0, i2, 0);
                        int i31 = i18;
                        if (i31 != Integer.MIN_VALUE) {
                            layoutParams.width = i31;
                        }
                        int measuredWidth = view2.getMeasuredWidth();
                        if (z7) {
                            view = view2;
                            this.mTotalLength += layoutParams.leftMargin + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(view);
                        } else {
                            view = view2;
                            int i32 = this.mTotalLength;
                            this.mTotalLength = Math.max(i32, i32 + measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin + getNextLocationOffset(view));
                        }
                        if (z3) {
                            i22 = Math.max(measuredWidth, i22);
                        }
                    }
                    i17 = 1073741824;
                    if (mode2 == i17) {
                    }
                    z4 = false;
                    int i282 = layoutParams.topMargin + layoutParams.bottomMargin;
                    measuredHeight = view.getMeasuredHeight() + i282;
                    i26 = View.combineMeasuredStates(i26, view.getMeasuredState());
                    int i292 = ((((layoutParams.O0000OOo >= 0 ? this.mGravity : layoutParams.O0000OOo) & 112) >> 4) & -2) >> 1;
                    iArr2[i292] = Math.max(iArr2[i292], baseline2);
                    iArr[i292] = Math.max(iArr[i292], measuredHeight - baseline2);
                    i23 = Math.max(i23, measuredHeight);
                    if (!z9) {
                    }
                    if (layoutParams.O0000O0o <= 0.0f) {
                    }
                } else {
                    i16 = i21;
                    z3 = z6;
                    z2 = z5;
                    view = virtualChildAt;
                    f2 = f3;
                }
                int i33 = i16;
                i15 = getChildrenSkipCount(view, i33) + i33;
            }
            i21 = i15 + 1;
            iArr3 = iArr;
            f3 = f2;
            z6 = z3;
            z5 = z2;
            i20 = 1073741824;
        }
        boolean z11 = z6;
        boolean z12 = z5;
        int i34 = i23;
        int i35 = i24;
        int i36 = i25;
        int i37 = i26;
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        if (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
            i4 = i34;
            i3 = i37;
        } else {
            i3 = i37;
            i4 = Math.max(i34, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        }
        if (z11 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.mTotalLength = 0;
            int i38 = 0;
            while (i38 < virtualChildCount) {
                View virtualChildAt2 = getVirtualChildAt(i38);
                if (virtualChildAt2 == null) {
                    this.mTotalLength += measureNullChild(i38);
                } else if (virtualChildAt2.getVisibility() == 8) {
                    i38 += getChildrenSkipCount(virtualChildAt2, i38);
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                    if (z7) {
                        this.mTotalLength += layoutParams2.leftMargin + i22 + layoutParams2.rightMargin + getNextLocationOffset(virtualChildAt2);
                    } else {
                        int i39 = this.mTotalLength;
                        i14 = i4;
                        this.mTotalLength = Math.max(i39, i39 + i22 + layoutParams2.leftMargin + layoutParams2.rightMargin + getNextLocationOffset(virtualChildAt2));
                        i38++;
                        i4 = i14;
                    }
                }
                i14 = i4;
                i38++;
                i4 = i14;
            }
        }
        int i40 = i4;
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumWidth()), i19, 0);
        int i41 = (16777215 & resolveSizeAndState) - this.mTotalLength;
        if (z8 || (i41 != 0 && f3 > 0.0f)) {
            float f4 = this.mWeightSum;
            if (f4 > 0.0f) {
                f3 = f4;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.mTotalLength = 0;
            int i42 = i35;
            int i43 = i3;
            int i44 = -1;
            float f5 = f3;
            int i45 = 0;
            while (i45 < virtualChildCount) {
                View virtualChildAt3 = getVirtualChildAt(i45);
                if (virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8) {
                    i11 = i41;
                    i10 = virtualChildCount;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f6 = layoutParams3.O0000O0o;
                    if (f6 > 0.0f) {
                        int i46 = (int) ((((float) i41) * f6) / f5);
                        float f7 = f5 - f6;
                        int i47 = i41 - i46;
                        i10 = virtualChildCount;
                        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + layoutParams3.topMargin + layoutParams3.bottomMargin, layoutParams3.height);
                        if (layoutParams3.width != 0 || mode != 1073741824) {
                            i13 = virtualChildAt3.getMeasuredWidth() + i46;
                        } else if (i46 > 0) {
                            i13 = i46;
                            virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(i13, 1073741824), childMeasureSpec);
                            i43 = View.combineMeasuredStates(i43, virtualChildAt3.getMeasuredState() & -16777216);
                            f5 = f7;
                            i11 = i47;
                        }
                        i13 = 0;
                        virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(i13, 1073741824), childMeasureSpec);
                        i43 = View.combineMeasuredStates(i43, virtualChildAt3.getMeasuredState() & -16777216);
                        f5 = f7;
                        i11 = i47;
                    } else {
                        i11 = i41;
                        i10 = virtualChildCount;
                    }
                    if (z7) {
                        this.mTotalLength += virtualChildAt3.getMeasuredWidth() + layoutParams3.leftMargin + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt3);
                        f = f5;
                    } else {
                        int i48 = this.mTotalLength;
                        f = f5;
                        this.mTotalLength = Math.max(i48, virtualChildAt3.getMeasuredWidth() + i48 + layoutParams3.leftMargin + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt3));
                    }
                    boolean z13 = mode2 != 1073741824 && layoutParams3.height == -1;
                    int i49 = layoutParams3.topMargin + layoutParams3.bottomMargin;
                    int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i49;
                    i44 = Math.max(i44, measuredHeight2);
                    if (!z13) {
                        i49 = measuredHeight2;
                    }
                    int max = Math.max(i42, i49);
                    if (z9) {
                        i12 = -1;
                        if (layoutParams3.height == -1) {
                            z = true;
                            if (!z12 && (baseline = virtualChildAt3.getBaseline()) != i12) {
                                int i50 = ((((layoutParams3.O0000OOo < 0 ? this.mGravity : layoutParams3.O0000OOo) & 112) >> 4) & -2) >> 1;
                                iArr2[i50] = Math.max(iArr2[i50], baseline);
                                iArr[i50] = Math.max(iArr[i50], measuredHeight2 - baseline);
                            }
                            i42 = max;
                            z9 = z;
                            f5 = f;
                        }
                    } else {
                        i12 = -1;
                    }
                    z = false;
                    if (!z12) {
                    }
                    i42 = max;
                    z9 = z;
                    f5 = f;
                }
                i45++;
                i41 = i11;
                virtualChildCount = i10;
            }
            i6 = i2;
            i5 = virtualChildCount;
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            if (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
                i9 = i44;
            } else {
                i9 = Math.max(i44, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            }
            i7 = i9;
            i3 = i43;
            i8 = i42;
        } else {
            i8 = Math.max(i35, i36);
            if (z11 && mode != 1073741824) {
                for (int i51 = 0; i51 < virtualChildCount; i51++) {
                    View virtualChildAt4 = getVirtualChildAt(i51);
                    if (!(virtualChildAt4 == null || virtualChildAt4.getVisibility() == 8 || ((LayoutParams) virtualChildAt4.getLayoutParams()).O0000O0o <= 0.0f)) {
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(i22, 1073741824), View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i6 = i2;
            i5 = virtualChildCount;
            i7 = i40;
        }
        if (z9 || mode2 == 1073741824) {
            i8 = i7;
        }
        setMeasuredDimension(resolveSizeAndState | (i3 & -16777216), View.resolveSizeAndState(Math.max(i8 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i6, i3 << 16));
        if (z10) {
            forceUniformHeight(i5, i);
        }
    }

    private void forceUniformHeight(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, makeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: package-private */
    public void layoutVertical(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int paddingLeft = getPaddingLeft();
        int i9 = i3 - i;
        int paddingRight = i9 - getPaddingRight();
        int paddingRight2 = (i9 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i10 = this.mGravity;
        int i11 = i10 & 112;
        int i12 = i10 & 8388615;
        if (i11 == 16) {
            i5 = getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
        } else if (i11 != 80) {
            i5 = getPaddingTop();
        } else {
            i5 = ((getPaddingTop() + i4) - i2) - this.mTotalLength;
        }
        int i13 = 0;
        while (i13 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i13);
            if (virtualChildAt == null) {
                i5 += measureNullChild(i13);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i14 = layoutParams.O0000OOo;
                if (i14 < 0) {
                    i14 = i12;
                }
                int O000000o2 = bk.O000000o(i14, cb.O0000Oo0(this)) & 7;
                if (O000000o2 == 1) {
                    i7 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                    i6 = layoutParams.rightMargin;
                    i8 = i7 - i6;
                } else if (O000000o2 != 5) {
                    i8 = layoutParams.leftMargin + paddingLeft;
                } else {
                    i7 = paddingRight - measuredWidth;
                    i6 = layoutParams.rightMargin;
                    i8 = i7 - i6;
                }
                int i15 = i8;
                if (hasDividerBeforeChildAt(i13)) {
                    i5 += this.mDividerHeight;
                }
                int i16 = i5 + layoutParams.topMargin;
                setChildFrame(virtualChildAt, i15, i16 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                i13 += getChildrenSkipCount(virtualChildAt, i13);
                i5 = i16 + measuredHeight + layoutParams.bottomMargin + getNextLocationOffset(virtualChildAt);
            }
            i13++;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fd  */
    public void layoutHorizontal(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean O000000o2 = o00.O000000o(this);
        int paddingTop = getPaddingTop();
        int i16 = i4 - i2;
        int paddingBottom = i16 - getPaddingBottom();
        int paddingBottom2 = (i16 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i17 = this.mGravity;
        int i18 = i17 & 112;
        boolean z = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int O000000o3 = bk.O000000o(8388615 & i17, cb.O0000Oo0(this));
        if (O000000o3 == 1) {
            i5 = getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
        } else if (O000000o3 != 5) {
            i5 = getPaddingLeft();
        } else {
            i5 = ((getPaddingLeft() + i3) - i) - this.mTotalLength;
        }
        if (O000000o2) {
            i7 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i7 = 0;
            i6 = 1;
        }
        int i19 = 0;
        while (i19 < virtualChildCount) {
            int i20 = i7 + (i6 * i19);
            View virtualChildAt = getVirtualChildAt(i20);
            if (virtualChildAt == null) {
                i5 += measureNullChild(i20);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (z) {
                    i11 = i19;
                    i10 = virtualChildCount;
                    if (layoutParams.height != -1) {
                        i12 = virtualChildAt.getBaseline();
                        i13 = layoutParams.O0000OOo;
                        if (i13 < 0) {
                            i13 = i18;
                        }
                        i14 = i13 & 112;
                        i9 = i18;
                        if (i14 != 16) {
                            i15 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + layoutParams.topMargin) - layoutParams.bottomMargin;
                        } else if (i14 == 48) {
                            int i21 = layoutParams.topMargin + paddingTop;
                            if (i12 != -1) {
                                i21 += iArr[1] - i12;
                            }
                            i15 = i21;
                        } else if (i14 != 80) {
                            i15 = paddingTop;
                        } else {
                            int i22 = (paddingBottom - measuredHeight) - layoutParams.bottomMargin;
                            if (i12 != -1) {
                                i22 -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - i12);
                            }
                            i15 = i22;
                        }
                        if (hasDividerBeforeChildAt(i20)) {
                            i5 += this.mDividerWidth;
                        }
                        int i23 = layoutParams.leftMargin + i5;
                        View view = virtualChildAt;
                        int i24 = i20;
                        i8 = paddingTop;
                        setChildFrame(view, i23 + getLocationOffset(virtualChildAt), i15, measuredWidth, measuredHeight);
                        int i25 = measuredWidth + layoutParams.rightMargin;
                        View view2 = view;
                        i19 = i11 + getChildrenSkipCount(view2, i24);
                        i5 = i23 + i25 + getNextLocationOffset(view2);
                        i19++;
                        virtualChildCount = i10;
                        i18 = i9;
                        paddingTop = i8;
                    }
                } else {
                    i11 = i19;
                    i10 = virtualChildCount;
                }
                i12 = -1;
                i13 = layoutParams.O0000OOo;
                if (i13 < 0) {
                }
                i14 = i13 & 112;
                i9 = i18;
                if (i14 != 16) {
                }
                if (hasDividerBeforeChildAt(i20)) {
                }
                int i232 = layoutParams.leftMargin + i5;
                View view3 = virtualChildAt;
                int i242 = i20;
                i8 = paddingTop;
                setChildFrame(view3, i232 + getLocationOffset(virtualChildAt), i15, measuredWidth, measuredHeight);
                int i252 = measuredWidth + layoutParams.rightMargin;
                View view22 = view3;
                i19 = i11 + getChildrenSkipCount(view22, i242);
                i5 = i232 + i252 + getNextLocationOffset(view22);
                i19++;
                virtualChildCount = i10;
                i18 = i9;
                paddingTop = i8;
            }
            i8 = paddingTop;
            i10 = virtualChildCount;
            i9 = i18;
            i19++;
            virtualChildCount = i10;
            i18 = i9;
            paddingTop = i8;
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.mGravity;
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.mGravity;
        if ((8388615 & i3) != i2) {
            this.mGravity = i2 | (-8388616 & i3);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.mGravity;
        if ((i3 & 112) != i2) {
            this.mGravity = i2 | (i3 & -113);
            requestLayout();
        }
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        int i = this.mOrientation;
        if (i == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public float O0000O0o;
        public int O0000OOo;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.O0000OOo = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842931, 16842996, 16842997, 16843137});
            this.O0000O0o = obtainStyledAttributes.getFloat(3, 0.0f);
            this.O0000OOo = obtainStyledAttributes.getInt(0, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.O0000OOo = -1;
            this.O0000O0o = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.O0000OOo = -1;
        }
    }
}
