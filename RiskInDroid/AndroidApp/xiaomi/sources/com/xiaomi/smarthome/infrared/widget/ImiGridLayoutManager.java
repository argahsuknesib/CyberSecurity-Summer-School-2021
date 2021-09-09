package com.xiaomi.smarthome.infrared.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ImiGridLayoutManager extends GridLayoutManager {
    public ImiGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public ImiGridLayoutManager(Context context) {
        super(context, 3);
    }

    public void onMeasure(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o, int i, int i2) {
        super.onMeasure(o000o0oo, o000OO0o, i, i2);
    }

    public void setMeasuredDimension(int i, int i2) {
        super.setMeasuredDimension(i, i2);
    }
}
