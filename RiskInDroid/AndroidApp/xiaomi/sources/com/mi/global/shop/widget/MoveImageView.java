package com.mi.global.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MoveImageView extends ImageView {
    private static final String TAG = "MoveImageView";
    private boolean mEnable = false;

    public MoveImageView(Context context) {
        super(context);
    }

    public MoveImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public MoveImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setLocation(int i, int i2) {
        if (this.mEnable) {
            int height = getHeight();
            int i3 = i2 > height ? -height : -i2;
            if (i2 > height) {
                setVisibility(4);
            } else {
                setVisibility(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
                layoutParams.topMargin = i3;
                setLayoutParams(layoutParams);
            }
            String str = TAG;
            Log.d(str, "---  " + i3 + "---  " + getWidth() + "---  ");
        }
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }
}
