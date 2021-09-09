package com.xiaomi.mico.common.transformation;

import android.graphics.Bitmap;
import com.squareup.picasso.Transformation;
import com.xiaomi.mico.common.util.BitmapUtil;

public class CropSquareTransformation implements Transformation {
    private TransformListener listener;
    private int roundPixels = 12;

    public interface TransformListener {
        void onTransforemed(Bitmap bitmap);
    }

    public String key() {
        return "square()";
    }

    public CropSquareTransformation() {
    }

    public CropSquareTransformation(int i) {
        this.roundPixels = i;
    }

    public CropSquareTransformation(int i, TransformListener transformListener) {
        this.roundPixels = i;
        this.listener = transformListener;
    }

    public Bitmap transform(Bitmap bitmap) {
        Bitmap roundCornerImage = BitmapUtil.roundCornerImage(bitmap, this.roundPixels);
        TransformListener transformListener = this.listener;
        if (transformListener != null) {
            transformListener.onTransforemed(roundCornerImage);
        }
        return roundCornerImage;
    }
}
