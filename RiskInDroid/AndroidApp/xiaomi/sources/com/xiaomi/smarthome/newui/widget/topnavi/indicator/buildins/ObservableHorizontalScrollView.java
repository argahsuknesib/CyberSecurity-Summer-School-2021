package com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

public class ObservableHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f10343O000000o = null;

    public interface O000000o {
        void onScrollChanged(ObservableHorizontalScrollView observableHorizontalScrollView, int i, int i2, int i3, int i4);
    }

    public ObservableHorizontalScrollView(Context context) {
        super(context);
    }

    public ObservableHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObservableHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ObservableHorizontalScrollView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setScrollViewListener(O000000o o000000o) {
        this.f10343O000000o = o000000o;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        O000000o o000000o = this.f10343O000000o;
        if (o000000o != null) {
            o000000o.onScrollChanged(this, i, i2, i3, i4);
        }
    }
}
