package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.xiaomi.smarthome.R;

public class ShadeImageView extends AppCompatImageView {
    private Drawable mForeground;

    public ShadeImageView(Context context) {
        this(context, null);
    }

    public ShadeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int color = getResources().getColor(R.color.mj_color_white_55_transparent);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.mc_foreground});
            color = obtainStyledAttributes.getColor(0, color);
            obtainStyledAttributes.recycle();
        }
        this.mForeground = new ColorDrawable(color);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.mForeground;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getHeight());
            this.mForeground.draw(canvas);
        }
    }
}
