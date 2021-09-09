package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.xiaomi.smarthome.R;

public class LimitedFrameLayout extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f9200O000000o;
    private int O00000Oo;

    public LimitedFrameLayout(Context context) {
        super(context);
    }

    public LimitedFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context, attributeSet);
    }

    public LimitedFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context, attributeSet);
    }

    private void O000000o(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.Max_Height, R.attr.Max_Width}, 0, 0);
        try {
            this.f9200O000000o = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.O00000Oo = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.f9200O000000o;
        if (size > i3 && i3 > 0) {
            i = View.MeasureSpec.makeMeasureSpec(i3, View.MeasureSpec.getMode(i));
        }
        int i4 = this.O00000Oo;
        if (size2 > i4 && i4 > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i4, View.MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setMaxWidth(int i) {
        this.f9200O000000o = i;
        invalidate();
        requestLayout();
    }

    public void setMaxHeight(int i) {
        this.O00000Oo = i;
        invalidate();
        requestLayout();
    }
}
