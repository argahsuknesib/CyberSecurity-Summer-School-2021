package com.xiaomi.mico.music.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class SearchContainer extends FrameLayout {
    private OnTouchStartListener mOnTouchStartListener;

    public interface OnTouchStartListener {
        void onTouchStart();
    }

    public SearchContainer(Context context) {
        super(context);
    }

    public SearchContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SearchContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mOnTouchStartListener != null && motionEvent.getAction() == 0) {
            this.mOnTouchStartListener.onTouchStart();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnTouchStartListener(OnTouchStartListener onTouchStartListener) {
        this.mOnTouchStartListener = onTouchStartListener;
    }
}
