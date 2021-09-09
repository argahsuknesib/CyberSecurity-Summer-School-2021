package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(@Nullable Context context) {
        super(context);
    }

    public AlertDialogLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (!tryOnMeasure(i, i2)) {
            super.onMeasure(i, i2);
        }
    }

    private boolean tryOnMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = i;
        int i9 = i2;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == R.id.topPanel) {
                    view = childAt;
                } else if (id == R.id.buttonPanel) {
                    view2 = childAt;
                } else if ((id != R.id.contentPanel && id != R.id.customPanel) || view3 != null) {
                    return false;
                } else {
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i8, 0);
            paddingTop += view.getMeasuredHeight();
            i3 = ViewCompat.combineMeasuredStates(0, ViewCompat.getMeasuredState(view));
        } else {
            i3 = 0;
        }
        if (view2 != null) {
            view2.measure(i8, 0);
            i5 = resolveMinimumHeight(view2);
            i4 = view2.getMeasuredHeight() - i5;
            paddingTop += i5;
            i3 = ViewCompat.combineMeasuredStates(i3, ViewCompat.getMeasuredState(view2));
        } else {
            i5 = 0;
            i4 = 0;
        }
        if (view3 != null) {
            if (mode == 0) {
                i7 = 0;
            } else {
                i7 = View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode);
            }
            view3.measure(i8, i7);
            i6 = view3.getMeasuredHeight();
            paddingTop += i6;
            i3 = ViewCompat.combineMeasuredStates(i3, ViewCompat.getMeasuredState(view3));
        } else {
            i6 = 0;
        }
        int i11 = size - paddingTop;
        if (view2 != null) {
            int i12 = paddingTop - i5;
            int min = Math.min(i11, i4);
            if (min > 0) {
                i11 -= min;
                i5 += min;
            }
            view2.measure(i8, View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
            paddingTop = i12 + view2.getMeasuredHeight();
            i3 = ViewCompat.combineMeasuredStates(i3, ViewCompat.getMeasuredState(view2));
        }
        if (view3 != null && i11 > 0) {
            view3.measure(i8, View.MeasureSpec.makeMeasureSpec(i6 + i11, mode));
            paddingTop = (paddingTop - i6) + view3.getMeasuredHeight();
            i3 = ViewCompat.combineMeasuredStates(i3, ViewCompat.getMeasuredState(view3));
        }
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt2 = getChildAt(i14);
            if (childAt2.getVisibility() != 8) {
                i13 = Math.max(i13, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(i13 + getPaddingLeft() + getPaddingRight(), i8, i3), ViewCompat.resolveSizeAndState(paddingTop, i9, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        forceUniformWidth(childCount, i9);
        return true;
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    private static int resolveMinimumHeight(View view) {
        while (true) {
            int minimumHeight = ViewCompat.getMinimumHeight(view);
            if (minimumHeight <= 0) {
                if (!(view instanceof ViewGroup)) {
                    break;
                }
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup.getChildCount() != 1) {
                    break;
                }
                view = viewGroup.getChildAt(0);
            } else {
                return minimumHeight;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a8  */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int paddingLeft = getPaddingLeft();
        int i10 = i3 - i;
        int paddingRight = i10 - getPaddingRight();
        int paddingRight2 = (i10 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i11 = gravity & 112;
        int i12 = gravity & 8388615;
        if (i11 == 16) {
            i5 = getPaddingTop() + (((i4 - i2) - measuredHeight) / 2);
        } else if (i11 != 80) {
            i5 = getPaddingTop();
        } else {
            i5 = ((getPaddingTop() + i4) - i2) - measuredHeight;
        }
        Drawable dividerDrawable = getDividerDrawable();
        if (dividerDrawable == null) {
            i6 = 0;
        } else {
            i6 = dividerDrawable.getIntrinsicHeight();
        }
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                int i14 = layoutParams.gravity;
                if (i14 < 0) {
                    i14 = i12;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i14, ViewCompat.getLayoutDirection(this)) & 7;
                if (absoluteGravity == 1) {
                    i9 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                    i8 = layoutParams.rightMargin;
                } else if (absoluteGravity != 5) {
                    i7 = layoutParams.leftMargin + paddingLeft;
                    if (hasDividerBeforeChildAt(i13)) {
                        i5 += i6;
                    }
                    int i15 = i5 + layoutParams.topMargin;
                    setChildFrame(childAt, i7, i15, measuredWidth, measuredHeight2);
                    i5 = i15 + measuredHeight2 + layoutParams.bottomMargin;
                } else {
                    i9 = paddingRight - measuredWidth;
                    i8 = layoutParams.rightMargin;
                }
                i7 = i9 - i8;
                if (hasDividerBeforeChildAt(i13)) {
                }
                int i152 = i5 + layoutParams.topMargin;
                setChildFrame(childAt, i7, i152, measuredWidth, measuredHeight2);
                i5 = i152 + measuredHeight2 + layoutParams.bottomMargin;
            }
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }
}
