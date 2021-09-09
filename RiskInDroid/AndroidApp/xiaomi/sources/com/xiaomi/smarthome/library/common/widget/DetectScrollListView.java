package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

public class DetectScrollListView extends ListView {

    /* renamed from: O000000o  reason: collision with root package name */
    public AbsListView.OnScrollListener f9171O000000o;
    public O000000o O00000Oo;

    public interface O000000o {
    }

    public DetectScrollListView(Context context) {
        super(context);
        O000000o();
    }

    public DetectScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public DetectScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    private void O000000o() {
        super.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.xiaomi.smarthome.library.common.widget.DetectScrollListView.AnonymousClass1 */
            private int O00000Oo = 0;
            private int O00000o0 = 0;

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (DetectScrollListView.this.f9171O000000o != null) {
                    DetectScrollListView.this.f9171O000000o.onScrollStateChanged(absListView, i);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (DetectScrollListView.this.f9171O000000o != null) {
                    DetectScrollListView.this.f9171O000000o.onScroll(absListView, i, i2, i3);
                }
                if (DetectScrollListView.this.O00000Oo != null) {
                    int i4 = 0;
                    View childAt = absListView.getChildAt(0);
                    if (childAt != null) {
                        i4 = childAt.getTop();
                    }
                    this.O00000Oo = i4;
                    this.O00000o0 = i;
                }
            }
        });
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f9171O000000o = onScrollListener;
    }

    public void setOnDetectScrollListener(O000000o o000000o) {
        this.O00000Oo = o000000o;
    }
}
