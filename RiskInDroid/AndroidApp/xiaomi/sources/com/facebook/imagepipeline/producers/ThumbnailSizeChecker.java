package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;

public final class ThumbnailSizeChecker {
    public static int getAcceptableSize(int i) {
        return (int) (((float) i) * 1.3333334f);
    }

    public static boolean isImageBigEnough(int i, int i2, ResizeOptions resizeOptions) {
        return resizeOptions == null ? ((float) getAcceptableSize(i)) >= 2048.0f && getAcceptableSize(i2) >= 2048 : getAcceptableSize(i) >= resizeOptions.width && getAcceptableSize(i2) >= resizeOptions.height;
    }

    public static boolean isImageBigEnough(EncodedImage encodedImage, ResizeOptions resizeOptions) {
        if (encodedImage == null) {
            return false;
        }
        int rotationAngle = encodedImage.getRotationAngle();
        if (rotationAngle == 90 || rotationAngle == 270) {
            return isImageBigEnough(encodedImage.getHeight(), encodedImage.getWidth(), resizeOptions);
        }
        return isImageBigEnough(encodedImage.getWidth(), encodedImage.getHeight(), resizeOptions);
    }
}
