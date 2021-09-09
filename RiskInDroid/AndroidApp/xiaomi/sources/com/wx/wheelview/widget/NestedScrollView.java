package com.wx.wheelview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

public class NestedScrollView extends ScrollView {
    public NestedScrollView(Context context) {
        super(context);
        O000000o();
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.wx.wheelview.widget.NestedScrollView.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                WheelView wheelView = (WheelView) NestedScrollView.this.findViewWithTag("com.wx.wheelview");
                if (wheelView != null) {
                    wheelView.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
        });
    }
}
