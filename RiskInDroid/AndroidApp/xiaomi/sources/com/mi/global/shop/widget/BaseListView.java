package com.mi.global.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class BaseListView extends ListView {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f4947O000000o;

    public interface O000000o {
    }

    public BaseListView(Context context) {
        super(context);
        setOverScrollMode(2);
    }

    public BaseListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOverScrollMode(2);
    }

    public BaseListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOverScrollMode(2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setOnLayoutListener(O000000o o000000o) {
        this.f4947O000000o = o000000o;
    }
}
