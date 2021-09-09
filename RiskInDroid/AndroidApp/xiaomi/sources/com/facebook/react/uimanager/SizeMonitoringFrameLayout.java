package com.facebook.react.uimanager;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class SizeMonitoringFrameLayout extends FrameLayout {
    private OnSizeChangedListener mOnSizeChangedListener;

    public interface OnSizeChangedListener {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public SizeMonitoringFrameLayout(Context context) {
        super(context);
    }

    public SizeMonitoringFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SizeMonitoringFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnSizeChangedListener(OnSizeChangedListener onSizeChangedListener) {
        this.mOnSizeChangedListener = onSizeChangedListener;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        OnSizeChangedListener onSizeChangedListener = this.mOnSizeChangedListener;
        if (onSizeChangedListener != null) {
            onSizeChangedListener.onSizeChanged(i, i2, i3, i4);
        }
    }
}
