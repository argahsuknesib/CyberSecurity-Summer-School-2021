package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class SM1LayerRecycleView extends RecyclerView {
    public SM1LayerRecycleView(Context context) {
        super(context);
    }

    public SM1LayerRecycleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SM1LayerRecycleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && !canScrollVertically(-1)) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else if (getChildCount() == 0) {
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            View childAt = getChildAt(0);
            if (childAt == null || childAt.getTop() != 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
