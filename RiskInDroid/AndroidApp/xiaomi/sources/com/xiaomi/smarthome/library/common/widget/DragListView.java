package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

public class DragListView extends ListView {
    public DragListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public DragListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DragListView(Context context) {
        super(context);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof DragSlideView) {
                    DragSlideView dragSlideView = (DragSlideView) childAt;
                    if ((motionEvent.getY() > ((float) dragSlideView.getBottom()) || motionEvent.getY() < ((float) dragSlideView.getTop())) && dragSlideView.O000000o()) {
                        dragSlideView.O00000Oo();
                    }
                }
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
