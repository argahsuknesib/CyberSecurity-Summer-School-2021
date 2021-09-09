package com.xiaomi.mico.common.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;

public class LimitHeightRecyclerView extends RecyclerView {
    private int mLimitHeight;

    public LimitHeightRecyclerView(Context context) {
        this(context, null);
    }

    public LimitHeightRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LimitHeightRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLimitHeight = 600;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.mc_maxHeight});
            this.mLimitHeight = obtainStyledAttributes.getDimensionPixelSize(0, 600);
            obtainStyledAttributes.recycle();
        }
    }

    public void onMeasure(int i, int i2) {
        int i3 = this.mLimitHeight;
        if (i3 > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }
}
