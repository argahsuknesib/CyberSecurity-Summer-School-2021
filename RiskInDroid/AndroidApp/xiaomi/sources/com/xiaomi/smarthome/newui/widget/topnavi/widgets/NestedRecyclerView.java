package com.xiaomi.smarthome.newui.widget.topnavi.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.newui.widget.topnavi.layoutmanager.FlowLayoutManager;

public class NestedRecyclerView extends RecyclerView {
    public NestedRecyclerView(Context context) {
        this(context, null);
    }

    public NestedRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setHasFixedSize(true);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        FlowLayoutManager flowLayoutManager = (FlowLayoutManager) getLayoutManager();
        View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size2 = flowLayoutManager.O000000o() + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, size2);
    }
}
