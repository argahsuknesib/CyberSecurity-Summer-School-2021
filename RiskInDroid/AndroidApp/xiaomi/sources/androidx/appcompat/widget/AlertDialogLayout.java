package androidx.appcompat.widget;

import _m_j.bk;
import _m_j.cb;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.xiaomi.smarthome.R;

public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009d  */
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
                int i14 = layoutParams.O0000OOo;
                if (i14 < 0) {
                    i14 = i12;
                }
                int O000000o2 = bk.O000000o(i14, cb.O0000Oo0(this)) & 7;
                if (O000000o2 == 1) {
                    i9 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                    i8 = layoutParams.rightMargin;
                } else if (O000000o2 != 5) {
                    i7 = layoutParams.leftMargin + paddingLeft;
                    if (hasDividerBeforeChildAt(i13)) {
                        i5 += i6;
                    }
                    int i15 = i5 + layoutParams.topMargin;
                    childAt.layout(i7, i15, measuredWidth + i7, i15 + measuredHeight2);
                    i5 = i15 + measuredHeight2 + layoutParams.bottomMargin;
                } else {
                    i9 = paddingRight - measuredWidth;
                    i8 = layoutParams.rightMargin;
                }
                i7 = i9 - i8;
                if (hasDividerBeforeChildAt(i13)) {
                }
                int i152 = i5 + layoutParams.topMargin;
                childAt.layout(i7, i152, measuredWidth + i7, i152 + measuredHeight2);
                i5 = i152 + measuredHeight2 + layoutParams.bottomMargin;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = i;
        int childCount = getChildCount();
        boolean z = false;
        View view = null;
        View view2 = null;
        View view3 = null;
        int i9 = 0;
        while (true) {
            if (i9 < childCount) {
                View childAt = getChildAt(i9);
                if (childAt.getVisibility() != 8) {
                    int id = childAt.getId();
                    if (id == R.id.topPanel) {
                        view = childAt;
                    } else if (id == R.id.buttonPanel) {
                        view2 = childAt;
                    } else if ((id == R.id.contentPanel || id == R.id.customPanel) && view3 == null) {
                        view3 = childAt;
                    }
                }
                i9++;
            } else {
                int mode = View.MeasureSpec.getMode(i2);
                int size = View.MeasureSpec.getSize(i2);
                int mode2 = View.MeasureSpec.getMode(i);
                int paddingTop = getPaddingTop() + getPaddingBottom();
                if (view != null) {
                    view.measure(i8, 0);
                    paddingTop += view.getMeasuredHeight();
                    i3 = View.combineMeasuredStates(0, view.getMeasuredState());
                } else {
                    i3 = 0;
                }
                if (view2 != null) {
                    view2.measure(i8, 0);
                    View view4 = view2;
                    while (true) {
                        i4 = cb.O0000o0o(view4);
                        if (i4 <= 0) {
                            if (!(view4 instanceof ViewGroup)) {
                                break;
                            }
                            ViewGroup viewGroup = (ViewGroup) view4;
                            if (viewGroup.getChildCount() != 1) {
                                break;
                            }
                            view4 = viewGroup.getChildAt(0);
                        } else {
                            break;
                        }
                    }
                    i4 = 0;
                    i5 = view2.getMeasuredHeight() - i4;
                    paddingTop += i4;
                    i3 = View.combineMeasuredStates(i3, view2.getMeasuredState());
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
                    i3 = View.combineMeasuredStates(i3, view3.getMeasuredState());
                } else {
                    i6 = 0;
                }
                int i10 = size - paddingTop;
                if (view2 != null) {
                    int i11 = paddingTop - i4;
                    int min = Math.min(i10, i5);
                    if (min > 0) {
                        i10 -= min;
                        i4 += min;
                    }
                    view2.measure(i8, View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
                    paddingTop = i11 + view2.getMeasuredHeight();
                    i3 = View.combineMeasuredStates(i3, view2.getMeasuredState());
                }
                if (view3 != null && i10 > 0) {
                    view3.measure(i8, View.MeasureSpec.makeMeasureSpec(i6 + i10, mode));
                    paddingTop = (paddingTop - i6) + view3.getMeasuredHeight();
                    i3 = View.combineMeasuredStates(i3, view3.getMeasuredState());
                }
                int i12 = 0;
                for (int i13 = 0; i13 < childCount; i13++) {
                    View childAt2 = getChildAt(i13);
                    if (childAt2.getVisibility() != 8) {
                        i12 = Math.max(i12, childAt2.getMeasuredWidth());
                    }
                }
                setMeasuredDimension(View.resolveSizeAndState(i12 + getPaddingLeft() + getPaddingRight(), i8, i3), View.resolveSizeAndState(paddingTop, i2, 0));
                if (mode2 != 1073741824) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
                    for (int i14 = 0; i14 < childCount; i14++) {
                        View childAt3 = getChildAt(i14);
                        if (childAt3.getVisibility() != 8) {
                            LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt3.getLayoutParams();
                            if (layoutParams.width == -1) {
                                int i15 = layoutParams.height;
                                layoutParams.height = childAt3.getMeasuredHeight();
                                measureChildWithMargins(childAt3, makeMeasureSpec, 0, i2, 0);
                                layoutParams.height = i15;
                            }
                        }
                    }
                }
                z = true;
            }
        }
        if (!z) {
            super.onMeasure(i, i2);
        }
    }
}
