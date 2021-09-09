package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RecyclableImageView extends ImageView {
    public RecyclableImageView(Context context) {
        super(context);
    }

    public RecyclableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RecyclableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null || !bitmap.isRecycled()) {
            super.onDraw(canvas);
        }
    }
}
