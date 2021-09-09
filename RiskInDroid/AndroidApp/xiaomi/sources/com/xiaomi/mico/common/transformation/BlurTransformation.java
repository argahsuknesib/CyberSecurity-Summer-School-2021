package com.xiaomi.mico.common.transformation;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.RSRuntimeException;
import com.squareup.picasso.Transformation;
import com.xiaomi.mico.common.util.BitmapUtil;

public class BlurTransformation implements Transformation {
    private static int DEFAULT_RADIUS = 25;
    private static int DEFAULT_SAMPLING = 1;
    private Context mContext;
    private int mRadius;
    private int mSampling;

    public BlurTransformation(Context context) {
        this(context, DEFAULT_SAMPLING, DEFAULT_RADIUS);
    }

    public BlurTransformation(Context context, int i) {
        this(context, i, DEFAULT_RADIUS);
    }

    public BlurTransformation(Context context, int i, int i2) {
        this.mContext = context.getApplicationContext();
        this.mSampling = i;
        this.mRadius = i2;
    }

    public Bitmap transform(Bitmap bitmap) {
        try {
            return BitmapUtil.blur(this.mContext, bitmap, this.mSampling, this.mRadius);
        } catch (RSRuntimeException unused) {
            return bitmap;
        }
    }

    public String key() {
        return "BlurTransformation(sampling=" + this.mSampling + ", radius=" + this.mRadius + ")";
    }
}
