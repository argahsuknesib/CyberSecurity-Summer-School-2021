package com.facebook.imagepipeline.animated.factory;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;

public interface AnimatedFactory {
    DrawableFactory getAnimatedDrawableFactory(Context context);

    ImageDecoder getGifDecoder(Bitmap.Config config);

    ImageDecoder getWebPDecoder(Bitmap.Config config);
}
