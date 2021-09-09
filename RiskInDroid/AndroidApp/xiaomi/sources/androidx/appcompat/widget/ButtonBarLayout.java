package androidx.appcompat.widget;

import _m_j.cb;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;

public class ButtonBarLayout extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f2716O000000o;
    private int O00000Oo = -1;
    private int O00000o0 = 0;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.allowStacking});
        cb.O000000o(this, context, new int[]{R.attr.allowStacking}, attributeSet, obtainStyledAttributes, 0);
        this.f2716O000000o = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }

    public void setAllowStacking(boolean z) {
        if (this.f2716O000000o != z) {
            this.f2716O000000o = z;
            if (!this.f2716O000000o && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        int size = View.MeasureSpec.getSize(i);
        int i4 = 0;
        if (this.f2716O000000o) {
            if (size > this.O00000Oo && O000000o()) {
                setStacked(false);
            }
            this.O00000Oo = size;
        }
        if (O000000o() || View.MeasureSpec.getMode(i) != 1073741824) {
            i3 = i;
            z = false;
        } else {
            i3 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(i3, i2);
        if (this.f2716O000000o && !O000000o()) {
            if ((getMeasuredWidthAndState() & -16777216) == 16777216) {
                setStacked(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(i, i2);
        }
        int O000000o2 = O000000o(0);
        if (O000000o2 >= 0) {
            View childAt = getChildAt(O000000o2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
            if (O000000o()) {
                int O000000o3 = O000000o(O000000o2 + 1);
                if (O000000o3 >= 0) {
                    paddingTop += getChildAt(O000000o3).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                i4 = paddingTop;
            } else {
                i4 = paddingTop + getPaddingBottom();
            }
        }
        if (cb.O0000o0o(this) != i4) {
            setMinimumHeight(i4);
        }
    }

    private int O000000o(int i) {
        int childCount = getChildCount();
        while (i < childCount) {
            if (getChildAt(i).getVisibility() == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int getMinimumHeight() {
        return Math.max(this.O00000o0, super.getMinimumHeight());
    }

    private void setStacked(boolean z) {
        setOrientation(z ? 1 : 0);
        setGravity(z ? 5 : 80);
        View findViewById = findViewById(R.id.spacer);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    private boolean O000000o() {
        return getOrientation() == 1;
    }
}
