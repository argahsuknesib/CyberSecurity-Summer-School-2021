package com.xiaomi.smarthome.newui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;

public class FixHeightRecyclerView extends RecyclerView {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f10306O000000o;

    public FixHeightRecyclerView(Context context) {
        this(context, null);
    }

    public FixHeightRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FixHeightRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10306O000000o = 7;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.maxLines}, 0, i);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 0) {
                this.f10306O000000o = obtainStyledAttributes.getInteger(index, -1);
            }
        }
        if (this.f10306O000000o <= 0) {
            this.f10306O000000o = 7;
        }
        obtainStyledAttributes.recycle();
        setHasFixedSize(true);
    }

    public void onMeasure(int i, int i2) {
        boolean z;
        FlowLayoutCopy flowLayoutCopy;
        int lines;
        super.onMeasure(i, i2);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            z = true;
            if (i3 >= getChildCount()) {
                z = false;
                break;
            }
            View childAt = getChildAt(i3);
            if ((childAt instanceof FlowLayoutCopy) && (lines = (flowLayoutCopy = (FlowLayoutCopy) childAt).getLines()) != 0) {
                int i6 = i4 + lines;
                int i7 = this.f10306O000000o;
                if (i6 > i7) {
                    i5 += (i7 - i4) * (childAt.getMeasuredHeight() / flowLayoutCopy.getLines());
                    break;
                }
                i5 += childAt.getMeasuredHeight();
                if (i3 == getChildCount() - 1 && i6 + lines <= 0) {
                    i5 += childAt.getMeasuredHeight() * ((1 - i6) - lines);
                    break;
                }
                i4 = i6;
            }
            i3++;
        }
        if (z) {
            setMeasuredDimension(getMeasuredWidth(), i5);
        }
    }

    public void setMaxLines(int i) {
        this.f10306O000000o = i;
    }
}
