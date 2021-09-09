package com.mibi.sdk.pay.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.xiaomi.smarthome.R;

public class MibiScrollView extends ScrollView {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f5164O000000o;

    public MibiScrollView(Context context) {
        this(context, null);
    }

    public MibiScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MibiScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.maxHeight});
            this.f5164O000000o = obtainStyledAttributes.getDimensionPixelSize(0, -1);
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f5164O000000o <= 0) {
            super.onMeasure(i, i2);
        } else if (View.MeasureSpec.getSize(i2) > this.f5164O000000o) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.f5164O000000o, View.MeasureSpec.getMode(i2)));
        } else {
            super.onMeasure(i, i2);
        }
    }
}
