package com.google.android.material.timepicker;

import _m_j.cb;
import _m_j.oOO0OOo0;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;
import com.xiaomi.smarthome.R;

class RadialViewGroup extends ConstraintLayout {
    private MaterialShapeDrawable background;
    private int radius;
    private final Runnable updateLayoutParametersRunnable;

    public RadialViewGroup(Context context) {
        this(context, null);
    }

    public RadialViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RadialViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate((int) R.layout.material_radial_view_group, this);
        cb.O000000o(this, createBackground());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.materialCircleRadius}, i, 0);
        this.radius = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.updateLayoutParametersRunnable = new Runnable() {
            /* class com.google.android.material.timepicker.RadialViewGroup.AnonymousClass1 */

            public void run() {
                RadialViewGroup.this.updateLayoutParams();
            }
        };
        obtainStyledAttributes.recycle();
    }

    private Drawable createBackground() {
        this.background = new MaterialShapeDrawable();
        this.background.setCornerSize(new RelativeCornerSize(0.5f));
        this.background.setFillColor(ColorStateList.valueOf(-1));
        return this.background;
    }

    public void setBackgroundColor(int i) {
        this.background.setFillColor(ColorStateList.valueOf(i));
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            view.setId(cb.O000000o());
        }
        updateLayoutParamsAsync();
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        updateLayoutParamsAsync();
    }

    private void updateLayoutParamsAsync() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.updateLayoutParametersRunnable);
            handler.post(this.updateLayoutParametersRunnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        updateLayoutParams();
    }

    /* access modifiers changed from: protected */
    public void updateLayoutParams() {
        int childCount = getChildCount();
        int i = 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            if (shouldSkipView(getChildAt(i2))) {
                i++;
            }
        }
        oOO0OOo0 ooo0ooo0 = new oOO0OOo0();
        ooo0ooo0.O00000Oo(this);
        float f = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getId() != R.id.circle_center && !shouldSkipView(childAt)) {
                ooo0ooo0.O000000o(childAt.getId(), this.radius, f);
                f += 360.0f / ((float) (childCount - i));
            }
        }
        ooo0ooo0.O00000o0(this);
    }

    public void setRadius(int i) {
        this.radius = i;
        updateLayoutParams();
    }

    public int getRadius() {
        return this.radius;
    }

    private static boolean shouldSkipView(View view) {
        return "skip".equals(view.getTag());
    }
}
