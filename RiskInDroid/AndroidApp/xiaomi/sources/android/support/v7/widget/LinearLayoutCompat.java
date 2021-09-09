package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.xiaomi.smarthome.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

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

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

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

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, new int[]{16842927, 16842948, 16843046, 16843047, 16843048, R.attr.divider, R.attr.dividerPadding, R.attr.measureWithLargestChild, R.attr.showDividers}, i, 0);
        int i2 = obtainStyledAttributes.getInt(1, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = obtainStyledAttributes.getInt(0, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = obtainStyledAttributes.getBoolean(2, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(4, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(3, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(7, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(5));
        this.mShowDividers = obtainStyledAttributes.getInt(8, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        obtainStyledAttributes.recycle();
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

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
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
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i5 = 0; i5 < virtualChildCount; i5++) {
            View virtualChildAt = getVirtualChildAt(i5);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i5))) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (isLayoutRtl) {
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
                if (isLayoutRtl) {
                    i3 = virtualChildAt2.getLeft() - layoutParams2.leftMargin;
                    i2 = this.mDividerWidth;
                } else {
                    i = virtualChildAt2.getRight() + layoutParams2.rightMargin;
                    drawVerticalDivider(canvas, i);
                }
            } else if (isLayoutRtl) {
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
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0335  */
    public void measureVertical(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        float f;
        int i10;
        boolean z;
        int i11;
        int i12;
        int i13;
        int i14;
        float f2;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        View view;
        int i21;
        LayoutParams layoutParams;
        int i22;
        boolean z2;
        int i23;
        int i24 = 0;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i25 = this.mBaselineAlignedChildIndex;
        boolean z3 = this.mUseLargestChild;
        float f3 = 0.0f;
        int i26 = 0;
        int i27 = Integer.MIN_VALUE;
        int i28 = 0;
        int i29 = 0;
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = false;
        int i30 = 0;
        while (i29 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i29);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i29);
                f2 = f3;
                i17 = i29;
                i15 = virtualChildCount;
                i14 = i30;
                i16 = mode2;
            } else {
                int i31 = i26;
                if (virtualChildAt.getVisibility() != 8) {
                    if (hasDividerBeforeChildAt(i29)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt.getLayoutParams();
                    f2 = f3 + layoutParams2.weight;
                    if (mode2 == 1073741824 && layoutParams2.height == 0 && layoutParams2.weight > 0.0f) {
                        int i32 = this.mTotalLength;
                        this.mTotalLength = Math.max(i32, layoutParams2.topMargin + i32 + layoutParams2.bottomMargin);
                        i21 = i28;
                        view = virtualChildAt;
                        i15 = virtualChildCount;
                        i14 = i30;
                        i22 = i31;
                        i27 = i27;
                        z4 = true;
                        i19 = i29;
                        i16 = mode2;
                        layoutParams = layoutParams2;
                    } else {
                        int i33 = i27;
                        if (layoutParams2.height != 0 || layoutParams2.weight <= 0.0f) {
                            i23 = Integer.MIN_VALUE;
                        } else {
                            layoutParams2.height = -2;
                            i23 = 0;
                        }
                        i22 = i31;
                        int i34 = i33;
                        View view2 = virtualChildAt;
                        i15 = virtualChildCount;
                        int i35 = i30;
                        i16 = mode2;
                        i19 = i29;
                        i21 = i28;
                        i14 = i35;
                        layoutParams = layoutParams2;
                        measureChildBeforeLayout(virtualChildAt, i29, i, 0, i2, f2 == 0.0f ? this.mTotalLength : 0);
                        int i36 = i23;
                        if (i36 != Integer.MIN_VALUE) {
                            layoutParams.height = i36;
                        }
                        int measuredHeight = view2.getMeasuredHeight();
                        int i37 = this.mTotalLength;
                        view = view2;
                        this.mTotalLength = Math.max(i37, i37 + measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin + getNextLocationOffset(view));
                        i27 = z3 ? Math.max(measuredHeight, i34) : i34;
                    }
                    if (i25 >= 0 && i25 == i19 + 1) {
                        this.mBaselineChildTop = this.mTotalLength;
                    }
                    if (i19 >= i25 || layoutParams.weight <= 0.0f) {
                        if (mode == 1073741824 || layoutParams.width != -1) {
                            z2 = false;
                        } else {
                            z2 = true;
                            z6 = true;
                        }
                        int i38 = layoutParams.leftMargin + layoutParams.rightMargin;
                        int measuredWidth = view.getMeasuredWidth() + i38;
                        i20 = Math.max(i22, measuredWidth);
                        i24 = ViewUtils.combineMeasuredStates(i24, ViewCompat.getMeasuredState(view));
                        z5 = z5 && layoutParams.width == -1;
                        if (layoutParams.weight > 0.0f) {
                            if (!z2) {
                                i38 = measuredWidth;
                            }
                            i18 = Math.max(i21, i38);
                        } else {
                            i18 = i21;
                            if (z2) {
                                measuredWidth = i38;
                            }
                            i14 = Math.max(i14, measuredWidth);
                        }
                    } else {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                } else {
                    i15 = virtualChildCount;
                    int i39 = i30;
                    i19 = i29;
                    i16 = mode2;
                    i18 = i28;
                    view = virtualChildAt;
                    f2 = f3;
                    i14 = i39;
                    i20 = i31;
                }
                i17 = getChildrenSkipCount(view, i19) + i19;
                i26 = i20;
                i28 = i18;
            }
            i29 = i17 + 1;
            mode2 = i16;
            virtualChildCount = i15;
            f3 = f2;
            i30 = i14;
        }
        int i40 = i26;
        int i41 = i27;
        int i42 = virtualChildCount;
        int i43 = i30;
        int i44 = mode2;
        int i45 = i28;
        if (this.mTotalLength > 0) {
            i3 = i42;
            if (hasDividerBeforeChildAt(i3)) {
                this.mTotalLength += this.mDividerHeight;
            }
        } else {
            i3 = i42;
        }
        if (z3) {
            i4 = i44;
            if (i4 == Integer.MIN_VALUE || i4 == 0) {
                this.mTotalLength = 0;
                int i46 = 0;
                while (i46 < i3) {
                    View virtualChildAt2 = getVirtualChildAt(i46);
                    if (virtualChildAt2 == null) {
                        this.mTotalLength += measureNullChild(i46);
                        i13 = i46;
                    } else if (virtualChildAt2.getVisibility() == 8) {
                        i12 = i46 + getChildrenSkipCount(virtualChildAt2, i46);
                        i46 = i12 + 1;
                    } else {
                        LayoutParams layoutParams3 = (LayoutParams) virtualChildAt2.getLayoutParams();
                        int i47 = this.mTotalLength;
                        i13 = i46;
                        this.mTotalLength = Math.max(i47, i47 + i41 + layoutParams3.topMargin + layoutParams3.bottomMargin + getNextLocationOffset(virtualChildAt2));
                    }
                    i12 = i13;
                    i46 = i12 + 1;
                }
            }
        } else {
            i4 = i44;
        }
        this.mTotalLength += getPaddingTop() + getPaddingBottom();
        int i48 = i2;
        int i49 = i45;
        int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumHeight()), i48, 0);
        int i50 = (16777215 & resolveSizeAndState) - this.mTotalLength;
        if (z4 || (i50 != 0 && f3 > 0.0f)) {
            float f4 = this.mWeightSum;
            if (f4 > 0.0f) {
                f3 = f4;
            }
            this.mTotalLength = 0;
            float f5 = f3;
            int i51 = 0;
            int i52 = i40;
            int i53 = i43;
            i6 = i52;
            while (i51 < i3) {
                View virtualChildAt3 = getVirtualChildAt(i51);
                if (virtualChildAt3.getVisibility() != 8) {
                    LayoutParams layoutParams4 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f6 = layoutParams4.weight;
                    if (f6 > 0.0f) {
                        int i54 = (int) ((((float) i50) * f6) / f5);
                        f = f5 - f6;
                        int i55 = i50 - i54;
                        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams4.leftMargin + layoutParams4.rightMargin, layoutParams4.width);
                        if (layoutParams4.height != 0 || i4 != 1073741824) {
                            int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i54;
                            if (measuredHeight2 < 0) {
                                measuredHeight2 = 0;
                            }
                            i54 = measuredHeight2;
                        } else if (i54 <= 0) {
                            i11 = 1073741824;
                            i54 = 0;
                            virtualChildAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i54, i11));
                            i24 = ViewUtils.combineMeasuredStates(i24, ViewCompat.getMeasuredState(virtualChildAt3) & -256);
                            i9 = i55;
                        }
                        i11 = 1073741824;
                        virtualChildAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i54, i11));
                        i24 = ViewUtils.combineMeasuredStates(i24, ViewCompat.getMeasuredState(virtualChildAt3) & -256);
                        i9 = i55;
                    } else {
                        i9 = i50;
                        f = f5;
                    }
                    int i56 = layoutParams4.leftMargin + layoutParams4.rightMargin;
                    int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i56;
                    int max = Math.max(i6, measuredWidth2);
                    if (mode != 1073741824) {
                        i8 = i4;
                        i10 = -1;
                        if (layoutParams4.width == -1) {
                            z = true;
                            if (z) {
                                measuredWidth2 = i56;
                            }
                            int max2 = Math.max(i53, measuredWidth2);
                            boolean z7 = !z5 && layoutParams4.width == i10;
                            int i57 = this.mTotalLength;
                            this.mTotalLength = Math.max(i57, virtualChildAt3.getMeasuredHeight() + i57 + layoutParams4.topMargin + layoutParams4.bottomMargin + getNextLocationOffset(virtualChildAt3));
                            z5 = z7;
                            f5 = f;
                            i53 = max2;
                            i6 = max;
                        }
                    } else {
                        i8 = i4;
                        i10 = -1;
                    }
                    z = false;
                    if (z) {
                    }
                    int max22 = Math.max(i53, measuredWidth2);
                    if (!z5) {
                    }
                    int i572 = this.mTotalLength;
                    this.mTotalLength = Math.max(i572, virtualChildAt3.getMeasuredHeight() + i572 + layoutParams4.topMargin + layoutParams4.bottomMargin + getNextLocationOffset(virtualChildAt3));
                    z5 = z7;
                    f5 = f;
                    i53 = max22;
                    i6 = max;
                } else {
                    i8 = i4;
                    i9 = i50;
                }
                i51++;
                i50 = i9;
                i4 = i8;
            }
            i5 = i;
            this.mTotalLength += getPaddingTop() + getPaddingBottom();
            i7 = i53;
        } else {
            i7 = Math.max(i43, i49);
            if (z3 && i4 != 1073741824) {
                for (int i58 = 0; i58 < i3; i58++) {
                    View virtualChildAt4 = getVirtualChildAt(i58);
                    if (!(virtualChildAt4 == null || virtualChildAt4.getVisibility() == 8 || ((LayoutParams) virtualChildAt4.getLayoutParams()).weight <= 0.0f)) {
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i41, 1073741824));
                    }
                }
            }
            i5 = i;
            i6 = i40;
        }
        if (z5 || mode == 1073741824) {
            i7 = i6;
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(i7 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i5, i24), resolveSizeAndState);
        if (z6) {
            forceUniformWidth(i3, i48);
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
    /* JADX WARNING: Removed duplicated region for block: B:180:0x043b  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x043e  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01da  */
    public void measureHorizontal(int i, int i2) {
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        int baseline;
        boolean z2;
        boolean z3;
        int i9;
        int i10;
        int i11;
        View view;
        LayoutParams layoutParams;
        int i12;
        int i13;
        boolean z4;
        int measuredHeight;
        int baseline2;
        int i14;
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
        int i15 = 1073741824;
        boolean z7 = mode == 1073741824;
        int i16 = 0;
        int i17 = Integer.MIN_VALUE;
        float f = 0.0f;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        boolean z8 = false;
        int i21 = 0;
        boolean z9 = true;
        boolean z10 = false;
        while (true) {
            iArr = iArr3;
            i3 = 8;
            if (i16 >= virtualChildCount) {
                break;
            }
            View virtualChildAt = getVirtualChildAt(i16);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i16);
                i9 = i16;
                z3 = z6;
                z2 = z5;
            } else {
                if (virtualChildAt.getVisibility() != 8) {
                    if (hasDividerBeforeChildAt(i16)) {
                        this.mTotalLength += this.mDividerWidth;
                    }
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt.getLayoutParams();
                    f += layoutParams2.weight;
                    if (mode == i15 && layoutParams2.width == 0 && layoutParams2.weight > 0.0f) {
                        if (z7) {
                            this.mTotalLength += layoutParams2.leftMargin + layoutParams2.rightMargin;
                        } else {
                            int i22 = this.mTotalLength;
                            this.mTotalLength = Math.max(i22, layoutParams2.leftMargin + i22 + layoutParams2.rightMargin);
                        }
                        if (z5) {
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                            virtualChildAt.measure(makeMeasureSpec, makeMeasureSpec);
                            i10 = i16;
                            z3 = z6;
                            z2 = z5;
                            layoutParams = layoutParams2;
                            view = virtualChildAt;
                            i12 = -1;
                        } else {
                            i10 = i16;
                            z3 = z6;
                            z2 = z5;
                            layoutParams = layoutParams2;
                            view = virtualChildAt;
                            i13 = 1073741824;
                            i12 = -1;
                            z8 = true;
                            if (mode2 == i13 && layoutParams.height == i12) {
                                z4 = true;
                                z10 = true;
                            } else {
                                z4 = false;
                            }
                            int i23 = layoutParams.topMargin + layoutParams.bottomMargin;
                            measuredHeight = view.getMeasuredHeight() + i23;
                            i21 = ViewUtils.combineMeasuredStates(i21, ViewCompat.getMeasuredState(view));
                            if (z2 && (baseline2 = view.getBaseline()) != i12) {
                                int i24 = ((((layoutParams.gravity >= 0 ? this.mGravity : layoutParams.gravity) & 112) >> 4) & -2) >> 1;
                                iArr2[i24] = Math.max(iArr2[i24], baseline2);
                                iArr[i24] = Math.max(iArr[i24], measuredHeight - baseline2);
                            }
                            i18 = Math.max(i18, measuredHeight);
                            z9 = !z9 && layoutParams.height == i12;
                            if (layoutParams.weight <= 0.0f) {
                                if (!z4) {
                                    i23 = measuredHeight;
                                }
                                i11 = Math.max(i20, i23);
                            } else {
                                i11 = i20;
                                if (z4) {
                                    measuredHeight = i23;
                                }
                                i19 = Math.max(i19, measuredHeight);
                            }
                        }
                    } else {
                        if (layoutParams2.width != 0 || layoutParams2.weight <= 0.0f) {
                            i14 = Integer.MIN_VALUE;
                        } else {
                            layoutParams2.width = -2;
                            i14 = 0;
                        }
                        i10 = i16;
                        int i25 = i14;
                        z3 = z6;
                        z2 = z5;
                        layoutParams = layoutParams2;
                        i12 = -1;
                        View view2 = virtualChildAt;
                        measureChildBeforeLayout(virtualChildAt, i10, i, f == 0.0f ? this.mTotalLength : 0, i2, 0);
                        if (i25 != Integer.MIN_VALUE) {
                            layoutParams.width = i25;
                        }
                        int measuredWidth = view2.getMeasuredWidth();
                        if (z7) {
                            view = view2;
                            this.mTotalLength += layoutParams.leftMargin + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(view);
                        } else {
                            view = view2;
                            int i26 = this.mTotalLength;
                            this.mTotalLength = Math.max(i26, i26 + measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin + getNextLocationOffset(view));
                        }
                        if (z3) {
                            i17 = Math.max(measuredWidth, i17);
                        }
                    }
                    i13 = 1073741824;
                    if (mode2 == i13) {
                    }
                    z4 = false;
                    int i232 = layoutParams.topMargin + layoutParams.bottomMargin;
                    measuredHeight = view.getMeasuredHeight() + i232;
                    i21 = ViewUtils.combineMeasuredStates(i21, ViewCompat.getMeasuredState(view));
                    int i242 = ((((layoutParams.gravity >= 0 ? this.mGravity : layoutParams.gravity) & 112) >> 4) & -2) >> 1;
                    iArr2[i242] = Math.max(iArr2[i242], baseline2);
                    iArr[i242] = Math.max(iArr[i242], measuredHeight - baseline2);
                    i18 = Math.max(i18, measuredHeight);
                    if (!z9) {
                    }
                    if (layoutParams.weight <= 0.0f) {
                    }
                } else {
                    i10 = i16;
                    z3 = z6;
                    z2 = z5;
                    view = virtualChildAt;
                    i11 = i20;
                }
                int i27 = i10;
                i9 = getChildrenSkipCount(view, i27) + i27;
                i20 = i11;
            }
            i16 = i9 + 1;
            iArr3 = iArr;
            z6 = z3;
            z5 = z2;
            i15 = 1073741824;
        }
        boolean z11 = z6;
        boolean z12 = z5;
        int i28 = i18;
        int i29 = i19;
        int i30 = i20;
        int i31 = i21;
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        if (!(iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1)) {
            i28 = Math.max(i28, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        }
        if (z11 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.mTotalLength = 0;
            int i32 = 0;
            while (i32 < virtualChildCount) {
                View virtualChildAt2 = getVirtualChildAt(i32);
                if (virtualChildAt2 == null) {
                    this.mTotalLength += measureNullChild(i32);
                } else if (virtualChildAt2.getVisibility() == i3) {
                    i32 += getChildrenSkipCount(virtualChildAt2, i32);
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt2.getLayoutParams();
                    if (z7) {
                        this.mTotalLength += layoutParams3.leftMargin + i17 + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt2);
                    } else {
                        int i33 = this.mTotalLength;
                        this.mTotalLength = Math.max(i33, i33 + i17 + layoutParams3.leftMargin + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt2));
                    }
                }
                i32++;
                i3 = 8;
            }
        }
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumWidth()), i, 0);
        int i34 = (16777215 & resolveSizeAndState) - this.mTotalLength;
        if (z8 || (i34 != 0 && f > 0.0f)) {
            float f2 = this.mWeightSum;
            if (f2 > 0.0f) {
                f = f2;
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
            int i35 = i29;
            i4 = -1;
            for (int i36 = 0; i36 < virtualChildCount; i36++) {
                View virtualChildAt3 = getVirtualChildAt(i36);
                if (virtualChildAt3 != null && virtualChildAt3.getVisibility() != 8) {
                    LayoutParams layoutParams4 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f3 = layoutParams4.weight;
                    if (f3 > 0.0f) {
                        int i37 = (int) ((((float) i34) * f3) / f);
                        f -= f3;
                        int i38 = i34 - i37;
                        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + layoutParams4.topMargin + layoutParams4.bottomMargin, layoutParams4.height);
                        if (!(layoutParams4.width == 0 && mode == 1073741824) ? (i37 = i37 + virtualChildAt3.getMeasuredWidth()) >= 0 : i37 > 0) {
                            i37 = 0;
                        }
                        virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(i37, 1073741824), childMeasureSpec);
                        i31 = ViewUtils.combineMeasuredStates(i31, ViewCompat.getMeasuredState(virtualChildAt3) & -16777216);
                        i34 = i38;
                    }
                    if (z7) {
                        i7 = i34;
                        this.mTotalLength += virtualChildAt3.getMeasuredWidth() + layoutParams4.leftMargin + layoutParams4.rightMargin + getNextLocationOffset(virtualChildAt3);
                    } else {
                        i7 = i34;
                        int i39 = this.mTotalLength;
                        this.mTotalLength = Math.max(i39, virtualChildAt3.getMeasuredWidth() + i39 + layoutParams4.leftMargin + layoutParams4.rightMargin + getNextLocationOffset(virtualChildAt3));
                    }
                    boolean z13 = mode2 != 1073741824 && layoutParams4.height == -1;
                    int i40 = layoutParams4.topMargin + layoutParams4.bottomMargin;
                    int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i40;
                    i4 = Math.max(i4, measuredHeight2);
                    if (!z13) {
                        i40 = measuredHeight2;
                    }
                    int max = Math.max(i35, i40);
                    if (z9) {
                        i8 = -1;
                        if (layoutParams4.height == -1) {
                            z = true;
                            if (z12 && (baseline = virtualChildAt3.getBaseline()) != i8) {
                                int i41 = ((((layoutParams4.gravity >= 0 ? this.mGravity : layoutParams4.gravity) & 112) >> 4) & -2) >> 1;
                                iArr2[i41] = Math.max(iArr2[i41], baseline);
                                iArr[i41] = Math.max(iArr[i41], measuredHeight2 - baseline);
                            }
                            i35 = max;
                            z9 = z;
                            i34 = i7;
                        }
                    } else {
                        i8 = -1;
                    }
                    z = false;
                    int i412 = ((((layoutParams4.gravity >= 0 ? this.mGravity : layoutParams4.gravity) & 112) >> 4) & -2) >> 1;
                    iArr2[i412] = Math.max(iArr2[i412], baseline);
                    iArr[i412] = Math.max(iArr[i412], measuredHeight2 - baseline);
                    i35 = max;
                    z9 = z;
                    i34 = i7;
                }
            }
            i6 = i2;
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            if (!(iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1)) {
                i4 = Math.max(i4, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            }
            i5 = i35;
        } else {
            i5 = Math.max(i29, i30);
            if (z11 && mode != 1073741824) {
                for (int i42 = 0; i42 < virtualChildCount; i42++) {
                    View virtualChildAt4 = getVirtualChildAt(i42);
                    if (!(virtualChildAt4 == null || virtualChildAt4.getVisibility() == 8 || ((LayoutParams) virtualChildAt4.getLayoutParams()).weight <= 0.0f)) {
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(i17, 1073741824), View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i6 = i2;
        }
        if (z9 || mode2 == 1073741824) {
            i5 = i4;
        }
        setMeasuredDimension(resolveSizeAndState | (-16777216 & i31), ViewCompat.resolveSizeAndState(Math.max(i5 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i6, i31 << 16));
        if (z10) {
            forceUniformHeight(virtualChildCount, i);
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
                int i14 = layoutParams.gravity;
                if (i14 < 0) {
                    i14 = i12;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i14, ViewCompat.getLayoutDirection(this)) & 7;
                if (absoluteGravity == 1) {
                    i7 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                    i6 = layoutParams.rightMargin;
                    i8 = i7 - i6;
                } else if (absoluteGravity != 5) {
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
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
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
        int absoluteGravity = GravityCompat.getAbsoluteGravity(8388615 & i17, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 1) {
            i5 = getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
        } else if (absoluteGravity != 5) {
            i5 = getPaddingLeft();
        } else {
            i5 = ((getPaddingLeft() + i3) - i) - this.mTotalLength;
        }
        if (isLayoutRtl) {
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
                        i13 = layoutParams.gravity;
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
                i13 = layoutParams.gravity;
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
        if (Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842931, 16842996, 16842997, 16843137});
            this.weight = obtainStyledAttributes.getFloat(3, 0.0f);
            this.gravity = obtainStyledAttributes.getInt(0, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.gravity = -1;
            this.weight = f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = -1;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = -1;
            this.weight = layoutParams.weight;
            this.gravity = layoutParams.gravity;
        }
    }
}
