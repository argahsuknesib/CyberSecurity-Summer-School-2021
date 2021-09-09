package com.facebook.imagepipeline.animated.factory;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;

public interface AnimatedImageFactory {
    CloseableImage decodeGif(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Bitmap.Config config);

    CloseableImage decodeWebP(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Bitmap.Config config);
}
