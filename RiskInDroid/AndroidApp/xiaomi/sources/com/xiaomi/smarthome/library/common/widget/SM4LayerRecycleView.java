package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class SM4LayerRecycleView extends RecyclerView {
    public SM4LayerRecycleView(Context context) {
        super(context);
    }

    public SM4LayerRecycleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SM4LayerRecycleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (canScrollVertically(-1) != false) goto L_0x004f;
     */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View childAt;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                }
                return super.dispatchTouchEvent(motionEvent);
            }
        } else if (getChildCount() != 0 && ((childAt = getChildAt(0)) == null || childAt.getTop() != 0)) {
            getParent().getParent().getParent().getParent().requestDisallowInterceptTouchEvent(true);
            return super.dispatchTouchEvent(motionEvent);
        }
        getParent().getParent().getParent().getParent().requestDisallowInterceptTouchEvent(false);
        return super.dispatchTouchEvent(motionEvent);
    }
}
