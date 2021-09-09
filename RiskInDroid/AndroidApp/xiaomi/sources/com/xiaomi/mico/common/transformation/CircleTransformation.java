package com.xiaomi.mico.common.transformation;

import android.graphics.Bitmap;
import com.squareup.picasso.Transformation;
import com.xiaomi.mico.common.util.BitmapUtil;

public class CircleTransformation implements Transformation {
    public String key() {
        return "CircleTransformation()";
    }

    public Bitmap transform(Bitmap bitmap) {
        return BitmapUtil.circle(bitmap);
    }
}
