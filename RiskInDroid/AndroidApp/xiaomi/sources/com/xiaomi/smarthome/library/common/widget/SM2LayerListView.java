package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

public class SM2LayerListView extends ListView {
    public SM2LayerListView(Context context) {
        super(context);
    }

    public SM2LayerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SM2LayerListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && !canScrollVertically(-1)) {
                getParent().getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else if (getChildCount() == 0) {
            getParent().getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            View childAt = getChildAt(0);
            if (childAt == null || childAt.getTop() != 0) {
                getParent().getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
