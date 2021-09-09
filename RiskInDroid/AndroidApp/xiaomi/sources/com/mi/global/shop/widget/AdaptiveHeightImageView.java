package com.mi.global.shop.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;

public class AdaptiveHeightImageView extends ImageView {
    @SuppressLint({"NewApi"})
    public AdaptiveHeightImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public AdaptiveHeightImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AdaptiveHeightImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdaptiveHeightImageView(Context context) {
        super(context);
    }

    public void setImageDrawable(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = (layoutParams.width * height) / width;
            setLayoutParams(layoutParams);
        }
        super.setImageDrawable(drawable);
    }
}
