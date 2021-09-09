package com.xiaomi.smarthome.library.common.widget;

import _m_j.gri;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

public class ListViewAdaptWidth extends ListView {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f9206O000000o;

    public ListViewAdaptWidth(Context context) {
        super(context);
        this.f9206O000000o = context;
    }

    public ListViewAdaptWidth(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9206O000000o = context;
    }

    public ListViewAdaptWidth(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9206O000000o = context;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(getMaxWidthOfChildren() + getPaddingLeft() + getPaddingRight(), 1073741824), i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    private int getMaxWidthOfChildren() {
        int i;
        Exception e;
        try {
            int count = getAdapter().getCount();
            View view = null;
            int i2 = 0;
            i = 0;
            while (i2 < count) {
                try {
                    view = getAdapter().getView(i2, view, this);
                    view.measure(0, 0);
                    if (view.getMeasuredWidth() > i) {
                        i = view.getMeasuredWidth();
                    }
                    i2++;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    int O000000o2 = i + gri.O000000o(13.0f);
                    int i3 = getResources().getDisplayMetrics().widthPixels;
                    if (O000000o2 >= i3 - (gri.O000000o(17.0f) * 2)) {
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            i = 0;
            e.printStackTrace();
            int O000000o22 = i + gri.O000000o(13.0f);
            int i32 = getResources().getDisplayMetrics().widthPixels;
            if (O000000o22 >= i32 - (gri.O000000o(17.0f) * 2)) {
            }
        }
        int O000000o222 = i + gri.O000000o(13.0f);
        int i322 = getResources().getDisplayMetrics().widthPixels;
        return O000000o222 >= i322 - (gri.O000000o(17.0f) * 2) ? i322 - (gri.O000000o(17.0f) * 2) : O000000o222;
    }
}
