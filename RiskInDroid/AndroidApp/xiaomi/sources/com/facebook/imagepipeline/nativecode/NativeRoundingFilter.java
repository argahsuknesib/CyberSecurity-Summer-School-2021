package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;

@DoNotStrip
public class NativeRoundingFilter {
    @DoNotStrip
    private static native void nativeToCircleFilter(Bitmap bitmap);

    static {
        ImagePipelineNativeLoader.load();
    }

    public static void toCircle(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap);
        nativeToCircleFilter(bitmap);
    }
}
