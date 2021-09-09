package com.xiaomi.smarthome.library.common.widget;

import _m_j.gqm;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;

public class AlphaAnimatedImageView extends ImageView {
    private int mBgResId = 0;
    private int mSrcResId = 0;

    public AlphaAnimatedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.bg, R.attr.source});
        setImageResource(obtainStyledAttributes.getResourceId(1, 0));
        obtainStyledAttributes.recycle();
    }

    public void setImageResource(int i) {
        if (i > 0 && this.mSrcResId != i) {
            setImageDrawable(new gqm(getResources(), ((BitmapDrawable) getResources().getDrawable(i)).getBitmap()));
        }
        this.mSrcResId = i;
    }

    public void setBackgroundResource(int i) {
        if (i > 0 && this.mBgResId != i) {
            setBackgroundDrawable(new gqm(getResources(), ((BitmapDrawable) getResources().getDrawable(i)).getBitmap()));
        }
        this.mBgResId = i;
    }
}
