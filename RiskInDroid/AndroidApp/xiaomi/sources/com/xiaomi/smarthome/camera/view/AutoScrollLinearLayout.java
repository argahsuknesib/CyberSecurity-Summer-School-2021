package com.xiaomi.smarthome.camera.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;

public class AutoScrollLinearLayout extends LinearLayout {
    public AutoScrollLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        super.onLayout(z, i, i2, i3, i4);
        int i5 = getContext().getResources().getDisplayMetrics().widthPixels;
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.camera_bottom_item_margin);
        if (getPaddingLeft() == dimensionPixelOffset && (width = (i5 - getWidth()) / 2) > 0) {
            int i6 = width + dimensionPixelOffset;
            setPadding(i6, getPaddingTop(), i6, getPaddingBottom());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
